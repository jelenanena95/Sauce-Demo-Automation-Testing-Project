package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenMenuDropDownPage extends BasePage {
    public OpenMenuDropDownPage (WebDriver driver) {
        super(driver);}
    WebElement logoutButton;
    WebElement aboutButton;
    WebElement allItemsButton;
    WebElement closeMenuButton;




    public WebElement getAboutButton() {
        return driver.findElement(By.id("about_sidebar_link"));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.id("logout_sidebar_link"));
    }

    public WebElement getAllItemsButton() {
        return driver.findElement(By.id("inventory_sidebar_link"));
    }

    public WebElement getCloseMenuButton() {
        return driver.findElement(By.xpath("//*[@id=\"react-burger-cross-btn\"]"));
    }

    public void clickOnTheLogoutButton() {
        waitForClickability(getLogoutButton());
        getLogoutButton().click();

    }

    public void clickOnTheAboutButton() {
        waitForClickability(getAboutButton());
        getAboutButton().click();

    }

    public void clickOnTheAllItemsButton() {
        waitForClickability(getAllItemsButton());
        getAllItemsButton().click();

    }

    public void clickOnTheCloseMenuButton() {
        waitForClickability(getCloseMenuButton());
        getCloseMenuButton().click();
    }

    //sa ove stranice zelimo da testiramo da li su sve opcije koje postoje kada se klikne na Open Menu
    //dostupne i da rade kako treba
}
