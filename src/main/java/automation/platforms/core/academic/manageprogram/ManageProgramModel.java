package automation.platforms.core.academic.manageprogram;

import automation.platforms.base.BaseModel;

public class ManageProgramModel extends BaseModel {

    public String searchKeyword;
    public String filterName;
    public String filterLabel;
    public String filterOption;
    public String searchOption;

    public ManageProgramModel searchByValidName(){
        searchKeyword = System.getenv().getOrDefault("TEST_PROGRAM_NAME", "[Automation] Test Program");
        return this;
    }

    public ManageProgramModel searchByInvalidId(){
        searchKeyword = System.getenv().getOrDefault("TEST_PROGRAM_ID", "1");
        return this;
    }

    public ManageProgramModel filterByOrganization(){
        filterName = "Organisasi Penyedia";
        searchOption = "Lembaga QA 1";
        filterOption = "Lembaga QA 1 (ID: 437)";
        return this;
    }

    public ManageProgramModel filterByStatus(){
        filterName = "Status";
        filterOption = "Aktif";
        return this;
    }
}
