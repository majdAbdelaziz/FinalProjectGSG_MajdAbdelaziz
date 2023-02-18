import com.github.dockerjava.api.model.CpuStatsConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchBoxTest extends BaseTest {
    BaseTest baseTest = new BaseTest();
    ChromeDriver driver;

    @BeforeClass
    public void setUp() {
        driver = baseTest.setUp("https://www.worldmarket.com/");
    }

    @Test(priority = 1)
    public void verifyThatSearchBoxIsDisplayed() {
        WebElement searchBox = driver.findElement(By.id("navsearchbox"));
        Assert.assertTrue(searchBox.isDisplayed());
    }


    @Test(priority = 2)
    public void verifyThatSearchBoxIsWritable() {
        WebElement closePopUp = driver.findElement(By.xpath("//*[@id=\"cpwm-additionaldisclaimer3\"]/button"));
        wait.until(ExpectedConditions.elementToBeClickable(closePopUp));
        closePopUp.click();
        WebElement searchBox = driver.findElement(By.id("navsearchbox"));
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchBox.sendKeys("Sofa");
        searchBox.sendKeys(Keys.ENTER);
        WebElement searchResult = driver.findElement(By.xpath("//*[@id=\"catalogResult\"]/div[2]/div[1]"));
        Assert.assertTrue(searchResult.equals("You searched for: \"Sofa\""));

    }
    @AfterClass
    public void tearDown(){
        baseTest.tearDown();
    }
}



