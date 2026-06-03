package mu.core.id.website.testcase.platforms.core.academic.bankelement.create;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import automation.platforms.core.academic.bankelement.create.CreateBankElementModel;
import automation.platforms.core.academic.bankelement.create.CreateBankElementPage;
import automation.platforms.core.academic.bankelement.create.CreateBankElementSteps;
import automation.platforms.core.academic.sidemenu.MenuCoreOptions;
import automation.platforms.core.academic.sidemenu.MenuCorePage;
import automation.platforms.core.academic.sidemenu.MenuCoreSteps;
import automation.platforms.core.user.login.LoginCorePage;
import automation.platforms.core.user.login.LoginCoreSteps;
import mu.core.id.website.testcase.platforms.core.BaseCoreDriverTest;
import org.testng.annotations.Test;

import static automation.utils.StepLogger.verifyStep;

@Epic("Platform Core")
@Feature("Academic - Create Bank Element")
public class CreateBankElementTest extends BaseCoreDriverTest implements CreateBankElementTestCase {
    private CreateBankElementSteps createBankElementSteps;
    private CreateBankElementModel createBankElementModel;
    private LoginCoreSteps loginCoreSteps;
    private MenuCoreSteps menuCoreSteps;

    @Override
    public void initInstance() {
        super.initInstance();
        createBankElementSteps = new CreateBankElementPage(page);
        createBankElementModel = new CreateBankElementModel();
        loginCoreSteps = new LoginCorePage(page);
        menuCoreSteps = new MenuCorePage(page);
    }

    @Test(priority = 1, description = "depend = 2052, 2117, 2120, 2144")
    @Override
    public void tambahElementMasterSuccessfullyCreateElementMasterWithValidRequiredFieldsAndCharacterLimits() {
        navigateToCreateBankElementMaster();
        verifyStep(createBankElementSteps.fillNameBankElement(createBankElementModel.validNameElement()),
                "Successfully fill name bank element", "Failed fill name bank element");
        verifyStep(createBankElementSteps.fillCodeBankElement(createBankElementModel.validCodeElement()),
                "Successfully fill code bank element", "Failed fill code bank element");
        verifyStep(
                createBankElementSteps
                        .fillDescriptionBankElement(createBankElementModel.validDescriptionElementMaster()),
                "Successfully fill description bank element", "Failed fill description bank element");
        verifyStep(createBankElementSteps.selectCluster(), "Successfully select cluster", "Failed select cluster");
        verifyStep(createBankElementSteps.saveBankElement(), "Successfully save bank element",
                "Failed save bank element");
    }

    @Test(priority = 2, description = "2121")
    @Override
    public void tambahElementMasterFailedToCreatedElementMasterWithOnlyOptionalFieldsFilled() {
        navigateToCreateBankElementMaster();
        verifyStep(createBankElementSteps.fillCodeBankElement(createBankElementModel.validCodeElement()),
                "Successfully fill code bank element", "Failed fill code bank element");
        verifyStep(
                createBankElementSteps
                        .fillDescriptionBankElement(createBankElementModel.validDescriptionElementMaster()),
                "Successfully fill description bank element", "Failed fill description bank element");
        boolean result = createBankElementSteps.saveBankElement();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 3, description = "2122")
    @Override
    public void tambahElementMasterFailedToCreatedElementMasterWithAllFieldsEmpty() {
        navigateToCreateBankElementMaster();
        boolean result = createBankElementSteps.saveBankElement();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 4, description = "2128")
    @Override
    public void tambahElementMasterFailedToCreatedElementMasterWithInputFieldsExceedingTheCharacterLimit() {
        navigateToCreateBankElementMaster();
        verifyStep(createBankElementSteps.fillNameBankElement(createBankElementModel.invalidNameElementLongChars()),
                "Successfully fill name bank element", "Failed fill name bank element");
        verifyStep(createBankElementSteps.fillCodeBankElement(createBankElementModel.invalidCodeElementLongChars()),
                "Successfully fill code bank element", "Failed fill code bank element");
        verifyStep(
                createBankElementSteps
                        .fillDescriptionBankElement(createBankElementModel.invalidDescriptionElementLongChars()),
                "Successfully fill description bank element", "Failed fill description bank element");
        boolean result = createBankElementSteps.saveBankElement();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 5, description = "2129")
    @Override
    public void tambahElementMasterFailedToCreateElementMasterWithDuplicateValuesInTheSameOrganization() {
        navigateToCreateBankElementMaster();
        verifyStep(createBankElementSteps.fillNameBankElement(createBankElementModel.sameNameElement()),
                "Successfully fill name bank element", "Failed fill name bank element");
        verifyStep(createBankElementSteps.fillCodeBankElement(createBankElementModel.sameCodeElement()),
                "Successfully fill code bank element", "Failed fill code bank element");
        boolean result = createBankElementSteps.saveBankElement();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 6, description = "2130")
    @Override
    public void tambahElementMasterFailedToCreateElementMasterWithUnsupportedSpecialCharactersInKodeElementMaster() {
        navigateToCreateBankElementMaster();
        verifyStep(createBankElementSteps.fillNameBankElement(createBankElementModel.validNameElement()),
                "Successfully fill name bank element", "Failed fill name bank element");
        verifyStep(createBankElementSteps.fillCodeBankElement(createBankElementModel.specialCharsCodeElement()),
                "Successfully fill code bank element", "Failed fill code bank element");
        boolean result = createBankElementSteps.saveBankElement();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 7, description = "depend = 2123, 2125, 2126, 2127")
    @Override
    public void tambahElementMasterSuccessfullyCancelsElementMasterCreationWhenClickTinggalkanHalamanButton() {
        navigateToCreateBankElementMaster();
        verifyStep(createBankElementSteps.fillNameBankElement(createBankElementModel.validNameElement()),
                "Successfully fill name bank element", "Failed fill name bank element");
        verifyStep(createBankElementSteps.selectCluster(), "Successfully select cluster", "Failed select cluster");
        verifyStep(createBankElementSteps.leavePageBankElement(), "Successfully leave page bank element",
                "Failed leave page bank element");
    }

    @Test(priority = 8, description = "depend = 2351, 2354")
    @Override
    public void tambahElementOrganisasiSuccessfullyCreatesElementOrganisasiWithValidRequiredFieldsAndCharacterLimits() {
        navigateToCreateBankElementOrganization();
        verifyStep(createBankElementSteps.fillNameBankElement(createBankElementModel.validNameElement()),
                "Successfully fill name bank element", "Failed fill name bank element");
        verifyStep(createBankElementSteps.fillCodeBankElement(createBankElementModel.validCodeElement()),
                "Successfully fill code bank element", "Failed fill code bank element");
        verifyStep(
                createBankElementSteps
                        .fillDescriptionBankElement(createBankElementModel.validDescriptionElementOrganization()),
                "Successfully fill description bank element", "Failed fill description bank element");
        verifyStep(createBankElementSteps.selectCluster(), "Successfully select cluster", "Failed select cluster");
        verifyStep(createBankElementSteps.saveBankElement(), "Successfully save bank element",
                "Failed save bank element");
    }

    @Test(priority = 9, description = "2355")
    @Override
    public void tambahElementOrganisasiFailedToCreatedElementOrganisasiWithOnlyOptionalFieldsFilled() {
        navigateToCreateBankElementOrganization();
        verifyStep(createBankElementSteps.fillCodeBankElement(createBankElementModel.validCodeElement()),
                "Successfully fill code bank element", "Failed fill code bank element");
        verifyStep(
                createBankElementSteps
                        .fillDescriptionBankElement(createBankElementModel.validDescriptionElementMaster()),
                "Successfully fill description bank element", "Failed fill description bank element");
        boolean result = createBankElementSteps.saveBankElement();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 10, description = "2356")
    @Override
    public void tambahElementOrganisasiFailedToCreatedElementOrganisasiWithAllFieldsEmpty() {
        navigateToCreateBankElementOrganization();
        boolean result = createBankElementSteps.saveBankElement();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 11, description = "2359")
    @Override
    public void tambahElementOrganisasiConfirmationSimpanDanTinggalkanHalamanTriggeredWhenUsingBreadcrumbSidebarAndBrowserBackWithUnsavedChanges() {
        navigateToCreateBankElementOrganization();
        verifyStep(createBankElementSteps.fillNameBankElement(createBankElementModel.validNameElement()),
                "Successfully fill name bank element", "Failed fill name bank element");
        verifyStep(createBankElementSteps.selectCluster(), "Successfully select cluster", "Failed select cluster");
        verifyStep(createBankElementSteps.leavePageBankElement(), "Successfully leave page bank element",
                "Failed leave page bank element");
    }

    @Test(priority = 12, description = "2362")
    @Override
    public void tambahElementOrganisasiFailedToCreatedElementOrganisasiWithInputFieldsExceedingTheCharacterLimit() {
        navigateToCreateBankElementOrganization();
        verifyStep(createBankElementSteps.fillNameBankElement(createBankElementModel.invalidNameElementLongChars()),
                "Successfully fill name bank element", "Failed fill name bank element");
        verifyStep(createBankElementSteps.fillCodeBankElement(createBankElementModel.invalidCodeElementLongChars()),
                "Successfully fill code bank element", "Failed fill code bank element");
        verifyStep(
                createBankElementSteps
                        .fillDescriptionBankElement(createBankElementModel.invalidDescriptionElementLongChars()),
                "Successfully fill description bank element", "Failed fill description bank element");
        boolean result = createBankElementSteps.saveBankElement();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 13, description = "2363")
    @Override
    public void tambahElementOrganisasiFailedToCreateElementOrganisasiWithDuplicateValuesInTheSameOrganization() {
        navigateToCreateBankElementOrganization();
        verifyStep(createBankElementSteps.fillNameBankElement(createBankElementModel.sameNameElement()),
                "Successfully fill name bank element", "Failed fill name bank element");
        verifyStep(createBankElementSteps.fillCodeBankElement(createBankElementModel.sameCodeElement()),
                "Successfully fill code bank element", "Failed fill code bank element");
        boolean result = createBankElementSteps.saveBankElement();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 14, description = "2364")
    @Override
    public void tambahElementOrganisasiFailedToCreateElementOrganisasiWithUnsupportedSpecialCharactersInKodeElementOrganisasi() {
        navigateToCreateBankElementOrganization();
        verifyStep(createBankElementSteps.fillNameBankElement(createBankElementModel.validNameElement()),
                "Successfully fill name bank element", "Failed fill name bank element");
        verifyStep(createBankElementSteps.fillCodeBankElement(createBankElementModel.specialCharsCodeElement()),
                "Successfully fill code bank element", "Failed fill code bank element");
        boolean result = createBankElementSteps.saveBankElement();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    private void navigateToCreateBankElementMaster() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_ELEMENT_MASTER),
                "Successfully navigate to Bank Element menu", "Failed navigate to Bank Element menu");
        verifyStep(createBankElementSteps.navigateToPageBankElement(), "Successfully navigate to Bank Element page",
                "Failed navigate to Bank Element page");
    }

    private void navigateToCreateBankElementOrganization() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_ELEMENT_ORGANIZATION),
                "Successfully navigate to Bank Element menu", "Failed navigate to Bank Element menu");
        verifyStep(createBankElementSteps.navigateToPageBankElement(), "Successfully navigate to Bank Element page",
                "Failed navigate to Bank Element page");
    }
}
