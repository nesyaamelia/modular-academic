package automation.platforms.core.academic.banktypeactivity.create;

import automation.platforms.base.BaseSteps;

public interface CreateBankTypeActivitySteps extends BaseSteps {
    boolean navigateToPageBankTypeActivity();

    boolean fillNameBankTypeActivity(CreateBankTypeActivityModel name);

    boolean fillCategoryBankTypeActivity(CreateBankTypeActivityModel category);

    boolean fillContentLearningBankTypeActivity(CreateBankTypeActivityModel contentLearning);

    boolean toggleStatusBankTypeActivity();

    boolean saveBankTypeActivity();

    boolean leavePageBankTypeActivity();

    boolean stayOnPageBankTypeActivity();

    void directUrlToClient();
}
