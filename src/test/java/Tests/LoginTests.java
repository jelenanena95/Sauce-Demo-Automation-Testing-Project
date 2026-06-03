package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.ProductsPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
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
    @Test (priority = 1)
    public void successfulLoginTest() {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();

        Assert.assertTrue(ProductsPage.getGoToCartButton().isDisplayed());
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertTrue(ProductsPage.getOpenMenuButton().isDisplayed());
        Assert.assertTrue(ProductsPage.getSauceDemoBikeLightItem().isDisplayed());
        Assert.assertEquals(ProductsPage.getTitle().getText(), "Products");

        //Kroz ovaj test sam proverila da li se korisnik uspesno ulogovao sa validnim korisnickim imenom i sifrom
        //i da je preusmeren na ProductsPage

    }

    @Test (priority = 2)
    public void unsuccessfulLoginTestWithInvalidUsername() {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("invalid_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();

        Assert.assertTrue(LoginPage.getUsername().isDisplayed());
        Assert.assertTrue(LoginPage.getLoginButton().isDisplayed());
        String possibleURL = "https://www.saucedemo.com/inventory.html";
        String actualURL = driver.getCurrentUrl();
        Assert.assertNotEquals(possibleURL, actualURL);
        Assert.assertEquals(LoginPage.getErrorLoggingIn().getText(), "Epic sadface: Username and password do not match any user in this service");

        //ovde sam proverila da li korisnik ne moze da se uloguje ako unese nevalidno korisnicko ime ili postoji bug i korisnik
        //pa se korisnik uspesno ulogovao
        //to sam kasnije proverila uz asertacije da trenutni url nije url ProductsPage i da se pojavila poruka da je pogresno
        //ili korisnicko ime ili sifra
    }
}
