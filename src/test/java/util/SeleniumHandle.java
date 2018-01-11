package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumHandle {
    public static SeleniumHandle seleniumHandle;
    private WebDriver driver;
    private String browserName;
    private String browserVersion;

    public SeleniumHandle() {
    }

    public static WebDriver getDriver() {
        if (seleniumHandle == null) {
            seleniumHandle = new SeleniumHandle();
            seleniumHandle.setUp();
        }
        return seleniumHandle.driver;
    }

    public void setUp() {
        // declaration and instantiation of objects/variables

        if (true) {
            // https://chromedriver.storage.googleapis.com/index.html?path=2.35/

            //System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver","/Users/rpowell/dev/fox-automation/chromedriver");
            //System.out.println("webdriver.chrome.driver: " + System.getProperty("webdriver.chrome.driver"));
            driver = new ChromeDriver();

        } else {
            // https://github.com/mozilla/geckodriver/releases/tag/v0.19.1
            // System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");

            // Firefox 35.0.1
            // geckodriver geckodriver-v0.19.1-macos.tar.gz

            System.setProperty("webdriver.firefox.marionette","geckodriver");
            driver = new FirefoxDriver();

        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        browserName = caps.getBrowserName();
        browserVersion = caps.getVersion();

        System.out.println("Automated test run. We’re running on " + browserName + " " + browserVersion);

    }

    public void tearDown() {
        driver.quit();
    }
}