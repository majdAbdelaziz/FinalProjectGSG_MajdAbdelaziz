import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class popUpTest extends BaseTest{

    BaseTest baseTest = new BaseTest();
    ChromeDriver driver;

    @BeforeClass
    public void setUp() {
        driver = baseTest.setUp("https://www.worldmarket.com/");
    }


    @Test(priority = 1)
    public void verifyThatEmailFieldInThePopUpIsDisplayed(){
        WebElement emailField = driver.findElement(By.xpath("/html/body/div[2]/form/div/input"));
        Assert.assertTrue(emailField.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailField.click();
    }

    @Test(priority = 2)
    public void verifyThatClosePopUpIsDisplayed(){
        WebElement closePopUp = driver.findElement(By.xpath("//*[@id=\"cpwm-additionaldisclaimer3\"]/button"));
        Assert.assertTrue(closePopUp.isDisplayed());
    }
    @Test(priority = 3)
    public void verifyThatClickingClosePopUpClosesIt(){
        WebElement closePopUp = driver.findElement(By.xpath("//*[@id=\"cpwm-additionaldisclaimer3\"]/button"));
        wait.until(ExpectedConditions.elementToBeClickable(closePopUp));
        closePopUp.click();
    }
    @AfterClass
    public void tearDown(){
        baseTest.tearDown();
    }
}
