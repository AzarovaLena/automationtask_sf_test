package ui_pages.initTrialOrgPages;

import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui_pages.BasePage;
import ui_pages.model.TrialOrg;

public class GoogleAccountPage extends BasePage {
    @FindBy(id = "headingText")
    protected WebElement headingText;
    @FindBy(name = "identifier")
    protected WebElement emailField;
    @FindBy(xpath = "//button[contains(@class, 'VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ')]")
    protected WebElement nextButton;
    @FindBy(xpath = "//input[@name='Passwd']")
    protected WebElement passwordField;
    @FindBy(xpath = "//div[contains(@class, 'ae4 aDM ')]//tr[1]")
    protected WebElement newEmail;
    @FindBy(xpath = "//div[contains(@class, 'a3s aiL ')]")
    protected WebElement text;
    @FindBy(xpath = "//input[@id='emc']")
    protected WebElement codeField;
    @FindBy(id = "save")
    protected WebElement verifyButton;
    @FindBy(xpath = "//div[contains(@class, 'gs')]//img[contains(@Class, 'ajT')]")
    protected WebElement lastLetter;


    @Step("Open 'Email' page via url")
    public GoogleAccountPage openAccountPage() {
        openPageByUrlNewTab("email.url");
        wait.until(ExpectedConditions.visibilityOf(headingText));
        return this;
    }

    @Step("Fill email field for google account")
    public GoogleAccountPage fillEmail(TrialOrg email) {
        emailField.sendKeys(email.getEmail());
        return this;
    }

    @Step("Click continue button")
    public GoogleAccountPage clickNextButton() {
        nextButton.click();
        return this;
    }

    @Step("Fill password field for google account")
    public GoogleAccountPage fillPassword(TrialOrg password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(password.getPassword());
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        return this;
    }

    @Step("Get verify code from gmail")
    public String getVerifyCode() {
        //this is a temporary solution for a test task
        try {
            newEmail.click();
        } catch (StaleElementReferenceException e) {
            newEmail.click();
        }
        try {
            lastLetter.click();
        } catch (StaleElementReferenceException e) {
            lastLetter.click();
        }
        String letterText = text.getText().replaceAll("[^0-9]", "");
        return letterText.substring(1);
    }

    @Step("Fill to verify code in login page")
    public GoogleAccountPage fillVerifyCode(String code) {
        switchToNewTab(0);
        codeField.sendKeys(code);
        verifyButton.click();
        return this;
    }
}
