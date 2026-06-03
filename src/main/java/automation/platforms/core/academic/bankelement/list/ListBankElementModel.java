package automation.platforms.core.academic.bankelement.list;

import automation.platforms.base.BaseModel;

public class ListBankElementModel extends BaseModel {
    public String searchKeyword;

    public ListBankElementModel searchByValidKeyword(){
       searchKeyword = "1";
       return this;
    }

    public ListBankElementModel searchByValidKeywordOrganizationElement(){
        searchKeyword = "62";
        return this;
    }
}
