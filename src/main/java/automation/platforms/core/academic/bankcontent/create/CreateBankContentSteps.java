package automation.platforms.core.academic.bankcontent.create;

import automation.platforms.base.BaseSteps;

public interface CreateBankContentSteps extends BaseSteps {
    boolean navigateToPageBankContent();

    boolean fillNameBankContent(CreateBankContentModel name);

    boolean fillContentLearning(CreateBankContentModel contentLearning);

    boolean uploadFile(String file);

    boolean fillLinkVirtual(String link);

    boolean fillLearningInstruction(CreateBankContentModel description);

    boolean addBehavioralObjective();

    boolean toggleStatus();

    boolean saveBankContentLearning();

    boolean fillOrganization(CreateBankContentModel organization);

    void directUrlToClient();
}
