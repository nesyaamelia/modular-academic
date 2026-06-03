package automation.platforms.core.academic.banktypeactivity.edit;

import automation.platforms.base.BaseModel;

public class EditBankTypeActivityModel extends BaseModel {

    public String nameActivity;
    public String idActivity;
    public String categoryActivity;
    public String contentLearning;
    public String searchKeyword;
    public boolean isAddAction;
    public boolean isSingleAction;

    public EditBankTypeActivityModel editValidNameActivity() {
        nameActivity = "[Automation] Edit Jenis Aktivitas ";
        return this;
    }

    public EditBankTypeActivityModel navigateToEditPage() {
        nameActivity = "[Automation] Aktivitas semua konten belajar";
        idActivity = "39";
        return this;
    }

    public EditBankTypeActivityModel editValidCategoryActivity(String category) {
        categoryActivity = category;
        return this;
    }

    public EditBankTypeActivityModel editValidContentLearning() {
        isAddAction = false;
        isSingleAction = true;
        contentLearning = "Gambar";
        return this;
    }

    public EditBankTypeActivityModel editInvalidNameActivityLongChars() {
        nameActivity = "Pengumpulan Laporan Akhir Proyek Kolaboratif Antar Siswa dengan Pendekatan Problem-Based Learning dalam Konteks Pembelajaran Interdisipliner Berbasis DigitalPengumpulan Laporan Akhir Proyek Kolaboratif Antar Siswa dengan Pendekatan Problem-Based Learning dalam Konteks Pembelajaran Interdisipliner Berbasis Digital";
        return this;
    }

    public EditBankTypeActivityModel editInvalidNameActivityEmpty() {
        nameActivity = "";
        return this;
    }
}
