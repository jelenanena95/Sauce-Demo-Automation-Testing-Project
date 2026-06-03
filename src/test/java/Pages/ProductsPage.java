package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class ProductsPage extends BasePage {

    public ProductsPage (WebDriver driver) {
        super(driver);
    }
    WebElement addBackpackToCart;
    WebElement addJacketToCart;
    WebElement addBikeLightToCart;
    WebElement goToCartButton;
    WebElement getOpenMenuButton;
    WebElement sortContainerButton;
    WebElement productSortContainerButton;
    WebElement orderItemsFromTheLowestToTheHighestPrice;
    WebElement sauceDemoTwiterPageIcon;
    WebElement sauceDemoBackpackItem;
    WebElement sauceDemoBikeLightItem;
    WebElement sauceDemoFleeceJacket;
    WebElement removeBackpack;
    WebElement itemQuantity;
    WebElement title;





    public WebElement getAddBackpackToCart() {

        return driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }

    public WebElement getAddJacketToCart() {

        return driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
    }

    public WebElement getAddBikeLightToCart() {

        return driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
    }


    public WebElement getGoToCartButton() {
        return driver.findElement(By.cssSelector("a[data-test='shopping-cart-link']"));
    }

    public WebElement getOpenMenuButton() {

        return driver.findElement(By.id("react-burger-menu-btn"));
    }

    public WebElement getOrderItemsAlphabeticallyFromZToA() {
        return driver.findElement(By.cssSelector("option[value='za']"));
    }

    public WebElement getProductSortContainerButton() {
        return driver.findElement(By.cssSelector("select[data-test='product-sort-container']"));
    }

    public WebElement getOrderItemsFromTheLowestToTheHighestPrice() {
        return driver.findElement(By.cssSelector("option[value='lohi']"));
    }


    public WebElement getSauceDemoTwiterPageIcon() {
        return driver.findElement(By.cssSelector("a[href='https://twitter.com/saucelabs']"));
    }

    public WebElement getSauceDemoBackpackItem() {
        return driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
    }

    public WebElement getSauceDemoBikeLightItem() {
        return driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
    }

    public WebElement getSauceDemoFleeceJacket() {
        return driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']"));
    }

    public WebElement getRemoveBackpack() {
        return driver.findElement(By.id("remove-sauce-labs-backpack"));
    }

    public WebElement getItemQuantity() {
        return driver.findElement(By.cssSelector("div[class='cart_quantity']"));
    }

    public WebElement getBackpackPrice() {
        return driver.findElement(By.cssSelector("div[class='item_pricebar']"));
    }

    public WebElement getTitle() {
        return driver.findElement(By.cssSelector("span[class='title']"));
    }

    //sa ove stranice imamo dosta elemenata koje mozemo da iskoristimo za razne testove


    public void clickOnAddBackpackToCartButton() {
        waitForClickability(getAddBackpackToCart());
        getAddBackpackToCart().click();
    }

    public void clickOnAddBikeLightToCartButton() {
        waitForClickability(getAddBikeLightToCart());
        getAddBikeLightToCart().click();
    }

    public void clickOnAddJacketToCartButton() {
        waitForClickability(getAddJacketToCart());
        getAddJacketToCart().click();
    }



    public void clickOnTheCartButton() {
        waitForClickability(getGoToCartButton());
        getGoToCartButton().click();
    }


    public void clickOnTheOpenMenuButton() {
        waitForClickability(getOpenMenuButton());
        getOpenMenuButton().click();
    }

    public void clickOnTheZToAOption() {
        waitForClickability(getOrderItemsAlphabeticallyFromZToA());
        getOrderItemsAlphabeticallyFromZToA().click();
    }

    public void clickOnTheProductSortContainerButton() {
        waitForClickability(getProductSortContainerButton());
        getProductSortContainerButton().click();
    }

    public void clickOnThePriceLowToHighOption() {
        waitForClickability(getOrderItemsFromTheLowestToTheHighestPrice());
        getOrderItemsFromTheLowestToTheHighestPrice().click();
    }

    public void clickOnSauceDemoTwiterPageIcon() {
        waitForClickability(getSauceDemoTwiterPageIcon());
        getSauceDemoTwiterPageIcon().click();


    }

    public void clickOnTheSauceDemoBackpackItem() {
        waitForClickability(getSauceDemoBackpackItem());
        getSauceDemoBackpackItem().click();
    }

    public int theNumberOfItemsNextToTheCart() {
        waitForClickability(getGoToCartButton());
        return Integer.parseInt(getGoToCartButton().getText());
    }

    public void clickOnRemoveButtonNextToBackpackItem() {
        waitForClickability(getRemoveBackpack());
        getRemoveBackpack().click();
    }

    public int theNumberOfItemsInTheCart() {
       waitForClickability(getItemQuantity());
        return Integer.parseInt(getItemQuantity().getText());
    }

    public boolean NoItemsInTheCart() {
        try {
            theNumberOfItemsInTheCart();
            return false;
        } catch (Exception e) {
            return true;
        }
    }

}


