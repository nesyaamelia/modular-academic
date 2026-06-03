package mu.core.id.website.testcase.platforms.core.academic.categoryinterpretationscore.edit;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import automation.platforms.core.academic.sidemenu.MenuCoreOptions;
import automation.platforms.core.academic.sidemenu.MenuCorePage;
import automation.platforms.core.academic.sidemenu.MenuCoreSteps;
import automation.platforms.core.academic.categoryinterpretationscore.edit.EditCategoryInterpretationScoreModel;
import automation.platforms.core.academic.categoryinterpretationscore.edit.EditCategoryInterpretationScorePage;
import automation.platforms.core.academic.categoryinterpretationscore.edit.EditCategoryInterpretationScoreSteps;
import automation.platforms.core.user.login.LoginCorePage;
import automation.platforms.core.user.login.LoginCoreSteps;
import mu.core.id.website.testcase.platforms.core.BaseCoreDriverTest;
import org.testng.annotations.Test;
import static automation.utils.StepLogger.verifyStep;

@Epic("Platform Core")
@Feature("Academic - Edit Category Interpretation Score")
public class EditCategoryInterpretationScoreTest extends BaseCoreDriverTest
    implements EditCategoryInterpretationScoreTestCase {
  private EditCategoryInterpretationScoreSteps editCategoryInterpretationScoreSteps;
  private EditCategoryInterpretationScoreModel editCategoryInterpretationScoreModel;
  private LoginCoreSteps loginCoreSteps;
  private MenuCoreSteps menuCoreSteps;

  @Override
  public void initInstance() {
    super.initInstance();
    editCategoryInterpretationScoreSteps = new EditCategoryInterpretationScorePage(page);
    editCategoryInterpretationScoreModel = new EditCategoryInterpretationScoreModel();
    loginCoreSteps = new LoginCorePage(page);
    menuCoreSteps = new MenuCorePage(page);
  }

  @Test(priority = 1, description = "depend = 4098, 4099, 4102, 4103")
  @Override
  public void successfullyEdit() {
    loginCoreSteps.injectLoginCoreCookies();
    verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.CATEGORY_INTERPRETATION_SCORE),
        "Successfully navigate to Category Interpretation Guidance menu",
        "Failed navigate to Category Interpretation Guidance menu");
    verifyStep(editCategoryInterpretationScoreSteps.successfullyEdit(editCategoryInterpretationScoreModel),
        "Successfully edit Category Interpretation Guidance", "Failed edit Category Interpretation Guidance");
  }

  @Test(priority = 2, description = "depend = 4094, 4095, 4096, 4097, 4106, 4109, 4110, 4120")
  @Override
  public void failedEditCategoryInterpretationGuidanceWithInvalidData() {
    navigateToPageCategoryInterpretationScore();
    verifyStep(
        editCategoryInterpretationScoreSteps.invalidCase(editCategoryInterpretationScoreModel),
        "Invalid cases correctly blocked",
        "Invalid cases were not blocked as expected");
  }

  @Test(priority = 3, description = "depend = 4100, 4104")
  @Override
  public void successfullyRedirectToListPage() {
    navigateToPageCategoryInterpretationScore();
    verifyStep(editCategoryInterpretationScoreSteps.redirectBackFromBreadcrumb(),
        "Successfully redirect back from breadcrumb", "Failed redirect back from breadcrumb");
    verifyStep(editCategoryInterpretationScoreSteps.redirectBackFromSideMenu(),
        "Successfully redirect back from Side menu", "Failed redirect back from Side menu");
    verifyStep(editCategoryInterpretationScoreSteps.redirectBackFromButtonBatalkan(),
        "Successfully redirect back from button batalkan", "Failed redirect back from button batalkan");
  }

  @Test(priority = 4, description = "depend = 4101")
  @Override
  public void buttonAddCategoryDisabledAfterCertainCondition() {
    navigateToPageCategoryInterpretationScore();
    verifyStep(editCategoryInterpretationScoreSteps.addCategoryTenTimesThenVerifyDisabled(),
        "Button is successfully disabled", "Failed to disable button");
  }

  @Test(priority = 5, description = "depend = 4111")
  @Override
  public void failedEditCategoryWhenMaxScoreIsSameScore() {
    loginCoreSteps.injectLoginCoreCookies();
    verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.CATEGORY_INTERPRETATION_SCORE),
        "Successfully navigate to Category Interpretation Guidance menu",
        "Failed navigate to Category Interpretation Guidance menu");
    verifyStep(
        editCategoryInterpretationScoreSteps
            .fillMaxValueThenAddCategoryAndFillSame(editCategoryInterpretationScoreModel.validValueCategory()),
        "Successfully catch error when user add same max score", "Failed catch error when user add same max score");
  }

  @Test(priority = 6, description = "depend = 4112, 4114, 4115")
  @Override
  public void activeNonActiveStatus() {
    loginCoreSteps.injectLoginCoreCookies();
    verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.CATEGORY_INTERPRETATION_SCORE),
        "Successfully navigate to Category Interpretation Guidance menu",
        "Failed navigate to Category Interpretation Guidance menu");
    verifyStep(
        editCategoryInterpretationScoreSteps.activeAndNonActiveStatus(
            editCategoryInterpretationScoreModel.validValueCategory(),
            editCategoryInterpretationScoreModel.validMaxValueCategory()),
        "Successfully switch button", "Failed switch button");
  }

  private void navigateToPageCategoryInterpretationScore() {
    loginCoreSteps.injectLoginCoreCookies();
    verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.CATEGORY_INTERPRETATION_SCORE),
        "Successfully navigate to Category Interpretation Guidance menu",
        "Failed navigate to Category Interpretation Guidance menu");
    verifyStep(editCategoryInterpretationScoreSteps.navigateToPageKategoriInterpretasiNilai(),
        "Successfully navigate to Category Interpretation Guidance page",
        "Failed navigate to Category Interpretation Guidance page");
  }
}
