package ui_pages;

import driver.MainDriver;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import conf.ConfProperties;
import java.util.Properties;

@Slf4j
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties properties;

    protected BasePage() {
        this.driver = MainDriver.getDriver();
        wait = new WebDriverWait(driver, 40);
        properties = ConfProperties.getProperties();
    }

    @Step("Navigating to page with URL: \"{0}\"")
    protected void openPageByUrl() {
       // log.debug("Navigate to URL: \"" + properties.getProperty("application.url") + "\"");
        driver.get(properties.getProperty("application.url"));
    }



    protected void click(By element) {
        driver.findElement(element).click();
    }

    protected void sendKeys(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    protected String getText(By element) {
       return driver.findElement(element).getText();
    }

    protected void moveToElement(WebElement element){
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
    }
}