package mu.core.id.website.testcase.platforms.core.academic.banktypeactivity.list;

public interface ListBankTypeActivityTestCase {
    void listTypeOfActivitySuccessSearchByIdWithValidKeyword();
    void listTypeOfActivityFailedSearchByIdWithInvalidKeyword();
    void listTypeOfActivitySuccessSearchByNamaJenisAktivitasWithValidKeyword();
    void listTypeOfActivityFailedSearchByNamaJenisAktivitasWithInvalidKeyword();
    void listTypeOfActivitySuccessFilterByKontenBelajarOnListTypeOfActivityTable();
    void listTypeOfActivitySuccessFilterByOrganisasiOnListTypeOfActivityTable();
    void listTypeOfActivitySuccessFilterByKategoriAktivitas();
    void listTypeOfActivitySuccessFilterByStatus();
    void listTypeOfActivitySuccessSearchOnModalFilterOrganisasiWithValidKeyword();
    void listTypeOfActivitySuccessSearchOnModalFilterKontenBelajarWithValidKeyword();
    void detailTypeOfActivityVerifyThatTheDetailPageDisplaysTheCorrectData();
}