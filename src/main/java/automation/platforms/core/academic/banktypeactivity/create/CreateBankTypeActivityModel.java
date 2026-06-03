package automation.platforms.core.academic.banktypeactivity.create;

import automation.platforms.base.BaseModel;

public class CreateBankTypeActivityModel extends BaseModel {
    public String nameActivity;
    public String categoryActivity;
    public String contentLearning;

    public CreateBankTypeActivityModel validNameActivity() {
        nameActivity = "[Automation] Aktivitas semua konten belajar";
        return this;
    }

    public CreateBankTypeActivityModel validCategoryActivity() {
        categoryActivity = "Materi";
        return this;
    }

    public CreateBankTypeActivityModel validContentLearning() {
        contentLearning = "Semua Konten Belajar";
        return this;
    }

    public CreateBankTypeActivityModel invalidInputNameActivityMoreThanChars() {
        nameActivity = "Rapat koordinasi lintas divisi terkait penyusunan strategi implementasi program kerja tahunan perusahaan untuk meningkatkan efektivitas operasional sekaligus memperkuat sinergi antar departemen dalam menghadapi tantangan bisnis global yang semakin kompetitif dan dinamis di era digitalisasi.";
        categoryActivity = "Materi";
        contentLearning = "Semua Konten Belajar";
        return this;
    }
}
