package mu.core.id.website.testcase.platforms.core.academic.bankdimension.edit;

public interface EditBankDimensionTestCase {
    void ubahDimensionSuccessfullyEditAnExistingDimensionWithValidInputs();
    void ubahDimensionSuccessfullyEditAnExistingDimensionByChangingElementToInactive();
    void ubahDimensionSuccessfullyEditAnExistingDimensionToInactiveStatus();
    void ubahDimensionFailedToEditAnExistingDimensionWhenMandatoryFieldIsEmpty();
    void ubahDimensionFailedToEditAnExistingDimensionWhenFieldExceedsTheMaximumCharacterLimit();
    void ubahDimensionFailedToEditAnExistingDimensionWhenChangeDataAsExisting();
    void ubahDimensionFailedToEditAnExistingDimensionWhenFieldContainCharacterNotAllowed();
}
