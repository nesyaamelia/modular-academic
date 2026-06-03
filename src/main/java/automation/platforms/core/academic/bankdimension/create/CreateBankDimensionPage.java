package automation.platforms.core.academic.bankdimension.create;

import automation.config.GlobalVariable;
import automation.platforms.core.BaseCore;

public class CreateBankDimensionPage extends BaseCore<CreateBankDimensionLocator> implements CreateBankDimensionSteps {
    @Override
    public void setupLocator() {
        mLocator = new CreateBankDimensionLocator();
    }

    public CreateBankDimensionPage(com.microsoft.playwright.Page page) {
        super(page);
    }

    @Override
    public boolean navigateToPageBankDimension(){
        element.click(mLocator.BUTTON_ADD_NEW_DIMENSION);
        element.midDelay();
        return element.verifyTextPresent("Tambah Dimension");
    }

    @Override
    public boolean fillNameBankDimension(String name) {
        element.click(mLocator.INPUT_NAME_DIMENSION);
        element.setText(mLocator.INPUT_NAME_DIMENSION, name);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillCodeBankDimension(String code) {
        element.click(mLocator.INPUT_CODE_DIMENSION);
        element.setText(mLocator.INPUT_CODE_DIMENSION, code);
        return element.handleElementPresent(mLocator.BUTTON_SAVE, GlobalVariable.THREE_SEC_IN_MILLIS);
    }

    @Override
    public boolean fillDescriptionBankDimension(CreateBankDimensionModel code) {
        element.click(mLocator.INPUT_DESCRIPTION_DIMENSION);
        element.setText(mLocator.INPUT_DESCRIPTION_DIMENSION, code.descriptionDimension);
        return element.verifyElementPresent(mLocator.INPUT_DESCRIPTION_DIMENSION);
    }

    @Override
    public boolean fillOrganizationDimension(CreateBankDimensionModel data){
        element.click(mLocator.FIELD_ORGANIZATION);
        element.setText(mLocator.INPUT_ORGANIZATION, data.nameOrganization);
        element.click(mLocator.SELECT_ORGANIZATION);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean selectElement(){
        element.click(mLocator.INPUT_ELEMENT);
        element.click(mLocator.SELECT_ELEMENT);
        element.clickBlankSpace();
        element.click(mLocator.ADD_ELEMENT);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean searchAndSelectMultipleElement(CreateBankDimensionModel data){
        element.click(mLocator.INPUT_ELEMENT);
        element.setText(mLocator.SEARCH_ELEMENT, data.searchElement);
        element.click(mLocator.SELECT_MULTIPLE_ELEMENT);
        element.clickBlankSpace();
        element.click(mLocator.ADD_ELEMENT);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean saveBankDimension(){
        element.clickHandlerJs(mLocator.BUTTON_SAVE);

        for (int i = 0; i < 10; i++) {
            if (element.handleElementPresent(mLocator.TOAST_SUCCESS, globalVariable.FIVE_SEC_IN_MILLIS)) return true;
            if (element.handleElementPresent(mLocator.ALERT_ERROR, globalVariable.FIVE_SEC_IN_MILLIS)) return false;
        }
        return false;
    }
}
