package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

//    @After
//    public void teardown() {
//        closeBrowser();
//    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //click on Sign In
        driver.findElement(By.xpath("//div[@class='panel header']//li/a[contains(text(),'Sign In')]")).click();
        //Enter email
        driver.findElement(By.id("email")).sendKeys("a123dp@gmail.com");
        //Enter password
        driver.findElement(By.id("pass")).sendKeys("AAimHigh123");
        //click on sing in button
        driver.findElement(By.xpath("//div[@class='login-container']//button[@id='send2']")).click();
        //getting text message
        String greetingMessage = driver.findElement(By.xpath("//div[@class='panel header']//li[@class='greet welcome']/span[contains(text(),'Welcome')]")).getText().substring(0, 7);
        String welcomeText = "Welcome";
        //verifying welcome text displayed
        Assert.assertEquals("Error: Actual message does not have Welcome text", welcomeText, greetingMessage);
    }

    @Test
    public void verifyThatErrorMessageWithInvalidCredentials() {
        // click on sign in
        driver.findElement(By.xpath("//div[@class='panel header']//li/a[contains(text(),'Sign In')]")).click();
        //enter invalid email
        driver.findElement(By.id("email")).sendKeys("a123dp@gmail.com");
        //enter password
        driver.findElement(By.id("pass")).sendKeys("AAimHigh123");
        //click on Sign In button
        driver.findElement(By.xpath("//div[@class='login-container']//button[@id='send2']")).click();
        //getting error message
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='page messages']//div[@class='message-error error message']")).getText();
        //expected error message
        String expectedErrorMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        //verifying error message
        Assert.assertEquals("Error: Messages DO NOT Match", expectedErrorMessage, actualErrorMessage);
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        //click on sign in
        driver.findElement(By.xpath("//div[@class='panel header']//li/a[contains(text(),'Sign In')]")).click();
        //enter valid email
        driver.findElement(By.id("email")).sendKeys("a123dp@gmail.com");

        //enter valid password
       driver.findElement(By.id("pass")).sendKeys("AAimHigh123");


//        //click on sign in
        driver.findElement(By.xpath("//div[@class='login-container']//button[@id='send2']")).click();
        String expectedText = "Welcome"; // Expected text from requirement
//        //Finding text element and getting the text trimming unwanted part
        String actualText = driver.findElement(By.xpath("//div[@class='panel header']//li[@class='greet welcome']/span[contains(text(),'Welcome')]")).getText().substring(0, 7);
        driver.findElement(By.xpath("//button[@class='action switch']")).click();
        driver.findElement(By.xpath("//li[@class='authorization-link']")).click();
//        // Expected message from requirements
        String expectedMessage1 = "You are signed out";
        String actualMessage1 = driver.findElement(By.xpath("//span[contains(text(),'You are signed out')]")).getText();
        Assert.assertEquals("User was unable to sign out.", expectedMessage1, actualMessage1);


    }

}
