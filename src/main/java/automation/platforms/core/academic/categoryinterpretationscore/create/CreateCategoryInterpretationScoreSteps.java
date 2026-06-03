package automation.platforms.core.academic.categoryinterpretationscore.create;

import automation.platforms.base.BaseSteps;

public interface CreateCategoryInterpretationScoreSteps extends BaseSteps {
    boolean navigateToPageKategoriInterpretasiNilai();
    boolean fillNameInterpretationGuidance(CreateCategoryInterpretationScoreModel name);
    boolean fillNameCategory(CreateCategoryInterpretationScoreModel name);
    boolean fillMaxValueCategory(CreateCategoryInterpretationScoreModel name);
    boolean saveCategoryInterpretationScore();
    boolean invalidCase(CreateCategoryInterpretationScoreModel name);
    boolean duplicateNameCase(CreateCategoryInterpretationScoreModel name);
    boolean duplicateNameInDifferentOrganizationCase(CreateCategoryInterpretationScoreModel name);
    boolean redirectBackFromBreadcrumb();
    boolean redirectBackFromSideMenu();
    boolean redirectBackFromButtonBatalkan();
    boolean addCategoryTenTimesThenVerifyDisabled();
    boolean fillMaxValueThenAddCategoryAndFillSame(CreateCategoryInterpretationScoreModel name);
    void directUrlToClient();
}
