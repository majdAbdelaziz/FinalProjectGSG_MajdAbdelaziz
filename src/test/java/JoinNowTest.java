import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JoinNowTest extends BaseTest{
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
    public void verifyJoinNowIsDisplayed(){
        WebElement JoinNow= driver.findElement(By.xpath("//*[@id=\"gpsnonjoin\"]"));
        Assert.assertTrue(JoinNow.isDisplayed());
    }

    @Test(priority = 3)
    public void verifyClickingJoinNowOpensTheForm(){
       WebElement joinNow= driver.findElement(By.xpath("//*[@id=\"gpsnonjoin\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(joinNow));
        joinNow.click();
     /**   WebElement joinNowForm = driver.findElement(By.xpath("//*[@id=\"ml-body-container\"]/main/div/div/div"));
        Assert.assertTrue(joinNowForm .isDisplayed());*/
    }

 /**   @Test(priority = 4)
    public void verifyThatFillingTheFormOutDisplayesSuccessMessage()
    {
        WebElement joinNow= driver.findElement(By.xpath("//*[@id=\"gpsnonjoin\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(joinNow));
        joinNow.click();
        driver.findElement(By.id("gpsnonjoin")).click();
        driver.findElement(By.id("create_firstName")).click();
        driver.findElement(By.id("create_firstName")).sendKeys("Majd");
        driver.findElement(By.id("create_lastName")).click();
        driver.findElement(By.id("create_lastName")).sendKeys("Abdelaziz");
        driver.findElement(By.id("loginEmailCreateAccount")).click();
        driver.findElement(By.id("loginEmailCreateAccount")).sendKeys("majd@gmail.com");
        driver.findElement(By.id("userPasswordCreate")).click();
        driver.findElement(By.id("userPasswordCreate")).sendKeys("123456");
        driver.findElement(By.id("memberIdInputCreateAccount")).click();
        driver.findElement(By.id("memberIdInputCreateAccount")).sendKeys("0599123456");
        driver.findElement(By.id("birthdayMonth")).click();
        {
            WebElement dropdown = driver.findElement(By.id("birthdayMonth"));
            dropdown.findElement(By.xpath("//option[. = 'January']")).click();
        }
        driver.findElement(By.cssSelector(".ml-wm-form-with-focus")).click();
        {
            WebElement dropdown = driver.findElement(By.id("birthdayDay"));
            dropdown.findElement(By.xpath("//option[. = '5']")).click();
        }
        driver.close();
    }*/

    @AfterClass
    public void tearDown(){
        baseTest.tearDown();
    }
}