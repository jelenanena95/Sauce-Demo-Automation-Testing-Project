package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import Pages.SauceLabsBackpackPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OpenTheProductsPageTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        LoginPage = new LoginPage(driver);
        ProductsPage = new ProductsPage(driver);
        SauceLabsBackpackPage = new SauceLabsBackpackPage(driver);
    }

    @Test(priority = 1)
    public void successfullyGoToTheSauceLabsBackpackPage () {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        ProductsPage.clickOnTheSauceDemoBackpackItem();

        Assert.assertTrue(SauceLabsBackpackPage.getBackToProductsButton().isDisplayed());
        String expectedURL = "https://www.saucedemo.com/inventory-item.html?id=4";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
        Assert.assertTrue(SauceLabsBackpackPage.getPrice().isDisplayed());

        //Ovaj test sluzi da verifikuje da li klikom na odredjeni artikl, u ovom slucaju ranac,
        //korisnik uspesno moze da ode na stranicu bas za taj artikl i vidi informacije o tom artiklu
    }
}
