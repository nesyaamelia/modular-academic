package mu.core.id.website.testcase.platforms.core.academic.bankbehavioralobjective;

public interface BankBehavioralObjectiveTestCase {
    void bankBehavioralObjectiveSuccessfullySearchBehavioralObjectiveByValidId();
    void bankBehavioralObjectiveSuccessfullySearchBehavioralObjectiveByNameMoreThan_3Character();
    void bankBehavioralObjectiveSuccessfullyFilterByStatus();
    void bankBehavioralObjectiveSuccessfullyFilterByTahapPerkembangan();
    void tambahBehavioralObjectiveSuccessfullyCreateBehavioralObjectiveWithValidData();
    void tambahBehavioralObjectiveSuccessfullyCreateBehavioralObjectiveWithMaximumLengthInputs();
    void tambahBehavioralObjectiveFailedToAddMultipleElementsAndAtLeastOneHasDuplicateRelations();
    void tambahBehavioralObjectiveFailedToAddElementWithUpdatedDataWhenAllElementRelationsHaveBeenAdded();
    void tambahBehavioralObjectiveFailedToSearchElementWhenDataNotFound();
    void tambahBehavioralObjectiveFailedToCreateBehavioralObjectiveWhenMandatoryFieldIsEmpty();
    void tambahBehavioralObjectiveSuccessfullyAddMultipleElementAndAppearsInTable();
    void ubahBehavioralObjectiveSuccessfullyEditAnExistingBehavioralObjectiveWithValidInputs();
    void ubahBehavioralObjectiveFailedToEditAnExistingBehavioralObjectiveWhenMandatoryFieldIsEmpty();
    void detailBehavioralObjectiveSuccessfullyOpenDetailBehavioralObjective();
}
