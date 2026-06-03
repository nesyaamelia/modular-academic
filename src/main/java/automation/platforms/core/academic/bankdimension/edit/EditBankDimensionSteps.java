package automation.platforms.core.academic.bankdimension.edit;

import automation.platforms.base.BaseSteps;

public interface EditBankDimensionSteps extends BaseSteps {
    boolean navigateToPageEditBankDimension(EditBankDimensionModel data);

    boolean fillNameBankDimension(EditBankDimensionModel name);

    boolean fillCodeBankDimension(EditBankDimensionModel code);

    boolean fillDescriptionBankDimension(EditBankDimensionModel code);

    boolean toggleStatusRelation();

    boolean toggleStatusBankDimension();

    boolean saveBankDimension();
}
