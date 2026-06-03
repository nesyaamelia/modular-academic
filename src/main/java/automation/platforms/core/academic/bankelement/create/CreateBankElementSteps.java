package automation.platforms.core.academic.bankelement.create;

import automation.platforms.base.BaseSteps;

public interface CreateBankElementSteps extends BaseSteps {
    boolean navigateToPageBankElement();

    boolean fillNameBankElement(String name);

    boolean fillCodeBankElement(String code);

    boolean fillDescriptionBankElement(CreateBankElementModel code);

    boolean selectCluster();

    boolean saveBankElement();

    boolean leavePageBankElement();
}
