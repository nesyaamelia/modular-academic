package automation.platforms.core.academic.bankdimension.list;

import automation.platforms.base.BaseSteps;

public interface ListBankDimensionSteps extends BaseSteps {
    boolean searchBankDimension(ListBankDimensionModel data);

    boolean filterByStatus(ListBankDimensionModel data);

    boolean goToDetailBankDimension();

    boolean goToEditDimension();
}
