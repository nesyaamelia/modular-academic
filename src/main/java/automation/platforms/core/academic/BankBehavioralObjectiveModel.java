package automation.platforms.core.academic.bankbehavioralobjective;

import automation.data.User;
import automation.helper.RandomNumber;
import automation.platforms.base.BaseModel;

public class BankBehavioralObjectiveModel extends BaseModel {

    public User user = new User();
    public String filterName;
    public String filterOptionTahapPerkembangan;
    public String name;
    public String searchElement;
    public String searchBy;
    public String code;
    public String elementName;
    public String multipleElementName;
    public String searchName;
    public boolean isMultipleElement = false;
    public boolean isValidElement = false;
    public boolean isSelectAll = false;
    public boolean isValidSearch = false;
    public boolean isEmpty = false;

    public int randomNumber = RandomNumber.getRandomInteger(1, 1000);

    public String generateNameBehavioralObjective() {
        return "Bank BO " + randomNumber;
    }

    public String generateEditNameBehavioralObjective() {
        return "Edit " + randomNumber;
    }

    public String generateCodeBehavioralObject() {
        return "BO-" + randomNumber;
    }

    public String maxNameBehavioralObjective() {
        return "Automation Maksimal karakter sebanyak 500 Competences encompassing the skills related to understanding " +
                "requirements, conceptualizing solutions, planning technical approaches, and evaluating system performance " +
                "against objectives. These skills are crucial for defining what needs to be built or improved and how it " +
                "should function.panjang Competences encompassing the skills related to understanding requirements, " +
                "conceptualizing solutions, planning technical approaches. evaliasi, gosok gigi, uyee uye";
    }

    public BankBehavioralObjectiveModel filterByStatus() {
        filterName = "Aktif";
        filterOptionTahapPerkembangan = "Level 1: PAUD KB (3–4 Tahun)";
        return this;
    }

    public BankBehavioralObjectiveModel filterByTahapPerkembangan() {
        filterName = "Level 1: PAUD KB (3–4 Tahun)";
        return this;
    }

    public BankBehavioralObjectiveModel searchNameBehavioralObjective() {
        searchBy = "Name";
        name = "Bank BO";
        return this;
    }

    public BankBehavioralObjectiveModel searchIDBehavioralObjective() {
        searchBy = "ID";
        name = "94";
        return this;
    }

    public BankBehavioralObjectiveModel searchValidElement() {
        searchElement = "Data Policy";
        return this;
    }

    public BankBehavioralObjectiveModel searchEditValidElement() {
        searchElement = "Data Quality";
        return this;
    }

    public BankBehavioralObjectiveModel searchEmptyElement() {
        searchElement = "asdfghjkl!";
        return this;
    }

    public String invalidNameLongChars() {
        return name = "Competences encompassing the skills related to understanding requirements, conceptualizing solutions" +
                "planning technical approaches, and evaluating system performance against objectives. These skills are crucial for " +
                "defining what needs to be built or improved and how it should function.panjang Competences encompassing the skills " +
                "related to understanding requirements, conceptualizing solutions planning technical approaches, and evaluating system performance " +
                "against objectives. These skills are crucial for defining what needs to be built or improved and how it should function.panjang";
    }

    public String invalidNameExisting() {
        return name = "Automation BO Assessment";
    }

    public BankBehavioralObjectiveModel validData() {
        name = "Automation auto generate - " + user.password.toUpperCase();
        code = user.password.toUpperCase();
        elementName = "automation";
        return this;
    }

    public BankBehavioralObjectiveModel maxLengthWithValidData() {
        name = user.lorem;
        code = user.password.toUpperCase();
        elementName = "automation";
        return this;
    }

    public BankBehavioralObjectiveModel selectAddSameElement() {
        isMultipleElement = true;
        isValidElement = false;
        elementName = "Data Policy";
        return this;
    }

    public BankBehavioralObjectiveModel selectAllElement() {
        isSelectAll = true;
        isValidElement = false;
        return this;
    }

    public BankBehavioralObjectiveModel searchInvalidElement() {
        elementName = "@#$%^&*()";
        isValidSearch = false;
        return this;
    }

    public BankBehavioralObjectiveModel emptyData() {
        name = "";
        code = "";
        elementName = "";
        isEmpty = true;
        return this;
    }

    public BankBehavioralObjectiveModel validDataMultipleElement() {
        name = "Automation auto generate - " + user.password.toUpperCase();
        code = user.password.toUpperCase();
        elementName = "automation";
        multipleElementName = "Data Policy";
        isMultipleElement = true;
        return this;
    }

    public BankBehavioralObjectiveModel editBehavioralObjective() {
        searchName = "Automation auto generate";
        name = "Automation auto generate - " + user.password.toUpperCase();
        code = user.password.toUpperCase();
        elementName = "automation";
        return this;
    }
}
