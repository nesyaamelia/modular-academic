package mu.core.id.website.testcase.platforms.core.academic.manageprogram;

import automation.platforms.core.academic.manageprogram.ManageProgramModel;
import automation.platforms.core.academic.manageprogram.ManageProgramPage;
import automation.platforms.core.academic.manageprogram.ManageProgramSteps;
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
@Feature("Academic - Manage Program Package")
public class ManageProgramTest extends BaseCoreDriverTest implements ManageProgramTestCase {
    private ManageProgramSteps manageProgramSteps;
    private ManageProgramModel manageProgramModel;
    private MenuCoreSteps menuCoreSteps;
    private LoginCoreSteps loginSteps;

    @Override
    public void initInstance() {
        super.initInstance();
        manageProgramSteps = new ManageProgramPage(page);
        manageProgramModel = new ManageProgramModel();
        menuCoreSteps = new MenuCorePage(page);
        loginSteps = new LoginCorePage(page);
    }

    @Test(priority = 1, description = "27875")
    @Override
    public void mainTableProgramSuccessfullySearchByIdNamaProgramAndFilterByOrganisasiPenyediaStatusProgram() {
        navigateToManageProgram();
        verifyStep(manageProgramSteps.searchManageProgram(manageProgramModel.searchByValidName()),
                "Successfully search manage program by invalid name keyword",
                "Failed search manage program by invalid name keyword");
        verifyStep(manageProgramSteps.filterByChips(manageProgramModel.filterByOrganization()),
                "Successfully filter manage program by organization", "Failed filter manage program by organization");
    }

    private void navigateToManageProgram() {
        loginSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_PROGRAM),
                "Successfully navigate to Kelola Program menu", "Failed navigate to Kelola Program menu");
    }
}
