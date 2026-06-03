package mu.core.id.website.testcase.platforms.core.academic.banktypeactivity.create;

public interface CreateBankTypeActivityTestCase {
    void addTypeOfActivitySuccessfullyAddTypeOfActivity();
    void addTypeOfActivityFailedAddTypeOfActivityWhenUserDoesnTFillAllField();
    void addTypeOfActivityFailedAddTypeOfActivityWhenUserInputNamaJenisAktivitasMoreThan_200Characters();
    void addTypeOfActivitySuccessfullyAddTypeOfActivityWithStatusJenisAktivitasIsInactive();
    void addTypeOfActivityFailedAddTypeActivityWhenNamaJenisAktivitasIsEmpty();
    void addTypeOfActivityFailedAddTypeActivityWhenKategoriJenisAktivitasIsEmpty();
    void addTypeOfActivityFailedAddTypeActivityWhenKontenBelajarIsEmpty();
    void addTypeOfActivityUserRedirectToLandingPageOrPreviousPageWhenClickButtonTinggalkanHalamanOnPopup();
    void addTypeOfActivityUserRemainsOnTheCurrentPageWhenClickButtonTetapDiHalamanOnPopup();
}
