package mu.core.id.website.testcase.platforms.core.academic.bankdimension.edit;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import automation.platforms.core.academic.bankdimension.edit.EditBankDimensionModel;
import automation.platforms.core.academic.bankdimension.edit.EditBankDimensionPage;
import automation.platforms.core.academic.bankdimension.edit.EditBankDimensionSteps;
import automation.platforms.core.academic.sidemenu.MenuCoreOptions;
import automation.platforms.core.academic.sidemenu.MenuCorePage;
import automation.platforms.core.academic.sidemenu.MenuCoreSteps;
import automation.platforms.core.user.login.LoginCorePage;
import automation.platforms.core.user.login.LoginCoreSteps;
import mu.core.id.website.testcase.platforms.core.BaseCoreDriverTest;
import org.testng.annotations.Test;

import static automation.utils.StepLogger.verifyStep;

@Epic("Platform Core")
@Feature("Academic - Edit Bank Dimension")
public class EditBankDimensionTest extends BaseCoreDriverTest implements EditBankDimensionTestCase {
    private EditBankDimensionSteps editBankDimensionSteps;
    private EditBankDimensionModel editBankDimensionModel;
    private MenuCoreSteps menuCoreSteps;
    private LoginCoreSteps loginCoreSteps;

    @Override
    public void initInstance() {
        editBankDimensionSteps = new EditBankDimensionPage(page);
        editBankDimensionModel = new EditBankDimensionModel();
        menuCoreSteps = new MenuCorePage(page);
        loginCoreSteps = new LoginCorePage(page);
    }

    @Test(priority = 1, description = "depend = 1856, 1857")
    @Override
    public void ubahDimensionSuccessfullyEditAnExistingDimensionWithValidInputs() {
        navigateToEditBankDimension();
        verifyStep(editBankDimensionSteps.fillNameBankDimension(editBankDimensionModel.validEditBankDimension()),
                "Successfully fill name dimension", "Failed fill name dimension");
        verifyStep(editBankDimensionSteps.fillCodeBankDimension(editBankDimensionModel.validEditBankDimension()),
                "Successfully fill name dimension", "Failed fill name dimension");
        verifyStep(editBankDimensionSteps.fillDescriptionBankDimension(editBankDimensionModel.validEditBankDimension()),
                "Successfully fill description dimension", "Failed fill description dimension");
        verifyStep(editBankDimensionSteps.saveBankDimension(), "Successfully save edit bank dimension",
                "Failed fill save edit bank dimension");
    }

    @Test(priority = 2, description = "1858")
    @Override
    public void ubahDimensionSuccessfullyEditAnExistingDimensionByChangingElementToInactive() {
        navigateToEditBankDimension();
        verifyStep(editBankDimensionSteps.toggleStatusRelation(), "Successfully toggle status relation",
                "Failed toggle status relation");
        verifyStep(editBankDimensionSteps.saveBankDimension(), "Successfully save edit bank dimension",
                "Failed fill save edit bank dimension");
    }

    @Test(priority = 3, description = "1859")
    @Override
    public void ubahDimensionSuccessfullyEditAnExistingDimensionToInactiveStatus() {
        navigateToEditBankDimension();
        verifyStep(editBankDimensionSteps.toggleStatusBankDimension(), "Successfully toggle status bank dimension",
                "Failed toggle status bank dimension");
        verifyStep(editBankDimensionSteps.saveBankDimension(), "Successfully save edit bank dimension",
                "Failed fill save edit bank dimension");
    }

    @Test(priority = 4, description = "1860")
    @Override
    public void ubahDimensionFailedToEditAnExistingDimensionWhenMandatoryFieldIsEmpty() {
        navigateToEditBankDimension();
        verifyStep(editBankDimensionSteps.fillNameBankDimension(editBankDimensionModel.emptyMandatoryField()),
                "Successfully fill name dimension with empty", "Failed fill name dimension with empty");
        boolean result = editBankDimensionSteps.saveBankDimension();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 5, description = "1861")
    @Override
    public void ubahDimensionFailedToEditAnExistingDimensionWhenFieldExceedsTheMaximumCharacterLimit() {
        navigateToEditBankDimension();
        verifyStep(
                editBankDimensionSteps.fillNameBankDimension(editBankDimensionModel.editFieldDimensionWithLongChars()),
                "Successfully fill name dimension", "Failed fill name dimension");
        verifyStep(
                editBankDimensionSteps.fillCodeBankDimension(editBankDimensionModel.editFieldDimensionWithLongChars()),
                "Successfully fill code dimension", "Failed fill code dimension");
        verifyStep(
                editBankDimensionSteps
                        .fillDescriptionBankDimension(editBankDimensionModel.editFieldDimensionWithLongChars()),
                "Successfully fill description dimension", "Failed fill description dimension");
        boolean result = editBankDimensionSteps.saveBankDimension();
        verifyStep(!result, "Expected error alert for exceeding character limit", "Error alert not shown as expected");
    }

    @Test(priority = 6, description = "1864")
    @Override
    public void ubahDimensionFailedToEditAnExistingDimensionWhenChangeDataAsExisting() {
        navigateToEditBankDimension();
        verifyStep(editBankDimensionSteps.fillNameBankDimension(editBankDimensionModel.sameNameDimension()),
                "Successfully fill name dimension with existing data", "Failed fill name dimension with existing data");
        verifyStep(editBankDimensionSteps.fillCodeBankDimension(editBankDimensionModel.sameCodeDimension()),
                "Successfully fill code dimension with existing data", "Failed fill code dimension with existing data");
        boolean result = editBankDimensionSteps.saveBankDimension();
        verifyStep(!result, "Expected error alert for existing data", "Error alert not shown as expected");
    }

    @Test(priority = 7, description = "1865")
    @Override
    public void ubahDimensionFailedToEditAnExistingDimensionWhenFieldContainCharacterNotAllowed() {
        navigateToEditBankDimension();
        verifyStep(editBankDimensionSteps.fillCodeBankDimension(editBankDimensionModel.specialCharsCodeDimension()),
                "Successfully fill code dimension with invalid character",
                "Failed fill code dimension with invalid character");
        boolean result = editBankDimensionSteps.saveBankDimension();
        verifyStep(!result, "Expected error alert for invalid character", "Error alert not shown as expected");
    }

    private void navigateToEditBankDimension() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_DIMENSION),
                "Successfully navigate to Bank Type Activity menu", "Failed navigate to Bank Type Activity menu");
        verifyStep(editBankDimensionSteps.navigateToPageEditBankDimension(editBankDimensionModel.navigateToEditPage()),
                "Successfully navigate to Bank Type Activity page", "Failed navigate to Bank Type Activity page");
    }
}
