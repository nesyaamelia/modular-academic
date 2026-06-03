package automation.platforms.core.academic.bankelement.create;

import automation.platforms.base.BaseModel;

import java.util.Random;

public class CreateBankElementModel extends BaseModel {
    public String descriptionElement;
    Random random = new Random();

    private String randomNumber() {
        return String.valueOf(random.nextInt(1000));
    }

    public String validNameElement() {
        return "Bank Element " + randomNumber();
    }

    public String validCodeElement() {
        return "EL-" + randomNumber();
    }

    public CreateBankElementModel validDescriptionElementMaster() {
        descriptionElement = "Element Master for Automation Testing";
        return this;
    }

    public CreateBankElementModel validDescriptionElementOrganization() {
        descriptionElement = "Element Organisasi for Automation Testing";
        return this;
    }

    public String invalidNameElementLongChars(){
        return "General Element Master 1 - Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed neque tortor, commodo nec eros dictum, consectetur rhoncus erat" + randomNumber();
    }

    public String invalidCodeElementLongChars(){
        return "GEM-01 - Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed neque tortor, commodo nec eros dictum, consectetur rhoncus erat" + randomNumber();
    }

    public CreateBankElementModel invalidDescriptionElementLongChars(){
        descriptionElement = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed neque tortor, commodo nec eros dictum, consectetur rhoncus erat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed neque tortor, commodo nec eros dictum, consectetur rhoncus erat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed neque tortor, commodo nec eros dictum, consectetur rhoncus erat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed neque tortor, commodo nec eros dictum, consectetur rhoncus erat";
        return this;
    }

    public String sameNameElement(){
        return "Automation Element";
    }

    public String sameCodeElement(){
        return "EL-AUTOMATION-01";
    }

    public String specialCharsCodeElement(){
        return "GEM-01#$^#";
    }
}
