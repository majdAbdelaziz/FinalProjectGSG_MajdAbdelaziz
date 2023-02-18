import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class AddToWishListTest extends BaseTest {
    BaseTest baseTest= new BaseTest();
    ChromeDriver driver;

    JavascriptExecutor js;
    private Map<String, Object> vars;
    @BeforeClass
    public void setUp(){
        driver=  baseTest.setUp("https://www.worldmarket.com/category/home-decor-pillows.do");
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

    }
    @Test(priority = 1)
    public void verifyThatClickingClosePopUpClosesIt(){
        WebElement closePopUp = driver.findElement(By.xpath("//*[@id=\"cpwm-additionaldisclaimer3\"]/button"));
        wait.until(ExpectedConditions.elementToBeClickable(closePopUp));
        closePopUp.click();
    }
  /**  @Test(priority = 2)
    public void verifyThatClickingTheImageOpensPage(){
        driver.get("https://www.worldmarket.com/category/home-decor-pillows.do");
        driver.manage().window().setSize(new Dimension(1346, 708));
        driver.findElement(By.xpath("//img[@alt=\'New Decor & Pillows\']")).click();
        js.executeScript("window.scrollTo(0,683)");
        {
            WebElement element = driver.findElement(By.xpath("//a[contains(text(),\'Multicolor Abstract Jacquard Throw Pillow\')]"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.xpath("//a[contains(text(),\'Multicolor Abstract Jacquard Throw Pillow\')]"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.xpath("//a[contains(text(),\'Multicolor Abstract Jacquard Throw Pillow\')]")).click();
        js.executeScript("window.scrollTo(0,238)");
        driver.findElement(By.id("addtoWishlist_463231")).click();
    }*/
   @AfterClass
    public void tearDown(){
        baseTest.tearDown();
    }
}
