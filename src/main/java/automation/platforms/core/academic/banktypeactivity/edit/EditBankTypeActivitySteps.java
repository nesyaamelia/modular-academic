package automation.platforms.core.academic.banktypeactivity.edit;

import automation.platforms.base.BaseSteps;

public interface EditBankTypeActivitySteps extends BaseSteps {

    boolean navigateToPageEditBankTypeActivity(EditBankTypeActivityModel data);

    boolean fillNameBankTypeActivity(EditBankTypeActivityModel name);

    boolean fillCategoryBankTypeActivity(EditBankTypeActivityModel category);

    boolean fillContentLearningBankTypeActivity(EditBankTypeActivityModel contentLearning);

    boolean toggleStatusBankTypeActivity();

    boolean saveEditBankTypeActivity();

    boolean clearAllField();

    void directUrlToClient();
}
