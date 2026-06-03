package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SauceLabsBackpackPage extends BasePage {
    public SauceLabsBackpackPage (WebDriver driver) {
        super(driver);
    }
    WebElement backToProductsButton;
    WebElement price;



    public WebElement getBackToProductsButton() {
        return driver.findElement(By.id("back-to-products"));
    }

    public WebElement getPrice() {
        return driver.findElement(By.cssSelector("div[class='inventory_details_price']"));
    }

    public void clickOnTheBackToProductsButton() {
        waitForClickability(getBackToProductsButton());
        getBackToProductsButton().click();
    }
}
