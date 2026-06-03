package mu.core.id.website.testcase.platforms.core.academic.manageactivity.create;

import automation.platforms.core.academic.manageactivity.create.CreateManageActivityModel;
import automation.platforms.core.academic.manageactivity.create.CreateManageActivityPage;
import automation.platforms.core.academic.manageactivity.create.CreateManageActivitySteps;
import automation.platforms.core.academic.sidemenu.MenuCoreOptions;
import automation.platforms.core.academic.sidemenu.MenuCorePage;
import automation.platforms.core.academic.sidemenu.MenuCoreSteps;
import automation.platforms.core.user.login.LoginCorePage;
import automation.platforms.core.user.login.LoginCoreSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mu.core.id.website.testcase.platforms.core.BaseCoreDriverTest;
import org.testng.annotations.Test;

import static automation.utils.StepLogger.verifyStep;

@Epic("Platform Core")
@Feature("Academic - Create Manage Activity Package")
public class CreateManageActivityTest extends BaseCoreDriverTest implements CreateManageActivityTestCase {
        private CreateManageActivitySteps createManageActivitySteps;
        private CreateManageActivityModel createManageActivityModel;
        private MenuCoreSteps menuCoreSteps;
        private LoginCoreSteps loginSteps;

        @Override
        public void initInstance() {
                super.initInstance();
                createManageActivitySteps = new CreateManageActivityPage(page);
                createManageActivityModel = new CreateManageActivityModel();
                menuCoreSteps = new MenuCorePage(page);
                loginSteps = new LoginCorePage(page);
        }

        @Test(priority = 1, description = "depend = 16253, 16276, 16280")
        @Override
        public void createStep_1_1AktivitasDasarSuccessfullyCreateActivityWithAppropriateContent() {
                navigateToManageActivity();
                verifyStep(createManageActivitySteps.tabBasicSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 1",
                                "Failed fill all required field in step 1");
        }

        @Test(priority = 2, description = "16277")
        @Override
        public void createStep_1_2AcademicFrameworkFailedToProceedToStep_2IfBehavioralObjectiveRelationHaveNotBeenSelected() {
                navigateToManageActivity();
                verifyStep(createManageActivitySteps.fillNameActivity(createManageActivityModel.validActivity()),
                                "Successfully fill name activity with valid data",
                                "Failed fill name activity with valid data");
                verifyStep(createManageActivitySteps.fillOrganization(createManageActivityModel.validActivity()),
                                "Successfully fill organization activity with valid data",
                                "Failed fill organization activity with valid data");
                verifyStep(createManageActivitySteps.fillPlatform(createManageActivityModel.validActivity()),
                                "Successfully fill platform activity with valid data",
                                "Failed fill platform activity with valid data");
                verifyStep(createManageActivitySteps.fillCategoryActivity(createManageActivityModel.validActivity()),
                                "Successfully fill category activity with valid data",
                                "Failed fill category activity with valid data");
                verifyStep(createManageActivitySteps.fillTypeActivity(createManageActivityModel.validActivity()),
                                "Successfully fill type activity with valid data",
                                "Failed fill type activity with valid data");
                verifyStep(createManageActivitySteps.fillContentActivity(createManageActivityModel.validActivity()),
                                "Successfully fill content activity with valid data",
                                "Failed fill content activity with valid data");
                verifyStep(createManageActivitySteps.fillDesignerActivity(createManageActivityModel.validActivity()),
                                "Successfully fill designer activity with valid data",
                                "Failed fill designer activity with valid data");
                verifyStep(createManageActivitySteps.fillFacilitatorActivity(createManageActivityModel.validActivity()),
                                "Successfully fill facilitator activity with valid data",
                                "Failed fill facilitator activity with valid data");
                boolean result = createManageActivitySteps.saveManageActivityStep1();
                verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
        }

        @Test(priority = 3, description = "14317")
        @Override
        public void tambahStep_2_2JadwalSuccessfullyCreatedStep_2ActivityWithJadwalToggleInactive() {
                navigateToManageActivity();
                verifyStep(createManageActivitySteps.tabBasicSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 1",
                                "Failed fill all required field in step 1");
                verifyStep(createManageActivitySteps.toggleActivityDsicussion(),
                                "Successfully toggle activity discussion", "Failed toggle activity discussion");
                verifyStep(createManageActivitySteps
                                .fillEstimatedActivityDuration(createManageActivityModel.validActivity()),
                                "Successfully fill estimated activity duration with valid data",
                                "Failed fill estimated activity duration with valid data");
                verifyStep(createManageActivitySteps.fillGroupsActivity(createManageActivityModel.validActivity()),
                                "Successfully fill groups activity with valid data",
                                "Failed fill groups activity with valid data");
                verifyStep(createManageActivitySteps.saveManageActivityStep2(),
                                "Successfully save step 2 activity with jadwal toggle inactive",
                                "Failed save step 2 activity with jadwal toggle inactive");
        }

        @Test(priority = 4, description = "14319")
        @Override
        public void tambahStep_2_2JadwalSuccessfullyCreatedStep_2ActivityWhenStartAndEndDateTimeAreTheSame() {
                navigateToManageActivity();
                verifyStep(createManageActivitySteps.tabBasicSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 1",
                                "Failed fill all required field in step 1");
                verifyStep(createManageActivitySteps.toggleActivityDsicussion(),
                                "Successfully toggle activity discussion", "Failed toggle activity discussion");
                verifyStep(createManageActivitySteps
                                .fillEstimatedActivityDuration(createManageActivityModel.validActivity()),
                                "Successfully fill estimated activity duration with valid data",
                                "Failed fill estimated activity duration with valid data");
                verifyStep(createManageActivitySteps.fillGroupsActivity(createManageActivityModel.validActivity()),
                                "Successfully fill groups activity with valid data",
                                "Failed fill groups activity with valid data");
                verifyStep(createManageActivitySteps
                                .fillScheduleActivity(createManageActivityModel.inputSameStartEndDateActivity()),
                                "Successfully fill schedule activity with jadwal toggle active and empty start end date fields",
                                "Failed fill schedule activity with jadwal toggle active and empty start end date fields");
                verifyStep(createManageActivitySteps.saveManageActivityStep2(),
                                "Successfully save step 2 activity with jadwal toggle inactive",
                                "Failed save step 2 activity with jadwal toggle inactive");
        }

        @Test(priority = 5, description = "14321")
        @Override
        public void tambahStep_2_2JadwalSuccessfullyCreatedStep_2ActivityWhenStartDateTimeIsEarlierThanEndDateTime() {
                navigateToManageActivity();
                verifyStep(createManageActivitySteps.tabBasicSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 1",
                                "Failed fill all required field in step 1");
                verifyStep(createManageActivitySteps.toggleActivityDsicussion(),
                                "Successfully toggle activity discussion", "Failed toggle activity discussion");
                verifyStep(createManageActivitySteps
                                .fillEstimatedActivityDuration(createManageActivityModel.validActivity()),
                                "Successfully fill estimated activity duration with valid data",
                                "Failed fill estimated activity duration with valid data");
                verifyStep(createManageActivitySteps.fillGroupsActivity(createManageActivityModel.validActivity()),
                                "Successfully fill groups activity with valid data",
                                "Failed fill groups activity with valid data");
                verifyStep(createManageActivitySteps
                                .fillScheduleActivity(createManageActivityModel.inputStartEndDateActivity()),
                                "Successfully fill schedule activity with jadwal toggle active and empty start end date fields",
                                "Failed fill schedule activity with jadwal toggle active and empty start end date fields");
                verifyStep(createManageActivitySteps.saveManageActivityStep2(),
                                "Successfully save step 2 activity with jadwal toggle inactive",
                                "Failed save step 2 activity with jadwal toggle inactive");
        }

        @Test(priority = 6, description = "19180")
        @Override
        public void createStep_2_2KuotaJadwalAktivitasKuotaTersediaFieldAppearsWhenUserSelectJenisKuotaAktivitasIsTerbatas() {
                navigateToManageActivity();
                verifyStep(createManageActivitySteps.tabBasicSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 1",
                                "Failed fill all required field in step 1");
                verifyStep(createManageActivitySteps.fillQuotaActivity(createManageActivityModel.validActivity()),
                                "Successfully fill quota activity fields", "Failed fill quota activity fields");
                verifyStep(createManageActivitySteps.saveManageActivityStep2(),
                                "Successfully save step 2 activity with kuota terbatas selected",
                                "Failed save step 2 activity with kuota terbatas selected");
        }

        @Test(priority = 7, description = "14564")
        @Override
        public void tambahStep_3PengaturanKontenSuccessfullyCreateStep_3ActivityWithKontenBelumTersedia() {
                navigateToManageActivity();
                verifyStep(createManageActivitySteps.tabBasicSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 1",
                                "Failed fill all required field in step 1");
                verifyStep(createManageActivitySteps.tabGeneralSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 2",
                                "Failed fill all required field in step 2");
                verifyStep(createManageActivitySteps.fillContent(createManageActivityModel.validActivity()),
                                "Successfully fill content activity with valid data",
                                "Failed fill content activity with valid data");
                verifyStep(createManageActivitySteps.saveManageActivityStep3(),
                                "Successfully save step 3 activity with konten belum tersedia",
                                "Failed save step 3 activity with konten belum tersedia");
        }

        @Test(priority = 8, description = "depend = 14565, 14618, 14619")
        @Override
        public void tambahStep_3PengaturanKontenSuccessfullyCreateStep_3ActivityWithKontenTersediaAmbilDariBankKonten() {
                navigateToManageActivity();
                verifyStep(createManageActivitySteps.tabBasicSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 1",
                                "Failed fill all required field in step 1");
                verifyStep(createManageActivitySteps.tabGeneralSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 2",
                                "Failed fill all required field in step 2");
                verifyStep(createManageActivitySteps.fillContent(createManageActivityModel.fillFromBankContent()),
                                "Successfully fill content activity fields", "Failed fill content activity fields");
                verifyStep(createManageActivitySteps.fillSourceContent(createManageActivityModel.fillFromBankContent()),
                                "Successfully fill source content activity with ambil dari bank konten option",
                                "Failed fill source content activity with ambil dari bank konten option");
                verifyStep(createManageActivitySteps.saveManageActivityStep3(),
                                "Successfully save step 3 activity with konten tersedia ambil dari bank konten",
                                "Failed save step 3 activity with konten tersedia ambil dari bank konten");
        }

        @Test(priority = 9, description = "depend = 14566, 14584")
        @Override
        public void tambahStep_3PengaturanKontenSuccessfullyCreateStep_3ActivityWithKontenTersediaBuatKontenBaru() {
                navigateToManageActivity();
                verifyStep(createManageActivitySteps.tabBasicSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 1",
                                "Failed fill all required field in step 1");
                verifyStep(createManageActivitySteps.tabGeneralSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 2",
                                "Failed fill all required field in step 2");
                verifyStep(createManageActivitySteps.fillContent(createManageActivityModel.fillNewContent()),
                                "Successfully fill content activity fields", "Failed fill content activity fields");
                verifyStep(createManageActivitySteps.fillSourceContent(createManageActivityModel.fillNewContent()),
                                "Successfully fill source content activity with ambil dari bank konten option",
                                "Failed fill source content activity with ambil dari bank konten option");
                verifyStep(createManageActivitySteps.saveManageActivityStep3(),
                                "Successfully save step 3 activity with konten tersedia buat konten baru",
                                "Failed save step 3 activity with konten tersedia buat konten baru");
        }

        @Test(priority = 10, description = "depend = 14585, 14586, 14587")
        @Override
        public void tambahStep_3PengaturanKontenFailedToSaveStep_3WithBankKontenWhenNoContentAndNoInstructionProvided() {
                navigateToManageActivity();
                verifyStep(createManageActivitySteps.tabBasicSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 1",
                                "Failed fill all required field in step 1");
                verifyStep(createManageActivitySteps.tabGeneralSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 2",
                                "Failed fill all required field in step 2");
                verifyStep(createManageActivitySteps.fillContent(createManageActivityModel.emptyInputContent()),
                                "Successfully fill content activity fields", "Failed fill content activity fields");
                verifyStep(createManageActivitySteps.fillSourceContent(createManageActivityModel.emptyInputContent()),
                                "Successfully fill source content activity with ambil dari bank konten option",
                                "Failed fill source content activity with ambil dari bank konten option");
                boolean result = createManageActivitySteps.saveManageActivityStep3();
                verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
        }

        @Test(priority = 11, description = "14588")
        @Override
        public void tambahStep_3PengaturanKontenFailedToSaveStep_3WithBankKontenWhenInstructionExceeds_3000Characters() {
                navigateToManageActivity();
                verifyStep(createManageActivitySteps.tabBasicSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 1",
                                "Failed fill all required field in step 1");
                verifyStep(createManageActivitySteps.tabGeneralSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 2",
                                "Failed fill all required field in step 2");
                verifyStep(createManageActivitySteps
                                .fillContent(createManageActivityModel.invalidInputInstructionContent()),
                                "Successfully fill content activity fields", "Failed fill content activity fields");
                verifyStep(createManageActivitySteps
                                .fillSourceContent(createManageActivityModel.invalidInputInstructionContent()),
                                "Successfully fill source content activity with ambil dari bank konten option",
                                "Failed fill source content activity with ambil dari bank konten option");
                boolean result = createManageActivitySteps.saveManageActivityStep3();
                verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
        }

        @Test(priority = 12, description = "depend = 12926, 12933, 12936")
        @Override
        public void createAktivitasPengaturanLaporanSuccessfullyFillAllFieldOnTabPengaturanLaporanSection_4_1Laporan() {
                navigateToManageActivity();
                verifyStep(createManageActivitySteps.tabBasicSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 1",
                                "Failed fill all required field in step 1");
                verifyStep(createManageActivitySteps.tabGeneralSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 2",
                                "Failed fill all required field in step 2");
                verifyStep(createManageActivitySteps.fillContent(createManageActivityModel.fillFromBankContent()),
                                "Successfully fill content activity fields", "Failed fill content activity fields");
                verifyStep(createManageActivitySteps.fillSourceContent(createManageActivityModel.fillFromBankContent()),
                                "Successfully fill source content activity with ambil dari bank konten option",
                                "Failed fill source content activity with ambil dari bank konten option");
                verifyStep(createManageActivitySteps.saveManageActivityStep3(),
                                "Successfully save step 3 activity with konten tersedia ambil dari bank konten",
                                "Failed save step 3 activity with konten tersedia ambil dari bank konten");
                verifyStep(createManageActivitySteps.fillReportActivity(createManageActivityModel.validReportSetting()),
                                "Successfully fill report activity fields", "Failed fill report activity fields");
                verifyStep(createManageActivitySteps
                                .fillCertificateActivity(createManageActivityModel.validReportSetting()),
                                "Successfully fill certificate activity fields",
                                "Failed fill certificate activity fields");
                verifyStep(createManageActivitySteps.saveManageActivityStep4(),
                                "Successfully save step 4 activity with all required field filled",
                                "Failed save step 4 activity with all required field filled");
        }

        @Test(priority = 13, description = "12938")
        @Override
        public void createAktivitasPengaturanLaporanFailedSaveTabPengaturanLaporanWhenUserDoesnTInputFasilitatorLaporanAktivitasField() {
                navigateToManageActivity();
                verifyStep(createManageActivitySteps.tabBasicSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 1",
                                "Failed fill all required field in step 1");
                verifyStep(createManageActivitySteps.tabGeneralSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 2",
                                "Failed fill all required field in step 2");
                verifyStep(createManageActivitySteps.fillContent(createManageActivityModel.fillFromBankContent()),
                                "Successfully fill content activity fields", "Failed fill content activity fields");
                verifyStep(createManageActivitySteps.fillSourceContent(createManageActivityModel.fillFromBankContent()),
                                "Successfully fill source content activity with ambil dari bank konten option",
                                "Failed fill source content activity with ambil dari bank konten option");
                verifyStep(createManageActivitySteps.saveManageActivityStep3(),
                                "Successfully save step 3 activity with konten tersedia ambil dari bank konten",
                                "Failed save step 3 activity with konten tersedia ambil dari bank konten");
                verifyStep(createManageActivitySteps.fillReportActivity(createManageActivityModel.emptyReportSetting()),
                                "Successfully fill report activity fields", "Failed fill report activity fields");
                verifyStep(createManageActivitySteps
                                .fillCertificateActivity(createManageActivityModel.emptyReportSetting()),
                                "Successfully fill certificate activity fields",
                                "Failed fill certificate activity fields");
                boolean result = createManageActivitySteps.saveManageActivityStep4();
                verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
        }

        @Test(priority = 14, description = "depend = 15798, 15806, 15808, 15820, 15827, 15831, 15834, 15835, 15799, 15800, 15823, 15828, 15829, 15830, 15837, 15840, 15841, 15842, 15843, 15844, 15845")
        @Override
        public void createAktivitasPengaturanOperasionalSuccessfullyCreateActivityWithToggleAktivitasBerbayarIsOff() {
                navigateToManageActivity();
                verifyStep(createManageActivitySteps.tabBasicSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 1",
                                "Failed fill all required field in step 1");
                verifyStep(createManageActivitySteps.tabGeneralSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 2",
                                "Failed fill all required field in step 2");
                verifyStep(createManageActivitySteps.fillContent(createManageActivityModel.fillFromBankContent()),
                                "Successfully fill content activity fields", "Failed fill content activity fields");
                verifyStep(createManageActivitySteps.fillSourceContent(createManageActivityModel.fillFromBankContent()),
                                "Successfully fill source content activity with ambil dari bank konten option",
                                "Failed fill source content activity with ambil dari bank konten option");
                verifyStep(createManageActivitySteps.saveManageActivityStep3(),
                                "Successfully save step 3 activity with konten tersedia ambil dari bank konten",
                                "Failed save step 3 activity with konten tersedia ambil dari bank konten");
                verifyStep(createManageActivitySteps.fillReportActivity(createManageActivityModel.validReportSetting()),
                                "Successfully fill report activity fields", "Failed fill report activity fields");
                verifyStep(createManageActivitySteps
                                .fillCertificateActivity(createManageActivityModel.validReportSetting()),
                                "Successfully fill certificate activity fields",
                                "Failed fill certificate activity fields");
                verifyStep(createManageActivitySteps.saveManageActivityStep4(),
                                "Successfully save step 4 activity with all required field filled",
                                "Failed save step 4 activity with all required field filled");
                verifyStep(createManageActivitySteps
                                .tabOperationalSetting(createManageActivityModel.validOperationalSetting()),
                                "Successfully fill all required field in step 5",
                                "Failed fill all required field in step 5");
        }

        @Test(priority = 15, description = "depend = 15799, 15800")
        @Override
        public void createAktivitasPengaturanOperasionalFailedToCreateActivityWhenRequiredFieldsAreEmpty() {
                navigateToManageActivity();
                verifyStep(createManageActivitySteps.tabBasicSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 1",
                                "Failed fill all required field in step 1");
                verifyStep(createManageActivitySteps.tabGeneralSetting(createManageActivityModel.validActivity()),
                                "Successfully fill all required field in step 2",
                                "Failed fill all required field in step 2");
                verifyStep(createManageActivitySteps.fillContent(createManageActivityModel.fillFromBankContent()),
                                "Successfully fill content activity fields", "Failed fill content activity fields");
                verifyStep(createManageActivitySteps.fillSourceContent(createManageActivityModel.fillFromBankContent()),
                                "Successfully fill source content activity with ambil dari bank konten option",
                                "Failed fill source content activity with ambil dari bank konten option");
                verifyStep(createManageActivitySteps.saveManageActivityStep3(),
                                "Successfully save step 3 activity with konten tersedia ambil dari bank konten",
                                "Failed save step 3 activity with konten tersedia ambil dari bank konten");
                verifyStep(createManageActivitySteps.fillReportActivity(createManageActivityModel.validReportSetting()),
                                "Successfully fill report activity fields", "Failed fill report activity fields");
                verifyStep(createManageActivitySteps
                                .fillCertificateActivity(createManageActivityModel.validReportSetting()),
                                "Successfully fill certificate activity fields",
                                "Failed fill certificate activity fields");
                verifyStep(createManageActivitySteps.saveManageActivityStep4(),
                                "Successfully save step 4 activity with all required field filled",
                                "Failed save step 4 activity with all required field filled");
                verifyStep(createManageActivitySteps
                                .fillPaidActivity(createManageActivityModel.emptyOperationalSetting()),
                                "Successfully fill all required field in step 5",
                                "Failed fill all required field in step 5");
                boolean result = createManageActivitySteps.saveManageActivityStep5();
                verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
        }

        private void navigateToManageActivity() {
                loginSteps.injectLoginCoreCookies();
                verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_ACTIVITY),
                                "Successfully navigate to Kelola Aktivitas menu",
                                "Failed navigate to Kelola Aktivitas menu");
                verifyStep(createManageActivitySteps.navigateToCreateManageActivityPage(),
                                "Successfully navigate to create manage activity page",
                                "Failed navigate to create manage activity page");
        }
}