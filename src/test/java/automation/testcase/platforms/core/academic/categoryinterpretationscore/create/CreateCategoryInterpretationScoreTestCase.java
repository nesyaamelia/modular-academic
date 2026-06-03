package mu.core.id.website.testcase.platforms.core.academic.categoryinterpretationscore.create;

public interface CreateCategoryInterpretationScoreTestCase {
  void successfullyCreateCategoryInterpretationGuidanceWithValidData();
  void failedCreateCategoryInterpretationGuidanceWithInvalidData();
  void successfullyCreateCategoryInterpretationGuidanceDuplicareDifferentOrg();
  void successfullyRedirectBackUsingBatalkanBreadcrumbSidebar();
  void buttonAddCategoryDisabledAfterCertainCondition();
  void failedAddCategoryWhenMaxScoreIsSameScore();
}
