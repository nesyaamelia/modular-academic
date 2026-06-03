package automation.platforms.core.academic.bankelement.list;

import automation.platforms.base.BaseSteps;

public interface ListBankElementSteps extends BaseSteps {
    boolean searchAndFilterBankElement(ListBankElementModel data);

    boolean goToDetailBankElement();

    boolean goToEditElement();
}
