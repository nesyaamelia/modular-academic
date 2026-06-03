package automation.platforms.core.academic.bankcontent.list;

import automation.platforms.base.BaseModel;

public class ListBankContentModel extends BaseModel {
    public String searchKeyword;
    public String filterName;
    public String filterLabel;
    public String filterOption;

    public ListBankContentModel searchByValidId(){
        searchKeyword = System.getenv().getOrDefault("TEST_CONTENT_ID", "1");
        return this;
    }

    public ListBankContentModel searchByValidName(){
        searchKeyword = "[Automation] Content";
        return this;
    }

    public ListBankContentModel searchByInvalidName(){
        searchKeyword = "$#()$*";
        return this;
    }

    public ListBankContentModel searchByInvalidId(){
        searchKeyword = "##@#";
        return this;
    }

    public ListBankContentModel filterByOrganization(){
        filterName = "Organisasi";
        filterOption = "PT. Semesta Integrasi Digital";
        return this;
    }

    public ListBankContentModel filterByContentLearning(){
        filterName = "Konten Belajar";
        filterOption = "Audio";
        return this;
    }

    public ListBankContentModel filterByStatus(){
        filterLabel = "Status";
        filterName = "Aktif";
        return this;
    }
}
