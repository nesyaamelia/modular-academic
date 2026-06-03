package automation.platforms.core.academic.bankdimension.create;

import automation.platforms.base.BaseSteps;

public interface CreateBankDimensionSteps extends BaseSteps {
    boolean navigateToPageBankDimension();

    boolean fillNameBankDimension(String name);

    boolean fillCodeBankDimension(String code);

    boolean fillDescriptionBankDimension(CreateBankDimensionModel code);

    boolean fillOrganizationDimension(CreateBankDimensionModel data);

    boolean selectElement();

    boolean searchAndSelectMultipleElement(CreateBankDimensionModel data);

    boolean saveBankDimension();
}
