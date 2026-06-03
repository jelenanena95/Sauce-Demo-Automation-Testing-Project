package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OrderingItemsTests extends BaseTest {

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
        CheckoutYourInformationPage = new CheckoutYourInformationPage(driver);
        CheckoutOverviewPage = new CheckoutOverviewPage(driver);
        CheckoutCompletePage = new CheckoutCompletePage(driver);

    }

    @Test(priority = 1)
    public void successfulOrderTest() {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        ProductsPage.clickOnAddBackpackToCartButton();
        ProductsPage.clickOnTheCartButton();
        CartPage.clickOnTheCheckoutButton();
        wait.until(ExpectedConditions.visibilityOf(CheckoutYourInformationPage.getFirstName()));
        CheckoutYourInformationPage.getFirstName().clear();
        CheckoutYourInformationPage.getFirstName().sendKeys("Jelena");
        CheckoutYourInformationPage.getLastName().clear();
        CheckoutYourInformationPage.getLastName().sendKeys("Smiljkovic");
        CheckoutYourInformationPage.getZipCode().clear();
        CheckoutYourInformationPage.getZipCode().sendKeys("18100");
        CheckoutYourInformationPage.clickOnTheContinueButton();
        CheckoutOverviewPage.clickOnTheFinishButton();

        Assert.assertEquals(CheckoutCompletePage.getTitle().getText(), "Checkout: Complete!");
        Assert.assertTrue(CheckoutCompletePage.getBackHomeButton().isDisplayed());
        Assert.assertTrue(CheckoutCompletePage.getSuccessfulOrderMessage().getText().contains("Thank you for your order!"));
        String expectedURL = "https://www.saucedemo.com/checkout-complete.html";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);

        //Ovde zelimo da proverimo da li kada prodjemo sve korake mozemo uspesno da zavrsimo narudzbinu ili ce
        //usput da nam se javi neka greska


    }

    @Test(priority = 2)
    public void unsuccessfulOrderDueToTheInvalidZipCode() {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        ProductsPage.clickOnAddBackpackToCartButton();
        ProductsPage.clickOnTheCartButton();
        CartPage.clickOnTheCheckoutButton();
        wait.until(ExpectedConditions.visibilityOf(CheckoutYourInformationPage.getFirstName()));
        CheckoutYourInformationPage.getFirstName().clear();
        CheckoutYourInformationPage.getFirstName().sendKeys("Jelena");
        CheckoutYourInformationPage.getLastName().clear();
        CheckoutYourInformationPage.getLastName().sendKeys("Smiljkovic");
        CheckoutYourInformationPage.getZipCode().clear();
        CheckoutYourInformationPage.getZipCode().sendKeys("39100");
        CheckoutYourInformationPage.clickOnTheContinueButton();

        Assert.assertTrue(CheckoutYourInformationPage.getCancelButton().isDisplayed());
        Assert.assertTrue(CheckoutYourInformationPage.getZipCode().isDisplayed());
        String expectedURL = "https://www.saucedemo.com/checkout-step-one.html";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);

        //Ovde proveravamo da li polje za zip code prihvata bilo koji unos ili prepoznaje da
        //je zip code koji je korisnik uneo validan ili ne i onda reaguje u skladu sa tim
        //ako je nevalidan ne dozvoljava korisniku da ide dalje i javlja gresku

    }

    @Test(priority = 3)
    public void unsuccessfulOrderTestDueToTheEmptyFirstNameField() {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        ProductsPage.clickOnAddBackpackToCartButton();
        ProductsPage.clickOnTheCartButton();
        CartPage.clickOnTheCheckoutButton();
        wait.until(ExpectedConditions.visibilityOf(CheckoutYourInformationPage.getFirstName()));
        CheckoutYourInformationPage.getLastName().clear();
        CheckoutYourInformationPage.getLastName().sendKeys("Smiljkovic");
        CheckoutYourInformationPage.getZipCode().clear();
        CheckoutYourInformationPage.getZipCode().sendKeys("39100");
        CheckoutYourInformationPage.clickOnTheContinueButton();

        Assert.assertEquals(CheckoutYourInformationPage.getErrorMessageFirstName().getText(), "Error: First Name is required");
        String wrongURL = "https://www.saucedemo.com/cart.html";
        String actualURL = driver.getCurrentUrl();
        Assert.assertNotEquals(wrongURL, actualURL);
        Assert.assertTrue(CheckoutYourInformationPage.getContinueButton().isDisplayed());
    }

    @Test(priority = 4)
    public void cancelTheOrderOnTheLastStep() {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        ProductsPage.clickOnAddBackpackToCartButton();
        ProductsPage.clickOnTheCartButton();
        CartPage.clickOnTheCheckoutButton();
        wait.until(ExpectedConditions.visibilityOf(CheckoutYourInformationPage.getFirstName()));
        CheckoutYourInformationPage.getFirstName().clear();
        CheckoutYourInformationPage.getFirstName().sendKeys("Jelena");
        CheckoutYourInformationPage.getLastName().clear();
        CheckoutYourInformationPage.getLastName().sendKeys("Smiljkovic");
        CheckoutYourInformationPage.getZipCode().clear();
        CheckoutYourInformationPage.getZipCode().sendKeys("18100");
        CheckoutYourInformationPage.clickOnTheContinueButton();
        CheckoutOverviewPage.clickOnTheCancelButton();

        String expectedURL = "https://www.saucedemo.com/inventory.html";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
        Assert.assertTrue(ProductsPage.getTitle().isDisplayed());
        Assert.assertTrue(ProductsPage.getProductSortContainerButton().isDisplayed());
        Assert.assertTrue(ProductsPage.getSauceDemoBackpackItem().isDisplayed());
    }

    @Test(priority = 5)
    public void itemTotalPrice() {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        ProductsPage.clickOnAddBackpackToCartButton();
        ProductsPage.clickOnAddBikeLightToCartButton();
        ProductsPage.clickOnAddJacketToCartButton();
        ProductsPage.clickOnTheCartButton();

        List<WebElement> itemPrices = driver.findElements(By.cssSelector("div[class='inventory_item_price']"));

        Assert.assertEquals(Double.parseDouble(itemPrices.get(0).getText().replace("$", "")), 29.99);
        Assert.assertEquals(Double.parseDouble(itemPrices.get(1).getText().replace("$", "")), 9.99);
        Assert.assertEquals(Double.parseDouble(itemPrices.get(2).getText().replace("$", "")), 49.99);

        CartPage.clickOnTheCheckoutButton();
        wait.until(ExpectedConditions.visibilityOf(CheckoutYourInformationPage.getFirstName()));
        CheckoutYourInformationPage.getFirstName().clear();
        CheckoutYourInformationPage.getFirstName().sendKeys("Jelena");
        CheckoutYourInformationPage.getLastName().clear();
        CheckoutYourInformationPage.getLastName().sendKeys("Smiljkovic");
        CheckoutYourInformationPage.getZipCode().clear();
        CheckoutYourInformationPage.getZipCode().sendKeys("18100");
        CheckoutYourInformationPage.clickOnTheContinueButton();
        scrollToElement(CheckoutOverviewPage.getItemTotal());

        double sum = 0;

        List<WebElement> itemPricesOverviewPage = driver.findElements(By.cssSelector("div[class='inventory_item_price']"));

        for (int i = 0; i < itemPricesOverviewPage.size(); i++) {

            sum += Double.parseDouble(itemPricesOverviewPage.get(i).getText().replace("$", ""));

        }

        Assert.assertEquals(sum, Double.parseDouble(CheckoutOverviewPage.getItemTotal().getText().replace("Item total: $", "")));
    }
}