package mu.core.id.website.testcase.platforms.core.academic.categoryinterpretationscore.create;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import automation.platforms.core.academic.sidemenu.MenuCoreOptions;
import automation.platforms.core.academic.sidemenu.MenuCorePage;
import automation.platforms.core.academic.sidemenu.MenuCoreSteps;
import automation.platforms.core.academic.categoryinterpretationscore.create.CreateCategoryInterpretationScoreModel;
import automation.platforms.core.academic.categoryinterpretationscore.create.CreateCategoryInterpretationScorePage;
import automation.platforms.core.academic.categoryinterpretationscore.create.CreateCategoryInterpretationScoreSteps;
import automation.platforms.core.user.login.LoginCorePage;
import automation.platforms.core.user.login.LoginCoreSteps;
import mu.core.id.website.testcase.platforms.core.BaseCoreDriverTest;
import org.testng.annotations.Test;
import static automation.utils.StepLogger.verifyStep;

@Epic("Platform Core")
@Feature("Academic - Create Bank Category Interpretation Score")
public class CreateCategoryInterpretationScoreTest extends BaseCoreDriverTest
                implements CreateCategoryInterpretationScoreTestCase {
        private CreateCategoryInterpretationScoreSteps createCategoryInterpretationScoreSteps;
        private CreateCategoryInterpretationScoreModel createCategoryInterpretationScoreModel;
        private LoginCoreSteps loginCoreSteps;
        private MenuCoreSteps menuCoreSteps;

        @Override
        public void initInstance() {
                super.initInstance();
                createCategoryInterpretationScoreSteps = new CreateCategoryInterpretationScorePage(page);
                createCategoryInterpretationScoreModel = new CreateCategoryInterpretationScoreModel();
                loginCoreSteps = new LoginCorePage(page);
                menuCoreSteps = new MenuCorePage(page);
        }

        @Test(priority = 1, description = "depend = 4074, 4080. 4083, 4084")
        @Override
        public void successfullyCreateCategoryInterpretationGuidanceWithValidData() {
                navigateToPageCategoryInterpretationScore();
                verifyStep(createCategoryInterpretationScoreSteps.fillNameInterpretationGuidance(
                                createCategoryInterpretationScoreModel.validNameInterpretationGuidance()),
                                "Successfully fill name interpretation guidance",
                                "Failed fill name interpretation guidance");
                verifyStep(createCategoryInterpretationScoreSteps
                                .fillNameCategory(createCategoryInterpretationScoreModel.validNameCategory()),
                                "Successfully fill name category", "Failed fill name category");
                verifyStep(createCategoryInterpretationScoreSteps
                                .fillMaxValueCategory(createCategoryInterpretationScoreModel.validMaxValueCategory()),
                                "Successfully fill max value category", "Failed fill max value category");
                verifyStep(createCategoryInterpretationScoreSteps.saveCategoryInterpretationScore(),
                                "Successfully save kategori interpretasi nilai",
                                "Failed save kategori interpretasi nilai");
        }

        @Test(priority = 2, description = "depend = 4075, 4076, 4077, 4087, 4090, 4091")
        @Override
        public void failedCreateCategoryInterpretationGuidanceWithInvalidData() {
                navigateToPageCategoryInterpretationScore();
                verifyStep(createCategoryInterpretationScoreSteps.invalidCase(createCategoryInterpretationScoreModel),
                                "Invalid cases correctly blocked", "Invalid cases were not blocked as expected");
        }

        @Test(priority = 3, description = "depend =  4078, 4079")
        @Override
        public void successfullyCreateCategoryInterpretationGuidanceDuplicareDifferentOrg() {
                loginCoreSteps.injectLoginCoreCookies();
                verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.CATEGORY_INTERPRETATION_SCORE),
                                "Successfully navigate to Category Interpretation Guidance menu",
                                "Failed navigate to Category Interpretation Guidance menu");
                verifyStep(createCategoryInterpretationScoreSteps.duplicateNameInDifferentOrganizationCase(
                                createCategoryInterpretationScoreModel.duplicateNameInterpretationGuidance()),
                                "Successfully handle duplicate name on different organozation",
                                "Successfully handle duplicate name on different organozation");
                verifyStep(createCategoryInterpretationScoreSteps.duplicateNameCase(
                                createCategoryInterpretationScoreModel.duplicateNameInterpretationGuidance()),
                                "Successfully handle duplicate name on one organozation",
                                "Failed handle duplicate name on one organozation");
        }

        @Test(priority = 4, description = "depend = 4081")
        @Override
        public void successfullyRedirectBackUsingBatalkanBreadcrumbSidebar() {
                navigateToPageCategoryInterpretationScore();
                verifyStep(createCategoryInterpretationScoreSteps.redirectBackFromBreadcrumb(),
                                "Successfully redirect back from breadcrumb", "Failed redirect back from breadcrumb");
                verifyStep(createCategoryInterpretationScoreSteps.redirectBackFromSideMenu(),
                                "Successfully redirect back from Side menu", "Failed redirect back from Side menu");
                verifyStep(createCategoryInterpretationScoreSteps.redirectBackFromButtonBatalkan(),
                                "Successfully redirect back from button batalkan",
                                "Failed redirect back from button batalkan");
        }

        @Test(priority = 5, description = "depend = 4082")
        @Override
        public void buttonAddCategoryDisabledAfterCertainCondition() {
                navigateToPageCategoryInterpretationScore();
                verifyStep(createCategoryInterpretationScoreSteps.addCategoryTenTimesThenVerifyDisabled(),
                                "Button is successfully disabled", "Failed to disable button");
        }

        @Test(priority = 6, description = "depend = 4092")
        @Override
        public void failedAddCategoryWhenMaxScoreIsSameScore() {
                navigateToPageCategoryInterpretationScore();
                verifyStep(createCategoryInterpretationScoreSteps.fillMaxValueThenAddCategoryAndFillSame(
                                createCategoryInterpretationScoreModel.validValueCategory()),
                                "Successfully catch error when user add same max score",
                                "Failed catch error when user add same max score");
        }

        private void navigateToPageCategoryInterpretationScore() {
                loginCoreSteps.injectLoginCoreCookies();
                verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.CATEGORY_INTERPRETATION_SCORE),
                                "Successfully navigate to Category Interpretation Guidance menu",
                                "Failed navigate to Category Interpretation Guidance menu");
                verifyStep(createCategoryInterpretationScoreSteps.navigateToPageKategoriInterpretasiNilai(),
                                "Successfully navigate to Category Interpretation Guidance page",
                                "Failed navigate to Category Interpretation Guidance page");
        }
}
