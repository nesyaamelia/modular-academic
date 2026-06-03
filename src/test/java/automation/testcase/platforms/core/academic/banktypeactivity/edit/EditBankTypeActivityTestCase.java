package mu.core.id.website.testcase.platforms.core.academic.banktypeactivity.edit;

public interface EditBankTypeActivityTestCase {
    void editTypeOfActivitySuccessfullyEditTypeOfActivity();
    void editTypeOfActivityFailedEditTypeOfActivityWhenUserDoesnTFillAllField();
    void editTypeOfActivityFailedEditTypeOfActivityWhenUserInputNamaJenisAktivitasMoreThan_150Characters();
    void editTypeOfActivityFailedEditTypeActivityWhenNamaJenisAktivitasIsEmpty();
}
