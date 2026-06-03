package mu.core.id.website.testcase.platforms.core.academic.bankcontent.create;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import automation.platforms.core.academic.bankcontent.create.CreateBankContentModel;
import automation.platforms.core.academic.bankcontent.create.CreateBankContentPage;
import automation.platforms.core.academic.bankcontent.create.CreateBankContentSteps;
import automation.platforms.core.academic.sidemenu.MenuCoreOptions;
import automation.platforms.core.academic.sidemenu.MenuCorePage;
import automation.platforms.core.academic.sidemenu.MenuCoreSteps;
import automation.platforms.core.user.login.LoginCorePage;
import automation.platforms.core.user.login.LoginCoreSteps;
import mu.core.id.website.testcase.platforms.core.BaseCoreDriverTest;
import org.testng.annotations.Test;

import static automation.utils.StepLogger.verifyStep;

@Epic("Platform Core")
@Feature("Academic - Create Bank Content")
public class CreateBankContentTest extends BaseCoreDriverTest implements CreateBankContentTestCase {
        private CreateBankContentSteps createBankContentSteps;
        private CreateBankContentModel createBankContentModel;
        private MenuCoreSteps menuCoreSteps;
        private LoginCoreSteps loginSteps;

        @Override
        public void initInstance() {
                super.initInstance();
                createBankContentSteps = new CreateBankContentPage(page);
                createBankContentModel = new CreateBankContentModel();
                menuCoreSteps = new MenuCorePage(page);
                loginSteps = new LoginCorePage(page);
        }

        @Override
        @Test(priority = 1, description = "depend = 1502, 1509")
        public void addContentSuccessfullyAddContentPdf() {
                navigateToCreateBankContent();
                verifyStep(createBankContentSteps.fillNameBankContent(createBankContentModel.pdfContentLearning()),
                                "Successfully fill name bank content", "Failed fill name bank content");
                verifyStep(createBankContentSteps.fillContentLearning(createBankContentModel.pdfContentLearning()),
                                "Successfully fill content learning", "Failed fill content learning");
                verifyStep(createBankContentSteps.uploadFile(createBankContentModel.filePdf),
                                "Successfully upload pdf file",
                                "Failed upload pdf file");
                verifyStep(createBankContentSteps.fillLearningInstruction(createBankContentModel.pdfContentLearning()),
                                "Successfully fill learning instruction", "Failed fill learning instruction");
                verifyStep(createBankContentSteps.addBehavioralObjective(), "Successfully add behavioral objective",
                                "Failed add behavioral objective");
                verifyStep(createBankContentSteps.saveBankContentLearning(), "Successfully save bank content learning",
                                "Failed save bank content learning");
        }

        @Override
        @Test(priority = 2, description = "1503")
        public void addContentSuccessfullyAddContentAudio() {
                navigateToCreateBankContent();
                verifyStep(createBankContentSteps.fillNameBankContent(createBankContentModel.audioContentLearning()),
                                "Successfully fill name bank content", "Failed fill name bank content");
                verifyStep(createBankContentSteps.fillContentLearning(createBankContentModel.audioContentLearning()),
                                "Successfully fill content learning", "Failed fill content learning");
                verifyStep(createBankContentSteps.uploadFile(createBankContentModel.fileAudio),
                                "Successfully upload audio file", "Failed upload audio file");
                verifyStep(createBankContentSteps
                                .fillLearningInstruction(createBankContentModel.audioContentLearning()),
                                "Successfully fill learning instruction", "Failed fill learning instruction");
                verifyStep(createBankContentSteps.addBehavioralObjective(), "Successfully add behavioral objective",
                                "Failed add behavioral objective");
                verifyStep(createBankContentSteps.saveBankContentLearning(), "Successfully save bank content learning",
                                "Failed save bank content learning");
        }

        @Override
        @Test(priority = 3, description = "1504")
        public void addContentSuccessfullyAddContentVideo() {
                navigateToCreateBankContent();
                verifyStep(createBankContentSteps.fillNameBankContent(createBankContentModel.videoContentLearning()),
                                "Successfully fill name bank content", "Failed fill name bank content");
                verifyStep(createBankContentSteps.fillContentLearning(createBankContentModel.videoContentLearning()),
                                "Successfully fill content learning", "Failed fill content learning");
                verifyStep(createBankContentSteps.uploadFile(createBankContentModel.fileVideo),
                                "Successfully upload video file", "Failed upload video file");
                verifyStep(createBankContentSteps
                                .fillLearningInstruction(createBankContentModel.videoContentLearning()),
                                "Successfully fill learning instruction", "Failed fill learning instruction");
                verifyStep(createBankContentSteps.addBehavioralObjective(), "Successfully add behavioral objective",
                                "Failed add behavioral objective");
                verifyStep(createBankContentSteps.saveBankContentLearning(), "Successfully save bank content learning",
                                "Failed save bank content learning");
        }

        @Override
        @Test(priority = 4, description = "1505")
        public void addContentSuccessfullyAddContentDokumen() {
                navigateToCreateBankContent();
                verifyStep(createBankContentSteps.fillNameBankContent(createBankContentModel.documentContentLearning()),
                                "Successfully fill name bank content", "Failed fill name bank content");
                verifyStep(createBankContentSteps.fillContentLearning(createBankContentModel.documentContentLearning()),
                                "Successfully fill content learning", "Failed fill content learning");
                verifyStep(createBankContentSteps.uploadFile(createBankContentModel.fileDocument),
                                "Successfully upload document file", "Failed upload document file");
                verifyStep(createBankContentSteps
                                .fillLearningInstruction(createBankContentModel.documentContentLearning()),
                                "Successfully fill learning instruction", "Failed fill learning instruction");
                verifyStep(createBankContentSteps.addBehavioralObjective(), "Successfully add behavioral objective",
                                "Failed add behavioral objective");
                verifyStep(createBankContentSteps.saveBankContentLearning(), "Successfully save bank content learning",
                                "Failed save bank content learning");
        }

        @Override
        @Test(priority = 5, description = "1506")
        public void addContentSuccessfullyAddContentVirtual() {
                navigateToCreateBankContent();
                verifyStep(createBankContentSteps.fillNameBankContent(createBankContentModel.virtualContentLearning()),
                                "Successfully fill name bank content", "Failed fill name bank content");
                verifyStep(createBankContentSteps.fillContentLearning(createBankContentModel.virtualContentLearning()),
                                "Successfully fill content learning", "Failed fill content learning");
                verifyStep(createBankContentSteps.fillLinkVirtual(createBankContentModel.inputVirtual),
                                "Successfully upload link virtual file", "Failed upload link virtual file");
                verifyStep(createBankContentSteps
                                .fillLearningInstruction(createBankContentModel.virtualContentLearning()),
                                "Successfully fill learning instruction", "Failed fill learning instruction");
                verifyStep(createBankContentSteps.addBehavioralObjective(), "Successfully add behavioral objective",
                                "Failed add behavioral objective");
                verifyStep(createBankContentSteps.saveBankContentLearning(), "Successfully save bank content learning",
                                "Failed save bank content learning");
        }

        @Override
        @Test(priority = 6, description = "depend = 1507, 1508")
        public void addContentSuccessfullyAddContentGambar() {
                navigateToCreateBankContent();
                verifyStep(createBankContentSteps.fillNameBankContent(createBankContentModel.imageContentLearning()),
                                "Successfully fill name bank content", "Failed fill name bank content");
                verifyStep(createBankContentSteps.fillContentLearning(createBankContentModel.imageContentLearning()),
                                "Successfully fill content learning", "Failed fill content learning");
                verifyStep(createBankContentSteps.uploadFile(createBankContentModel.fileImage),
                                "Successfully upload image file", "Failed upload image file");
                verifyStep(createBankContentSteps
                                .fillLearningInstruction(createBankContentModel.imageContentLearning()),
                                "Successfully fill learning instruction", "Failed fill learning instruction");
                verifyStep(createBankContentSteps.addBehavioralObjective(), "Successfully add behavioral objective",
                                "Failed add behavioral objective");
                verifyStep(createBankContentSteps.saveBankContentLearning(), "Successfully save bank content learning",
                                "Failed save bank content learning");
        }

        @Override
        @Test(priority = 7, description = "depend = 1515, 1516, 1519")
        public void addContentFailedAddContentWhenUserInputNamaKontenMoreThan_200Characters() {
                navigateToCreateBankContent();
                verifyStep(createBankContentSteps
                                .fillNameBankContent(createBankContentModel.invalidInputContentLearning()),
                                "Successfully fill name bank content", "Failed fill name bank content");
                verifyStep(createBankContentSteps
                                .fillContentLearning(createBankContentModel.invalidInputContentLearning()),
                                "Successfully fill content learning", "Failed fill content learning");
                verifyStep(createBankContentSteps
                                .fillLearningInstruction(createBankContentModel.invalidInputContentLearning()),
                                "Successfully fill learning instruction", "Failed fill learning instruction");
                boolean result = createBankContentSteps.saveBankContentLearning();
                verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
        }

        @Override
        @Test(priority = 8, description = "depend = 1512, 1543, 1544, 1545, 1546")
        public void addContentFailedAddContentWhenUserDoesnTFillAllField() {
                navigateToCreateBankContent();
                verifyStep(createBankContentSteps.fillNameBankContent(createBankContentModel.emptyField()),
                                "Successfully fill name bank content", "Failed fill name bank content");
                verifyStep(createBankContentSteps.fillContentLearning(createBankContentModel.emptyField()),
                                "Successfully fill content learning", "Failed fill content learning");
                verifyStep(createBankContentSteps.fillLearningInstruction(createBankContentModel.emptyField()),
                                "Successfully fill learning instruction", "Failed fill learning instruction");
                boolean result = createBankContentSteps.saveBankContentLearning();
                verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
        }

        @Override
        @Test(priority = 9, description = "1517")
        public void addContentFailedUploadPdfMoreThan_100Mb() {
                navigateToCreateBankContent();
                verifyStep(createBankContentSteps.fillNameBankContent(createBankContentModel.pdfContentLearning()),
                                "Successfully fill name bank content", "Failed fill name bank content");
                verifyStep(createBankContentSteps.fillContentLearning(createBankContentModel.pdfContentLearning()),
                                "Successfully fill content learning", "Failed fill content learning");
                verifyStep(createBankContentSteps.uploadFile(createBankContentModel.fileLargePdf),
                                "Successfully upload pdf file", "Failed upload pdf file");
                verifyStep(createBankContentSteps.fillLearningInstruction(createBankContentModel.pdfContentLearning()),
                                "Successfully fill learning instruction", "Failed fill learning instruction");
                verifyStep(createBankContentSteps.addBehavioralObjective(), "Successfully add behavioral objective",
                                "Failed add behavioral objective");
                boolean result = createBankContentSteps.saveBankContentLearning();
                verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
        }

        @Override
        @Test(priority = 10, description = "1518")
        public void addContentFailedToUploadLearningContentPdfOtherThanPdfFormat() {
                navigateToCreateBankContent();
                verifyStep(createBankContentSteps.fillNameBankContent(createBankContentModel.pdfContentLearning()),
                                "Successfully fill name bank content", "Failed fill name bank content");
                verifyStep(createBankContentSteps.fillContentLearning(createBankContentModel.pdfContentLearning()),
                                "Successfully fill content learning", "Failed fill content learning");
                verifyStep(createBankContentSteps.uploadFile(createBankContentModel.fileAudio),
                                "Successfully upload link virtual file", "Failed upload link virtual file");
                verifyStep(createBankContentSteps.fillLearningInstruction(createBankContentModel.pdfContentLearning()),
                                "Successfully fill learning instruction", "Failed fill learning instruction");
                verifyStep(createBankContentSteps.addBehavioralObjective(), "Successfully add behavioral objective",
                                "Failed add behavioral objective");
                boolean result = createBankContentSteps.saveBankContentLearning();
                verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
        }

        @Override
        @Test(priority = 11, description = "1523")
        public void addContentFailedUploadVideoMoreThan_200Mb() {
                navigateToCreateBankContent();
                verifyStep(createBankContentSteps.fillNameBankContent(createBankContentModel.videoContentLearning()),
                                "Successfully fill name bank content", "Failed fill name bank content");
                verifyStep(createBankContentSteps.fillContentLearning(createBankContentModel.videoContentLearning()),
                                "Successfully fill content learning", "Failed fill content learning");
                verifyStep(createBankContentSteps.uploadFile(createBankContentModel.fileLargeVideo),
                                "Successfully upload pdf file", "Failed upload pdf file");
                verifyStep(createBankContentSteps
                                .fillLearningInstruction(createBankContentModel.videoContentLearning()),
                                "Successfully fill learning instruction", "Failed fill learning instruction");
                verifyStep(createBankContentSteps.addBehavioralObjective(), "Successfully add behavioral objective",
                                "Failed add behavioral objective");
                boolean result = createBankContentSteps.saveBankContentLearning();
                verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
        }

        @Override
        @Test(priority = 12, description = "1524")
        public void addContentFailedToUploadLearningContentVideoOtherThanInvalidFormat() {
                navigateToCreateBankContent();
                verifyStep(createBankContentSteps.fillNameBankContent(createBankContentModel.videoContentLearning()),
                                "Successfully fill name bank content", "Failed fill name bank content");
                verifyStep(createBankContentSteps.fillContentLearning(createBankContentModel.videoContentLearning()),
                                "Successfully fill content learning", "Failed fill content learning");
                verifyStep(createBankContentSteps.uploadFile(createBankContentModel.filePdf),
                                "Successfully upload link virtual file", "Failed upload link virtual file");
                verifyStep(createBankContentSteps
                                .fillLearningInstruction(createBankContentModel.videoContentLearning()),
                                "Successfully fill learning instruction", "Failed fill learning instruction");
                verifyStep(createBankContentSteps.addBehavioralObjective(), "Successfully add behavioral objective",
                                "Failed add behavioral objective");
                boolean result = createBankContentSteps.saveBankContentLearning();
                verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
        }

        @Override
        @Test(priority = 13, description = "1526")
        public void addContentFailedUploadDocumentMoreThan_200Mb() {
                navigateToCreateBankContent();
                verifyStep(createBankContentSteps.fillNameBankContent(createBankContentModel.documentContentLearning()),
                                "Successfully fill name bank content", "Failed fill name bank content");
                verifyStep(createBankContentSteps.fillContentLearning(createBankContentModel.documentContentLearning()),
                                "Successfully fill content learning", "Failed fill content learning");
                verifyStep(createBankContentSteps.uploadFile(createBankContentModel.fileLargeDocument),
                                "Successfully upload pdf file", "Failed upload pdf file");
                verifyStep(createBankContentSteps
                                .fillLearningInstruction(createBankContentModel.documentContentLearning()),
                                "Successfully fill learning instruction", "Failed fill learning instruction");
                verifyStep(createBankContentSteps.addBehavioralObjective(), "Successfully add behavioral objective",
                                "Failed add behavioral objective");
                boolean result = createBankContentSteps.saveBankContentLearning();
                verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
        }

        @Override
        @Test(priority = 14, description = "1527")
        public void addContentFailedToUploadLearningContentDocumentOtherThanInvalidFormat() {
                navigateToCreateBankContent();
                verifyStep(createBankContentSteps.fillNameBankContent(createBankContentModel.documentContentLearning()),
                                "Successfully fill name bank content", "Failed fill name bank content");
                verifyStep(createBankContentSteps.fillContentLearning(createBankContentModel.documentContentLearning()),
                                "Successfully fill content learning", "Failed fill content learning");
                verifyStep(createBankContentSteps.uploadFile(createBankContentModel.fileAudio),
                                "Successfully upload link virtual file", "Failed upload link virtual file");
                verifyStep(createBankContentSteps
                                .fillLearningInstruction(createBankContentModel.documentContentLearning()),
                                "Successfully fill learning instruction", "Failed fill learning instruction");
                verifyStep(createBankContentSteps.addBehavioralObjective(), "Successfully add behavioral objective",
                                "Failed add behavioral objective");
                boolean result = createBankContentSteps.saveBankContentLearning();
                verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
        }

        @Override
        @Test(priority = 15, description = "1528")
        public void addContentFailedToSaveLearningContentIfTheTautanFieldIsEmpty() {
                navigateToCreateBankContent();
                verifyStep(createBankContentSteps.fillNameBankContent(createBankContentModel.virtualContentLearning()),
                                "Successfully fill name bank content", "Failed fill name bank content");
                verifyStep(createBankContentSteps.fillContentLearning(createBankContentModel.virtualContentLearning()),
                                "Successfully fill content learning", "Failed fill content learning");
                verifyStep(createBankContentSteps.uploadFile(createBankContentModel.emptyVirtual),
                                "Successfully upload pdf file", "Failed upload pdf file");
                verifyStep(createBankContentSteps
                                .fillLearningInstruction(createBankContentModel.virtualContentLearning()),
                                "Successfully fill learning instruction", "Failed fill learning instruction");
                verifyStep(createBankContentSteps.addBehavioralObjective(), "Successfully add behavioral objective",
                                "Failed add behavioral objective");
                boolean result = createBankContentSteps.saveBankContentLearning();
                verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
        }

        @Override
        @Test(priority = 16, description = "1529")
        public void addContentFailedToSaveLearningContentTautanIfFillFieldWithInvalidFormat() {
                navigateToCreateBankContent();
                verifyStep(createBankContentSteps.fillNameBankContent(createBankContentModel.virtualContentLearning()),
                                "Successfully fill name bank content", "Failed fill name bank content");
                verifyStep(createBankContentSteps.fillContentLearning(createBankContentModel.virtualContentLearning()),
                                "Successfully fill content learning", "Failed fill content learning");
                verifyStep(createBankContentSteps.fillLinkVirtual(createBankContentModel.invalidLinkVirtual),
                                "Successfully upload pdf file", "Failed upload pdf file");
                verifyStep(createBankContentSteps
                                .fillLearningInstruction(createBankContentModel.virtualContentLearning()),
                                "Successfully fill learning instruction", "Failed fill learning instruction");
                verifyStep(createBankContentSteps.addBehavioralObjective(), "Successfully add behavioral objective",
                                "Failed add behavioral objective");
                boolean result = createBankContentSteps.saveBankContentLearning();
                verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
        }

        @Override
        @Test(priority = 17, description = "1530")
        public void addContentFailedUploadImageMoreThan_20Mb() {
                navigateToCreateBankContent();
                verifyStep(createBankContentSteps.fillNameBankContent(createBankContentModel.imageContentLearning()),
                                "Successfully fill name bank content", "Failed fill name bank content");
                verifyStep(createBankContentSteps.fillContentLearning(createBankContentModel.imageContentLearning()),
                                "Successfully fill content learning", "Failed fill content learning");
                verifyStep(createBankContentSteps.uploadFile(createBankContentModel.fileLargeImage),
                                "Successfully upload pdf file", "Failed upload pdf file");
                verifyStep(createBankContentSteps
                                .fillLearningInstruction(createBankContentModel.imageContentLearning()),
                                "Successfully fill learning instruction", "Failed fill learning instruction");
                verifyStep(createBankContentSteps.addBehavioralObjective(), "Successfully add behavioral objective",
                                "Failed add behavioral objective");
                boolean result = createBankContentSteps.saveBankContentLearning();
                verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
        }

        @Override
        @Test(priority = 18, description = "1531")
        public void addContentFailedToUploadLearningContentImageWithInvalidFormat() {
                navigateToCreateBankContent();
                verifyStep(createBankContentSteps.fillNameBankContent(createBankContentModel.imageContentLearning()),
                                "Successfully fill name bank content", "Failed fill name bank content");
                verifyStep(createBankContentSteps.fillContentLearning(createBankContentModel.imageContentLearning()),
                                "Successfully fill content learning", "Failed fill content learning");
                verifyStep(createBankContentSteps.uploadFile(createBankContentModel.fileVideo),
                                "Successfully upload pdf file",
                                "Failed upload pdf file");
                verifyStep(createBankContentSteps
                                .fillLearningInstruction(createBankContentModel.imageContentLearning()),
                                "Successfully fill learning instruction", "Failed fill learning instruction");
                verifyStep(createBankContentSteps.addBehavioralObjective(), "Successfully add behavioral objective",
                                "Failed add behavioral objective");
                boolean result = createBankContentSteps.saveBankContentLearning();
                verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
        }

        @Override
        @Test(priority = 19, description = "1532")
        public void addContentFailedUploadAudioMoreThan_50Mb() {
                navigateToCreateBankContent();
                verifyStep(createBankContentSteps.fillNameBankContent(createBankContentModel.audioContentLearning()),
                                "Successfully fill name bank content", "Failed fill name bank content");
                verifyStep(createBankContentSteps.fillContentLearning(createBankContentModel.audioContentLearning()),
                                "Successfully fill content learning", "Failed fill content learning");
                verifyStep(createBankContentSteps.uploadFile(createBankContentModel.fileLargeAudio),
                                "Successfully upload pdf file", "Failed upload pdf file");
                verifyStep(createBankContentSteps
                                .fillLearningInstruction(createBankContentModel.audioContentLearning()),
                                "Successfully fill learning instruction", "Failed fill learning instruction");
                verifyStep(createBankContentSteps.addBehavioralObjective(), "Successfully add behavioral objective",
                                "Failed add behavioral objective");
                boolean result = createBankContentSteps.saveBankContentLearning();
                verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
        }

        @Override
        @Test(priority = 20, description = "1533")
        public void addContentFailedToUploadLearningContentAudioWithInvalidFormat() {
                navigateToCreateBankContent();
                verifyStep(createBankContentSteps.fillNameBankContent(createBankContentModel.audioContentLearning()),
                                "Successfully fill name bank content", "Failed fill name bank content");
                verifyStep(createBankContentSteps.fillContentLearning(createBankContentModel.audioContentLearning()),
                                "Successfully fill content learning", "Failed fill content learning");
                verifyStep(createBankContentSteps.uploadFile(createBankContentModel.fileVideo),
                                "Successfully upload pdf file",
                                "Failed upload pdf file");
                verifyStep(createBankContentSteps
                                .fillLearningInstruction(createBankContentModel.audioContentLearning()),
                                "Successfully fill learning instruction", "Failed fill learning instruction");
                verifyStep(createBankContentSteps.addBehavioralObjective(), "Successfully add behavioral objective",
                                "Failed add behavioral objective");
                boolean result = createBankContentSteps.saveBankContentLearning();
                verifyStep(!result, "Expected error alert for mandatory field", "Error alert not shown as expected");
        }

        @Override
        @Test(priority = 21, description = "1542")
        public void addContentSuccessfullyAddContentWithStatusContentLearningIsInactive() {
                navigateToCreateBankContent();
                verifyStep(createBankContentSteps.fillNameBankContent(createBankContentModel.audioContentLearning()),
                                "Successfully fill name bank content", "Failed fill name bank content");
                verifyStep(createBankContentSteps.fillContentLearning(createBankContentModel.audioContentLearning()),
                                "Successfully fill content learning", "Failed fill content learning");
                verifyStep(createBankContentSteps.uploadFile(createBankContentModel.fileAudio),
                                "Successfully upload audio file", "Failed upload audio file");
                verifyStep(createBankContentSteps
                                .fillLearningInstruction(createBankContentModel.audioContentLearning()),
                                "Successfully fill learning instruction", "Failed fill learning instruction");
                verifyStep(createBankContentSteps.toggleStatus(), "Successfully toggle status to inactive",
                                "Failed toggle status to inactive");
                verifyStep(createBankContentSteps.addBehavioralObjective(), "Successfully add behavioral objective",
                                "Failed add behavioral objective");
                verifyStep(createBankContentSteps.saveBankContentLearning(), "Successfully save bank content learning",
                                "Failed save bank content learning");
        }

        private void navigateToCreateBankContent() {
                loginSteps.injectLoginCoreCookies();
                verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_STUDY_CONTENT),
                                "Successfully navigate to Bank Content menu", "Failed navigate to Bank Content menu");
                verifyStep(createBankContentSteps.navigateToPageBankContent(),
                                "Successfully navigate to Create Bank Content page",
                                "Failed navigate to Create Bank Content page");
        }
}
