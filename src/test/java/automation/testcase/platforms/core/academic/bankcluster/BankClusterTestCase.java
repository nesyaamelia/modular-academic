package mu.core.id.website.testcase.platforms.core.academic.bankcluster;

public interface BankClusterTestCase {
    void successfullyCreateClusterWithValidData();
    void successfullySearchClusterByNameMoreThan_3Character();
    void successfullySearchClusterByValidId();
    void successfullyFilterByStatusAktif();
    void successfullyFilterByStatusTidakAktif();
    void successfullyOpenDetailClusterPageWithCorrectSlug();
    void successfullyEditAnExistingClusterWithValidInputs();
    void failedToEditAnExistingClusterWhenMandatoryFieldIsEmpty();
    void failedToEditAnExistingClusterWhenFieldExceedsTheMaximumCharacterLimit();
    void failedToEditAnExistingClusterWhenFieldContainCharacterNotAllowed();
    void successfullyCreateClusterWithOptionalFieldIsEmpty();
    void successfullyCreateClusterWithMaximumLengthInputs();
    void failedToCreateClusterWhenMandatoryFieldIsEmpty();
    void failedToCreateClusterWhenInputFieldExceedsTheMaximumCharacterLimit();
    void popUpTinggalkanHalamanAppearsIfTheUserHasInputAtLeast_1CharacterOnTambahClusterPage();
    void returnToBankClusterPageWhenUserCancelCreateClusterAndClickTinggalkanHalamanButtonOnPopUp();
}
