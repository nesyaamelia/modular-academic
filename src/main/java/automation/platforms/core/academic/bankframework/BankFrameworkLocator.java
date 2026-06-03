package automation.platforms.core.academic.bankframework;

import automation.platforms.base.BaseLocator;

public class BankFrameworkLocator extends BaseLocator {

    //create page
    public final String inputNameFramework = ("#framework-name-input");
    public final String inputCodeFramework = ("#framework-code-input");
    public final String dropdownOrganizerProvider = ("#framework-organization-dropdown");
    public final String inputDescriptionFramework = ("#framework-description-input");
    public final String toggleStatusFramework = ("#framework-status-toggle");
    public final String buttonSaveFramework = ("#save-framework-button");
    public final String buttonCancelFramework = ("#cancel-framework-button");
    public final String buttonAddBankFramework = ("#add-framework-button");
    public final String validationMessage = ("xpath=(//span[@class='grow break-words'])");

    public final String buttonCancelPopUp = ("#popup-cancel-button");
    public final String buttonSubmitPopUp = ("#popup-submit-button");

    //list page
    public final String searchInputBankFramework = ("#framework-search-field-input");
    public final String resultListBankFramework = ("xpath=//table[@id='framework-table']//tbody//tr");
    public final String rowDisplayBankFramework = ("#framework-table-pagination-pagination-row");

    public String getValidationMessage(int index) {
        return "xpath=(//span[@class='grow break-words'])[" + index + "]";
    }

    public String getResultBankFramework(int index){
        return "xpath=//table[@id='framework-table']//tbody//tr[" + index + "]";
    }

    public String getColumnNameBankFramework(int index){
        return "xpath=(//table[@id='framework-table']//tbody//tr//td[2])[" + index + "]";
    }

    public String getColumnCodeBankFramework(int index){
        return "xpath=(//table[@id='framework-table']//tbody//tr//td[3])[" + index + "]";
    }

    public String getColumnOrganizerBankFramework(int index){
        return "xpath=(//table[@id='framework-table']//tbody//tr//td[4])[" + index + "]";
    }

    public String getColumnStatusBankFramework(int index){
        return "xpath=(//table[@id='framework-table']//tbody//tr//td[5])[" + index + "]";
    }

    public String getButtonDetailBankFramework(int index){
        return "xpath=(//div[@class='w-full flex justify-center']//a[contains(@href,'detail')])[" + index + "]";
    }

    public String getButtonEditBankFramework(int index){
        return "xpath=(//div[@class='w-full flex justify-center']//a[contains(@href,'edit')])[" + index + "]";
    }
}
