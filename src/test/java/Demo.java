import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.AssertJUnit.assertEquals;

public class Demo
{
    WebDriver driver;
    String expectedTitleName = "IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows";
    String expectedUrlAddress = "https://www.imdb.com/";

    @BeforeClass
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://imdb.com");
    }

    @Test
    public void test()
    {
        driver.navigate().refresh();
        String actualTitleName = driver.getTitle();
        System.out.println("Title is: " + actualTitleName);
        String actualUrlAddress = driver.getCurrentUrl();
        System.out.println("Address is: " + actualUrlAddress);

        if (actualTitleName.equals(expectedTitleName))
            System.out.println("Title Test Passed");
        else
            System.out.println("Title Test Failed");

        if (actualUrlAddress.equals(expectedUrlAddress))
            System.out.println("Address Test Passed");
        else
            System.out.println("Address Test Failed");

        assertEquals(expectedTitleName,actualTitleName);
        assertEquals(expectedUrlAddress,actualUrlAddress);

        System.out.println("\n Test SUCCESS!!! \n changing The JDK");

    }

    @AfterClass
    public void closeBrowser()
    {
        driver.quit();
    }
}