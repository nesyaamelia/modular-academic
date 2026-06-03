package mu.core.id.website.testcase.platforms.core.academic.banktypeactivity.edit;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import automation.platforms.core.academic.banktypeactivity.edit.EditBankTypeActivityPage;
import automation.platforms.core.academic.banktypeactivity.edit.EditBankTypeActivityModel;
import automation.platforms.core.academic.banktypeactivity.edit.EditBankTypeActivitySteps;
import automation.platforms.core.academic.sidemenu.MenuCoreOptions;
import automation.platforms.core.academic.sidemenu.MenuCorePage;
import automation.platforms.core.academic.sidemenu.MenuCoreSteps;
import automation.platforms.core.user.login.LoginCorePage;
import automation.platforms.core.user.login.LoginCoreSteps;
import mu.core.id.website.testcase.platforms.core.BaseCoreDriverTest;
import org.testng.annotations.Test;

import static automation.utils.StepLogger.verifyStep;

@Epic("Platform Core")
@Feature("Academic - Edit Bank Type Activity")
public class EditBankTypeActivityTest extends BaseCoreDriverTest implements EditBankTypeActivityTestCase {
    private EditBankTypeActivitySteps editBankTypeActivitySteps;
    private EditBankTypeActivityModel editBankTypeActivityModel;
    private LoginCoreSteps loginCoreSteps;
    private MenuCoreSteps menuCoreSteps;

    @Override
    public void initInstance() {
        super.initInstance();
        editBankTypeActivitySteps = new EditBankTypeActivityPage(page);
        editBankTypeActivityModel = new EditBankTypeActivityModel();
        loginCoreSteps = new LoginCorePage(page);
        menuCoreSteps = new MenuCorePage(page);
    }

    @Test(priority = 1, description = "depend = 1671, 1672, 1673, 1675, 1676")
    @Override
    public void editTypeOfActivitySuccessfullyEditTypeOfActivity() {
        navigateToEditBankTypeActivity();
        verifyStep(
                editBankTypeActivitySteps.fillNameBankTypeActivity(editBankTypeActivityModel.editValidNameActivity()),
                "Successfully fill name bank type activity", "Failed fill name bank type activity");
        verifyStep(
                editBankTypeActivitySteps
                        .fillCategoryBankTypeActivity(editBankTypeActivityModel.editValidCategoryActivity("Random")),
                "Successfully fill category activity", "Failed fill category activity");
        verifyStep(
                editBankTypeActivitySteps
                        .fillContentLearningBankTypeActivity(editBankTypeActivityModel.editValidContentLearning()),
                "Successfully fill content learning", "Failed fill content learning");
        verifyStep(editBankTypeActivitySteps.saveEditBankTypeActivity(), "Successfully save edit bank type activity",
                "Failed fill save edit bank type activity");
    }

    @Test(priority = 2, description = "depend = 1677, 1680, 1681")
    @Override
    public void editTypeOfActivityFailedEditTypeOfActivityWhenUserDoesnTFillAllField() {
        navigateToEditBankTypeActivity();
        verifyStep(editBankTypeActivitySteps.clearAllField(), "Successfully clear all field", "Failed clear all field");
        boolean result = editBankTypeActivitySteps.saveEditBankTypeActivity();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 3, description = "1678")
    @Override
    public void editTypeOfActivityFailedEditTypeOfActivityWhenUserInputNamaJenisAktivitasMoreThan_150Characters() {
        navigateToEditBankTypeActivity();
        verifyStep(
                editBankTypeActivitySteps
                        .fillNameBankTypeActivity(editBankTypeActivityModel.editInvalidNameActivityLongChars()),
                "Successfully fill name bank type activity", "Failed fill name bank type activity");
        boolean result = editBankTypeActivitySteps.saveEditBankTypeActivity();
        verifyStep(!result, "Expected error alert for exceeding character limit", "Error alert not shown as expected");
    }

    @Test(priority = 4, description = "1679")
    @Override
    public void editTypeOfActivityFailedEditTypeActivityWhenNamaJenisAktivitasIsEmpty() {
        navigateToEditBankTypeActivity();
        verifyStep(
                editBankTypeActivitySteps
                        .fillNameBankTypeActivity(editBankTypeActivityModel.editInvalidNameActivityEmpty()),
                "Successfully fill name bank type activity with empty",
                "Failed fill name bank type activity with empty");
        boolean result = editBankTypeActivitySteps.saveEditBankTypeActivity();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    private void navigateToEditBankTypeActivity() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_ACTIVITY_TYPE),
                "Successfully navigate to Bank Type Activity menu", "Failed navigate to Bank Type Activity menu");
        verifyStep(
                editBankTypeActivitySteps
                        .navigateToPageEditBankTypeActivity(editBankTypeActivityModel.navigateToEditPage()),
                "Successfully navigate to Bank Type Activity page", "Failed navigate to Bank Type Activity page");
    }
}
