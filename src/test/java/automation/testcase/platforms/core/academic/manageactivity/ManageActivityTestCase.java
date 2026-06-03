package mu.core.id.website.testcase.platforms.core.academic.manageactivity;

public interface ManageActivityTestCase {
    void kelolaAktivitasSuccessfullySearchActivityByValidId();
    void kelolaAktivitasNoResultInTableWhenIdNotFound();
    void kelolaAktivitasSuccessfullySearchActivityByActivityName();
    void kelolaAktivitasNoResultInTableWhenTheActivityNameDoesNotMatch();
    void kelolaAktivitasSuccessfullyFilterByStatus();
    void kelolaAktivitasSuccessfullyFilterByKontenAktivitas();
    void kelolaAktivitasSuccessfullyFilterByOrganisasiPenyedia();
    void kelolaAktivitasSuccessfullyFiltersAndSearchesActivityWithValidInputCombinations();
}
