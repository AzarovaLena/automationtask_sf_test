package ui_pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui_pages.model.LoginForm;

import static conf.JsonUtil.readJsonObjectFromFile;

public class LoginTests extends BaseTest {
    private static LoginForm LOGIN_FORM_DATA;

    @BeforeClass(description = "Test data init", alwaysRun = true)
    public void testDataInit() {
        LOGIN_FORM_DATA = readJsonObjectFromFile("src/test/resources/test_data/login_form.json", LoginForm.class);

    }

    @Test(description = "")
    public void deliveryPageOpeningViaMenu() {
        loginPage.openLoginPage()
                .fillUsername(LOGIN_FORM_DATA);
    }
}
