package ui_pages.initTrialOrgPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui_pages.BasePage;
import ui_pages.model.TrialOrg;

public class LoginPage extends BasePage {
    @FindBy(id = "username")
    protected WebElement usernameField;
    @FindBy(id = "logo")
    protected WebElement logo;
    @FindBy(id = "password")
    protected WebElement passwordField;
    @FindBy(id = "Login")
    protected WebElement loginButton;
    @FindBy(id = "header")
    protected WebElement verifyIdentity;

    @Step("Open 'Login Page' page via url")
    public LoginPage openLoginPage() {
        openPageByUrl("application.url");
        wait.until(ExpectedConditions.visibilityOf(logo));
        return this;
    }

    @Step("Fill the username field")
    public LoginPage fillUsername(TrialOrg userName) {
        usernameField.sendKeys(userName.getUserName());
        return this;
    }

    @Step("Fill the password field")
    public LoginPage fillPassword(TrialOrg password) {
        passwordField.sendKeys(password.getPassword());
        return this;
    }

    @Step("Click login button")
    public LoginPage clickLogin() {
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(verifyIdentity));
        return this;
    }
}
