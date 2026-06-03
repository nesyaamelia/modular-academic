package automation.platforms.core.academic.categoryinterpretationscore.edit;

import automation.platforms.base.BaseSteps;

public interface EditCategoryInterpretationScoreSteps extends BaseSteps {
  boolean invalidCase(EditCategoryInterpretationScoreModel name);
  boolean saveCategoryInterpretationScoreFailed();
  boolean navigateToPageKategoriInterpretasiNilai();
  boolean successfullyEdit(EditCategoryInterpretationScoreModel name);
  boolean saveCategoryInterpretationScore();
  boolean redirectBackFromBreadcrumb();
  boolean redirectBackFromSideMenu();
  boolean redirectBackFromButtonBatalkan();
  boolean addCategoryTenTimesThenVerifyDisabled();
  boolean fillMaxValueThenAddCategoryAndFillSame(EditCategoryInterpretationScoreModel name);
  boolean activeAndNonActiveStatus(EditCategoryInterpretationScoreModel value1, EditCategoryInterpretationScoreModel value2);
  void directUrlToClient();
}
