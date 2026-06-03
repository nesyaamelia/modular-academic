package automation.platforms.core.academic.banktypeactivity.list;

import automation.platforms.base.BaseModel;

public class ListBankTypeActivityModel extends BaseModel {

    public String searchKeyword;
    public String filterName;
    public String filterLabel;
    public boolean filterWithSearch = false;
    public String searchValue;
    public String searchBy;
    public boolean isSuccessSearch = true;
    public String filterOption;

    public ListBankTypeActivityModel searchByValidId(){
        ListBankTypeActivityModel data = new ListBankTypeActivityModel();
        data.searchKeyword = System.getenv().getOrDefault("TEST_ACTIVITY_TYPE_ID", "1");
        data.searchBy = "id";
        return data;
    }

    public ListBankTypeActivityModel searchByInvalidId(){
        ListBankTypeActivityModel data = new ListBankTypeActivityModel();
        data.searchKeyword = ")#(@)";
        data.searchBy = "id";
        data.isSuccessSearch = false;
        return data;
    }

    public ListBankTypeActivityModel searchByValidNameActivity(){
        ListBankTypeActivityModel data = new ListBankTypeActivityModel();
        data.searchKeyword = System.getenv().getOrDefault("TEST_ACTIVITY_TYPE_NAME", "[Automation] Test Type Activity");
        data.searchBy = "name";
        return data;
    }

    public ListBankTypeActivityModel searchByInvalidNameActivity(){
        ListBankTypeActivityModel data = new ListBankTypeActivityModel();
        data.searchKeyword = "#)@(#";
        data.searchBy = "name";
        data.isSuccessSearch = false;
        return data;
    }

    public ListBankTypeActivityModel filterByOrganization(){
        ListBankTypeActivityModel data = new ListBankTypeActivityModel();
        data.filterName = "Organisasi";
        data.filterOption = "PT. Semesta Integrasi Digital (ID:0)";
        return data;
    }

    public ListBankTypeActivityModel filterByContentLearning(){
        ListBankTypeActivityModel data = new ListBankTypeActivityModel();
        data.filterName = "Konten Belajar";
        data.filterOption = "Audio";
        return data;
    }

    public ListBankTypeActivityModel filterByCategoryActivity(){
        ListBankTypeActivityModel data = new ListBankTypeActivityModel();
        data.filterLabel = "Kategori Aktivitas";
        data.filterName = "Materi";
        return data;
    }

    public ListBankTypeActivityModel filterByStatus(){
        ListBankTypeActivityModel data = new ListBankTypeActivityModel();
        data.filterLabel = "Status Jenis Aktivitas";
        data.filterName = "Aktif";
        return data;
    }

    public ListBankTypeActivityModel searchFilterOrganization() {
        ListBankTypeActivityModel data = new ListBankTypeActivityModel();
        data.filterLabel = "Organisasi";
        data.searchValue = "Lembaga QA 1";
        data.filterName = "Lembaga QA 1";
        data.filterWithSearch = true;
        return data;
    }

    public ListBankTypeActivityModel searchFilterContentLearning() {
        ListBankTypeActivityModel data = new ListBankTypeActivityModel();
        data.filterLabel = "Konten Belajar";
        data.searchValue = "Gambar";
        data.filterName = "Gambar";
        data.filterWithSearch = true;
        return data;
    }
}
