package ui_pages;

import driver.MainDriver;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import conf.ConfProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties properties;

    protected BasePage() {
        this.driver = MainDriver.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 40);
        properties = ConfProperties.getProperties();
    }

    @Step("Navigating to page with URL: \"{0}\"")
    protected void openPageByUrl(String key) {
        log.debug("Navigate to URL: \"" + properties.getProperty(key) + "\"");
        log.debug("All cookies deleting");
        driver.manage().deleteAllCookies();
        driver.get(properties.getProperty(key));
    }

    @Step("Switch to new tab")
    public void switchToNewTab(int tabNumber) {
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(tabNumber));
    }

    @Step("Open page by url in new tab")
    protected void openPageByUrlNewTab(String key) {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        switchToNewTab(1);
        driver.get(properties.getProperty(key));
    }
}