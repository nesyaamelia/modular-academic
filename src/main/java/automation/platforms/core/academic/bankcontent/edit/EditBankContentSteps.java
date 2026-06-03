package automation.platforms.core.academic.bankcontent.edit;

import automation.platforms.base.BaseSteps;

public interface EditBankContentSteps extends BaseSteps {
    boolean navigateToPageEditBankContent(EditBankContentModel data);

    boolean fillNameBankContent(EditBankContentModel name);

    boolean fillLearningInstruction(EditBankContentModel description);

    boolean uploadFile(String file);

    boolean toggleStatusBankContent();

    boolean saveBankContent();

    void directUrlToClient();
}
