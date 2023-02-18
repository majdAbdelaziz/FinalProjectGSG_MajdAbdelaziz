import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomePageTest extends BaseTest {
    BaseTest baseTest= new BaseTest();
    ChromeDriver driver;
    @BeforeClass
    public void setUp(){
        driver=  baseTest.setUp("https://www.worldmarket.com/");
    }
    @Test(priority = 1)
    public void verifyThatClickingClosePopUpClosesIt(){
        WebElement closePopUp = driver.findElement(By.xpath("//*[@id=\"cpwm-additionaldisclaimer3\"]/button"));
        wait.until(ExpectedConditions.elementToBeClickable(closePopUp));
        closePopUp.click();
    }
    @Test(priority = 2)
    public void verifyThatHomeScreenIsOpenedSuccessfully() {
        WebElement sliderContainer = driver.findElement(By.id("slider-container"));
        assertTrue(sliderContainer.isDisplayed());
    }
    @Test(priority = 3)
    public void VerifyThatShopNowButtonIsDisplayed(){
        WebElement shopNow= driver.findElement(By.xpath("//*[@id=\"home_topnav_layout_15_fillslot-7\"]/a/div"));
        assertTrue(shopNow.isDisplayed());
    }

    @Test(priority = 4)
    public void verifyThatEmailUsButtonIsDisplayed(){
        WebElement emailUs = driver.findElement(By.xpath("//*[@id=\"ml-footer-contact-wrapper\"]/a[2]/div"));
        assertTrue(emailUs.isDisplayed());
    }

    @Test(priority = 5)
    public void verifyThatEmailUsButtonIsClickable(){
        WebElement emailUs = driver.findElement(By.xpath("//*[@id=\"ml-footer-contact-wrapper\"]/a[2]/div"));
        wait.until(ExpectedConditions.elementToBeClickable(emailUs));
        emailUs.click();
    }


    @AfterClass
    public void tearDown(){
        baseTest.tearDown();
    }
}

