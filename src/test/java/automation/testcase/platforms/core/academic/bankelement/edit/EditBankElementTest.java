package mu.core.id.website.testcase.platforms.core.academic.bankelement.edit;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import automation.platforms.core.academic.bankelement.edit.EditBankElementModel;
import automation.platforms.core.academic.bankelement.edit.EditBankElementPage;
import automation.platforms.core.academic.bankelement.edit.EditBankElementSteps;
import automation.platforms.core.academic.sidemenu.MenuCoreOptions;
import automation.platforms.core.academic.sidemenu.MenuCorePage;
import automation.platforms.core.academic.sidemenu.MenuCoreSteps;
import automation.platforms.core.user.login.LoginCorePage;
import automation.platforms.core.user.login.LoginCoreSteps;
import mu.core.id.website.testcase.platforms.core.BaseCoreDriverTest;
import org.testng.annotations.Test;

import static automation.utils.StepLogger.verifyStep;

@Epic("Platform Core")
@Feature("Academic - Edit Bank Element")
public class EditBankElementTest extends BaseCoreDriverTest implements EditBankElementTestCase {
    private EditBankElementSteps editBankElementSteps;
    private EditBankElementModel editBankElementModel;
    private LoginCoreSteps loginCoreSteps;
    private MenuCoreSteps menuCoreSteps;

    @Override
    public void initInstance() {
        super.initInstance();
        editBankElementSteps = new EditBankElementPage(page);
        editBankElementModel = new EditBankElementModel();
        loginCoreSteps = new LoginCorePage(page);
        menuCoreSteps = new MenuCorePage(page);
    }

    @Test(priority = 1, description = "depend = 2213, 2216, 2227, 2236, 2249")
    @Override
    public void ubahElementMasterSuccessfullyUpdatedElementMasterWithValidRequiredFieldsAndCharacterLimits() {
        navigateToEditBankElementMaster();
        verifyStep(editBankElementSteps.fillNameBankElement(editBankElementModel.validNameEditMaster()),
                "Successfully fill name bank element", "Failed fill name bank element");
        verifyStep(editBankElementSteps.fillCodeBankElement(editBankElementModel.validCodeEditMaster()),
                "Successfully fill code bank element", "Failed fill code bank element");
        verifyStep(
                editBankElementSteps.fillDescriptionBankElement(editBankElementModel.validDescriptionElementMaster()),
                "Successfully fill description bank element", "Failed fill description bank element");
        verifyStep(editBankElementSteps.saveEditBankElement(), "Successfully save edit bank element",
                "Failed fill save edit bank element");
    }

    @Test(priority = 2, description = "2218")
    @Override
    public void ubahElementMasterFailedToUpdateElementMasterWithAllFieldsEmpty() {
        navigateToEditBankElementMaster();
        verifyStep(editBankElementSteps.clearAllField(), "Successfully clear all field", "Failed clear all field");
        boolean result = editBankElementSteps.saveEditBankElement();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 3, description = "2217")
    @Override
    public void ubahElementMasterFailedToUpdateElementMasterWithOnlyOptionalFieldsFilled() {
        navigateToEditBankElementMaster();
        verifyStep(editBankElementSteps.fillNameBankElement(editBankElementModel.emptyNameEditElement()),
                "Successfully fill name bank element", "Failed fill name bank element");
        verifyStep(editBankElementSteps.fillCodeBankElement(editBankElementModel.validCodeEditMaster()),
                "Successfully fill code bank element", "Failed fill code bank element");
        verifyStep(
                editBankElementSteps.fillDescriptionBankElement(editBankElementModel.validDescriptionElementMaster()),
                "Successfully fill description bank element", "Failed fill description bank element");
        boolean result = editBankElementSteps.saveEditBankElement();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 4, description = "2224")
    @Override
    public void ubahElementMasterFailedToCreatedElementMasterWithInputFieldsExceedingTheCharacterLimit() {
        navigateToEditBankElementMaster();
        verifyStep(editBankElementSteps.fillNameBankElement(editBankElementModel.inputNameLongChars()),
                "Successfully fill name bank element", "Failed fill name bank element");
        verifyStep(
                editBankElementSteps.fillDescriptionBankElement(editBankElementModel.inputDescriptionWithLongChars()),
                "Successfully fill description bank element", "Failed fill description bank element");
        boolean result = editBankElementSteps.saveEditBankElement();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 5, description = "2225")
    @Override
    public void ubahElementMasterFailedToUpdateElementMasterWithDuplicateValueInTheSameOrganization() {
        navigateToEditBankElementMaster();
        verifyStep(editBankElementSteps.fillCodeBankElement(editBankElementModel.duplicateCodeElement()),
                "Successfully fill code bank element", "Failed fill code bank element");
        boolean result = editBankElementSteps.saveEditBankElement();
        verifyStep(!result, "Expected error alert for duplicate value", "Error alert not shown as expected");
    }

    @Test(priority = 6, description = "2226")
    @Override
    public void ubahElementMasterFailedToUpdateElementMasterWithUnsupportedSpecialCharactersInKodeElementMaster() {
        navigateToEditBankElementMaster();
        verifyStep(editBankElementSteps.fillCodeBankElement(editBankElementModel.invalidCodeElement()),
                "Successfully fill code bank element", "Failed fill code bank element");
        boolean result = editBankElementSteps.saveEditBankElement();
        verifyStep(!result, "Expected error alert for unsupported special characters",
                "Error alert not shown as expected");
    }

    @Test(priority = 7, description = "2230")
    @Override
    public void ubahElementMasterSuccessfullyDeactivatesElementMasterAfterClickingNonaktifkanButton() {
        navigateToEditBankElementMaster();
        verifyStep(editBankElementSteps.toggleStatusBankElement(), "Successfully toggle status bank element",
                "Failed toggle status bank element");
        verifyStep(editBankElementSteps.saveEditBankElement(), "Successfully save edit bank element",
                "Failed fill save edit bank element");
    }

    @Test(priority = 8, description = "depend = 2440, 2442, 2443, 2459")
    @Override
    public void ubahElementOrganisasiSuccessfullyUpdatedElementOrganisasiWithValidRequiredFieldsAndCharacterLimits() {
        navigateToEditBankElementOrganization();
        verifyStep(editBankElementSteps.fillNameBankElement(editBankElementModel.validNameEditOrganization()),
                "Successfully fill name bank element", "Failed fill name bank element");
        verifyStep(editBankElementSteps.fillCodeBankElement(editBankElementModel.validCodeEditOrganization()),
                "Successfully fill code bank element", "Failed fill code bank element");
        verifyStep(
                editBankElementSteps
                        .fillDescriptionBankElement(editBankElementModel.validDescriptionElementOrganization()),
                "Successfully fill description bank element", "Failed fill description bank element");
        verifyStep(editBankElementSteps.saveEditBankElement(), "Successfully save edit bank element",
                "Failed fill save edit bank element");
    }

    @Test(priority = 9, description = "2444")
    @Override
    public void ubahElementOrganisasiFailedToUpdateElementOrganisasiWithOnlyOptionalFieldsFilled() {
        navigateToEditBankElementOrganization();
        verifyStep(editBankElementSteps.fillNameBankElement(editBankElementModel.emptyNameEditElement()),
                "Successfully fill name bank element", "Failed fill name bank element");
        verifyStep(editBankElementSteps.fillCodeBankElement(editBankElementModel.validCodeEditOrganization()),
                "Successfully fill code bank element", "Failed fill code bank element");
        verifyStep(
                editBankElementSteps
                        .fillDescriptionBankElement(editBankElementModel.validDescriptionElementOrganization()),
                "Successfully fill description bank element", "Failed fill description bank element");
        boolean result = editBankElementSteps.saveEditBankElement();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 10, description = "2445")
    @Override
    public void ubahElementOrganisasiFailedToUpdateElementOrganisasiWithAllFieldsEmpty() {
        navigateToEditBankElementOrganization();
        verifyStep(editBankElementSteps.clearAllField(), "Successfully clear all field", "Failed clear all field");
        boolean result = editBankElementSteps.saveEditBankElement();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 11, description = "2451")
    @Override
    public void ubahElementOrganisasiFailedToCreatedElementOrganisasiWithInputFieldsExceedingTheCharacterLimit() {
        navigateToEditBankElementOrganization();
        verifyStep(editBankElementSteps.fillNameBankElement(editBankElementModel.inputNameLongChars()),
                "Successfully fill name bank element", "Failed fill name bank element");
        verifyStep(
                editBankElementSteps.fillDescriptionBankElement(editBankElementModel.inputDescriptionWithLongChars()),
                "Successfully fill description bank element", "Failed fill description bank element");
        boolean result = editBankElementSteps.saveEditBankElement();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 12, description = "2452")
    @Override
    public void ubahElementOrganisasiFailedToUpdateElementOrganisasiWithDuplicateValueInTheSameOrganization() {
        navigateToEditBankElementOrganization();
        verifyStep(editBankElementSteps.fillCodeBankElement(editBankElementModel.duplicateCodeElementOrganization()),
                "Successfully fill code bank element", "Failed fill code bank element");
        boolean result = editBankElementSteps.saveEditBankElement();
        verifyStep(!result, "Expected error alert for duplicate value", "Error alert not shown as expected");
    }

    @Test(priority = 13, description = "2453")
    @Override
    public void ubahElementOrganisasiFailedToUpdateElementOrganisasiWithUnsupportedSpecialCharactersInKodeElementOrganisasi() {
        navigateToEditBankElementOrganization();
        verifyStep(editBankElementSteps.fillCodeBankElement(editBankElementModel.invalidCodeElement()),
                "Successfully fill code bank element", "Failed fill code bank element");
        boolean result = editBankElementSteps.saveEditBankElement();
        verifyStep(!result, "Expected error alert for unsupported special characters",
                "Error alert not shown as expected");
    }

    @Test(priority = 14, description = "depend = 2475, 2477")
    @Override
    public void ubahElementOrganisasiNonaktifkanRelasiAcademicFrameworkConfirmationTriggeredWhenSetElementOrganisasiStatusFromOnToOff() {
        navigateToEditBankElementOrganization();
        verifyStep(editBankElementSteps.toggleStatusBankElement(), "Successfully toggle status bank element",
                "Failed toggle status bank element");
        verifyStep(editBankElementSteps.saveEditBankElement(), "Successfully save edit bank element",
                "Failed fill save edit bank element");
    }

    private void navigateToEditBankElementMaster() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_ELEMENT_MASTER),
                "Successfully navigate to Bank Element menu", "Failed navigate to Bank Element menu");
        verifyStep(editBankElementSteps.navigateToPageEditBankElement(editBankElementModel.navigateToEditPage()),
                "Successfully navigate to Bank Element page", "Failed navigate to Bank Element page");
    }

    private void navigateToEditBankElementOrganization() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_ELEMENT_ORGANIZATION),
                "Successfully navigate to Bank Element menu", "Failed navigate to Bank Element menu");
        verifyStep(
                editBankElementSteps
                        .navigateToPageEditBankElement(editBankElementModel.navigateToEditElementOrganizationPage()),
                "Successfully navigate to Bank Element page", "Failed navigate to Bank Element page");
    }
}
