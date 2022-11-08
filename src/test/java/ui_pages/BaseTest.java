package ui_pages;

import driver.Listener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import ui_pages.accountPages.AccountPage;
import ui_pages.initTrialOrgPages.GoogleAccountPage;
import ui_pages.initTrialOrgPages.LoginPage;
import utils.AllureHelper;

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
    protected GoogleAccountPage googleAccountPage;
    protected AccountPage accountPage;

    @BeforeClass(description = "Initializing pages objects", alwaysRun = true)
    public void initPages() {
        loginPage = initElements(driver, LoginPage.class);
        googleAccountPage = initElements(driver, GoogleAccountPage.class);
        accountPage = initElements(driver, AccountPage.class);
    }

    @AfterMethod(description = "Logs gathering stage", alwaysRun = true)
    private void attachScreenshotToUITest() {
        WebDriver currentUIDriver = getDriver();
        if (currentUIDriver != null) {
            AllureHelper.takeScreenShot(currentUIDriver);
        }
    }
}