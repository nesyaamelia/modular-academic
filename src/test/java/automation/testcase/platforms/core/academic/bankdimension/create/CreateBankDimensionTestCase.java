package mu.core.id.website.testcase.platforms.core.academic.bankdimension.create;

public interface CreateBankDimensionTestCase {
    void tambahDimensionSuccessfullyCreateDimensionWithValidData();
    void tambahDimensionSuccessfullyCreateDimensionWithChangeDefaultValueOfOrganisasiPenyediaDimensionField();
    void tambahDimensionSuccessfullyCreateDimensionWithMaximumLengthInputs();
    void tambahDimensionSuccessfullyCreateDimensionWhenDataAsExistingInTheDifferentOraganization();
    void tambahDimensionSuccessfullySelectMultipleElementWhenCreateDimension();
    void tambahDimensionFailedToCreateDimensionWhenMandatoryFieldIsEmpty();
    void tambahDimensionFailedToCreateDimensionWhenInputFieldExceedsTheMaximumCharacterLimit();
    void tambahDimensionFailedToCreateDimensionWhenDataAsExistingInTheSameOraganization();
    void tambahDimensionFailedToCreateDimensionWhenFieldContainCharacterNotAllowed();
    void tambahDimensionFailedToAdd_1ElementWithTheSameName();
    void tambahDimensionFailedToAddMoreThan_1ElementWithTheSameName();
}