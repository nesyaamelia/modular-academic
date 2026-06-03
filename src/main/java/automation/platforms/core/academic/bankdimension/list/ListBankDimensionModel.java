package automation.platforms.core.academic.bankdimension.list;

import automation.platforms.base.BaseModel;

public class ListBankDimensionModel extends BaseModel {
    public String searchKeyword;
    public String filterStatusOption;

    public ListBankDimensionModel searchByValidId(){
        searchKeyword = "89";
        return this;
    }

    public ListBankDimensionModel searchByValidName(){
        searchKeyword = "Dimensi Analyst";
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
