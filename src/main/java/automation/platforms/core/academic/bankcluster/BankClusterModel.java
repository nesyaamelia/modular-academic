package automation.platforms.core.academic.bankcluster;

import automation.helper.RandomNumber;
import automation.helper.StringHelper;
import automation.platforms.base.BaseModel;

public class BankClusterModel extends BaseModel {

    public String searchKeyword;
    public String searchBy;
    public String nameCluster;
    public String codeCluster;
    public String descriptionCluster;
    public int randomNumber = RandomNumber.getRandomInteger(1, 1000);

    public BankClusterModel generateValidDataCluster() {
        nameCluster =  "[Automation] Bank Cluster " + randomNumber;
        codeCluster = "CL-" + randomNumber;
        descriptionCluster =  StringHelper.generateRandomLowercase(200);
        return this;
    }

    public BankClusterModel generateInvalidDataCluster(){
        nameCluster = "[Automation] Bank Cluster " + StringHelper.generateRandomLowercase(75);
        codeCluster = "CL" + "-" + StringHelper.generateRandomUppercase(28);
        descriptionCluster =  StringHelper.generateRandomLowercase(501);
        return this;
    }

    public BankClusterModel searchByValidNameCluster() {
        BankClusterModel data = new BankClusterModel();
        data.searchBy = "name";
        data.searchKeyword = "[Automation] Bank Cluster 22";
        return data;
    }

    public BankClusterModel searchByValidId() {
        BankClusterModel data = new BankClusterModel();
        data.searchBy = "id";
        data.searchKeyword = "162";
        return data;
    }

    public BankClusterModel editInvalidNameClusterEmpty() {
        nameCluster = "";
        return this;
    }

    public BankClusterModel editInvalidCodeClusterSpecialChars(){
        codeCluster = "CL - @#!$%^&*()_+|}{:?><,./;'[]\\=-`~";
        return this;
    }

    public BankClusterModel generateDataClusterMaximumLength(){
        nameCluster = "[Automation] Bank Cluster " + StringHelper.generateRandomLowercase(74);
        codeCluster = "CL-" + StringHelper.generateRandomUppercase(27);
        descriptionCluster =  StringHelper.generateRandomLowercase(500);
        return this;
    }
}
