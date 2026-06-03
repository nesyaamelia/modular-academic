package mu.core.id.website.testcase.platforms.core.academic.categoryinterpretationscore.edit;

public interface EditCategoryInterpretationScoreTestCase {
  void failedEditCategoryInterpretationGuidanceWithInvalidData();
  void successfullyEdit();
  void successfullyRedirectToListPage();
  void buttonAddCategoryDisabledAfterCertainCondition();
  void failedEditCategoryWhenMaxScoreIsSameScore();
  void activeNonActiveStatus();
}