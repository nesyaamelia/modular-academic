package mu.core.id.website.testcase.platforms.core.academic.manageactivity;

import automation.platforms.core.academic.manageactivity.ManageActivityModel;
import automation.platforms.core.academic.manageactivity.ManageActivityPage;
import automation.platforms.core.academic.manageactivity.ManageActivitySteps;
import automation.platforms.core.academic.sidemenu.MenuCoreOptions;
import automation.platforms.core.academic.sidemenu.MenuCorePage;
import automation.platforms.core.academic.sidemenu.MenuCoreSteps;
import automation.platforms.core.user.login.LoginCorePage;
import automation.platforms.core.user.login.LoginCoreSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mu.core.id.website.testcase.platforms.core.BaseCoreDriverTest;
import org.testng.annotations.Test;

import static automation.utils.StepLogger.verifyStep;

@Epic("Platform Core")
@Feature("Academic - Manage Activity Package")
public class ManageActivityTest extends BaseCoreDriverTest implements ManageActivityTestCase {
    private ManageActivitySteps manageActivitySteps;
    private ManageActivityModel manageActivityModel;
    private MenuCoreSteps menuCoreSteps;
    private LoginCoreSteps loginSteps;

    @Override
    public void initInstance() {
        super.initInstance();
        manageActivitySteps = new ManageActivityPage(page);
        manageActivityModel = new ManageActivityModel();
        menuCoreSteps = new MenuCorePage(page);
        loginSteps = new LoginCorePage(page);
    }

    @Test(priority = 1, description = "16431")
    @Override
    public void kelolaAktivitasSuccessfullySearchActivityByValidId() {
        navigateToManageActivity();
        verifyStep(manageActivitySteps.searchManageActivity(manageActivityModel.searchByValidId()),
                "Successfully search manage activity by valid id keyword",
                "Failed search manage activity by valid id keyword");
    }

    @Test(priority = 2, description = "16432")
    @Override
    public void kelolaAktivitasNoResultInTableWhenIdNotFound() {
        navigateToManageActivity();
        verifyStep(manageActivitySteps.searchManageActivity(manageActivityModel.searchByInvalidId()),
                "Successfully search manage activity by invalid id keyword",
                "Failed search manage activity by invalid id keyword");
    }

    @Test(priority = 3, description = "16434")
    @Override
    public void kelolaAktivitasSuccessfullySearchActivityByActivityName() {
        navigateToManageActivity();
        verifyStep(manageActivitySteps.searchManageActivity(manageActivityModel.searchByValidName()),
                "Successfully search manage activity by valid name keyword",
                "Failed search manage activity by valid id keyword");
    }

    @Test(priority = 4, description = "16435")
    @Override
    public void kelolaAktivitasNoResultInTableWhenTheActivityNameDoesNotMatch() {
        navigateToManageActivity();
        verifyStep(manageActivitySteps.searchManageActivity(manageActivityModel.searchByInvalidName()),
                "Successfully search manage activity by invalid name keyword",
                "Failed search manage activity by invalid name keyword");
    }

    @Test(priority = 6, description = "16436")
    @Override
    public void kelolaAktivitasSuccessfullyFilterByStatus() {
        navigateToManageActivity();
        verifyStep(manageActivitySteps.filterByChips(manageActivityModel.filterByStatus()),
                "Successfully filter bank content by status", "Failed filter bank content by status");
    }

    @Test(priority = 7, description = "16438")
    @Override
    public void kelolaAktivitasSuccessfullyFilterByKontenAktivitas() {
        navigateToManageActivity();
        verifyStep(manageActivitySteps.filterByChips(manageActivityModel.filterByContentActivity()),
                "Successfully filter bank content by content activity", "Failed filter bank content activity");
    }

    @Test(priority = 8, description = "16439")
    @Override
    public void kelolaAktivitasSuccessfullyFilterByOrganisasiPenyedia() {
        navigateToManageActivity();
        verifyStep(manageActivitySteps.advancedFilter(manageActivityModel.filterByOrganization()),
                "Successfully filter bank content by organization", "Failed filter bank content by organization");
    }

    @Test(priority = 9, description = "16433")
    @Override
    public void kelolaAktivitasSuccessfullyFiltersAndSearchesActivityWithValidInputCombinations() {
        navigateToManageActivity();
        verifyStep(manageActivitySteps.searchManageActivity(manageActivityModel.searchByValidId()),
                "Successfully search manage activity by invalid name keyword",
                "Failed search manage activity by invalid name keyword");
        verifyStep(manageActivitySteps.filterByChips(manageActivityModel.filterByStatus()),
                "Successfully filter bank content by status", "Failed filter bank content by status");
    }

    private void navigateToManageActivity() {
        loginSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_ACTIVITY),
                "Successfully navigate to Kelola Aktivitas menu", "Failed navigate to Kelola Aktivitas menu");
    }
}
