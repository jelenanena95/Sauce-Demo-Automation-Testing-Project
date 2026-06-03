package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    WebElement username;
    WebElement password;
    WebElement loginButton;
    WebElement errorLoggingIn;



    public WebElement getUsername() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.id("login-button"));
    }

    public WebElement getErrorLoggingIn() {
        return driver.findElement(By.cssSelector("h3[data-test='error']"));
    }


    public void clickOnTheLoginButton() {
        waitForClickability(getLoginButton());
        getLoginButton().click();
    }

    //ovde smo ubacili elemente koji su nam potrebni i za uspesno i za neuspesno logovanje


}
