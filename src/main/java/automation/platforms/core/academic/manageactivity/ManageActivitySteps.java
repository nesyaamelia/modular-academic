package automation.platforms.core.academic.manageactivity;

import automation.platforms.base.BaseSteps;

public interface ManageActivitySteps extends BaseSteps {
    boolean searchManageActivity(ManageActivityModel data);

    boolean filterByChips(ManageActivityModel data);

    boolean advancedFilter(ManageActivityModel data);
}
