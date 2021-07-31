import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class SampleTest {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        String dir=System.getProperty("user.dir");
        String driverLocation = dir + File.separatorChar + "src" + File.separatorChar + "main" + File.separatorChar + "java" + File.separatorChar + "chromedriver_mac";
        System.setProperty("webdriver.chrome.driver", driverLocation);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("--window-size=1400,600");
        options.addArguments("--disable-extensions");
        // options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("start-maximized");
        System.setProperty("webdriver.chrome.whitelistedIps", "");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @Test
    public void assertGoogleTitle(){
        driver.get("https://www.google.com");
        Assert.assertTrue(driver.getTitle().contains("Google"),"title mismatched");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
