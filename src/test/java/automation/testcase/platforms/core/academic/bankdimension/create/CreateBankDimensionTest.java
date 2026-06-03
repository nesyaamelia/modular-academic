package mu.core.id.website.testcase.platforms.core.academic.bankdimension.create;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import automation.platforms.core.academic.bankdimension.create.CreateBankDimensionModel;
import automation.platforms.core.academic.bankdimension.create.CreateBankDimensionPage;
import automation.platforms.core.academic.bankdimension.create.CreateBankDimensionSteps;
import automation.platforms.core.academic.sidemenu.MenuCoreOptions;
import automation.platforms.core.academic.sidemenu.MenuCorePage;
import automation.platforms.core.academic.sidemenu.MenuCoreSteps;
import automation.platforms.core.user.login.LoginCorePage;
import automation.platforms.core.user.login.LoginCoreSteps;
import mu.core.id.website.testcase.platforms.core.BaseCoreDriverTest;
import org.testng.annotations.Test;

import static automation.utils.StepLogger.verifyStep;

@Epic("Platform Core")
@Feature("Academic - Create Bank Dimension")
public class CreateBankDimensionTest extends BaseCoreDriverTest implements CreateBankDimensionTestCase {
    private CreateBankDimensionSteps createBankDimensionSteps;
    private CreateBankDimensionModel createBankDimensionModel;
    private MenuCoreSteps menuCoreSteps;
    private LoginCoreSteps loginCoreSteps;

    @Override
    public void initInstance() {
        createBankDimensionSteps = new CreateBankDimensionPage(page);
        createBankDimensionModel = new CreateBankDimensionModel();
        menuCoreSteps = new MenuCorePage(page);
        loginCoreSteps = new LoginCorePage(page);
    }

    @Test(priority = 1, description = "depend = 1829, 1831, 1838")
    @Override
    public void tambahDimensionSuccessfullyCreateDimensionWithValidData() {
        navigateToCreateBankDimension();
        verifyStep(createBankDimensionSteps.fillNameBankDimension(createBankDimensionModel.validNameDimension()),
                "Successfully fill name bank dimension", "Failed fill name bank dimension");
        verifyStep(createBankDimensionSteps.fillCodeBankDimension(createBankDimensionModel.validCodeDimension()),
                "Successfully fill code bank dimension", "Failed fill code bank dimension");
        verifyStep(
                createBankDimensionSteps
                        .fillDescriptionBankDimension(createBankDimensionModel.validDescriptionDimension()),
                "Successfully fill description bank dimension", "Failed fill description bank dimension");
        verifyStep(createBankDimensionSteps.selectElement(), "Successfully select element", "Failed select element");
        verifyStep(createBankDimensionSteps.saveBankDimension(), "Successfully save bank dimension",
                "Failed save bank dimension");
    }

    @Test(priority = 2, description = "depend = 1832, 1833")
    @Override
    public void tambahDimensionSuccessfullyCreateDimensionWithChangeDefaultValueOfOrganisasiPenyediaDimensionField() {
        navigateToCreateBankDimension();
        verifyStep(createBankDimensionSteps.fillNameBankDimension(createBankDimensionModel.validNameDimension()),
                "Successfully fill name bank dimension", "Failed fill name bank dimension");
        verifyStep(createBankDimensionSteps.fillOrganizationDimension(createBankDimensionModel.validOrganization()),
                "Successfully fill organization bank dimension", "Failed fill organization bank dimension");
        verifyStep(createBankDimensionSteps.selectElement(), "Successfully select element", "Failed select element");
        verifyStep(createBankDimensionSteps.saveBankDimension(), "Successfully save bank dimension",
                "Failed save bank dimension");
    }

    @Test(priority = 3, description = "1834")
    @Override
    public void tambahDimensionSuccessfullyCreateDimensionWithMaximumLengthInputs() {
        navigateToCreateBankDimension();
        verifyStep(
                createBankDimensionSteps.fillNameBankDimension(createBankDimensionModel.validNameDimensionLongChars()),
                "Successfully fill name bank dimension", "Failed fill name bank dimension");
        verifyStep(
                createBankDimensionSteps.fillCodeBankDimension(createBankDimensionModel.validCodeDimensionLongChars()),
                "Successfully fill code bank dimension", "Failed fill code bank dimension");
        verifyStep(
                createBankDimensionSteps
                        .fillDescriptionBankDimension(createBankDimensionModel.validDescriptionLongChars()),
                "Successfully fill description bank dimension", "Failed fill description bank dimension");
        verifyStep(createBankDimensionSteps.selectElement(), "Successfully select element", "Failed select element");
        verifyStep(createBankDimensionSteps.saveBankDimension(), "Successfully save bank dimension",
                "Failed save bank dimension");
    }

    @Test(priority = 4, description = "1835")
    @Override
    public void tambahDimensionSuccessfullyCreateDimensionWhenDataAsExistingInTheDifferentOraganization() {
        navigateToCreateBankDimension();
        verifyStep(
                createBankDimensionSteps.fillNameBankDimension(createBankDimensionModel.validNameDimensionLongChars()),
                "Successfully fill name bank dimension", "Failed fill name bank dimension");
        verifyStep(
                createBankDimensionSteps.fillCodeBankDimension(createBankDimensionModel.validCodeDimensionLongChars()),
                "Successfully fill code bank dimension", "Failed fill code bank dimension");
        verifyStep(
                createBankDimensionSteps
                        .fillDescriptionBankDimension(createBankDimensionModel.validDescriptionLongChars()),
                "Successfully fill description bank dimension", "Failed fill description bank dimension");
        verifyStep(createBankDimensionSteps.fillOrganizationDimension(createBankDimensionModel.validOrganization()),
                "Successfully fill organization bank dimension", "Failed fill organization bank dimension");
        verifyStep(createBankDimensionSteps.selectElement(), "Successfully select element", "Failed select element");
        verifyStep(createBankDimensionSteps.saveBankDimension(), "Successfully save bank dimension",
                "Failed save bank dimension");
    }

    @Test(priority = 5, description = "depend = 1836, 1837")
    @Override
    public void tambahDimensionSuccessfullySelectMultipleElementWhenCreateDimension() {
        navigateToCreateBankDimension();
        verifyStep(createBankDimensionSteps.fillNameBankDimension(createBankDimensionModel.validNameDimension()),
                "Successfully fill name bank dimension", "Failed fill name bank dimension");
        verifyStep(createBankDimensionSteps.fillCodeBankDimension(createBankDimensionModel.validCodeDimension()),
                "Successfully fill code bank dimension", "Failed fill code bank dimension");
        verifyStep(
                createBankDimensionSteps
                        .fillDescriptionBankDimension(createBankDimensionModel.validDescriptionDimension()),
                "Successfully fill description bank dimension", "Failed fill description bank dimension");
        verifyStep(
                createBankDimensionSteps
                        .searchAndSelectMultipleElement(createBankDimensionModel.searchAndSelectMultipleElement()),
                "Successfully select multiple element", "Failed select multiple element");
        verifyStep(createBankDimensionSteps.saveBankDimension(), "Successfully save bank dimension",
                "Failed save bank dimension");
    }

    @Test(priority = 6, description = "1843")
    @Override
    public void tambahDimensionFailedToCreateDimensionWhenMandatoryFieldIsEmpty() {
        navigateToCreateBankDimension();
        boolean result = createBankDimensionSteps.saveBankDimension();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 7, description = "1844")
    @Override
    public void tambahDimensionFailedToCreateDimensionWhenInputFieldExceedsTheMaximumCharacterLimit() {
        navigateToCreateBankDimension();
        verifyStep(
                createBankDimensionSteps
                        .fillNameBankDimension(createBankDimensionModel.invalidNameDimensionLongChars()),
                "Successfully fill name bank dimension", "Failed fill name bank dimension");
        verifyStep(
                createBankDimensionSteps
                        .fillCodeBankDimension(createBankDimensionModel.invalidCodeDimensionLongChars()),
                "Successfully fill code bank dimension", "Failed fill code bank dimension");
        verifyStep(
                createBankDimensionSteps
                        .fillDescriptionBankDimension(createBankDimensionModel.invalidDescriptionLongChars()),
                "Successfully fill description bank dimension", "Failed fill description bank dimension");
        boolean result = createBankDimensionSteps.saveBankDimension();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 8, description = "1845")
    @Override
    public void tambahDimensionFailedToCreateDimensionWhenDataAsExistingInTheSameOraganization() {
        navigateToCreateBankDimension();
        verifyStep(createBankDimensionSteps.fillNameBankDimension(createBankDimensionModel.sameNameDimension()),
                "Successfully fill name bank dimension", "Failed fill name bank dimension");
        verifyStep(createBankDimensionSteps.fillCodeBankDimension(createBankDimensionModel.sameCodeDimension()),
                "Successfully fill code bank dimension", "Failed fill code bank dimension");
        verifyStep(createBankDimensionSteps.selectElement(), "Successfully select element", "Failed select element");
        boolean result = createBankDimensionSteps.saveBankDimension();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 9, description = "1846")
    @Override
    public void tambahDimensionFailedToCreateDimensionWhenFieldContainCharacterNotAllowed() {
        navigateToCreateBankDimension();
        verifyStep(createBankDimensionSteps.fillNameBankDimension(createBankDimensionModel.validNameDimension()),
                "Successfully fill name bank dimension", "Failed fill name bank dimension");
        verifyStep(createBankDimensionSteps.fillCodeBankDimension(createBankDimensionModel.specialCharsCodeDimension()),
                "Successfully fill code bank dimension", "Failed fill code bank dimension");
        boolean result = createBankDimensionSteps.saveBankDimension();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 10, description = "1839")
    @Override
    public void tambahDimensionFailedToAdd_1ElementWithTheSameName() {
        navigateToCreateBankDimension();
        verifyStep(
                createBankDimensionSteps.fillNameBankDimension(createBankDimensionModel.validNameDimensionLongChars()),
                "Successfully fill name bank dimension", "Failed fill name bank dimension");
        verifyStep(
                createBankDimensionSteps.fillCodeBankDimension(createBankDimensionModel.validCodeDimensionLongChars()),
                "Successfully fill code bank dimension", "Failed fill code bank dimension");
        verifyStep(
                createBankDimensionSteps
                        .fillDescriptionBankDimension(createBankDimensionModel.validDescriptionLongChars()),
                "Successfully fill description bank dimension", "Failed fill description bank dimension");
        verifyStep(createBankDimensionSteps.selectElement(), "Successfully select element", "Failed select element");
        verifyStep(createBankDimensionSteps.selectElement(), "Successfully select element", "Failed select element");
        boolean result = createBankDimensionSteps.saveBankDimension();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 11, description = "1840")
    @Override
    public void tambahDimensionFailedToAddMoreThan_1ElementWithTheSameName() {
        navigateToCreateBankDimension();
        verifyStep(createBankDimensionSteps.fillNameBankDimension(createBankDimensionModel.validNameDimension()),
                "Successfully fill name bank dimension", "Failed fill name bank dimension");
        verifyStep(createBankDimensionSteps.fillCodeBankDimension(createBankDimensionModel.validCodeDimension()),
                "Successfully fill code bank dimension", "Failed fill code bank dimension");
        verifyStep(
                createBankDimensionSteps
                        .fillDescriptionBankDimension(createBankDimensionModel.validDescriptionDimension()),
                "Successfully fill description bank dimension", "Failed fill description bank dimension");
        verifyStep(
                createBankDimensionSteps
                        .searchAndSelectMultipleElement(createBankDimensionModel.searchAndSelectMultipleElement()),
                "Successfully select multiple element", "Failed select multiple element");
        verifyStep(
                createBankDimensionSteps
                        .searchAndSelectMultipleElement(createBankDimensionModel.searchAndSelectMultipleElement()),
                "Successfully select multiple element", "Failed select multiple element");
        boolean result = createBankDimensionSteps.saveBankDimension();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    private void navigateToCreateBankDimension() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_DIMENSION),
                "Successfully navigate to Bank Dimension menu", "Failed navigate to Bank Dimension menu");
        verifyStep(createBankDimensionSteps.navigateToPageBankDimension(),
                "Successfully navigate to Bank Dimension page", "Failed navigate to Bank Dimension page");
    }
}
