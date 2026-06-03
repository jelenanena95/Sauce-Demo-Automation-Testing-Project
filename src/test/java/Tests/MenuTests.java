package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.OpenMenuDropDownPage;
import Pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MenuTests extends BaseTest {

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        LoginPage = new LoginPage(driver);
        ProductsPage = new ProductsPage(driver);
        OpenMenuDropDownPage = new OpenMenuDropDownPage(driver);
    }

    @Test (priority = 1)
    public void clickSuccessfullyOnTheOpenMenuDropDown () {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        ProductsPage.clickOnTheOpenMenuButton();

        Assert.assertTrue(OpenMenuDropDownPage.getCloseMenuButton().isDisplayed());
        Assert.assertTrue(OpenMenuDropDownPage.getAboutButton().isDisplayed());

        //ovde proveravam da li je dugme OpenMenu klikabilno i da li se uspesno otvara meni i vidimo opcije
        //koje tu postoje

    }

    @Test (priority = 2)
    public void clickSuccessfullyOnTheLogoutButton () {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        ProductsPage.clickOnTheOpenMenuButton();
        OpenMenuDropDownPage.clickOnTheLogoutButton();

        Assert.assertTrue(LoginPage.getLoginButton().isDisplayed());
        String expectedURL = "https://www.saucedemo.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        WebElement password = driver.findElement(By.cssSelector("div[class='login_password']"));
        Assert.assertTrue(password.isDisplayed());

        //ova metoda sluzi da testira da dugme za logout radi kako treba kad korisnik klikne na njeg
        //to asertujemo tako sto vidimo da li smo se vratili na login page i da li se vidi polje za sifru
    }

    @Test (priority = 3)
    public void clickSuccessfullyOnTheAboutButton () {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        ProductsPage.clickOnTheOpenMenuButton();
        OpenMenuDropDownPage.clickOnTheAboutButton();

        String expectedURL = "https://saucelabs.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
        WebElement title = driver.findElement(By.cssSelector("h1[class='MuiTypography-root MuiTypography-h1 css-hqwp3n']"));
        Assert.assertEquals(title.getText(), "The World's Only Full-Lifecycle AI-Quality Platform");

        // Ova provera potvrdjuje da je korisnik preusmeren na About stranicu nakon
        // klika na odgovarajucu opciju menija
    }

    @Test (priority = 4)
    public void clickSuccessfullyOnTheAllItemsButton () {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        ProductsPage.clickOnTheOpenMenuButton();
        OpenMenuDropDownPage.clickOnTheAllItemsButton();

        Assert.assertTrue(ProductsPage.getOpenMenuButton().isDisplayed());
        WebElement openMenuDropDown = driver.findElement(By.cssSelector("div[class='bm-menu']"));
        Assert.assertFalse(openMenuDropDown.isDisplayed());

        // Ovde verifikujemo da opcija ALlItems iz OpenMenu uspesno zatvara otvoreni meni
        // i vraca korisnika na ProductsPage
        //Ovde sam primetila bug:jer to dugme AllItems ne nije klikabilno
        //Osim toga, iako je otvoren ovaj dropdown, vebsajt se ponasa kao da je zatvoren
        // i dohvata npr dugme za OpenMenu koje se nalazi ispod drop down menija
    }

    @Test (priority = 5)
    public void clickSuccessfullyOnCloseMenuButton () {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        ProductsPage.clickOnTheOpenMenuButton();
        OpenMenuDropDownPage.clickOnTheCloseMenuButton();

        Assert.assertTrue(ProductsPage.getOpenMenuButton().isDisplayed());
        Assert.assertEquals(ProductsPage.getTitle().getText(), "Products");
        Assert.assertTrue(ProductsPage.getSauceDemoBikeLightItem().isDisplayed());

        //ovde proveravamo da li mozemo da zatvorimo meni klikom na dugme CloseMenu
        // i da li je korisnik vracen na ProductsPage


    }


}
