package mu.core.id.website.testcase.platforms.core.academic.bankcontent.list;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import automation.platforms.core.academic.bankcontent.list.ListBankContentModel;
import automation.platforms.core.academic.bankcontent.list.ListBankContentPage;
import automation.platforms.core.academic.bankcontent.list.ListBankContentSteps;
import automation.platforms.core.academic.sidemenu.MenuCoreOptions;
import automation.platforms.core.academic.sidemenu.MenuCorePage;
import automation.platforms.core.academic.sidemenu.MenuCoreSteps;
import automation.platforms.core.user.login.LoginCorePage;
import automation.platforms.core.user.login.LoginCoreSteps;
import mu.core.id.website.testcase.platforms.core.BaseCoreDriverTest;
import org.testng.annotations.Test;

import static automation.utils.StepLogger.verifyStep;

@Epic("Platform Core")
@Feature("Academic - List Bank Content")
public class ListBankContentTest extends BaseCoreDriverTest implements ListBankContentTestCase {
        private ListBankContentSteps listBankContentSteps;
        private ListBankContentModel listBankContentModel;
        private MenuCoreSteps menuCoreSteps;
        private LoginCoreSteps loginSteps;

        @Override
        public void initInstance() {
                super.initInstance();
                listBankContentSteps = new ListBankContentPage(page);
                listBankContentModel = new ListBankContentModel();
                menuCoreSteps = new MenuCorePage(page);
                loginSteps = new LoginCorePage(page);
        }

        @Test(priority = 1, description = "1276")
        @Override
        public void listContentSuccessSearchByIdWithValidKeyword() {
                navigateToListBankContent();
                verifyStep(listBankContentSteps.searchBankContent(listBankContentModel.searchByValidId()),
                                "Successfully search bank content by valid id keyword",
                                "Failed search bank content by valid id keyword");
        }

        @Test(priority = 2, description = "1277")
        @Override
        public void listContentFailedSearchByIdWithInvalidKeyword() {
                navigateToListBankContent();
                verifyStep(listBankContentSteps.searchBankContent(listBankContentModel.searchByInvalidId()),
                                "Successfully search bank content by valid id keyword",
                                "Failed search bank content by valid id keyword");
        }

        @Test(priority = 3, description = "1278")
        @Override
        public void listContentSuccessSearchByNamaKontenWithValidKeyword() {
                navigateToListBankContent();
                verifyStep(listBankContentSteps.searchBankContent(listBankContentModel.searchByValidName()),
                                "Successfully search bank content by valid id keyword",
                                "Failed search bank content by valid id keyword");
        }

        @Test(priority = 4, description = "1279")
        @Override
        public void listContentFailedSearchByNamaKontenWithInvalidKeyword() {
                navigateToListBankContent();
                verifyStep(listBankContentSteps.searchBankContent(listBankContentModel.searchByInvalidName()),
                                "Successfully search bank content by valid id keyword",
                                "Failed search bank content by valid id keyword");
        }

        @Test(priority = 5, description = "1287")
        @Override
        public void listContentSuccessFilterByOrganisasiOnListContentTable() {
                navigateToListBankContent();
                verifyStep(listBankContentSteps.filterByChips(listBankContentModel.filterByOrganization()),
                                "Successfully filter bank content by organization",
                                "Failed filter bank content by organization");
        }

        @Test(priority = 6, description = "1288")
        @Override
        public void listContentSuccessFilterByKontenBelajarOnListContentTable() {
                navigateToListBankContent();
                verifyStep(listBankContentSteps.filterByChips(listBankContentModel.filterByContentLearning()),
                                "Successfully filter bank content by organization",
                                "Failed filter bank content by organization");
        }

        @Test(priority = 7, description = "1293")
        @Override
        public void listContentSuccessFilterByStatus() {
                navigateToListBankContent();
                verifyStep(listBankContentSteps.advancedFilter(listBankContentModel.filterByStatus()),
                                "Successfully filter bank content by status", "Failed filter bank content by status");
        }

        @Test(priority = 8, description = "depend = 1609, 1617")
        @Override
        public void detailContentVerifyThatTheDetailPageDisplaysTheCorrectData() {
                navigateToListBankContent();
                verifyStep(listBankContentSteps.goToDetailBankContentLearning(),
                                "Successfully navigate to detail bank content page",
                                "Failed navigate to detail bank content page");
        }

        @Test(priority = 9, description = "1610")
        @Override
        public void detailContentSuccessOpenTheFileWhenUserClickButtonLihatInFileField() {
                navigateToListBankContent();
                verifyStep(listBankContentSteps.searchBankContent(listBankContentModel.searchByValidId()),
                                "Successfully search bank content by valid id keyword",
                                "Failed search bank content by valid id keyword");
                verifyStep(listBankContentSteps.goToDetailBankContentLearning(),
                                "Successfully navigate to detail bank content page",
                                "Failed navigate to detail bank content page");
                verifyStep(listBankContentSteps.viewFileBankContentLearning(),
                                "Successfully open the file when user click button lihat in file field",
                                "Failed open the file when user click button lihat in file field");
        }

        private void navigateToListBankContent() {
                loginSteps.injectLoginCoreCookies();
                verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_STUDY_CONTENT),
                                "Successfully navigate to Bank Content menu", "Failed navigate to Bank Content menu");
        }
}
