package ui_pages.accountTests;

import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui_pages.BaseTest;
import ui_pages.model.TrialOrg;

import static utils.JsonUtil.readJsonObjectFromFile;

@Feature("[UI][Trial Org] Accounts")
public class AccountTests extends BaseTest {
    private static TrialOrg TRIAL_ORG_DATA;

    @BeforeClass(description = "Login to the trial org")
    public void loginTrialOrg() {
        TRIAL_ORG_DATA = readJsonObjectFromFile("src/test/resources/test_data/trial_org_data.json", TrialOrg.class);

        loginPage.openLoginPage()
                .fillUsername(TRIAL_ORG_DATA)
                .fillPassword(TRIAL_ORG_DATA)
                .clickLogin();
        googleAccountPage.openAccountPage()
                .fillEmail(TRIAL_ORG_DATA)
                .clickNextButton()
                .fillPassword(TRIAL_ORG_DATA)
                .clickNextButton();
        String code = googleAccountPage.getVerifyCode();
        googleAccountPage.fillVerifyCode(code);
    }

    @Test(description = "Create a new account", priority = 1)
    public void createNewAccount() {
        accountPage.clickAccountTab()
                .createNewAccount();
        String accountName = accountPage.fillAccountName(TRIAL_ORG_DATA);
        accountPage.fillPhoneNumber(TRIAL_ORG_DATA)
                .clickSaveButton()
                .clickAccountTab();
        Assert.assertTrue(accountPage.getAccountsNames().stream().anyMatch(name -> name.equals(accountName)));
    }

    @Test(description = "Edit an account", priority = 2)
    public void editAccount() {
        accountPage.clickFirstAccount();
        accountPage.clickEditButton();
        String editAccountName = accountPage.editAccountName(TRIAL_ORG_DATA);
        accountPage.clickSaveButton();
        Assert.assertTrue(accountPage.getEditedAccountName().equals(editAccountName));
    }
}
