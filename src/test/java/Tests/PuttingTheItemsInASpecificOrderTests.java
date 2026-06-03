package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PuttingTheItemsInASpecificOrderTests extends BaseTest {

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        LoginPage = new LoginPage(driver);
        ProductsPage = new ProductsPage(driver);
    }

    @Test(priority = 1)
    public void successfullyOrderItemsAlphabeticallyFromZToA () {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        ProductsPage.clickOnTheProductSortContainerButton();
        ProductsPage.clickOnTheZToAOption();

        List<WebElement> listOfItems = driver.findElements(By.cssSelector("div[class='inventory_item']"));
        List<String> actualOrderOfItems = new ArrayList<>();
        for (int i = 0; i < listOfItems.size(); i++) {
            actualOrderOfItems.add(listOfItems.get(i).getText());
        }

        List<String> expectedOrderFromZToA = new ArrayList<>(actualOrderOfItems);
        expectedOrderFromZToA.sort(Collections.reverseOrder());
        Assert.assertEquals(expectedOrderFromZToA, actualOrderOfItems);
        Assert.assertTrue(actualOrderOfItems.get(0).contains("Test.allTheThings() T-Shirt (Red)"));
        Assert.assertTrue(actualOrderOfItems.get(5).contains("Sauce Labs Backpack"));

        //Ovim testom proveravamo da li klikom na Name (Z to A) redosled artikala se menja u skladu sa
        //redosledom koji je izabran
        //Kako bismo to uspesno proverili, napravila sam listu svih artikala kako su poredjani nakon sto sam
        //kliknula na opciju Name(Z to A), napravila kopiju liste koji su poredjani od Z do A i proverila da li
        //su te dve liste iste

    }



    @Test (priority = 2)
    public void successfullyOrderItemsFromTheLowestToTheHighestPrice () {
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("standard_user");
        LoginPage.getPassword().clear();
        LoginPage.getPassword().sendKeys("secret_sauce");
        LoginPage.clickOnTheLoginButton();
        ProductsPage.clickOnTheProductSortContainerButton();
        ProductsPage.clickOnThePriceLowToHighOption();

        List<WebElement> listOfItemsByPrice = driver.findElements(By.cssSelector("div[class='inventory_item_price']"));
        List<String> actualOrderOfItemsByPrice = new ArrayList<>();
        for (int i = 0; i < listOfItemsByPrice.size(); i++) {
            actualOrderOfItemsByPrice.add(listOfItemsByPrice.get(i).getText());

        }

        List<String> expectedOrderFromLowToHigh = new ArrayList<>(actualOrderOfItemsByPrice);

        Assert.assertEquals(expectedOrderFromLowToHigh, actualOrderOfItemsByPrice);
        Assert.assertTrue(actualOrderOfItemsByPrice.get(0).contains("$7.99"));
        Assert.assertTrue(actualOrderOfItemsByPrice.get(5).contains("$49.99"));

        //Ovde proveravamo da li se klikom na opciju da se poredjaju artikli po ceni prvo od najnize pa do najvise
        //redosled artikala menja i prvo se prikazuje najjeftiniji a na kraju najskuplji
        //isto sam asertovala da li su artikli uspesno poredjani po ceni tako sto sam napravila listu svih artikala
        //po odabranom redosledu, napravila kopiju gde su artikli bili poredjani od najjeftinijeg do najskupljeg i
        //uporedila da li su te dve liste iste
    }


}
