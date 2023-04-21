package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SalesTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


  @After
    public void tearDown() {
       closeBrowser();
   }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWOmensJacketsPage() {
        //Finding and clicking on Sale link
        driver.findElement(By.xpath(" //a[@id='ui-id-8'] ")).click();
        //Finding and clicking on Jackets link
        driver.findElement(By.linkText("Jackets")).click();
        // Expected text from requirement
        String expectedText = "Jackets";
        //Finding text element and getting text value
        String actualText = driver.findElement(By.xpath("//div[@class='page-title-wrapper']//h1/span[text()='Jackets']")).getText();
        Assert.assertEquals("Jackets text is not there.", expectedText, actualText);
        String expectedTotalItems = driver.findElement(By.id("toolbar-amount")).getText();
        List<WebElement> jackets = driver.findElements(By.xpath("//div[@class='products wrapper grid products-grid']/ol/li[contains(@class,'item product')]//div[@class='product details product-item-details']//a[@class='product-item-link']"));
        String actualTotalItems = jackets.size() + " Items";
        for (WebElement a : jackets) {
            // Iterating the list and printing titles of each element
            System.out.println(a.getText());
            Assert.assertEquals("Total number of items displayed is not matching.", expectedTotalItems, actualTotalItems);
        }


    }

}

