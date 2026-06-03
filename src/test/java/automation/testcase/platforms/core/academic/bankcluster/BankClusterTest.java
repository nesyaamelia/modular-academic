package mu.core.id.website.testcase.platforms.core.academic.bankcluster;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import automation.platforms.core.academic.bankcluster.BankClusterModel;
import automation.platforms.core.academic.bankcluster.BankClusterPage;
import automation.platforms.core.academic.bankcluster.BankClusterSteps;
import automation.platforms.core.academic.sidemenu.MenuCoreOptions;
import automation.platforms.core.academic.sidemenu.MenuCorePage;
import automation.platforms.core.academic.sidemenu.MenuCoreSteps;
import automation.platforms.core.user.login.LoginCorePage;
import automation.platforms.core.user.login.LoginCoreSteps;
import mu.core.id.website.testcase.platforms.core.BaseCoreDriverTest;
import org.testng.annotations.Test;

import static automation.utils.StepLogger.verifyStep;

@Epic("Platform Core")
@Feature("Academic - Bank Cluster")
public class BankClusterTest extends BaseCoreDriverTest implements BankClusterTestCase {
        private BankClusterSteps bankClusterSteps;
        private BankClusterModel bankClusterModel;
        private LoginCoreSteps loginCoreSteps;
        private MenuCoreSteps menuCoreSteps;

        @Override
        public void initInstance() {
                super.initInstance();
                bankClusterSteps = new BankClusterPage(page);
                bankClusterModel = new BankClusterModel();
                loginCoreSteps = new LoginCorePage(page);
                menuCoreSteps = new MenuCorePage(page);
        }

        @Test(priority = 1, description = "depend =  1746, 1747, 1749, 1756, 1758")
        @Override
        public void successfullyCreateClusterWithValidData() {
                navigateToBankClusterMenu();
                verifyStep(bankClusterSteps.navigateToPageBankCluster(), "Successfully navigate to Bank Cluster page",
                                "Failed to navigate to Bank Cluster page");
                verifyStep(bankClusterSteps.fillNameBankCluster(bankClusterModel.generateValidDataCluster()),
                                "Successfully fill Name Bank Cluster", "Failed to fill Name Bank Cluster");
                verifyStep(bankClusterSteps.fillCodeBankCluster(bankClusterModel.generateValidDataCluster()),
                                "Successfully fill Code Bank Cluster", "Failed to fill Code Bank Cluster");
                verifyStep(bankClusterSteps.fillDescriptionBankCluster(bankClusterModel.generateValidDataCluster()),
                                "Successfully fill Description Bank Cluster",
                                "Failed to fill Description Bank Cluster");
                verifyStep(bankClusterSteps.selectFramework(), "Successfully select Framework",
                                "Failed to select Framework");
                verifyStep(bankClusterSteps.clickButtonAddFramework(), "Successfully click button Add Framework",
                                "Failed to click button Add Framework");
                verifyStep(bankClusterSteps.clickButtonSaveCluster(),
                                "Successfully click button Save Bank Cluster and navigate to Bank Cluster page",
                                "Failed to click button Save Bank Cluster and navigate to Bank Cluster page");
        }

        @Test(priority = 2, description = "1728")
        @Override
        public void successfullySearchClusterByNameMoreThan_3Character() {
                navigateToBankClusterMenu();
                verifyStep(bankClusterSteps.searchBankCluster(bankClusterModel.searchByValidNameCluster()),
                                "Successfully search Bank Cluster with valid keyword",
                                "Failed to search Bank Cluster with valid keyword");
        }

        @Test(priority = 3, description = "1726")
        @Override
        public void successfullySearchClusterByValidId() {
                navigateToBankClusterMenu();
                verifyStep(bankClusterSteps.searchBankCluster(bankClusterModel.searchByValidId()),
                                "Successfully search Bank Cluster with valid keyword",
                                "Failed to search Bank Cluster with valid keyword");
        }

        @Test(priority = 4, description = "depend = 1731, 1736")
        @Override
        public void successfullyFilterByStatusAktif() {
                navigateToBankClusterMenu();
                verifyStep(bankClusterSteps.filterByActiveStatus(), "Successfully filter Bank Cluster by Status Aktif",
                                "Failed to filter Bank Cluster by Status Aktif");
                verifyStep(bankClusterSteps.clickButtonResetFilter(), "Successfully click button Reset Filter",
                                "Failed to click button Reset Filter");
        }

        @Test(priority = 5, description = "1732")
        @Override
        public void successfullyFilterByStatusTidakAktif() {
                navigateToBankClusterMenu();
                verifyStep(bankClusterSteps.filterByInactiveStatus(),
                                "Successfully filter Bank Cluster by Status Tidak Aktif",
                                "Failed to filter Bank Cluster by Status Tidak Aktif");
        }

        @Test(priority = 6, description = "1791")
        @Override
        public void successfullyOpenDetailClusterPageWithCorrectSlug() {
                navigateToBankClusterMenu();
                verifyStep(bankClusterSteps.clickButtonDetail(),
                                "Successfully click button Detail and navigate to Detail Bank Cluster page",
                                "Failed to click button Detail and navigate to Detail Bank Cluster page");
        }

        @Test(priority = 7, description = "depend =  1774, 1775, 1776, 1777")
        @Override
        public void successfullyEditAnExistingClusterWithValidInputs() {
                navigateToBankClusterMenu();
                verifyStep(bankClusterSteps.clickButtonEdit(),
                                "Successfully click button Edit and navigate to Edit Bank Cluster page",
                                "Failed to click button Edit and navigate to Edit Bank Cluster page");
                verifyStep(bankClusterSteps.fillNameBankCluster(bankClusterModel.generateValidDataCluster()),
                                "Successfully fill Name Bank Cluster", "Failed to fill Name Bank Cluster");
                verifyStep(bankClusterSteps.fillCodeBankCluster(bankClusterModel.generateValidDataCluster()),
                                "Successfully fill Code Bank Cluster", "Failed to fill Code Bank Cluster");
                verifyStep(bankClusterSteps.fillDescriptionBankCluster(bankClusterModel.generateValidDataCluster()),
                                "Successfully fill Description Bank Cluster",
                                "Failed to fill Description Bank Cluster");
                verifyStep(bankClusterSteps.toggleStatusCluster(), "Successfully non-aktifkan Cluster",
                                "Failed to non-aktifkan Cluster");
                verifyStep(bankClusterSteps.toggleStatusRelationFramework(),
                                "Successfully non-aktifkan Relasi Framework",
                                "Failed to non-aktifkan Relasi Framework");
                verifyStep(bankClusterSteps.saveEditCluster(),
                                "Successfully Save Edit Bank Cluster and navigate to Bank Cluster page",
                                "Failed to Save Edit Bank Cluster and navigate to Bank Cluster page");
        }

        @Test(priority = 8, description = "1782")
        @Override
        public void failedToEditAnExistingClusterWhenMandatoryFieldIsEmpty() {
                navigateToBankClusterMenu();
                verifyStep(bankClusterSteps.clickButtonEdit(),
                                "Successfully click button Edit and navigate to Edit Bank Cluster page",
                                "Failed to click button Edit and navigate to Edit Bank Cluster page");
                verifyStep(bankClusterSteps.fillNameBankCluster(bankClusterModel.editInvalidNameClusterEmpty()),
                                "Successfully fill Name Bank Cluster with empty",
                                "Failed to fill Name Bank Cluster with empty");
                verifyStep(bankClusterSteps.saveClusterExpectingError(), "Expected error alert for mandatory field",
                                "Error alert not shown as expected");
        }

        @Test(priority = 9, description = "1783")
        @Override
        public void failedToEditAnExistingClusterWhenFieldExceedsTheMaximumCharacterLimit() {
                navigateToBankClusterMenu();
                verifyStep(bankClusterSteps.clickButtonEdit(),
                                "Successfully click button Edit and navigate to Edit Bank Cluster page",
                                "Failed to click button Edit and navigate to Edit Bank Cluster page");
                verifyStep(bankClusterSteps.fillNameBankCluster(bankClusterModel.generateInvalidDataCluster()),
                                "Successfully fill Name Bank Cluster with more than 100 characters",
                                "Failed to fill Name Bank Cluster with more than 100 characters");
                verifyStep(bankClusterSteps.fillCodeBankCluster(bankClusterModel.generateInvalidDataCluster()),
                                "Successfully fill Code Bank Cluster with more than 30 characters",
                                "Failed to fill Code Bank Cluster with more than 30 characters");
                verifyStep(bankClusterSteps.fillDescriptionBankCluster(bankClusterModel.generateInvalidDataCluster()),
                                "Successfully fill Description Bank Cluster with more than 500 characters",
                                "Failed to fill Description Bank Cluster with more than 500 characters");
                verifyStep(bankClusterSteps.saveClusterExpectingError(),
                                "Expected error alert for exceeding character limit",
                                "Error alert not shown as expected");
        }

        @Test(priority = 10, description = "1785")
        @Override
        public void failedToEditAnExistingClusterWhenFieldContainCharacterNotAllowed() {
                navigateToBankClusterMenu();
                verifyStep(bankClusterSteps.clickButtonEdit(),
                                "Successfully click button Edit and navigate to Edit Bank Cluster page",
                                "Failed to click button Edit and navigate to Edit Bank Cluster page");
                verifyStep(bankClusterSteps.fillCodeBankCluster(bankClusterModel.editInvalidCodeClusterSpecialChars()),
                                "Successfully fill Name Bank Cluster with special characters",
                                "Failed to fill Name Bank Cluster with special characters");
                verifyStep(bankClusterSteps.saveClusterExpectingError(), "Expected error alert for invalid characters",
                                "Error alert not shown as expected");
        }

        @Test(priority = 11, description = "1753")
        @Override
        public void successfullyCreateClusterWithOptionalFieldIsEmpty() {
                navigateToBankClusterMenu();
                verifyStep(bankClusterSteps.navigateToPageBankCluster(), "Successfully navigate to Bank Cluster page",
                                "Failed to navigate to Bank Cluster page");
                verifyStep(bankClusterSteps.fillNameBankCluster(bankClusterModel.generateValidDataCluster()),
                                "Successfully fill Name Bank Cluster", "Failed to fill Name Bank Cluster");
                verifyStep(bankClusterSteps.selectFramework(), "Successfully select Framework",
                                "Failed to select Framework");
                verifyStep(bankClusterSteps.clickButtonAddFramework(), "Successfully click button Add Framework",
                                "Failed to click button Add Framework");
                verifyStep(bankClusterSteps.clickButtonSaveCluster(),
                                "Successfully click button Save Bank Cluster and navigate to Bank Cluster page",
                                "Failed to click button Save Bank Cluster and navigate to Bank Cluster page");
        }

        @Test(priority = 12, description = "1754")
        @Override
        public void successfullyCreateClusterWithMaximumLengthInputs() {
                navigateToBankClusterMenu();
                verifyStep(bankClusterSteps.navigateToPageBankCluster(), "Successfully navigate to Bank Cluster page",
                                "Failed to navigate to Bank Cluster page");
                verifyStep(bankClusterSteps.fillNameBankCluster(bankClusterModel.generateDataClusterMaximumLength()),
                                "Successfully fill Name Bank Cluster with maximum length",
                                "Failed to fill Name Bank Cluster with maximum length");
                verifyStep(bankClusterSteps.fillCodeBankCluster(bankClusterModel.generateDataClusterMaximumLength()),
                                "Successfully fill Code Bank Cluster with maximum length",
                                "Failed to fill Code Bank Cluster with maximum length");
                verifyStep(bankClusterSteps
                                .fillDescriptionBankCluster(bankClusterModel.generateDataClusterMaximumLength()),
                                "Successfully fill Description Bank Cluster with maximum length",
                                "Failed to fill Description Bank Cluster with maximum length");
                verifyStep(bankClusterSteps.selectFramework(), "Successfully select Framework",
                                "Failed to select Framework");
                verifyStep(bankClusterSteps.clickButtonAddFramework(), "Successfully click button Add Framework",
                                "Failed to click button Add Framework");
                verifyStep(bankClusterSteps.clickButtonSaveCluster(),
                                "Successfully click button Save Bank Cluster and navigate to Bank Cluster page",
                                "Failed to click button Save Bank Cluster and navigate to Bank Cluster page");
        }

        @Test(priority = 13, description = "1763")
        @Override
        public void failedToCreateClusterWhenMandatoryFieldIsEmpty() {
                navigateToBankClusterMenu();
                verifyStep(bankClusterSteps.navigateToPageBankCluster(), "Successfully navigate to Bank Cluster page",
                                "Failed to navigate to Bank Cluster page");
                verifyStep(bankClusterSteps.fillCodeBankCluster(bankClusterModel.generateValidDataCluster()),
                                "Successfully fill Code Bank Cluster", "Failed to fill Code Bank Cluster");
                verifyStep(bankClusterSteps.fillDescriptionBankCluster(bankClusterModel.generateValidDataCluster()),
                                "Successfully fill Description Bank Cluster",
                                "Failed to fill Description Bank Cluster");
                verifyStep(bankClusterSteps.saveClusterExpectingError(), "Expected error alert for mandatory field",
                                "Error alert not shown as expected");
        }

        @Test(priority = 14, description = "1764")
        @Override
        public void failedToCreateClusterWhenInputFieldExceedsTheMaximumCharacterLimit() {
                navigateToBankClusterMenu();
                verifyStep(bankClusterSteps.navigateToPageBankCluster(), "Successfully navigate to Bank Cluster page",
                                "Failed to navigate to Bank Cluster page");
                verifyStep(bankClusterSteps.fillNameBankCluster(bankClusterModel.generateInvalidDataCluster()),
                                "Successfully fill Name Bank Cluster with more than 100 characters",
                                "Failed to fill Name Bank Cluster with more than 100 characters");
                verifyStep(bankClusterSteps.fillCodeBankCluster(bankClusterModel.generateInvalidDataCluster()),
                                "Successfully fill Code Bank Cluster with more than 30 characters",
                                "Failed to fill Code Bank Cluster with more than 30 characters");
                verifyStep(bankClusterSteps.fillDescriptionBankCluster(bankClusterModel.generateInvalidDataCluster()),
                                "Successfully fill Description Bank Cluster with more than 500 characters",
                                "Failed to fill Description Bank Cluster with more than 500 characters");
                verifyStep(bankClusterSteps.selectFramework(), "Successfully select Framework",
                                "Failed to select Framework");
                verifyStep(bankClusterSteps.clickButtonAddFramework(), "Successfully click button Add Framework",
                                "Failed to click button Add Framework");
                verifyStep(bankClusterSteps.saveClusterExpectingError(),
                                "Expected error alert for exceeding character limit",
                                "Error alert not shown as expected");
        }

        @Test(priority = 15, description = "depend = 1769, 1771")
        @Override
        public void popUpTinggalkanHalamanAppearsIfTheUserHasInputAtLeast_1CharacterOnTambahClusterPage() {
                navigateToBankClusterMenu();
                verifyStep(bankClusterSteps.navigateToPageBankCluster(), "Successfully navigate to Bank Cluster page",
                                "Failed to navigate to Bank Cluster page");
                verifyStep(bankClusterSteps.fillNameBankCluster(bankClusterModel.generateValidDataCluster()),
                                "Successfully fill Name Bank Cluster", "Failed to fill Name Bank Cluster");
                verifyStep(bankClusterSteps.stayOnThePage(),
                                "Pop-up Tinggalkan Halaman appears when user has input at least 1 character on Tambah Cluster page",
                                "Pop-up Tinggalkan Halaman not appears when user has input at least 1 character on Tambah Cluster page");
        }

        @Test(priority = 16, description = "1770")
        @Override
        public void returnToBankClusterPageWhenUserCancelCreateClusterAndClickTinggalkanHalamanButtonOnPopUp() {
                navigateToBankClusterMenu();
                verifyStep(bankClusterSteps.navigateToPageBankCluster(), "Successfully navigate to Bank Cluster page",
                                "Failed to navigate to Bank Cluster page");
                verifyStep(bankClusterSteps.fillNameBankCluster(bankClusterModel.generateValidDataCluster()),
                                "Successfully fill Name Bank Cluster", "Failed to fill Name Bank Cluster");
                verifyStep(bankClusterSteps.leavingPageWithoutSaving(),
                                "Successfully leave page Bank Cluster without saving and navigate to Bank Cluster page",
                                "Failed to leave page Bank Cluster without saving and navigate to Bank Cluster page");
        }

        private void navigateToBankClusterMenu() {
                loginCoreSteps.injectLoginCoreCookies();
                verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_CLUSTER),
                                "Successfully navigate to Bank Cluster menu",
                                "Failed to navigate to Bank Cluster menu");
        }
}
