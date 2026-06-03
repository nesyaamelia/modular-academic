package mu.core.id.website.testcase.platforms.core.academic.bankframework;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import automation.helper.StringHelper;
import automation.platforms.core.academic.bankframework.BankFrameworkModel;
import automation.platforms.core.academic.bankframework.BankFrameworkPage;
import automation.platforms.core.academic.bankframework.BankFrameworkSteps;
import automation.platforms.core.academic.sidemenu.MenuCoreOptions;
import automation.platforms.core.academic.sidemenu.MenuCorePage;
import automation.platforms.core.academic.sidemenu.MenuCoreSteps;
import automation.platforms.base.SekolahmuElement;
import automation.platforms.core.user.login.LoginCoreModel;
import automation.platforms.core.user.login.LoginCorePage;
import automation.platforms.core.user.login.LoginCoreSteps;
import mu.core.id.website.testcase.platforms.core.BaseCoreDriverTest;
import org.testng.annotations.Test;

import static automation.utils.StepLogger.verifyStep;

@Epic("Platform Core")
@Feature("Academic - Bank Framework")
public class BankFrameworkTest extends BaseCoreDriverTest implements BankFrameworkTestCase {
    private BankFrameworkSteps bankFrameworkSteps;
    private BankFrameworkModel bankFrameworkModel;
    private LoginCoreSteps loginCoreSteps;
    private LoginCoreModel loginCoreModel;
    private MenuCoreSteps menuCoreSteps;
    private SekolahmuElement sekolahmuElement;

    @Override
    public void initInstance() {
        super.initInstance();
        bankFrameworkSteps = new BankFrameworkPage(page);
        bankFrameworkModel = new BankFrameworkModel();
        loginCoreSteps = new LoginCorePage(page);
        loginCoreModel = new LoginCoreModel();
        menuCoreSteps = new MenuCorePage(page);
        sekolahmuElement = new SekolahmuElement(page);
    }

    @Test(priority = 1, description = "CA-364, CA-386, CA-389, CA-390, CA-392, CA-403, CA-401, CA-367, CA-368")
    @Override
    public void createBankFrameworkWithValidCredentials() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_FRAMEWORK),
                "Successfully navigate to Bank Framework menu", "Failed navigate to Bank Framework menu");
        verifyStep(bankFrameworkSteps.navigateToPageBankFramework(), "Successfully navigate to Bank Framework page",
                "Failed navigate to Bank Framework page");

        verifyStep(bankFrameworkSteps.fillNameBankFramework(bankFrameworkModel.generateNameFramework()),
                "Successfully fill name bank framework", "Failed fill name bank framework");
        verifyStep(bankFrameworkSteps.fillCodeBankFramework(bankFrameworkModel.generateCodeFramework()),
                "Successfully fill code bank framework", "Failed fill code bank framework");
        verifyStep(bankFrameworkSteps.fillDescriptionBankFramework(StringHelper.generateRandomLowercase(200)),
                "Successfully fill description bank framework", "Failed fill description bank framework");

        verifyStep(bankFrameworkSteps.clickButtonSaveFramework(), "Successfully click Save framework",
                "Failed click Save framework");
    }

    @Test(priority = 2, description = "CA-402")
    @Override
    public void tambahFrameworkFailedToCreateFrameworkWithUnsupportedSpecialCharactersInKodeFramework() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_FRAMEWORK),
                "Successfully navigate to Bank Framework menu", "Failed navigate to Bank Framework menu");
        verifyStep(bankFrameworkSteps.navigateToPageBankFramework(), "Successfully navigate to Bank Framework page",
                "Failed navigate to Bank Framework page");

        verifyStep(bankFrameworkSteps.fillCodeBankFramework("!@(#(*!@KAJDSKAS"),
                "Successfully fill code bank framework", "Failed fill code bank framework");
        verifyStep(bankFrameworkSteps.clickButtonSaveFramework(), "Successfully click Save framework",
                "Failed click Save framework");
        verifyStep(bankFrameworkSteps.getValidationMessages(), "Successfully validate bank framework",
                "Failed validate bank framework");
    }

    @Test(priority = 3, description = "CA-365,CA-366,CA-387,CA-388")
    public void tambahFrameworkSuccessfullyRedirectFrom_404ToDashboardPage() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_FRAMEWORK),
                "Successfully navigate to Bank Framework menu", "Failed navigate to Bank Framework menu");
        verifyStep(sekolahmuElement.navigateToUrl("https://core.dev.sid.id/framework/231"),
                "Successfully navigate to 404 page", "Failed navigate to 404 page");
    }

    @Test(priority = 4, description = "CA-393")
    public void tambahFrameworkFailedToCreatedFrameworkWithOnlyOptionalFieldsFilled() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_FRAMEWORK),
                "Successfully navigate to Bank Framework menu", "Failed navigate to Bank Framework menu");
        verifyStep(bankFrameworkSteps.navigateToPageBankFramework(), "Successfully navigate to Bank Framework page",
                "Failed navigate to Bank Framework page");

        verifyStep(bankFrameworkSteps.fillCodeBankFramework("!@(#(*!@KAJDSKAS"),
                "Successfully fill code bank framework", "Failed fill code bank framework");
        verifyStep(bankFrameworkSteps.clickButtonSaveFramework(), "Successfully click Save framework",
                "Failed click Save framework");
        verifyStep(bankFrameworkSteps.getValidationMessages(), "Successfully validate bank framework",
                "Failed validate bank framework");
    }

    @Test(priority = 5, description = "CA-394")
    public void tambahFrameworkFailedToCreatedFrameworkWithAllFieldsEmpty() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_FRAMEWORK),
                "Successfully navigate to Bank Framework menu", "Failed navigate to Bank Framework menu");
        verifyStep(bankFrameworkSteps.navigateToPageBankFramework(), "Successfully navigate to Bank Framework page",
                "Failed navigate to Bank Framework page");

        verifyStep(bankFrameworkSteps.clickButtonSaveFramework(), "Successfully click Save framework",
                "Failed click Save framework");
        verifyStep(bankFrameworkSteps.getValidationMessages(), "Successfully validate bank framework",
                "Failed validate bank framework");
    }

    @Test(priority = 6, description = "CA-395, CA-399")
    public void tambahFrameworkConfirmationPopupTriggeredWhenCancellingUsingBatalkanButtonWithUnsavedChanges() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_FRAMEWORK),
                "Successfully navigate to Bank Framework menu", "Failed navigate to Bank Framework menu");
        verifyStep(bankFrameworkSteps.navigateToPageBankFramework(), "Successfully navigate to Bank Framework page",
                "Failed navigate to Bank Framework page");

        verifyStep(bankFrameworkSteps.fillNameBankFramework(bankFrameworkModel.generateNameFramework()),
                "Successfully fill name bank framework", "Failed fill name bank framework");
        verifyStep(bankFrameworkSteps.fillCodeBankFramework(bankFrameworkModel.generateCodeFramework()),
                "Successfully fill code bank framework", "Failed fill code bank framework");
        verifyStep(bankFrameworkSteps.fillDescriptionBankFramework(StringHelper.generateRandomLowercase(200)),
                "Successfully fill description bank framework", "Failed fill description bank framework");

        verifyStep(bankFrameworkSteps.clickButtonCancelFramework(), "Successfully click Cancel framework",
                "Failed click Cancel framework");
        verifyStep(bankFrameworkSteps.validationPopUp(false),
                "Successfully validate confirmation popup is displayed",
                "Failed validate confirmation popup is displayed");
    }

    @Test(priority = 7, description = "CA-396")
    public void tambahFrameworkNoConfirmationTriggeredWhenCancellingWithNoChanges() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_FRAMEWORK),
                "Successfully navigate to Bank Framework menu", "Failed navigate to Bank Framework menu");
        verifyStep(bankFrameworkSteps.navigateToPageBankFramework(), "Successfully navigate to Bank Framework page",
                "Failed navigate to Bank Framework page");

        verifyStep(bankFrameworkSteps.clickButtonCancelFramework(), "Successfully click Cancel framework",
                "Failed click Cancel framework");
    }

    @Test(priority = 8, description = "CA-400")
    public void tambahFrameworkFailedToCreatedFrameworkWithInputFieldsExceedingTheCharacterLimit() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_FRAMEWORK),
                "Successfully navigate to Bank Framework menu", "Failed navigate to Bank Framework menu");
        verifyStep(bankFrameworkSteps.navigateToPageBankFramework(), "Successfully navigate to Bank Framework page",
                "Failed navigate to Bank Framework page");

        verifyStep(bankFrameworkSteps.fillNameBankFramework(StringHelper.generateRandomLowercase(150)),
                "Successfully fill name bank framework", "Failed fill name bank framework");
        verifyStep(bankFrameworkSteps.fillCodeBankFramework(StringHelper.generateRandomLowercase(100)),
                "Successfully fill code bank framework", "Failed fill code bank framework");
        verifyStep(bankFrameworkSteps.getValidationMessages(), "Successfully validate bank framework",
                "Failed validate bank framework");
    }

    @Test(priority = 9, description = "CA-404")
    public void tambahFrameworkNoOrganizationResultReturnedInOrganisasiPenyediaFrameworkField() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_FRAMEWORK),
                "Successfully navigate to Bank Framework menu", "Failed navigate to Bank Framework menu");
        verifyStep(bankFrameworkSteps.navigateToPageBankFramework(), "Successfully navigate to Bank Framework page",
                "Failed navigate to Bank Framework page");

        verifyStep(bankFrameworkSteps.fillNameBankFramework(bankFrameworkModel.generateNameFramework()),
                "Successfully fill name bank framework", "Failed fill name bank framework");
        verifyStep(bankFrameworkSteps.fillCodeBankFramework(bankFrameworkModel.generateCodeFramework()),
                "Successfully fill code bank framework", "Failed fill code bank framework");
        verifyStep(bankFrameworkSteps.fillDescriptionBankFramework(StringHelper.generateRandomLowercase(200)),
                "Successfully fill description bank framework", "Failed fill description bank framework");

        verifyStep(bankFrameworkSteps.selectOrganizerProvider("PT. Tidak Ada"),
                "Successfully select organizer provider",
                "Failed select organizer provider");
    }

    @Test(priority = 10, description = "CA-398, CA-397")
    public void tambahFrameworkSuccessfullyCancelsFrameworkCreationWhenClickTinggalkanHalamanButton() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_FRAMEWORK),
                "Successfully navigate to Bank Framework menu", "Failed navigate to Bank Framework menu");
        verifyStep(bankFrameworkSteps.navigateToPageBankFramework(), "Successfully navigate to Bank Framework page",
                "Failed navigate to Bank Framework page");

        verifyStep(bankFrameworkSteps.fillNameBankFramework(bankFrameworkModel.generateNameFramework()),
                "Successfully fill name bank framework", "Failed fill name bank framework");
        verifyStep(bankFrameworkSteps.fillCodeBankFramework(bankFrameworkModel.generateCodeFramework()),
                "Successfully fill code bank framework", "Failed fill code bank framework");
        verifyStep(bankFrameworkSteps.fillDescriptionBankFramework(StringHelper.generateRandomLowercase(200)),
                "Successfully fill description bank framework", "Failed fill description bank framework");

        verifyStep(bankFrameworkSteps.clickButtonCancelFramework(), "Successfully click Cancel framework",
                "Failed click Cancel framework");
        verifyStep(bankFrameworkSteps.validationPopUp(true),
                "Successfully validate confirmation popup is displayed",
                "Failed validate confirmation popup is displayed");
    }

    @Test(priority = 11, description = "CA-369")
    public void bankFrameworkSuccessfullyNavigationToTheEditFrameworkViaEditButtonOnActionColumn() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_FRAMEWORK),
                "Successfully navigate to Bank Framework menu", "Failed navigate to Bank Framework menu");
        verifyStep(bankFrameworkSteps.clickButtonEdit(1), "Successfully click Edit button on Action column",
                "Failed click Edit button on Action column");
    }

    @Test(priority = 12, description = "CA-370")
    public void bankFrameworkSuccessfullyNavigationToTheDetailFrameworkViaDetailButtonOnActionColumn() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_FRAMEWORK),
                "Successfully navigate to Bank Framework menu", "Failed navigate to Bank Framework menu");
        verifyStep(bankFrameworkSteps.clickButtonDetail(1), "Successfully click Detail button on Action column",
                "Failed click Detail button on Action column");
    }

    @Test(priority = 13, description = "CA-382")
    public void bankFrameworkSuccessfullyChangingTheNumberOfRowsDisplayedPerPage() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_FRAMEWORK),
                "Successfully navigate to Bank Framework menu", "Failed navigate to Bank Framework menu");
        verifyStep(bankFrameworkSteps.selectRowDisplay("100"), "test", "success");
    }

    @Test(priority = 14, description = "CA-413, CA-417")
    public void ubahFrameworkSuccessfullyNavigatingToEditFrameworkViaFrameworkEditIdFrameworkSlug() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_FRAMEWORK),
                "Successfully navigate to Bank Framework menu", "Failed navigate to Bank Framework menu");
        verifyStep(sekolahmuElement.navigateToUrl("https://core.dev.sid.id/framework/edit/137"),
                "Successfully navigate to Edit Framework page using URL with valid ID",
                "Failed navigate to Edit Framework page using URL with valid ID");
    }

    @Test(priority = 15, description = "CA-414, CA-415, CA-416")
    public void ubahFrameworkFailedAccessToUbahFrameworkPageWhenAccessingNonExistingId() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_FRAMEWORK),
                "Successfully navigate to Bank Framework menu", "Failed navigate to Bank Framework menu");
        verifyStep(sekolahmuElement.navigateToUrl("https://core.dev.sid.id/framework/edit/02913918237"),
                "Successfully navigate to 404 page using URL with non-existing ID",
                "Failed navigate to 404 page using URL with non-existing ID");
    }

    @Test(priority = 16, description = "CA-420")
    public void ubahFrameworkSuccessfullyUpdatedFrameworkWithValidRequiredFieldsAndCharacterLimits() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_FRAMEWORK),
                "Successfully navigate to Bank Framework menu", "Failed navigate to Bank Framework menu");
        sekolahmuElement.navigateToUrl("https://core.dev.sid.id/framework/edit/137");
        verifyStep(bankFrameworkSteps.fillNameBankFramework(""), "Successfully fill name bank framework",
                "Failed fill name bank framework");
        verifyStep(bankFrameworkSteps.clickButtonSaveFramework(), "Successfully click Save framework",
                "Failed click Save framework");
    }
}
