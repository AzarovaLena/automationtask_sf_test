package utils;

import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

@Slf4j
public class AllureHelper {

    @Attachment(value = "screenshot.png", type = "image/png")
    public static byte[] takeScreenShot(WebDriver driver) {
        log.debug("Attaching screenshot of failed UI test to Allure report");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
