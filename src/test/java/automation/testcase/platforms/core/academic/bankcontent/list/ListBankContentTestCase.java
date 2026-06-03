package mu.core.id.website.testcase.platforms.core.academic.bankcontent.list;

public interface ListBankContentTestCase {
    void listContentSuccessSearchByIdWithValidKeyword();
    void listContentFailedSearchByIdWithInvalidKeyword();
    void listContentSuccessSearchByNamaKontenWithValidKeyword();
    void listContentFailedSearchByNamaKontenWithInvalidKeyword();
    void listContentSuccessFilterByOrganisasiOnListContentTable();
    void listContentSuccessFilterByKontenBelajarOnListContentTable();
    void listContentSuccessFilterByStatus();
    void detailContentVerifyThatTheDetailPageDisplaysTheCorrectData();
    void detailContentSuccessOpenTheFileWhenUserClickButtonLihatInFileField();
}