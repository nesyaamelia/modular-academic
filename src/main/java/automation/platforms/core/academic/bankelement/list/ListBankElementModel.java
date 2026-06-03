package automation.platforms.core.academic.bankelement.list;

import automation.platforms.base.BaseModel;

public class ListBankElementModel extends BaseModel {
    public String searchKeyword;

    public ListBankElementModel searchByValidKeyword(){
       searchKeyword = System.getenv().getOrDefault("TEST_ELEMENT_ID", "1");
       return this;
    }

    public ListBankElementModel searchByValidKeywordOrganizationElement(){
        searchKeyword = System.getenv().getOrDefault("TEST_ELEMENT_ID", "1");
        return this;
    }
}
