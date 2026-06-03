package automation.platforms.core.academic.bankelement.edit;

import automation.platforms.base.BaseSteps;

public interface EditBankElementSteps extends BaseSteps {
    boolean navigateToPageEditBankElement(EditBankElementModel data);

    boolean fillNameBankElement(String name);

    boolean fillCodeBankElement(String code);

    boolean fillDescriptionBankElement(EditBankElementModel data);

    boolean saveEditBankElement();

    boolean clearAllField();

    boolean toggleStatusBankElement();
}
