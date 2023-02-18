import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ShopSofasAndSectionalsTest extends BaseTest{
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
    public void verifyThatShopSofasAndSectionalButtonIsDisplayed() {
        WebElement shopSofasAndSectional= driver.findElement(By.xpath("//*[@id=\"slider-container\"]/div/div/div/div/a/div/div/img[1]"));
        Assert.assertTrue(shopSofasAndSectional.isDisplayed());
    }
    @Test(priority = 3)
    public void verifyClickingShopSofasAndSectionalButtonOpensSofasPage(){
        WebElement shopSofasAndSectional= driver.findElement(By.xpath("//*[@id=\"slider-container\"]/div/div/div/div/a/div/div/img[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(shopSofasAndSectional));
        shopSofasAndSectional.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"testgrid\"]/div[1]/div/h1")));
        WebElement sofaPageHeader = driver.findElement(By.xpath("//*[@id=\"testgrid\"]/div[1]/div/h1"));
        Assert.assertEquals(sofaPageHeader,"sofaPageHeader");


    }

    @AfterClass
    public void tearDown(){
        baseTest.tearDown();
    }


}
