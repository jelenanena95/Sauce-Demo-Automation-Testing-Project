package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    } //napravila sam metodu koja ce da ceka 15 sekundi da element postane vidljiv pre nego sto javi da je test pao
    //ovo je napravljeno u BasePage klasi kako ne bih morala u svakoj page klasi da pravim novi waiter nego ce sve page
    //klase da naslede BasePage i onda cu samo da pozivam waiter iz ove klase


    public void waitForClickability(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    } //napravila sam metodu koja ce da ceka 15 sekundi da element postane klikabilan pre nego sto javi da je test pao
    //nekada ce neki popup da prekrije taj element i sa ovim waiterom test ce da zastane na 15 sekundi ako element
    // jos nije klikabilan i ako treba da ukloni taj popup nakon cega ce element da bude klikabilan
    //kao i za prethodnu metodu, i ova metoda je napravljena u BasePage klasi kako ne bih morala u svakoj page klasi da
    // pravim novi waiter nego ce sve page klase da naslede BasePage i onda cu samo da pozivam waiter iz ove klase


}
