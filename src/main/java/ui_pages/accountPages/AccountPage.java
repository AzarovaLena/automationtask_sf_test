package ui_pages.accountPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui_pages.BasePage;
import ui_pages.model.TrialOrg;

import java.util.List;
import java.util.stream.Collectors;

public class AccountPage extends BasePage {
    @FindBy(xpath = "//one-app-nav-bar-item-root[@data-id='Account']")
    protected WebElement accountTab;
    @FindBy(xpath = "//a[@title='New']")
    protected WebElement newButton;
    @FindBy(xpath = "//a[@class='toggle slds-th__action slds-text-link--reset ']")
    protected WebElement accountNameFilter;
    @FindBy(xpath = "//input[contains(@class, 'default input uiInput uiInputTextForAutocomplete')]")
    protected WebElement accountNameField;
    @FindBy(xpath = "//button[@title='Save']")
    protected WebElement saveButton;
    @FindBy(xpath = "//span[@class='searchLabel']")
    protected WebElement searchAddress;
    @FindBy(xpath = "//input[@class=' input']")
    protected List<WebElement> inputData;
    @FindBy(xpath = "//span[contains(@class, 'slds-grid')]//a[@data-refid='recordId']")
    protected List<WebElement> accountList;
    @FindBy(xpath = "//button[@name='Edit']")
    protected WebElement editButton;
    @FindBy(xpath = "//h3[contains(@class, 'slds-section__title slds-theme--shade primaryPaletteBorder')]")
    protected WebElement accountSummary;
    @FindBy(xpath = "//div[contains(@class, 'uiInput')]//input[contains(@class, 'input uiInput uiInputText ')]")
    protected WebElement accountEditNameField;
    @FindBy(xpath = "//lightning-formatted-text[@class='custom-truncate']")
    protected WebElement editedAccountName;
    @FindBy(xpath = "//flexipage-tab2[@class='slds-tabs_default__content slds-show']")
    protected WebElement newAccount;
    @FindBy(xpath = "//div[@class='forceVisualMessageQueue']")
    protected WebElement successMessage;


    @Step("Click an account tab")
    public AccountPage clickAccountTab() {
        accountTab.click();
        if (accountList.size() > 0) {
            WebElement lastAccount = accountList.get(accountList.size() - 1);
            wait.until(ExpectedConditions.elementToBeClickable(lastAccount));
        }
        wait.until(ExpectedConditions.visibilityOf(accountNameFilter));
        return this;
    }

    @Step("Click button new for creating account")
    public AccountPage createNewAccount() {
        newButton.click();
        wait.until(ExpectedConditions.visibilityOf(searchAddress));
        return this;
    }

    @Step("Fill in the field with the account name")
    public String fillAccountName(TrialOrg accountName) {
        accountNameField.sendKeys(accountName.getAccountName());
        return accountName.getAccountName();
    }

    @Step("Fill in the field with the phone number")
    public AccountPage fillPhoneNumber(TrialOrg phone) {
        inputData.get(inputData.size() - 1).sendKeys(phone.getPhone());
        return this;
    }

    @Step("Click save button")
    public AccountPage clickSaveButton() {
        saveButton.click();
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        wait.until(ExpectedConditions.invisibilityOf(successMessage));
        return this;
    }

    @Step("Get list with names of accounts")
    public List<String> getAccountsNames() {
        return accountList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Step("Click on the first account in the list")
    public AccountPage clickFirstAccount() {
        accountList.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(editButton));
        return this;
    }

    @Step("Click edit button")
    public AccountPage clickEditButton() {
        editButton.click();
        wait.until(ExpectedConditions.visibilityOf(accountSummary));
        return this;
    }

    @Step("Fill account name field in edit form")
    public String editAccountName(TrialOrg value) {
        accountEditNameField.clear();
        accountEditNameField.sendKeys(value.getNewName());
        return value.getNewName();
    }

    @Step("Get edited account name")
    public String getEditedAccountName() {
        return editedAccountName.getText();
    }
}
