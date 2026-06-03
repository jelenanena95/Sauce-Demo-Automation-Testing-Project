package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutYourInformationPage extends BasePage {
    public CheckoutYourInformationPage (WebDriver driver) {
        super(driver);}
    WebElement firstName;
    WebElement lastName;
    WebElement zipCode;
    WebElement continueButton;
    WebElement cancelButton;
    WebElement errorMessageFirstName;



    public WebElement getFirstName() {
        return driver.findElement(By.id("first-name"));
    }

    public WebElement getLastName() {
        return driver.findElement(By.id("last-name"));
    }

    public WebElement getZipCode() {
        return driver.findElement(By.id("postal-code"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.id("continue"));
    }

    public WebElement getCancelButton() {
        return driver.findElement(By.cssSelector("button[data-test='cancel']"));}

    public WebElement getErrorMessageFirstName() {
        return driver.findElement(By.cssSelector("h3[data-test='error']"));
    }

    public void clickOnTheContinueButton () {
        waitForClickability(getContinueButton());
        getContinueButton().click();

    } // na ovoj stranici treba da unesemo podatke kako bismo zavrsili porudzbinu, pa ubacujemo elemente
    //koji su nam potrebni za to: first name, last name i zip code, kao i continue dugme kako bismo dosli do kraja
}
