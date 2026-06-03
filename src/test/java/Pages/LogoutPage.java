package Pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage extends BasePage {
    public LogoutPage (WebDriver driver) {
        super(driver);}
    WebElement logoutButton;



    public WebElement getLogoutButton() {
        return driver.findElement(By.id("logout_sidebar_link"));
    }

    public void clickOnTheLogoutButton() {
        waitForClickability(getLogoutButton());
        getLogoutButton().click();

    }
}
