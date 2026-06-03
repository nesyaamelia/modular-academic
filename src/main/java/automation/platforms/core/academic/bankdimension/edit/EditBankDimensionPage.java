package automation.platforms.core.academic.bankdimension.edit;

import automation.config.GlobalVariable;
import automation.platforms.core.BaseCore;
import automation.platforms.core.academic.bankdimension.create.CreateBankDimensionLocator;
import com.microsoft.playwright.Page;

public class EditBankDimensionPage extends BaseCore<CreateBankDimensionLocator> implements EditBankDimensionSteps {

    @Override
    public void setupLocator() {
        mLocator = new CreateBankDimensionLocator();
    }

    public EditBankDimensionPage(Page page){
        super(page);
    }

    @Override
    public boolean navigateToPageEditBankDimension(EditBankDimensionModel data){
        element.setText(mLocator.INPUT_SEARCH, data.idDimension);
        element.handleElementPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
        element.handleElementNotPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
        int getTotalRow = element.getSize(mLocator.TOTAl_ROW);
        int foundIndex = -1;
        for (int i = 1; i <= getTotalRow ; i++) {
            String getIdActivity = element.getText(mLocator.getIDActivity(i));
            boolean isMatch = getIdActivity.equals(data.idDimension);
            if (isMatch){
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1) return false;
        element.click(mLocator.getButtonEdit(foundIndex));
        return element.handleElementPresent(mLocator.INPUT_NAME_DIMENSION, globalVariable.FIVE_SEC_IN_MILLIS);
    }

    @Override
    public boolean fillNameBankDimension(EditBankDimensionModel name) {
        element.click(mLocator.INPUT_NAME_DIMENSION);
        element.clearText(mLocator.INPUT_NAME_DIMENSION);
        element.setText(mLocator.INPUT_NAME_DIMENSION, name.nameDimension);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillCodeBankDimension(EditBankDimensionModel code) {
        element.click(mLocator.INPUT_CODE_DIMENSION);
        element.clearText(mLocator.INPUT_CODE_DIMENSION);
        element.setText(mLocator.INPUT_CODE_DIMENSION, code.codeDimension);
        return element.handleElementPresent(mLocator.BUTTON_SAVE, GlobalVariable.THREE_SEC_IN_MILLIS);
    }

    @Override
    public boolean fillDescriptionBankDimension(EditBankDimensionModel code) {
        element.click(mLocator.INPUT_DESCRIPTION_DIMENSION);
        element.clearText(mLocator.INPUT_DESCRIPTION_DIMENSION);
        element.setText(mLocator.INPUT_DESCRIPTION_DIMENSION, code.descriptionDimension);
        return element.verifyElementPresent(mLocator.INPUT_DESCRIPTION_DIMENSION);
    }

    @Override
    public boolean toggleStatusRelation() {
        element.scrollToElement(mLocator.TOGGLE_STATUS_RELATION);
        String currentStatus = element.getText(mLocator.TOGGLE_STATUS_RELATION);
        element.clickHandlerJs(mLocator.TOGGLE_STATUS_RELATION);
        if (currentStatus.equalsIgnoreCase("Aktif")) {
            if (element.handleElementPresent(mLocator.POPUP_NONACTIVE_RELATION, GlobalVariable.THREE_SEC_IN_MILLIS)) {
                element.click(mLocator.BUTTON_SUBMIT_POPUP_STATUS_RELATION);
                return element.verifyElementPresent(mLocator.BUTTON_SAVE);
            } else {
                return false;
            }
        }
        return element.verifyElementPresent(mLocator.BUTTON_SAVE);
    }


    @Override
    public boolean toggleStatusBankDimension() {
        String currentStatus = element.getText(mLocator.TOGGLE_STATUS);
        element.clickHandlerJs(mLocator.TOGGLE_STATUS);
        if (currentStatus.equalsIgnoreCase("Aktif")) {
            if (element.handleElementPresent(mLocator.POPUP_STATUS, GlobalVariable.THREE_SEC_IN_MILLIS)) {
                element.click(mLocator.SUBMIT_NONACTIVE);
                return element.verifyElementPresent(mLocator.BUTTON_SAVE);
            } else {
                return false;
            }
        }
        return element.verifyElementPresent(mLocator.BUTTON_SAVE);
    }


    @Override
    public boolean saveBankDimension(){
        element.clickHandlerJs(mLocator.BUTTON_SAVE);
        if (element.handleElementPresent(mLocator.POPUP_EDIT_CONFIRMATION, GlobalVariable.THREE_SEC_IN_MILLIS)){
            element.click(mLocator.BUTTON_SAVE_POPUP);
            for (int i = 0; i < 10; i++) {
                if (element.handleElementPresent(mLocator.TOAST_SUCCESS_EDIT, globalVariable.FIVE_SEC_IN_MILLIS)) return true;
                if (element.handleElementPresent(mLocator.ALERT_ERROR, globalVariable.FIVE_SEC_IN_MILLIS)) return false;
            }
            return false;
        } else if (element.handleElementPresent(mLocator.ALERT_ERROR, globalVariable.FIVE_SEC_IN_MILLIS)) {
            return false;
        }
        return false;
    }
}
