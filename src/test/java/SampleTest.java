import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class SampleTest {
    WebDriver driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // String dir=System.getProperty("user.dir");
        // String driverLocation = dir + File.separatorChar + "src" + File.separatorChar + "main" + File.separatorChar + "java" + File.separatorChar + "chromedriver_linux";
        // System.setProperty("webdriver.chrome.driver", driverLocation);
        // ChromeOptions options = new ChromeOptions();
        // options.addArguments("test-type");
        // options.addArguments("--window-size=1400,600");
        // options.addArguments("--disable-extensions");
        //  options.addArguments("--headless");
        // options.addArguments("--no-sandbox");
        // options.addArguments("start-maximized");
        // System.setProperty("webdriver.chrome.whitelistedIps", "");
        // driver = new ChromeDriver(options);
        DesiredCapabilities desiredCapabilities= DesiredCapabilities.chrome();
        driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),desiredCapabilities);
        driver.manage().window().maximize();
    }

    @Test
    public void assertGoogleTitle2(){
        driver.get("https://www.google.com");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getTitle().contains("Google"),"title mismatched");
    }

    @Test
    public void assertGoogleTitle3(){
        driver.get("https://www.bing.com");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getTitle().contains("Bing"),"title mismatched");
    }

    @Test
    public void assertGoogleTitle4(){
        driver.get("https://www.facebook.com");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getTitle().contains("Facebook"),"title mismatched");
    }

    @Test
    public void assertGoogleTitle5(){
        driver.get("https://www.gmail.com");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getTitle().contains("Gmail"),"title mismatched");
    }

    @Test
    public void assertGoogleTitle(){
        driver.get("https://www.youtube.com");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getTitle().contains("Youtube"),"title mismatched");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
