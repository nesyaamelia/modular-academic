package automation.platforms.core.academic.bankelement.edit;

import automation.platforms.base.BaseModel;

import java.util.Random;

public class EditBankElementModel extends BaseModel {
    public String nameElement;
    public String descriptionElement;
    public String idElement;
    Random random = new Random();

    private String randomNumber() {
        return String.valueOf(random.nextInt(1000));
    }

    public EditBankElementModel navigateToEditPage() {
        nameElement = "Automation Element";
        idElement = "68";
        return this;
    }

    public EditBankElementModel navigateToEditElementOrganizationPage() {
        idElement = "63";
        return this;
    }

    public String validNameEditMaster() {
        return "Bank Element " + randomNumber();
    }

    public String validCodeEditMaster() {
        return "ELO-" + randomNumber();
    }

    public EditBankElementModel validDescriptionElementMaster() {
        descriptionElement = "Description element edited for master";
        return this;
    }

    public String validNameEditOrganization() {
        return "Bank Element Edit " + randomNumber();
    }

    public String validCodeEditOrganization() {
        return "ELO-" + randomNumber();
    }

    public EditBankElementModel validDescriptionElementOrganization() {
        descriptionElement = "Description element edited for organization";
        return this;
    }

    public String emptyNameEditElement() {
        return "";
    }

    public String inputNameLongChars() {
        return "General Element Master 1 - Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed neque tortor, commodo nec eros dictum, consectetur rhoncus erat" + randomNumber();
    }

    public EditBankElementModel inputDescriptionWithLongChars() {
        descriptionElement = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed neque tortor, commodo nec eros dictum, consectetur rhoncus erat. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. In rhoncus in elit vel volutpat. Nulla eu vulputate odio, in maximus mi. Nunc semper tortor et facilisis dictum. Nullam condimentum bibendum mi non ultricies. Phasellus elit risus, vehicula eget ligula nec, lacinia gravida quam. Sed in viverra justo, id commodo lacus. Nunc eleifend, nunc non finibus placerat, magna tellus ullamcorper lorem, at dapibus lorem mi at eros";
        return this;
    }

    public String duplicateCodeElement() {
        return "EL-610";
    }

    public String duplicateCodeElementOrganization() {
        return "EL-246";
    }

    public String invalidCodeElement() {
        return "GEM-01#@%$&%$^";
    }
}