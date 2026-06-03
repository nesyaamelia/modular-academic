package automation.platforms.core.academic.bankcontent.list;

import automation.platforms.base.BaseSteps;

public interface ListBankContentSteps extends BaseSteps {
    boolean searchBankContent(ListBankContentModel data);

    boolean filterByChips(ListBankContentModel data);

    boolean advancedFilter(ListBankContentModel data);

    boolean goToDetailBankContentLearning();

    boolean viewFileBankContentLearning();

    void directUrlToClient();
}
