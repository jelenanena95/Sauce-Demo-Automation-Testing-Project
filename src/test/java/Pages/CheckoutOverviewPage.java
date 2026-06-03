package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutOverviewPage extends BasePage {
    public CheckoutOverviewPage (WebDriver driver) {
        super(driver);
    }
    WebElement finishButton;
    WebElement cancelButton;
    WebElement itemTotal;



    public WebElement getFinishButton() {
        return driver.findElement(By.cssSelector("button[class='btn btn_action btn_medium cart_button']"));
    }

    public WebElement getCancelButton() {

        return driver.findElement(By.id("cancel"));
    }

    public WebElement getItemTotal() {
        return driver.findElement(By.cssSelector("div[class='summary_subtotal_label']"));
    }

    public void clickOnTheFinishButton() {
        waitForClickability(getFinishButton());
        getFinishButton().click();

    }

    public void clickOnTheCancelButton() {
        waitForClickability(getCancelButton());
        getCancelButton().click();
    }
}
