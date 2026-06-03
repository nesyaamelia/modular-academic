package automation.platforms.core.academic.categoryinterpretationscore.list;

import automation.platforms.base.BaseSteps;

public interface ListCategoryInterpretationScoreSteps extends BaseSteps {
  boolean fillSearchBarInput(ListCategoryInterpretationScoreModel listCategoryInterpretationScoreModel);
  boolean useFilterOrganization();
  boolean useFilterStatus();
  boolean redirectFromList();
  boolean redirectFromSlugLink();
  void directUrlToClient();
}
