package mu.core.id.website.testcase.platforms.core.academic.bankcontent.edit;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import automation.platforms.core.academic.bankcontent.edit.EditBankContentModel;
import automation.platforms.core.academic.bankcontent.edit.EditBankContentPage;
import automation.platforms.core.academic.bankcontent.edit.EditBankContentSteps;
import automation.platforms.core.academic.sidemenu.MenuCoreOptions;
import automation.platforms.core.academic.sidemenu.MenuCorePage;
import automation.platforms.core.academic.sidemenu.MenuCoreSteps;
import automation.platforms.core.user.login.LoginCorePage;
import automation.platforms.core.user.login.LoginCoreSteps;
import mu.core.id.website.testcase.platforms.core.BaseCoreDriverTest;
import org.testng.annotations.Test;

import static automation.utils.StepLogger.verifyStep;

@Epic("Platform Core")
@Feature("Academic - Edit Bank Content")
public class EditBankContentTest extends BaseCoreDriverTest implements EditBankContentTestCase {
    private EditBankContentSteps editBankContentSteps;
    private EditBankContentModel editBankContentModel;
    private MenuCoreSteps menuCoreSteps;
    private LoginCoreSteps loginCoreSteps;

    @Override
    public void initInstance() {
        super.initInstance();
        editBankContentSteps = new EditBankContentPage(page);
        editBankContentModel = new EditBankContentModel();
        menuCoreSteps = new MenuCorePage(page);
        loginCoreSteps = new LoginCorePage(page);
    }

    @Test(priority = 1, description = "depend = 1585, 1590, 1591")
    @Override
    public void editContentSuccessfullyEditContent() {
        navigateToEditBankContent();
        verifyStep(editBankContentSteps.fillNameBankContent(editBankContentModel.validEditBankContent()),
                "Successfully fill name content", "Failed fill name content");
        verifyStep(editBankContentSteps.uploadFile(editBankContentModel.fileAudio), "Successfully upload file",
                "Failed upload file");
        verifyStep(editBankContentSteps.fillLearningInstruction(editBankContentModel.validEditBankContent()),
                "Successfully fill instruction learning content", "Failed fill instruction learning content");
        verifyStep(editBankContentSteps.toggleStatusBankContent(), "Successfully edit status", "Failed edit status");
        verifyStep(editBankContentSteps.saveBankContent(), "Successfully save edit bank content",
                "Failed fill save edit bank content");
    }

    @Test(priority = 2, description = "depend = 1595, 1597, 1598, 1599")
    public void editContentFailedEditContentWhenUserDoesnTFillAllField() {
        navigateToEditBankContent();
        verifyStep(editBankContentSteps.fillNameBankContent(editBankContentModel.emptyField()),
                "Successfully fill name content", "Failed fill name content");
        verifyStep(editBankContentSteps.fillLearningInstruction(editBankContentModel.emptyField()),
                "Successfully fill instruction learning content", "Failed fill instruction learning content");
        boolean result = editBankContentSteps.saveBankContent();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    @Test(priority = 3, description = "1596")
    public void editContentFailedEditContentWhenUserInputNamaKontenBelajarMoreThan_200Characters() {
        navigateToEditBankContent();
        verifyStep(editBankContentSteps.fillNameBankContent(editBankContentModel.nameContentLongChars()),
                "Successfully fill name content", "Failed fill name content");
        boolean result = editBankContentSteps.saveBankContent();
        verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
    }

    private void navigateToEditBankContent() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_STUDY_CONTENT),
                "Successfully navigate to Bank Konten Belajar menu", "Failed navigate to Bank Konten Belajar menu");
        verifyStep(editBankContentSteps.navigateToPageEditBankContent(editBankContentModel.navigateToEditPage()),
                "Successfully navigate to Bank Konten Belajar page", "Failed navigate to Bank Konten Belajar page");
    }
}
