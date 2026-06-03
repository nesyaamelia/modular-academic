package automation.platforms.core.academic.manageactivity.create;

import automation.helper.RandomNumber;
import automation.platforms.base.BaseModel;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CreateManageActivityModel extends BaseModel {
    public String nameActivity;
    public String organizationActivity;
    public String platformActivity;
    public String categoryActivity;
    public String typeActivity;
    public String contentActivity;
    public String designerActivity;
    public String facilitatorActivity;
    public String picActivity;
    public String durationActivity;
    public String groupActivity;
    public String quotaActivity;
    public String quotaValue;
    public String content;
    public String sourceContent;
    public String startDateActivity;
    public String endDateActivity;
    public String fileContent;
    public String instructionContent;
    public String facilitatorReport;
    public String certificateTemplate;
    public String aboutActivity;
    public String sellingPriceActivity;
    public String crossoutPriceActivity;
    public String activityCover;
    public String coverImage;
    public String teaserImage;
    public String teaserVideo;
    public String paidPlatformActivity;
    public String tagActivity;
    public String aboutOrganization;
    public String aboutFacilitator;
    public String characteristicParticipants;
    public String userGroups;
    public String emailSubject;
    public String emailMessage;
    public String freeTextVariation;
    public String scheduleVariation;
    public List<String> variationType;
    public boolean scheduleActivity;
    public int randomNumber = RandomNumber.getRandomInteger(1, 1000);

    public CreateManageActivityModel validActivity() {
        nameActivity = "[Automation] Manage Activity " + randomNumber;
        organizationActivity = "Lembaga QA 1 (ID: 437)";
        platformActivity = "Tribe 3A - Main";
        categoryActivity = "Materi";
        typeActivity = "Smoketest Jenis Aktivitas untuk aktivitas";
        contentActivity = "PDF";
        designerActivity = "nesya fasil (Platform: Tribe 3A - Main)";
        facilitatorActivity = "nesya fasil (Platform: Tribe 3A - Main)";
        durationActivity = "60";
        groupActivity = "Tidak Menggunakan Kelompok Aktivitas";
        quotaActivity = "Terbatas";
        quotaValue = "100";
        scheduleActivity = true;
        startDateActivity = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        endDateActivity = LocalDateTime.now().plusDays(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        content = "Konten Belum Tersedia";
        return this;
    }

    public CreateManageActivityModel inputStartEndDateActivity(){
        startDateActivity = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        endDateActivity = LocalDateTime.now().plusDays(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return this;
    }

    public CreateManageActivityModel inputSameStartEndDateActivity(){
        startDateActivity = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        endDateActivity = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return this;
    }

    public CreateManageActivityModel fillFromBankContent(){
        content = "Konten Tersedia";
        sourceContent = "Ambil dari Bank Konten";
        instructionContent = "Instruksi automation test";
        return this;
    }

    public CreateManageActivityModel fillNewContent(){
        content = "Konten Tersedia";
        sourceContent = "Buat Konten Baru";
        fileContent = "files/content/pdf-content.pdf";
        instructionContent = "Instruksi automation test";
        return this;
    }

    public CreateManageActivityModel emptyInputContent(){
        content = "Konten Tersedia";
        sourceContent = "Buat Konten Baru";
        fileContent = "";
        instructionContent = "";
        return this;
    }

    public CreateManageActivityModel invalidInputInstructionContent(){
        content = "Konten Tersedia";
        sourceContent = "Buat Konten Baru";
        fileContent = "files/content/pdf-content.pdf";
        instructionContent = "Harap membaca dan mengikuti seluruh instruksi ini dengan seksama sebelum kegiatan dimulai Peserta wajib hadir tepat waktu sesuai jadwal yang tertera dan melakukan registrasi ulang di lokasi atau melalui tautan yang disediakan Gunakan pakaian yang rapi sopan dan nyaman serta membawa identitas diri yang masih berlaku Pastikan perangkat yang digunakan dalam kondisi baik baterai cukup dan koneksi internet stabil apabila kegiatan dilakukan secara daring Peserta diwajibkan mengisi daftar hadir mengerjakan tugas atau kuis yang diberikan serta mengikuti arahan fasilitator sampai kegiatan selesai Selama kegiatan berlangsung peserta diminta untuk menjaga ketertiban tidak mengganggu peserta lain dan mematikan atau menonaktifkan suara notifikasi yang dapat mengganggu konsentrasi Apabila ingin bertanya gunakan fitur tanya jawab atau angkat tangan dan tunggu giliran berbicara Sampaikan pertanyaan dengan jelas singkat dan relevan dengan materi Untuk kegiatan tatap muka peserta wajib menjaga kebersihan area mengikuti aturan keselamatan dan mematuhi tata tertib tempat kegiatan Dilarang membawa barang berbahaya serta dilarang merokok di area yang tidak diperbolehkan Peserta diharapkan aktif berdiskusi namun tetap menghormati pendapat orang lain dan menghindari penggunaan kata kata yang tidak pantas atau bersifat menyerang pribadi Dokumentasi kegiatan dapat dilakukan oleh panitia untuk kebutuhan laporan dan publikasi internal dengan tetap memperhatikan etika dan privasi peserta Jika peserta berhalangan hadir mohon menginformasikan kepada panitia sebelum kegiatan dimulai melalui kontak yang tersedia Peserta yang terlambat lebih dari batas toleransi dapat diarahkan untuk mengikuti sesi berikutnya atau mendapatkan penyesuaian sesuai kebijakan penyelenggara Pastikan semua formulir yang diminta telah diisi dengan benar termasuk data nama nomor kontak dan informasi lain yang diperlukan untuk keperluan sertifikat Sertifikat atau bukti keikutsertaan akan diberikan kepada peserta yang memenuhi ketentuan kehadiran dan menyelesaikan seluruh rangkaian kegiatan Apabila terdapat kendala teknis segera laporkan kepada panitia agar dapat dibantu secepatnya Peserta tidak diperkenankan menyebarkan materi kegiatan kepada pihak luar tanpa izin tertulis dari penyelenggara Materi yang dibagikan hanya digunakan untuk pembelajaran pribadi dan pengembangan kompetensi Setelah kegiatan selesai peserta diminta mengisi survei evaluasi secara jujur dan konstruktif agar kualitas kegiatan dapat terus ditingkatkan Terima kasih atas kerja sama dan partisipasi Anda semoga kegiatan ini bermanfaat dan memberikan pengalaman belajar yang menyenangkan serta berdampak positif untuk pekerjaan dan pengembangan diri ke depannya Pastikan Anda mengikuti seluruh sesi dari awal hingga akhir serta menyimpan informasi penting seperti jadwal tautan akses dan kontak panitia agar komunikasi berjalan lancar dan tidak ada informasi yang terlewat Jika Anda membutuhkan bantuan tambahan seperti kebutuhan aksesibilitas";
        return this;
    }

    public CreateManageActivityModel validReportSetting(){
        facilitatorReport = "nesya fasil";
        certificateTemplate = "Basic Certificate Template";
        return this;
    }

    public CreateManageActivityModel emptyReportSetting(){
        facilitatorReport = "";
        certificateTemplate = "";
        return this;
    }

    public CreateManageActivityModel validOperationalSetting(){
        aboutActivity = "This activity is for automation test purpose.";
        sellingPriceActivity = "500000";
        crossoutPriceActivity = "750000";
        activityCover = "Unggah Cover Baru";
        coverImage = "files/content/image-content.jpg";
        teaserImage = "files/content/image-content.jpg";
        teaserVideo = "files/asesmen/video.mov";
        paidPlatformActivity = "Tribe 3A - Main";
        tagActivity = "Automation";
        aboutOrganization = "This organization is created for automation test purpose.";
        aboutFacilitator = "This facilitator is created for automation test purpose.";
        characteristicParticipants = "This activity is suitable for all participants who want to learn about automation testing and improve their skills in software testing methodologies and tools.";
        userGroups = "Group 1";
        emailSubject = "[Automation Test] Notification for Manage Activity";
        emailMessage = "Dear Participant,\n\nWe are excited to inform you about the upcoming activity that you have registered for. Location: Online Platform\n\nWe look forward to your active participation.\n\nBest regards,\nAutomation Test Team, This activity is suitable for all participants who want to learn about automation testing and improve their skills in software testing methodologies and tools.";
        return this;
    }

    public CreateManageActivityModel emptyOperationalSetting(){
        aboutActivity = "";
        sellingPriceActivity = "";
        crossoutPriceActivity = "";
        activityCover = "";
        coverImage = "";
        teaserImage = "";
        teaserVideo = "";
        paidPlatformActivity = "";
        tagActivity = "";
        aboutOrganization = "";
        aboutFacilitator = "";
        characteristicParticipants = "";
        userGroups = "";
        emailSubject = "";
        emailMessage = "";
        return this;
    }

    public CreateManageActivityModel activityPsikometri() {
        nameActivity = "[Automation] Psikometri " + randomNumber;
        organizationActivity = "Organisasi 3B QA (ID: 450)";
        platformActivity = "Tribe 3B - Main";
        categoryActivity = "Tugas & Asesmen";
        typeActivity = "Mengerjakan Asesmen (Complex & Simple)";
        contentActivity = "Psikometri";
        picActivity = "Firnan (Platform: Tribe 3B - Main)";
        durationActivity = "60";
        groupActivity = "Tidak Menggunakan Kelompok Aktivitas";
        quotaActivity = "Terbatas";
        quotaValue = "100";
        scheduleActivity = true;
        startDateActivity = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        endDateActivity = LocalDateTime.now().plusDays(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        content = "Konten Belum Tersedia";
        return this;
    }
}
