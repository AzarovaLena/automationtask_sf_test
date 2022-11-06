package ui_pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui_pages.model.LoginForm;

public class LoginPage extends BasePage{
    @FindBy(id = "username")
    protected WebElement usernameField;

    @Step("Open 'Login Page' page via url")
    public LoginPage openLoginPage() {
        openPageByUrl();
        return this;
    }

    @Step("Fill username field")
    public LoginPage fillUsername(LoginForm userName) {
        usernameField.sendKeys(userName.getUserName());
        return this;
    }
}
