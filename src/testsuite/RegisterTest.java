package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

     @After
    public void teardown() {
     closeBrowser();}

    @Test

    public void verifyThatSignInPageDisplay() {
        //locate ‘Create an Account’link and click link

        WebElement CreateAnAccountLink = driver.findElement(By.linkText("Create an Account"));
        CreateAnAccountLink.click();
        //This is from requirement
        String exceptedMessage = "Create New Customer Account";
        //find the ‘Create New Customer Account’  text
        WebElement actualMessageElement = driver.findElement(By.tagName("h1"));
        String actualMessage = actualMessageElement.getText();

        Assert.assertEquals(exceptedMessage, actualMessage);

    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {

        driver.findElement(By.linkText("Create an Account")).click();
        driver.findElement(By.id("firstname")).sendKeys("Dhara");
        driver.findElement(By.id("lastname")).sendKeys("Desai");
        //click on subscription btn
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.id("email_address")).sendKeys("108dp@gmail.com");
        driver.findElement(By.id("password")).sendKeys("AimHigh123");
        driver.findElement(By.id("password-confirmation")).sendKeys("AimHigh123");
        driver.findElement(By.xpath("//button[@class='action submit primary']//span[contains(text(),'Create an Account')]")).click();
       //Verify the message
        String expectedMessage = "Thank you for registering with Main Website Store.";
        WebElement actualMessageElement = driver.findElement(By.xpath("//div[contains(text(),'Thank you for registering with Main Website Store.')]"));
        String actualMessage =actualMessageElement.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage,actualMessage);
        driver.findElement(By.xpath("//body[1]/div[1]/header[1]/div[1]/div[1]/ul[1]/li[2]/span[1]")).click();
        driver.findElement(By.xpath("//li[@class='authorization-link']")).click();
        // Expected message from requirements
        String expectedMessage1 = "You are signed out";
        WebElement actualMessageElement1 = driver.findElement(By.xpath("//span[contains(text(),'You are signed out')]"));
        String actualMessage1 =actualMessageElement1.getText();
        System.out.println(actualMessage1);
        Assert.assertEquals(expectedMessage1,actualMessage1);


    }




}




