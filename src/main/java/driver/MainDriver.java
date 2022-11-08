package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import conf.ConfProperties;

public class MainDriver {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private MainDriver() {
    }

    public static void setDriver() {
        if (driver.get() == null) {
            createDriver();
        }
    }

    private static void createDriver() {
        if (ConfProperties.getProperties().containsKey("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(ConfProperties.getProperties().getProperty("chrome").split(";"));
            driver.set(new ChromeDriver(chromeOptions));
        } else if (ConfProperties.getProperties().containsKey("mozilla")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().close();
            driver.get().quit();
            driver.remove();
        }
    }
}