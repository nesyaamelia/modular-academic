package mu.core.id.website.testcase.platforms.core.academic.bankelement.list;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import automation.platforms.core.academic.bankelement.list.ListBankElementModel;
import automation.platforms.core.academic.bankelement.list.ListBankElementPage;
import automation.platforms.core.academic.bankelement.list.ListBankElementSteps;
import automation.platforms.core.academic.sidemenu.MenuCoreOptions;
import automation.platforms.core.academic.sidemenu.MenuCorePage;
import automation.platforms.core.academic.sidemenu.MenuCoreSteps;
import automation.platforms.core.user.login.LoginCorePage;
import automation.platforms.core.user.login.LoginCoreSteps;
import mu.core.id.website.testcase.platforms.core.BaseCoreDriverTest;
import org.testng.annotations.Test;

import static automation.utils.StepLogger.verifyStep;

@Epic("Platform Core")
@Feature("Academic - List Bank Element")
public class ListBankElementTest extends BaseCoreDriverTest implements ListBankElementTestCase {
    private ListBankElementSteps listBankElementSteps;
    private ListBankElementModel listBankElementModel;
    private LoginCoreSteps loginCoreSteps;
    private MenuCoreSteps menuCoreSteps;

    @Override
    public void initInstance() {
        super.initInstance();
        listBankElementSteps = new ListBankElementPage(page);
        listBankElementModel = new ListBankElementModel();
        loginCoreSteps = new LoginCorePage(page);
        menuCoreSteps = new MenuCorePage(page);
    }

    @Test(priority = 1, description = "depend = 2055, 2058")
    @Override
    public void bankElementMasterSuccessfullyFiltersAndSearchesElementsWithValidInputCombinations() {
        navigateToBankElementMaster();
        verifyStep(listBankElementSteps.searchAndFilterBankElement(listBankElementModel.searchByValidKeyword()),
                "Successfully search and filter bank element with valid keyword",
                "Failed search and filter bank element with valid keyword");
    }

    @Test(priority = 2, description = "depend = 2054, 2269,")
    @Override
    public void detailElementMasterSuccessfullyOpenDetailElementMasterPage() {
        navigateToBankElementMaster();
        verifyStep(listBankElementSteps.goToDetailBankElement(), "Successfully go to detail bank element page",
                "Failed go to detail bank element page");
    }

    @Test(priority = 3, description = "2271")
    @Override
    public void detailElementMasterSuccessfullyNavigatesToTheEditElementMasterPageWhenClickUbahElement() {
        navigateToBankElementMaster();
        verifyStep(listBankElementSteps.goToDetailBankElement(), "Successfully go to detail bank element page",
                "Failed go to detail bank element page");
        verifyStep(listBankElementSteps.goToEditElement(), "Successfully go to edit bank element page",
                "Failed go to edit bank element page");
    }

    @Test(priority = 4, description = "depend = 2291, 2294")
    @Override
    public void bankElementOrganisasiSuccessfullyFiltersAndSearchesElementsWithValidInputCombinations() {
        navigateToBankElementOrganization();
        verifyStep(
                listBankElementSteps
                        .searchAndFilterBankElement(listBankElementModel.searchByValidKeywordOrganizationElement()),
                "Successfully search and filter bank element with valid keyword",
                "Failed search and filter bank element with valid keyword");
    }

    @Test(priority = 5, description = "depend = 2606, 2607")
    @Override
    public void detailElementOrganisasiSuccessfullyOpenDetailElementOrganisasiPage() {
        navigateToBankElementOrganization();
        verifyStep(listBankElementSteps.goToDetailBankElement(), "Successfully go to detail bank element page",
                "Failed go to detail bank element page");
    }

    @Test(priority = 6, description = "2608")
    @Override
    public void detailElementOrganisasiSuccessfullyNavigatesToTheEditElementOrganisasiPageWhenClickUbahElement() {
        navigateToBankElementOrganization();
        verifyStep(listBankElementSteps.goToDetailBankElement(), "Successfully go to detail bank element page",
                "Failed go to detail bank element page");
        verifyStep(listBankElementSteps.goToEditElement(), "Successfully go to edit bank element page",
                "Failed go to edit bank element page");
    }

    private void navigateToBankElementMaster() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_ELEMENT_MASTER),
                "Successfully navigate to Bank Element menu", "Failed navigate to Bank Element menu");
    }

    private void navigateToBankElementOrganization() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_ELEMENT_ORGANIZATION),
                "Successfully navigate to Bank Element menu", "Failed navigate to Bank Element menu");
    }
}
