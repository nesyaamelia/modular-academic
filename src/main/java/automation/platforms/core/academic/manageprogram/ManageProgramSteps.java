package automation.platforms.core.academic.manageprogram;

import automation.platforms.base.BaseSteps;

public interface ManageProgramSteps extends BaseSteps {
    boolean searchManageProgram(ManageProgramModel data);

    boolean filterByChips(ManageProgramModel data);
}
