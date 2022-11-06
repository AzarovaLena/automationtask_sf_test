package ui_pages;

import driver.Listener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import static driver.MainDriver.getDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

@Listeners(Listener.class)
public class BaseTest {
    public static WebDriver driver;

    @BeforeTest
    public void setupDriver(ITestContext context) {
        driver = getDriver();
    }

    protected LoginPage loginPage;

    @BeforeClass(description = "Initializing pages objects", alwaysRun = true)
    public void initPages() {
        loginPage = initElements(driver, LoginPage.class);
    }
}