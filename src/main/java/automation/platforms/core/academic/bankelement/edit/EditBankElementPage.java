package automation.platforms.core.academic.bankelement.edit;

import automation.config.GlobalVariable;
import automation.platforms.core.BaseCore;
import automation.platforms.core.academic.bankelement.create.CreateBankElementLocator;
import com.microsoft.playwright.Page;

public class EditBankElementPage extends BaseCore<CreateBankElementLocator> implements EditBankElementSteps{
    @Override
    public void setupLocator() {
        mLocator = new CreateBankElementLocator();
    }

    public EditBankElementPage(Page page){
        super(page);
    }

    @Override
    public boolean navigateToPageEditBankElement(EditBankElementModel data){
        element.setText(mLocator.INPUT_SEARCH, data.idElement);
        element.handleElementPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
        element.handleElementNotPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
        int getTotalRow = element.getSize(mLocator.TOTAl_ROW);
        int foundIndex = -1;
        for (int i = 1; i <= getTotalRow ; i++) {
            String getIdActivity = element.getText(mLocator.getIdElement(i));
            boolean isMatch = getIdActivity.equals(data.idElement);
            if (isMatch){
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1) return false;
        element.click(mLocator.getButtonEdit(foundIndex));
        return element.handleElementPresent(mLocator.INPUT_ELEMENT_NAME, globalVariable.FIVE_SEC_IN_MILLIS);
    }

    @Override
    public boolean fillNameBankElement(String name) {
        element.click(mLocator.INPUT_ELEMENT_NAME);
        element.clearText(mLocator.INPUT_ELEMENT_NAME);
        element.setText(mLocator.INPUT_ELEMENT_NAME, name);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillCodeBankElement(String code) {
        element.click(mLocator.INPUT_CODE_ELEMENT);
        element.clearText(mLocator.INPUT_CODE_ELEMENT);
        element.setText(mLocator.INPUT_CODE_ELEMENT, code);
        return element.handleElementPresent(mLocator.BUTTON_SAVE, GlobalVariable.THREE_SEC_IN_MILLIS);
    }

    @Override
    public boolean fillDescriptionBankElement(EditBankElementModel data) {
        element.click(mLocator.INPUT_DESCRIPTION);
        element.clearText(mLocator.INPUT_DESCRIPTION);
        element.setText(mLocator.INPUT_DESCRIPTION, data.descriptionElement);
        return element.verifyElementPresent(mLocator.INPUT_DESCRIPTION);
    }

    @Override
    public boolean saveEditBankElement() {
        element.clickHandlerJs(mLocator.BUTTON_SAVE);
        element.handleElementPresent(mLocator.POPUP_EDIT_CONFIRMATION, GlobalVariable.THREE_SEC_IN_MILLIS);
        element.click(mLocator.BUTTON_SAVE_POPUP);

        for (int i = 0; i < 10; i++) {
            if (element.handleElementPresent(mLocator.TOAST_SUCCESS_EDIT, globalVariable.FIVE_SEC_IN_MILLIS)) return true;
            if (element.verifyElementPresent(mLocator.ALERT_ERROR)) return false;
        }
        return false;
    }

    @Override
    public boolean clearAllField(){
        element.click(mLocator.INPUT_ELEMENT_NAME);
        element.clearText(mLocator.INPUT_ELEMENT_NAME);
        element.click(mLocator.INPUT_CODE_ELEMENT);
        element.clearText(mLocator.INPUT_CODE_ELEMENT);
        element.click(mLocator.INPUT_DESCRIPTION);
        element.clearText(mLocator.INPUT_DESCRIPTION);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean toggleStatusBankElement(){
        String currentStatus = element.getText(mLocator.TOGGLE_STATUS);
        element.clickHandlerJs(mLocator.TOGGLE_STATUS);
        if (currentStatus.equalsIgnoreCase("Aktif")) {
            if (element.handleElementPresent(mLocator.POPUP_STATUS, GlobalVariable.THREE_SEC_IN_MILLIS)) {
                element.click(mLocator.BUTTON_SUBMIT_POPUP);
                return element.verifyElementPresent(mLocator.BUTTON_SAVE);
            } else {
                return false;
            }
        }
        return element.verifyElementPresent(mLocator.BUTTON_SAVE);
    }
}
