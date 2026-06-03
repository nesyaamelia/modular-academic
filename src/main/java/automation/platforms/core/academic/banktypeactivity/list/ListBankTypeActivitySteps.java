package automation.platforms.core.academic.banktypeactivity.list;

import automation.platforms.base.BaseSteps;

public interface ListBankTypeActivitySteps extends BaseSteps {
    boolean searchActivityType(ListBankTypeActivityModel data);
    boolean filterByChips(ListBankTypeActivityModel data);
    boolean advancedFilter(ListBankTypeActivityModel data);

    boolean detailActivityType();

    void directUrlToClient();
}
