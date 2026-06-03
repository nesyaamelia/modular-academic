package automation.platforms.core.academic.bankdimension.list;

import automation.platforms.base.BaseModel;

public class ListBankDimensionModel extends BaseModel {
    public String searchKeyword;
    public String filterStatusOption;

    public ListBankDimensionModel searchByValidId(){
        searchKeyword = System.getenv().getOrDefault("TEST_DIMENSION_ID", "1");
        return this;
    }

    public ListBankDimensionModel searchByValidName(){
        searchKeyword = System.getenv().getOrDefault("TEST_DIMENSION_NAME", "[Automation] Dimensi");
        return this;
    }

    public ListBankDimensionModel filterStatusActive(){
        filterStatusOption = "Aktif";
        return this;
    }

    public ListBankDimensionModel filterStatusNonActive(){
        filterStatusOption = "Tidak Aktif";
        return this;
    }
}
