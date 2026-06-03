package automation.platforms.core.academic.bankcontent.edit;

import automation.helper.RandomNumber;
import automation.platforms.base.BaseModel;

public class EditBankContentModel extends BaseModel {
    public String idContent;
    public String nameContent;
    public String instructionLearning;
    public String fileAudio = "files/asesmen/audio.wav";
    public int randomNumber = RandomNumber.getRandomInteger(1, 1000);

    public EditBankContentModel navigateToEditPage() {
        idContent = "164";
        return this;
    }

    public EditBankContentModel validEditBankContent() {
        nameContent = "Audio Automation Edited" + randomNumber;
        instructionLearning = "Instruksi belajar edited";
        return this;
    }

    public EditBankContentModel emptyField() {
        nameContent = "";
        instructionLearning = "";
        return this;
    }

    public EditBankContentModel nameContentLongChars() {
        nameContent = "Pengumpulan Laporan Akhir Proyek Kolaboratif Antar Konteks Pembelajaran Interdisipliner Berbasis DigitalSiswa dengan Pendekatan Problem-Based Learning dalam Konteks Pembelajaran Interdisipliner Berbasis Digital";
        return this;
    }
}