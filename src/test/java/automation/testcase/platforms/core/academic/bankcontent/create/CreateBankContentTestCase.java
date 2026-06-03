package mu.core.id.website.testcase.platforms.core.academic.bankcontent.create;

public interface CreateBankContentTestCase {
    void addContentSuccessfullyAddContentPdf();
    void addContentSuccessfullyAddContentAudio();
    void addContentSuccessfullyAddContentVideo();
    void addContentSuccessfullyAddContentDokumen();
    void addContentSuccessfullyAddContentVirtual();
    void addContentSuccessfullyAddContentGambar();
    void addContentFailedAddContentWhenUserInputNamaKontenMoreThan_200Characters();
    void addContentFailedAddContentWhenUserDoesnTFillAllField();
    void addContentFailedUploadPdfMoreThan_100Mb();
    void addContentFailedToUploadLearningContentPdfOtherThanPdfFormat();
    void addContentFailedUploadVideoMoreThan_200Mb();
    void addContentFailedToUploadLearningContentVideoOtherThanInvalidFormat();
    void addContentFailedUploadDocumentMoreThan_200Mb();
    void addContentFailedToUploadLearningContentDocumentOtherThanInvalidFormat();
    void addContentFailedToSaveLearningContentIfTheTautanFieldIsEmpty();
    void addContentFailedToSaveLearningContentTautanIfFillFieldWithInvalidFormat();
    void addContentFailedUploadImageMoreThan_20Mb();
    void addContentFailedToUploadLearningContentImageWithInvalidFormat();
    void addContentFailedUploadAudioMoreThan_50Mb();
    void addContentFailedToUploadLearningContentAudioWithInvalidFormat();
    void addContentSuccessfullyAddContentWithStatusContentLearningIsInactive();
}
