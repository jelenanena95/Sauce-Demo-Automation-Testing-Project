package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.ProductsPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TwiterPageTest extends BaseTest {
    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        LoginPage = new LoginPage(driver);
        ProductsPage = new ProductsPage(driver);


    }

    @Test(priority = 1)
    public void clickSuccessfullyOnTheSauceDemoTwiterPage() throws InterruptedException {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        scrollToElement(ProductsPage.getSauceDemoTwiterPageIcon());

        String originalWindow = driver.getWindowHandle();

        ProductsPage.clickOnSauceDemoTwiterPageIcon();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        wait.until(ExpectedConditions.urlToBe("https://x.com/saucelabs"));

        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, "https://x.com/saucelabs");

        //Ovim testom zelim da proverim da li su ikonice za drustvene mreze klikabilne, u ovom slucaju Twiter
        //kada korisnik klikne na samu ikonicu za Twiter (znam da je X, ali mi se vise svidja ime Twiter)

    }
}
