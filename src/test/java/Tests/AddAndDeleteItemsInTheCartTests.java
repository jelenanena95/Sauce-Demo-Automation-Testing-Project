package Tests;

import Base.BaseTest;
import Pages.CartPage;
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
import java.util.ArrayList;
import java.util.List;

public class AddAndDeleteItemsInTheCartTests extends BaseTest {

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
        OpenMenuDropDownPage = new OpenMenuDropDownPage(driver);
    }

    @Test (priority = 1)
    public void successfullyClickOnAddToCartButton () {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        ProductsPage.clickOnAddBackpackToCartButton();


        Assert.assertTrue(ProductsPage.getRemoveBackpack().isDisplayed());
        Assert.assertEquals(ProductsPage.theNumberOfItemsNextToTheCart(), 1);
    }

    @Test (priority = 2)
    public void addOneItemInTheCart () {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        ProductsPage.clickOnAddBackpackToCartButton();
        ProductsPage.clickOnTheCartButton();

        Assert.assertEquals(ProductsPage.theNumberOfItemsNextToTheCart(), 1);
        Assert.assertEquals(ProductsPage.theNumberOfItemsInTheCart(), 1);
        Assert.assertTrue(ProductsPage.getBackpackPrice().isDisplayed());

    }

    @Test (priority = 3)
    public void addMoreThanOneItemInTheCart () {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        ProductsPage.clickOnAddBackpackToCartButton();
        Assert.assertEquals(ProductsPage.theNumberOfItemsNextToTheCart(), 1);
        ProductsPage.clickOnAddBikeLightToCartButton();
        Assert.assertEquals(ProductsPage.theNumberOfItemsNextToTheCart(), 2);
        ProductsPage.clickOnAddJacketToCartButton();
        Assert.assertEquals(ProductsPage.theNumberOfItemsNextToTheCart(), 3);
        ProductsPage.clickOnTheCartButton();

        Assert.assertEquals(ProductsPage.theNumberOfItemsNextToTheCart(), 3);
        Assert.assertEquals(ProductsPage.theNumberOfItemsInTheCart(), 1);
        Assert.assertTrue(ProductsPage.getRemoveBackpack().isDisplayed());
        Assert.assertTrue(ProductsPage.getSauceDemoBackpackItem().isDisplayed());
        Assert.assertTrue(ProductsPage.getSauceDemoBikeLightItem().isDisplayed());
        Assert.assertTrue(ProductsPage.getSauceDemoFleeceJacket().isDisplayed());

    }

    @Test (priority = 4)
    public void deleteItemsFromTheCart () {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        ProductsPage.clickOnAddBackpackToCartButton();
        ProductsPage.clickOnAddBikeLightToCartButton();
        ProductsPage.clickOnAddJacketToCartButton();
        ProductsPage.clickOnTheCartButton();

        //ovim testom zelim da asertujem da korisnik uspesno moze da izbrise artikle iz korpe
        //to kasnije proveravam kroz asertacije tako sto prvo proverim koliko artikala ima u korpi
        //onda obrisem artikl pa vidim da li se korpa apdejtovala
        //onda obrisem sledeci artikl i opet proverim stanje korpe i tako sve dok ne dodjemo do 0 artikala

        Assert.assertEquals(ProductsPage.theNumberOfItemsNextToTheCart(), 3);
        Assert.assertTrue(ProductsPage.getSauceDemoBackpackItem().isDisplayed());
        Assert.assertTrue(ProductsPage.getSauceDemoBikeLightItem().isDisplayed());
        Assert.assertTrue(ProductsPage.getSauceDemoFleeceJacket().isDisplayed());

        CartPage.clickOnTheRemoveBackpackButton();

        Assert.assertEquals(ProductsPage.theNumberOfItemsNextToTheCart(), 2);

        CartPage.clickOnTheRemoveBikeLightButton();

        Assert.assertEquals(ProductsPage.theNumberOfItemsNextToTheCart(), 1);

        CartPage.clickOnTheRemoveJacketButton();

        Assert.assertTrue(ProductsPage.NoItemsInTheCart());

    }

    @Test (priority = 5)
    public void isTheNumberOfItemsInTheCartCorrectTest () {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        ProductsPage.clickOnAddBackpackToCartButton();
        ProductsPage.theNumberOfItemsNextToTheCart();
        System.out.println("Broj artikala je: " + ProductsPage.theNumberOfItemsNextToTheCart());

        Assert.assertEquals(ProductsPage.theNumberOfItemsNextToTheCart(), 1);
        ProductsPage.clickOnTheCartButton();
        Assert.assertTrue(ProductsPage.getSauceDemoBackpackItem().isDisplayed());


        CartPage.clickOnTheContinueShoppingButton();
        ProductsPage.clickOnAddBikeLightToCartButton();
        ProductsPage.theNumberOfItemsNextToTheCart();
        System.out.println("Broj artikala je: " + ProductsPage.theNumberOfItemsNextToTheCart());

        Assert.assertEquals(ProductsPage.theNumberOfItemsNextToTheCart(), 2);
        ProductsPage.clickOnTheCartButton();
        Assert.assertTrue(ProductsPage.getSauceDemoBackpackItem().isDisplayed());
        Assert.assertTrue(ProductsPage.getSauceDemoBikeLightItem().isDisplayed());


        CartPage.clickOnTheContinueShoppingButton();
        ProductsPage.clickOnAddJacketToCartButton();
        ProductsPage.theNumberOfItemsNextToTheCart();
        System.out.println("Broj artikala je: " + ProductsPage.theNumberOfItemsNextToTheCart());

        Assert.assertEquals(ProductsPage.theNumberOfItemsNextToTheCart(), 3);
        ProductsPage.clickOnTheCartButton();
        Assert.assertTrue(ProductsPage.getSauceDemoBackpackItem().isDisplayed());
        Assert.assertTrue(ProductsPage.getSauceDemoBikeLightItem().isDisplayed());
        Assert.assertTrue(ProductsPage.getSauceDemoFleeceJacket().isDisplayed());


    }
    //u ovoj metodi proveravam da li broj artikala koje korpa prikazuje je uskladjen sa brojem artikala
    //koje sam dodala
    //to sam proveravala tako sto dodam artikl i proverim stanje korpe i tako za svaki artikl
    //nakon svakog dodatog artikla sam dodala korak da se ispise stanje korpe kako bih u konzoli
    //videla da je sve u redu

    @Test (priority = 6)
    public void theItemsStayInTheCartAfterLoggingout () {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        ProductsPage.clickOnAddBackpackToCartButton();
        Assert.assertEquals(ProductsPage.theNumberOfItemsNextToTheCart(), 1);
        ProductsPage.clickOnAddBikeLightToCartButton();
        Assert.assertEquals(ProductsPage.theNumberOfItemsNextToTheCart(), 2);
        ProductsPage.clickOnTheOpenMenuButton();
        OpenMenuDropDownPage.clickOnTheLogoutButton();
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        ProductsPage.clickOnTheCartButton();

        List<WebElement> listOfItemsInTheCart = driver.findElements(By.cssSelector("div[data-test='inventory-item']"));
        Assert.assertEquals(listOfItemsInTheCart.size(), 2);
        Assert.assertTrue(CartPage.getSauceDemoBackpackItem().isDisplayed());
        Assert.assertTrue(CartPage.getSauceDemoBikeLightItem().isDisplayed());

    }



}
