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

public class ReturnToTheProductsPageTest extends BaseTest {
    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        LoginPage = new LoginPage(driver);
        ProductsPage = new ProductsPage(driver);
        CartPage = new CartPage(driver);
        SauceLabsBackpackPage = new SauceLabsBackpackPage(driver);
    }

    @Test(priority = 1)
    public void successfullyReturnToTheProductsPageTest () {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        ProductsPage.clickOnTheSauceDemoBackpackItem();
        SauceLabsBackpackPage.clickOnTheBackToProductsButton();

        Assert.assertTrue(ProductsPage.getSauceDemoBackpackItem().isDisplayed());
        Assert.assertEquals(ProductsPage.getTitle().getText(), "Products");
        Assert.assertTrue(ProductsPage.getGoToCartButton().isDisplayed());
        Assert.assertTrue(ProductsPage.getProductSortContainerButton().isDisplayed());

        //Ovim testom sam verifikovala da li korisnik uspesno moze da se vrati na pocetnu stranu sa proizvodima
        //nakon sto ode na stranicu nekog artikla i klikne na dugme BackToProducts
    }

}
