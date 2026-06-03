package Pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutPage extends BasePage {
    public AboutPage (WebDriver driver) {
        super(driver);
    }
    WebElement tryItForFreeButton;
    WebElement title;
    //ovo su svi elementi koji ce da nam budu potrebni
    //to radimo na svakoj stranici, navodimo ih, pravimo gettere za njih preko kojih
    //te elemente nalazimo u metodama koje pravimo na svakoj stranici ili u testovima



    public WebElement getTryItForFreeButton() {
        return driver.findElement(By.cssSelector("span[class='MuiTouchRipple-root css-4mb1j7']"));
    }

    public WebElement getTitle () {
        return driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[1]/div/div/div[1]/div/div[1]/div[1]/h1"));
    }

    public void clickOnTheTryItForFreeButton() {
        waitForClickability(getTryItForFreeButton());
        getTryItForFreeButton().click();
    }
    // ove metoda ce da posluzi da asertujemo da li smo otisli na AboutSauceDemo stranicu
    //jer se ovo dugme pojavljuje tamo
    //u page klasama pravimo metode koje cemo posle samo da pozivamo u testovima

    public void titleIsVisible() {
        waitForClickability(getTitle());
    }
    //ova metoda ce isto da nam posluzi da da asertujemo isti test, jer sluzi da dohvati titl
    //koji se nalazi na About stranici
}


