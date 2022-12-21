import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Zalenium {

    public static WebDriver driver;
    public static DesiredCapabilities cap;

    @BeforeClass
    @Parameters({"browserName"})
    public static void startSession(String browser) throws MalformedURLException {
        if (browser.equalsIgnoreCase("Chrome")) {
            cap = DesiredCapabilities.chrome();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
        }else if (browser.equalsIgnoreCase("firefox")) {
            cap = DesiredCapabilities.firefox();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
        }else
            throw new RuntimeException("Wrong Browser Name");
        driver.manage().window().maximize();
    }
    @Test
    public static void Test01_browserCheck(){
        driver.get("https://www.whatismybrowser.com/");
        WebElement Text = driver.findElement(By.xpath("//*[@id=\"primary-browser-detection-backend\"]/div[1]/a"));
        String Result = Text.getText();
        System.out.println(Result);
    }
    @AfterClass
    public static void endSession(){
        driver.quit();
    }
}
