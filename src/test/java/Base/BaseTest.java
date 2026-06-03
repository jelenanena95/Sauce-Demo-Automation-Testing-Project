package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    public AboutPage AboutPage;
    public CartPage CartPage;
    public CheckoutCompletePage CheckoutCompletePage;
    public CheckoutOverviewPage CheckoutOverviewPage;
    public CheckoutYourInformationPage CheckoutYourInformationPage;
    public LoginPage LoginPage;
    public LogoutPage LogoutPage;
    public OpenMenuDropDownPage OpenMenuDropDownPage;
    public ProductsPage ProductsPage;
    public SauceLabsBackpackPage SauceLabsBackpackPage;




    public WebDriver driver;
    public WebDriverWait wait;



    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    } // ovu metodu sam napravila ovde kako bih mogla da je koristim u testovima
    //mogla sam da je napravim i u BasePage i onda bih je pozivala u Pages klasama, ovako je pozivam u Tests klasama
    //nekada element nije vidljiv odmah nego mora da se skroluje kako bi se doslo do njega, pa zato i pravimo ovu metodu
    //kako bismo mogli da dohvatimo taj element, u suprotnom bi test pao jer element ne bi bio vidljiv


    @BeforeClass
    public void setUp () {
        WebDriverManager.firefoxdriver().setup();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

    }



    @AfterMethod
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
