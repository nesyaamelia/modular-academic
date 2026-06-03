package mu.core.id.website.testcase.platforms.core.academic.categoryinterpretationscore.list;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import automation.platforms.core.academic.sidemenu.MenuCoreOptions;
import automation.platforms.core.academic.sidemenu.MenuCorePage;
import automation.platforms.core.academic.sidemenu.MenuCoreSteps;
import automation.platforms.core.academic.categoryinterpretationscore.list.ListCategoryInterpretationScoreModel;
import automation.platforms.core.academic.categoryinterpretationscore.list.ListCategoryInterpretationScorePage;
import automation.platforms.core.academic.categoryinterpretationscore.list.ListCategoryInterpretationScoreSteps;
import automation.platforms.core.user.login.LoginCorePage;
import automation.platforms.core.user.login.LoginCoreSteps;
import mu.core.id.website.testcase.platforms.core.BaseCoreDriverTest;
import org.testng.annotations.Test;
import static automation.utils.StepLogger.verifyStep;

@Epic("Platform Core")
@Feature("Academic - List Bank Category Interpretation Score")
public class ListCategoryInterpretationScoreTest extends BaseCoreDriverTest
    implements ListCategoryInterpretationScoreTestCase {
  private ListCategoryInterpretationScoreSteps listCategoryInterpretationScoreSteps;
  private ListCategoryInterpretationScoreModel listCategoryInterpretationScoreModel;
  private LoginCoreSteps loginCoreSteps;
  private MenuCoreSteps menuCoreSteps;

  @Override
  public void initInstance() {
    super.initInstance();
    listCategoryInterpretationScoreSteps = new ListCategoryInterpretationScorePage(page);
    listCategoryInterpretationScoreModel = new ListCategoryInterpretationScoreModel();
    loginCoreSteps = new LoginCorePage(page);
    menuCoreSteps = new MenuCorePage(page);
  }

  @Test(priority = 1, description = "4063, 4064, 4066, 4067, 4069")
  @Override
  public void successfullyFilterAndSearch() {
    navigateToPageCategoryInterpretationScore();
    verifyStep(listCategoryInterpretationScoreSteps.useFilterOrganization(), "Successfully filter by organization",
        "Failed filter by organization");
    verifyStep(listCategoryInterpretationScoreSteps.useFilterStatus(), "Successfully filter by status",
        "Failed filter by status");
    verifyStep(
        listCategoryInterpretationScoreSteps.fillSearchBarInput(listCategoryInterpretationScoreModel.validSearch()),
        "Successfully search value", "Failed search value");
  }

  @Test(priority = 2, description = "4118, 4119")
  @Override
  public void successfullyRedirectToDetailPage() {
    navigateToPageCategoryInterpretationScore();
    verifyStep(listCategoryInterpretationScoreSteps.redirectFromList(), "Successfully redirect to detail page",
        "Failed redirect to detail page");
    verifyStep(listCategoryInterpretationScoreSteps.redirectFromSlugLink(),
        "Successfully redirect to detail page from slug link", "Failed redirect to detail page from slug link");
  }

  private void navigateToPageCategoryInterpretationScore() {
    loginCoreSteps.injectLoginCoreCookies();
    verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.CATEGORY_INTERPRETATION_SCORE),
        "Successfully navigate to Category Interpretation Guidance menu",
        "Failed navigate to Category Interpretation Guidance menu");
  }

}
