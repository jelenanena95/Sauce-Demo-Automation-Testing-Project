package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutCompletePage extends BasePage {
    public CheckoutCompletePage (WebDriver driver) {
        super(driver);
    }
    WebElement backHomeButton;
    WebElement successfulOrderMessage;
    WebElement title;



    public WebElement getBackHomeButton() {
        return driver.findElement(By.id("back-to-products"));
    }

    public WebElement getSuccessfulOrderMessage() {
        return driver.findElement(By.cssSelector("h2[data-test='complete-header']"));
    } //kada dodjemo do kraja narudzbine pojavi se poruka da je narudzbina uspesna, pa koristimo tu
    //poruku za asertaciju izvrsen

    public WebElement getTitle() {
        return driver.findElement(By.cssSelector("span[class='title']"));
    }

    public void clickOnTheBackHomeButton() {
        waitForClickability(getBackHomeButton());
        getBackHomeButton().click();

    } //ovo je isto dugme koje se pojavi kada dodjemo do kraja narucivanja i koje ce da nam sluzi
    //da asertujemo da smo dosli do kraja porudzbine


}
