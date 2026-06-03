package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage{
    public CartPage (WebDriver driver) {
        super(driver); } // napravili smo konstruktor koji se nasledjuje iz parent klase a to je BasePage
    //to radimo za svaku Page klasu koja nasledjuje BasePage


    WebElement checkoutButton;
    WebElement continueShoppingButton;
    WebElement removeBackpackFromTheCart;
    WebElement removeBikeLightFromTheCart;
    WebElement removeJacketFromTheCart;
    WebElement sauceDemoBackpackItem;
    WebElement sauceDemoBikeLightItem;


    public WebElement getCheckoutButton() {
        return driver.findElement(By.id("checkout"));
    }

    public WebElement getContinueShoppingButton() {
        return driver.findElement(By.id("continue-shopping"));
    }

    public WebElement getRemoveBackpackFromTheCart () {
        return driver.findElement(By.id("remove-sauce-labs-backpack"));
    }

    public WebElement getRemoveBikeLightFromTheCart () {
        return driver.findElement(By.id("remove-sauce-labs-bike-light"));
    }

    public WebElement getRemoveJacketFromTheCart () {
        return driver.findElement(By.id("remove-sauce-labs-fleece-jacket"));
    }

    public WebElement getSauceDemoBackpackItem() {
        return driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
    }

    public WebElement getSauceDemoBikeLightItem() {
        return driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
    }

    public void clickOnTheCheckoutButton () {
        waitForClickability(getCheckoutButton());
        getCheckoutButton().click();

    }

    public void clickOnTheContinueShoppingButton () {
        waitForClickability(getContinueShoppingButton());
        getContinueShoppingButton().click();

    }

    public void clickOnTheRemoveBackpackButton () {
        waitForClickability(getRemoveBackpackFromTheCart());
        getRemoveBackpackFromTheCart().click();
    }

    public void clickOnTheRemoveBikeLightButton () {
        waitForClickability(getRemoveBikeLightFromTheCart());
        getRemoveBikeLightFromTheCart().click();
    }

    public void clickOnTheRemoveJacketButton () {
        waitForClickability(getRemoveJacketFromTheCart());
        getRemoveJacketFromTheCart().click();

    }
    //ovde smo napravili metode koje cemo da koristimo sa stranice CartPage i koje
    //ce da nam skrate korake u Tests klasama jer samo treba da pozovemo tu metodu
    //uglavnom jedna metoda = jedan korak u testu
    //ovo radimo u svakoj Pages klasi: vidimo koje su nam stranice potrebne, koji elementi su nam
    //potrebni sa te stranice, pa deklarisemo te elemente i pravimo metode koji ce da koriste te elemente
}
