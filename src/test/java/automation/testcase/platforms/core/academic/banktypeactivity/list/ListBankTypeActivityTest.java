package mu.core.id.website.testcase.platforms.core.academic.banktypeactivity.list;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import automation.platforms.core.academic.sidemenu.MenuCoreOptions;
import automation.platforms.core.academic.sidemenu.MenuCorePage;
import automation.platforms.core.academic.sidemenu.MenuCoreSteps;
import automation.platforms.core.academic.banktypeactivity.list.ListBankTypeActivityModel;
import automation.platforms.core.academic.banktypeactivity.list.ListBankTypeActivityPage;
import automation.platforms.core.academic.banktypeactivity.list.ListBankTypeActivitySteps;
import automation.platforms.core.user.login.LoginCorePage;
import automation.platforms.core.user.login.LoginCoreSteps;
import mu.core.id.website.testcase.platforms.core.BaseCoreDriverTest;
import org.testng.annotations.Test;

import static automation.utils.StepLogger.verifyStep;

@Epic("Platform Core")
@Feature("Academic - List Bank Type Activity")
public class ListBankTypeActivityTest extends BaseCoreDriverTest implements ListBankTypeActivityTestCase {
    private ListBankTypeActivitySteps listBankTypeActivitySteps;
    private ListBankTypeActivityModel listBankTypeActivityModel;
    private LoginCoreSteps loginCoreSteps;
    private MenuCoreSteps menuCoreSteps;

    @Override
    public void initInstance() {
        super.initInstance();
        listBankTypeActivitySteps = new ListBankTypeActivityPage(page);
        listBankTypeActivityModel = new ListBankTypeActivityModel();
        loginCoreSteps = new LoginCorePage(page);
        menuCoreSteps = new MenuCorePage(page);
    }

    @Test(priority = 1, description = "depend = CA-286, CA-291")
    @Override
    public void listTypeOfActivitySuccessSearchByIdWithValidKeyword() {
        navigateToBankTypeActivity();
        verifyStep(listBankTypeActivitySteps.searchActivityType(listBankTypeActivityModel.searchByValidId()),
                "Successfully search bank type activity with valid keyword",
                "Failed search bank type activity with valid keyword");
    }

    @Test(priority = 2, description = "CA-290, CA-292")
    @Override
    public void listTypeOfActivityFailedSearchByIdWithInvalidKeyword() {
        navigateToBankTypeActivity();
        verifyStep(listBankTypeActivitySteps.searchActivityType(listBankTypeActivityModel.searchByInvalidId()),
                "Successfully search bank type activity with invalid keyword",
                "Failed search bank type activity with invalid keyword");
    }

    @Test(priority = 3, description = "CA-291")
    @Override
    public void listTypeOfActivitySuccessSearchByNamaJenisAktivitasWithValidKeyword() {
        navigateToBankTypeActivity();
        verifyStep(listBankTypeActivitySteps.searchActivityType(listBankTypeActivityModel.searchByValidNameActivity()),
                "Successfully search bank type activity with valid keyword",
                "Failed search bank type activity with valid keyword");
    }

    @Test(priority = 4, description = "CA-292")
    @Override
    public void listTypeOfActivityFailedSearchByNamaJenisAktivitasWithInvalidKeyword() {
        navigateToBankTypeActivity();
        verifyStep(
                listBankTypeActivitySteps.searchActivityType(listBankTypeActivityModel.searchByInvalidNameActivity()),
                "Successfully search bank type activity with invalid keyword",
                "Failed search bank type activity with invalid keyword");
    }

    @Test(priority = 5, description = "CA-301")
    @Override
    public void listTypeOfActivitySuccessFilterByKontenBelajarOnListTypeOfActivityTable() {
        navigateToBankTypeActivity();
        verifyStep(listBankTypeActivitySteps.filterByChips(listBankTypeActivityModel.filterByContentLearning()),
                "Successfully filter bank type activity by konten belajar",
                "Failed filter bank type activity by konten belajar");
    }

    @Test(priority = 6, description = "CA-300")
    @Override
    public void listTypeOfActivitySuccessFilterByOrganisasiOnListTypeOfActivityTable() {
        navigateToBankTypeActivity();
        verifyStep(listBankTypeActivitySteps.filterByChips(listBankTypeActivityModel.filterByOrganization()),
                "Successfully filter bank type activity by organization",
                "Failed filter bank type activity by organization");
    }

    @Test(priority = 7, description = "CA-306")
    @Override
    public void listTypeOfActivitySuccessFilterByKategoriAktivitas() {
        navigateToBankTypeActivity();
        verifyStep(listBankTypeActivitySteps.advancedFilter(listBankTypeActivityModel.filterByCategoryActivity()),
                "Successfully filter bank type activity by organization",
                "Failed filter bank type activity by organization");
    }

    @Test(priority = 8, description = "CA-307")
    @Override
    public void listTypeOfActivitySuccessFilterByStatus() {
        navigateToBankTypeActivity();
        verifyStep(listBankTypeActivitySteps.advancedFilter(listBankTypeActivityModel.filterByStatus()),
                "Successfully filter bank type activity by organization",
                "Failed filter bank type activity by organization");
    }

    @Test(priority = 9, description = "CA-303")
    @Override
    public void listTypeOfActivitySuccessSearchOnModalFilterOrganisasiWithValidKeyword() {
        navigateToBankTypeActivity();
        verifyStep(listBankTypeActivitySteps.advancedFilter(listBankTypeActivityModel.searchFilterOrganization()),
                "Successfully filter bank type activity by organization",
                "Failed filter bank type activity by organization");
    }

    @Test(priority = 10, description = "CA-304")
    @Override
    public void listTypeOfActivitySuccessSearchOnModalFilterKontenBelajarWithValidKeyword() {
        navigateToBankTypeActivity();
        verifyStep(listBankTypeActivitySteps.advancedFilter(listBankTypeActivityModel.searchFilterContentLearning()),
                "Successfully filter bank type activity by organization",
                "Failed filter bank type activity by organization");
    }

    @Test(priority = 11, description = "depend = CA-361, CA-362")
    @Override
    public void detailTypeOfActivityVerifyThatTheDetailPageDisplaysTheCorrectData() {
        navigateToBankTypeActivity();
        verifyStep(listBankTypeActivitySteps.detailActivityType(), "Successfully open detail jenis aktivitas",
                "Failed open detail jenis aktivitas");
    }

    private void navigateToBankTypeActivity() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_ACTIVITY_TYPE),
                "Successfully navigate to Bank Jenis Aktivitas menu", "Failed navigate to Bank Jenis Aktivitas menu");
    }
}
