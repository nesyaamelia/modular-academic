package mu.core.id.website.testcase.platforms.core.academic.banktypeactivity.create;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import automation.platforms.core.academic.sidemenu.MenuCoreOptions;
import automation.platforms.core.academic.sidemenu.MenuCorePage;
import automation.platforms.core.academic.sidemenu.MenuCoreSteps;
import automation.platforms.core.academic.banktypeactivity.create.CreateBankTypeActivityModel;
import automation.platforms.core.academic.banktypeactivity.create.CreateBankTypeActivityPage;
import automation.platforms.core.academic.banktypeactivity.create.CreateBankTypeActivitySteps;
import automation.platforms.core.user.login.LoginCorePage;
import automation.platforms.core.user.login.LoginCoreSteps;
import mu.core.id.website.testcase.platforms.core.BaseCoreDriverTest;
import org.testng.annotations.Test;

import static automation.utils.StepLogger.verifyStep;

@Epic("Platform Core")
@Feature("Academic - Create Bank Type Activity")
public class CreateBankTypeActivityTest extends BaseCoreDriverTest implements CreateBankTypeActivityTestCase {
    private CreateBankTypeActivitySteps createBankTypeActivitySteps;
    private CreateBankTypeActivityModel createBankTypeActivityModel;
    private LoginCoreSteps loginCoreSteps;
    private MenuCoreSteps menuCoreSteps;

    @Override
    public void initInstance() {
        super.initInstance();
        createBankTypeActivitySteps = new CreateBankTypeActivityPage(page);
        createBankTypeActivityModel = new CreateBankTypeActivityModel();
        loginCoreSteps = new LoginCorePage(page);
        menuCoreSteps = new MenuCorePage(page);
    }

    @Test(priority = 1, description = "depend = CA-325, CA-326, CA-328, CA-335")
    @Override
    public void addTypeOfActivitySuccessfullyAddTypeOfActivity() {
        navigateToCreateBankTypeActivity();
        verifyStep(
                createBankTypeActivitySteps.fillNameBankTypeActivity(createBankTypeActivityModel.validNameActivity()),
                "Successfully fill name bank type activity", "Failed fill name bank type activity");
        verifyStep(
                createBankTypeActivitySteps
                        .fillCategoryBankTypeActivity(createBankTypeActivityModel.validCategoryActivity()),
                "Successfully fill category activity", "Failed fill category activity");
        verifyStep(
                createBankTypeActivitySteps
                        .fillContentLearningBankTypeActivity(createBankTypeActivityModel.validContentLearning()),
                "Successfully fill content learning", "Failed fill content learning");
        verifyStep(createBankTypeActivitySteps.saveBankTypeActivity(), "Successfully save bank type activity",
                "Failed fill save bank type activity");
    }

    @Test(priority = 2, description = "CA-329")
    @Override
    public void addTypeOfActivityFailedAddTypeOfActivityWhenUserDoesnTFillAllField() {
        navigateToCreateBankTypeActivity();
        boolean result = createBankTypeActivitySteps.saveBankTypeActivity();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 3, description = "CA-334")
    @Override
    public void addTypeOfActivityFailedAddTypeOfActivityWhenUserInputNamaJenisAktivitasMoreThan_200Characters() {
        navigateToCreateBankTypeActivity();
        verifyStep(
                createBankTypeActivitySteps
                        .fillNameBankTypeActivity(createBankTypeActivityModel.invalidInputNameActivityMoreThanChars()),
                "Successfully fill name bank type activity", "Failed fill name bank type activity");
        verifyStep(
                createBankTypeActivitySteps
                        .fillCategoryBankTypeActivity(createBankTypeActivityModel.validCategoryActivity()),
                "Successfully fill category activity", "Failed fill category activity");
        verifyStep(
                createBankTypeActivitySteps
                        .fillContentLearningBankTypeActivity(createBankTypeActivityModel.validContentLearning()),
                "Successfully fill content learning", "Failed fill content learning");
        boolean result = createBankTypeActivitySteps.saveBankTypeActivity();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 4, description = "CA-343")
    @Override
    public void addTypeOfActivitySuccessfullyAddTypeOfActivityWithStatusJenisAktivitasIsInactive() {
        navigateToCreateBankTypeActivity();
        verifyStep(
                createBankTypeActivitySteps.fillNameBankTypeActivity(createBankTypeActivityModel.validNameActivity()),
                "Successfully fill name bank type activity", "Failed fill name bank type activity");
        verifyStep(
                createBankTypeActivitySteps
                        .fillCategoryBankTypeActivity(createBankTypeActivityModel.validCategoryActivity()),
                "Successfully fill category activity", "Failed fill category activity");
        verifyStep(
                createBankTypeActivitySteps
                        .fillContentLearningBankTypeActivity(createBankTypeActivityModel.validContentLearning()),
                "Successfully fill content learning", "Failed fill content learning");
        verifyStep(createBankTypeActivitySteps.toggleStatusBankTypeActivity(), "Successfully set status inactive",
                "Failed set status inactive");
        verifyStep(createBankTypeActivitySteps.saveBankTypeActivity(), "Successfully save bank type activity",
                "Failed fill save bank type activity");
    }

    @Test(priority = 5, description = "CA-344")
    @Override
    public void addTypeOfActivityFailedAddTypeActivityWhenNamaJenisAktivitasIsEmpty() {
        navigateToCreateBankTypeActivity();
        verifyStep(
                createBankTypeActivitySteps
                        .fillCategoryBankTypeActivity(createBankTypeActivityModel.validCategoryActivity()),
                "Successfully fill category activity", "Failed fill category activity");
        verifyStep(
                createBankTypeActivitySteps
                        .fillContentLearningBankTypeActivity(createBankTypeActivityModel.validContentLearning()),
                "Successfully fill content learning", "Failed fill content learning");
        boolean result = createBankTypeActivitySteps.saveBankTypeActivity();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 6, description = "CA-345")
    @Override
    public void addTypeOfActivityFailedAddTypeActivityWhenKategoriJenisAktivitasIsEmpty() {
        navigateToCreateBankTypeActivity();
        verifyStep(
                createBankTypeActivitySteps.fillNameBankTypeActivity(createBankTypeActivityModel.validNameActivity()),
                "Successfully fill name bank type activity", "Failed fill name bank type activity");
        verifyStep(
                createBankTypeActivitySteps
                        .fillContentLearningBankTypeActivity(createBankTypeActivityModel.validContentLearning()),
                "Successfully fill content learning", "Failed fill content learning");
        boolean result = createBankTypeActivitySteps.saveBankTypeActivity();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 7, description = "CA-346")
    @Override
    public void addTypeOfActivityFailedAddTypeActivityWhenKontenBelajarIsEmpty() {
        navigateToCreateBankTypeActivity();
        verifyStep(
                createBankTypeActivitySteps.fillNameBankTypeActivity(createBankTypeActivityModel.validNameActivity()),
                "Successfully fill name bank type activity", "Failed fill name bank type activity");
        verifyStep(
                createBankTypeActivitySteps
                        .fillCategoryBankTypeActivity(createBankTypeActivityModel.validCategoryActivity()),
                "Successfully fill category activity", "Failed fill category activity");
        boolean result = createBankTypeActivitySteps.saveBankTypeActivity();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 8, description = "depend = CA-327, CA-331")
    @Override
    public void addTypeOfActivityUserRedirectToLandingPageOrPreviousPageWhenClickButtonTinggalkanHalamanOnPopup() {
        navigateToCreateBankTypeActivity();
        verifyStep(
                createBankTypeActivitySteps.fillNameBankTypeActivity(createBankTypeActivityModel.validNameActivity()),
                "Successfully fill name bank type activity", "Failed fill name bank type activity");
        verifyStep(createBankTypeActivitySteps.leavePageBankTypeActivity(),
                "Successfully leave page bank type activity", "Failed leave page bank type activity");
    }

    @Test(priority = 9, description = "CA-332")
    @Override
    public void addTypeOfActivityUserRemainsOnTheCurrentPageWhenClickButtonTetapDiHalamanOnPopup() {
        navigateToCreateBankTypeActivity();
        verifyStep(
                createBankTypeActivitySteps.fillNameBankTypeActivity(createBankTypeActivityModel.validNameActivity()),
                "Successfully fill name bank type activity", "Failed fill name bank type activity");
        verifyStep(createBankTypeActivitySteps.stayOnPageBankTypeActivity(), "Successfully stay on the current page",
                "Failed stay on the current page");
    }

    private void navigateToCreateBankTypeActivity() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_ACTIVITY_TYPE),
                "Successfully navigate to Bank Type Activity menu", "Failed navigate to Bank Type Activity menu");
        verifyStep(createBankTypeActivitySteps.navigateToPageBankTypeActivity(),
                "Successfully navigate to Bank Type Activity page", "Failed navigate to Bank Type Activity page");
    }
}
