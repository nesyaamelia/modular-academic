package automation.platforms.core.academic.bankcontent.edit;

import automation.config.GlobalVariable;
import automation.config.Host;
import automation.platforms.core.BaseCore;
import automation.platforms.core.academic.bankcontent.create.CreateBankContentLocator;
import com.microsoft.playwright.Page;

public class EditBankContentPage extends BaseCore<CreateBankContentLocator> implements EditBankContentSteps {

    @Override
    public void setupLocator() {
        mLocator = new CreateBankContentLocator();
    }

    public EditBankContentPage(Page page){
        super(page);
    }

    @Override
    public boolean navigateToPageEditBankContent(EditBankContentModel data){
        element.setText(mLocator.INPUT_SEARCH, data.idContent);
        element.handleElementPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
        element.handleElementNotPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
        int getTotalRow = element.getSize(mLocator.TOTAl_ROW);
        int foundIndex = -1;
        for (int i = 1; i <= getTotalRow ; i++) {
            String getIdContent = element.getText(mLocator.getIdContent(i)).replace(" ", "");
            boolean isMatch = getIdContent.equals(data.idContent);
            if (isMatch){
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1) return false;
        element.click(mLocator.getButtonEdit(foundIndex));
        return element.handleElementPresent(mLocator.INPUT_CONTENT_NAME, globalVariable.FIVE_SEC_IN_MILLIS);
    }

    @Override
    public boolean fillNameBankContent(EditBankContentModel name) {
        element.click(mLocator.INPUT_CONTENT_NAME);
        element.setText(mLocator.INPUT_CONTENT_NAME, name.nameContent);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillLearningInstruction(EditBankContentModel description) {
        element.click(mLocator.INPUT_LEARNING_INSTRUCTION);
        element.setText(mLocator.INPUT_LEARNING_INSTRUCTION, description.instructionLearning);
        return element.verifyElementPresent(mLocator.INPUT_LEARNING_INSTRUCTION);
    }

    @Override
    public boolean uploadFile(String file) {
        element.click(mLocator.REMOVE_FILE);
        element.handleElementPresent(mLocator.UPLOAD_FILE, GlobalVariable.THREE_SEC_IN_MILLIS);
        element.dropFile(mLocator.UPLOAD_FILE, file);
        element.midDelay();
        return element.verifyElementPresent(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean toggleStatusBankContent() {
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
    public boolean saveBankContent(){
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

    @Override
    public void directUrlToClient() {
        element.navigateToUrl(Host.clientHost() + "admin/content");
        element.verifyElement(mLocator.BUTTON_ADD_CONTENT);
    }
}
