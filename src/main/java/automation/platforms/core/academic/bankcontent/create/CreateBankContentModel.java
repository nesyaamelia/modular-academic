package automation.platforms.core.academic.bankcontent.create;

import automation.platforms.base.BaseModel;

public class CreateBankContentModel extends BaseModel {
    public String contentLearning;
    public String nameContentLearning;
    public String instructionalLearning;
    public String organizationLearning;
    public String fileAudio = "files/asesmen/audio.wav";
    public String filePdf = "files/content/pdf-content.pdf";
    public String fileVideo = "files/asesmen/video.mov";
    public String fileDocument = "files/norms/file_norm.xlsx";
    public String inputVirtual = "https://meet.example.com/test-meeting-link";
    public String fileImage = "files/content/image-content.jpg";
    public String fileLargePdf = "files/content/pdf-large.pdf";
    public String fileLargeVideo = "files/content/video-large.mov";
    public String fileLargeDocument = "files/content/document-large.xlsx";
    public String emptyVirtual = "";
    public String invalidLinkVirtual = "meet google . com";
    public String fileLargeImage = "files/content/image-large.jpg";
    public String fileLargeAudio = "files/content/audio-large.wav";
    public String searchKeyword;

    public CreateBankContentModel pdfContentLearning() {
        nameContentLearning = "[Automation] PDF Content Learning";
        contentLearning = "PDF";
        instructionalLearning = "Ini adalah deskripsi untuk konten belajar PDF Automation.";
        return this;
    }

    public CreateBankContentModel audioContentLearning() {
        nameContentLearning = "[Automation] Audio Content Learning";
        contentLearning = "Audio";
        instructionalLearning = "Ini adalah deskripsi untuk konten belajar Audio Automation.";
        return this;
    }

    public CreateBankContentModel videoContentLearning() {
        nameContentLearning = "[Automation] Video Content Learning";
        contentLearning = "Video";
        instructionalLearning = "Ini adalah deskripsi untuk konten belajar Video Automation.";
        return this;
    }

    public CreateBankContentModel documentContentLearning() {
        nameContentLearning = "[Automation] Document Content Learning";
        contentLearning = "Unduh Dokumen";
        instructionalLearning = "Ini adalah deskripsi untuk konten belajar Dokumen Automation.";
        return this;
    }

    public CreateBankContentModel virtualContentLearning() {
        nameContentLearning = "[Automation] Virtual Content Learning";
        contentLearning = "Virtual";
        instructionalLearning = "Ini adalah deskripsi untuk konten belajar Virtual Automation.";
        return this;
    }

    public CreateBankContentModel imageContentLearning() {
        nameContentLearning = "[Automation] Gambar Content Learning";
        contentLearning = "Gambar";
        instructionalLearning = "Ini adalah deskripsi untuk konten belajar Gambar Automation.";
        return this;
    }

    public CreateBankContentModel invalidInputContentLearning() {
        nameContentLearning = "Pengenalan Dasar Tentang Pemrograman Berorientasi Objek Menggunakan Bahasa Java dengan Studi Kasus Pengembangan Aplikasi Inventarisasi Barang di Lingkungan Sekolah Menengah Kejuruan secara Modular dan Terstruktur";
        contentLearning = "Gambar";
        instructionalLearning = "Instruksi Belajar: Membangun Kemampuan Berpikir Kritis dan Kolaboratif dalam Pemecahan Masalah Nyata Halo peserta belajar! Selamat datang di sesi pembelajaran kali ini. Di modul ini, kamu akan berlatih bagaimana cara berpikir kritis, bekerja sama dalam tim, dan mengambil keputusan berdasarkan data serta pengalaman nyata. Pastikan kamu membaca seluruh bagian dengan cermat dan mengikuti setiap langkah agar hasil belajarmu optimal. Tujuan Pembelajaran Setelah mengikuti seluruh aktivitas dalam modul ini, kamu diharapkan mampu: Mengidentifikasi masalah dari situasi nyata dengan pendekatan analisis kritis.Menggali berbagai alternatif solusi berdasarkan teori dan praktik. Mengembangkan argumen logis untuk mendukung keputusan yang diambil. Menunjukkan kemampuan bekerja sama dan berkomunikasi efektif dalam kelompok. Menyusun laporan reflektif yang menggambarkan proses berpikir dan hasil akhir pembelajaran. Langkah-Langkah Pembelajaran 1. Eksplorasi Konsep Dasar Mulailah dengan membaca ringkasan teori pada bagian “Konsep Kritis” di tab konten. Kamu akan menemukan penjelasan tentang bagaimana berpikir kritis dibangun melalui observasi, inferensi, dan analisis bukti. Bacalah dengan saksama, lalu buat catatan singkat berisi 3 hal yang menurutmu paling menarik.Setelah itu, buka video penjelasan yang berdurasi 10 menit. Di sana kamu akan menemukan contoh penerapan berpikir kritis dalam konteks kehidupan sehari-hari, seperti pengambilan keputusan finansial, analisis media sosial, dan pemecahan konflik di lingkungan kerja. 2. Aktivitas Analisis Kasus Bacalah studi kasus “Tim Riset Alpha” yang sudah disiapkan. Dalam kasus ini, kamu berperan sebagai anggota tim yang harus menentukan strategi terbaik untuk menyelesaikan proyek dengan sumber daya terbatas. Gunakan template analisis di bagian “Lembar Kerja Peserta”. Tuliskan:Masalah utama yang kamu identifikasi Akar penyebab dari masalah tersebut Alternatif solusi dan risiko dari masing-masing alternatif Solusi akhir yang kamu pilih beserta alasannya Kamu tidak perlu terburu-buru menulis jawaban; luangkan waktu untuk berpikir, diskusi dengan teman, dan periksa kembali logika argumenmu. 3. Diskusi Kelompok Setelah menyelesaikan analisis individu, lanjutkan dengan diskusi kelompok melalui ruang kolaboratif yang sudah disediakan. diskusi dengan teman, dan periksa kembali logika argumenmu. 3. Diskusi Kelompok Setelah menyelesaikan analisis individu, lanjutkan dengan diskusi kelompok melalui ruang kolaboratif yang sudah disediakan. diskusi dengan teman, dan periksa kembali logika argumenmu. 3. Diskusi Kelompok Setelah menyelesaikan analisis individu, lanjutkan dengan diskusi kelompok melalui ruang kolaboratif yang sudah disediakan. diskusi dengan teman, dan periksa kembali logika argumenmu. 3. Diskusi Kelompok Setelah menyelesaikan analisis individu, lanjutkan dengan diskusi kelompok melalui ruang kolaboratif yang sudah disediakan.diskusi dengan teman, dan periksa kembali logika argumenmu. 3. Diskusi bersama guru terbaik";
        return this;
    }

    public CreateBankContentModel emptyField() {
        nameContentLearning = "";
        contentLearning = "Audio";
        instructionalLearning = "";
        return this;
    }

    public CreateBankContentModel selectOrganization() {
        organizationLearning = "PT. Semesta Integrasi Digital (ID:0)";
        return this;
    }
}
