import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Zalenium {

    static WebDriver driver;

    @BeforeClass
    @Parameters({"browserName"})
    public static void startSession(String browser) throws MalformedURLException {
        if (browser.equalsIgnoreCase("Chrome")) {
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
        }else if (browser.equalsIgnoreCase("firefox")) {
            DesiredCapabilities cap = DesiredCapabilities.firefox();

        }else
            throw new RuntimeException("Wrong Browser Name");
        driver.manage().window().maximize();
        driver.get("https://www.whatismybrowser.com/");
    }

    @AfterClass
    public static void endSession(){
        driver.quit();
    }

    @Test
    public static void Test01_BrowserCheck(){
        WebElement Text = driver.findElement(By.xpath("//*[@id=\"primary-browser-detection-backend\"]/div[1]/a"));
        String Result = Text.getText();
        System.out.println(Result);
    }
}
