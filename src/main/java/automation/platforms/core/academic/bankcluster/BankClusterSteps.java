package automation.platforms.core.academic.bankcluster;

public interface BankClusterSteps {
    boolean navigateToPageBankCluster();

    boolean fillNameBankCluster(BankClusterModel name);

    boolean fillCodeBankCluster(BankClusterModel code);

    boolean fillDescriptionBankCluster(BankClusterModel description);

    boolean selectFramework();

    boolean clickButtonAddFramework();

    boolean clickButtonSaveCluster();

    boolean searchBankCluster(BankClusterModel data);

    boolean filterByActiveStatus();

    boolean filterByInactiveStatus();

    boolean clickButtonResetFilter();

    boolean clickButtonDetail();

    boolean clickButtonEdit();

    boolean toggleStatusCluster();

    boolean toggleStatusRelationFramework();

    boolean saveEditCluster();

    boolean saveClusterExpectingError();

    boolean leavingPageWithoutSaving();

    boolean stayOnThePage();
}
