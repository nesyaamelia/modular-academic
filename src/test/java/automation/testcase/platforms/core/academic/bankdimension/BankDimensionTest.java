package mu.core.id.website.testcase.platforms.core.academic.bankdimension;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import automation.platforms.core.academic.bankdimension.list.ListBankDimensionModel;
import automation.platforms.core.academic.bankdimension.list.ListBankDimensionPage;
import automation.platforms.core.academic.bankdimension.list.ListBankDimensionSteps;
import automation.platforms.core.academic.sidemenu.MenuCoreOptions;
import automation.platforms.core.academic.sidemenu.MenuCorePage;
import automation.platforms.core.academic.sidemenu.MenuCoreSteps;
import automation.platforms.core.user.login.LoginCorePage;
import automation.platforms.core.user.login.LoginCoreSteps;
import mu.core.id.website.testcase.platforms.core.BaseCoreDriverTest;
import org.testng.annotations.Test;

import static automation.utils.StepLogger.verifyStep;

@Epic("Platform Core")
@Feature("Academic - Bank Dimension")
public class BankDimensionTest extends BaseCoreDriverTest implements BankDimensionTestCase {
    private ListBankDimensionSteps listBankDimensionSteps;
    private ListBankDimensionModel listBankDimensionModel;
    private MenuCoreSteps menuCoreSteps;
    private LoginCoreSteps loginCoreSteps;

    @Override
    public void initInstance() {
        super.initInstance();
        listBankDimensionSteps = new ListBankDimensionPage(page);
        listBankDimensionModel = new ListBankDimensionModel();
        menuCoreSteps = new MenuCorePage(page);
        loginCoreSteps = new LoginCorePage(page);
    }

    @Test(priority = 1, description = "1808")
    @Override
    public void bankDimensionSuccessfullySearchDimensionByValidId() {
        navigateToBankDimension();
        verifyStep(listBankDimensionSteps.searchBankDimension(listBankDimensionModel.searchByValidId()),
                "Successfully search bank dimension by valid id", "Failed search bank dimension by valid id");
    }

    @Test(priority = 2, description = "1811")
    @Override
    public void bankDimensionSuccessfullySearchDimensionByNameMoreThan_3Character() {
        navigateToBankDimension();
        verifyStep(listBankDimensionSteps.searchBankDimension(listBankDimensionModel.searchByValidName()),
                "Successfully search bank dimension by name more than 3 character",
                "Failed search bank dimension by name more than 3 character");
    }

    @Test(priority = 3, description = "depend = 1810, 1814")
    @Override
    public void bankDimensionSuccessfullyFiltersAndSearchesDimensionWithValidInputCombinations() {
        navigateToBankDimension();
        verifyStep(listBankDimensionSteps.searchBankDimension(listBankDimensionModel.searchByValidId()),
                "Successfully search bank dimension by valid id", "Failed search bank dimension by valid id");
        verifyStep(listBankDimensionSteps.filterByStatus(listBankDimensionModel.filterStatusActive()),
                "Successfully filter bank dimension by active status", "Failed filter bank dimension by active status");
    }

    @Test(priority = 4, description = "1815")
    @Override
    public void bankDimensionSuccessfullyFilterByStatusTidakAktif() {
        navigateToBankDimension();
        verifyStep(listBankDimensionSteps.filterByStatus(listBankDimensionModel.filterStatusNonActive()),
                "Successfully filter bank dimension by non active status",
                "Failed filter bank dimension by non active status");
    }

    @Test(priority = 5, description = "1873")
    public void detailDimensionSuccessfullyOpenDetailDimension() {
        navigateToBankDimension();
        verifyStep(listBankDimensionSteps.goToDetailBankDimension(), "Successfully open detail dimension page",
                "Failed open detail dimension page");
    }

    @Test(priority = 6, description = "1887")
    public void detailDimensionUbahDimensionButtonRedirectToUbahDimensionPage() {
        navigateToBankDimension();
        verifyStep(listBankDimensionSteps.goToDetailBankDimension(), "Successfully open detail dimension page",
                "Failed open detail dimension page");
        verifyStep(listBankDimensionSteps.goToEditDimension(), "Successfully open edit dimension page",
                "Failed open edit dimension page");
    }

    private void navigateToBankDimension() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_DIMENSION),
                "Successfully navigate to Bank Dimension menu", "Failed navigate to Bank Dimension menu");
    }
}
