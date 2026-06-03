package automation.platforms.core.academic.bankelement.create;

import automation.config.GlobalVariable;
import automation.platforms.core.BaseCore;

public class CreateBankElementPage extends BaseCore<CreateBankElementLocator> implements CreateBankElementSteps{
    @Override
    public void setupLocator() {
        mLocator = new CreateBankElementLocator();
    }

    public CreateBankElementPage(com.microsoft.playwright.Page page) {
        super(page);
    }

    @Override
    public boolean navigateToPageBankElement(){
        element.click(mLocator.BUTTON_ADD_ELEMENT);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return element.verifyElementPresent(mLocator.INPUT_ELEMENT_NAME);
    }

    @Override
    public boolean fillNameBankElement(String name) {
        element.click(mLocator.INPUT_ELEMENT_NAME);
        element.setText(mLocator.INPUT_ELEMENT_NAME, name);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillCodeBankElement(String code) {
        element.click(mLocator.INPUT_CODE_ELEMENT);
        element.setText(mLocator.INPUT_CODE_ELEMENT, code);
        return element.handleElementPresent(mLocator.BUTTON_SAVE, GlobalVariable.THREE_SEC_IN_MILLIS);
    }

    @Override
    public boolean fillDescriptionBankElement(CreateBankElementModel code) {
        element.click(mLocator.INPUT_DESCRIPTION);
        element.setText(mLocator.INPUT_DESCRIPTION, code.descriptionElement);
        return element.verifyElementPresent(mLocator.INPUT_DESCRIPTION);
    }

    @Override
    public boolean selectCluster(){
        element.click(mLocator.INPUT_CLUSTER);
        element.click(mLocator.SELECT_CLUSTER);
        element.clickBlankSpace();
        element.click(mLocator.BUTTON_ADD_CLUSTER);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean saveBankElement(){
        element.clickHandlerJs(mLocator.BUTTON_SAVE);

        for (int i = 0; i < 10; i++) {
            if (element.verifyElementPresent(mLocator.TOAST_SUCCESS)) return true;
            if (element.verifyElementPresent(mLocator.ALERT_ERROR)) return false;
            sleep();
        }
        return false;
    }
    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public boolean leavePageBankElement() {
        element.click(mLocator.BUTTON_CANCEL);
        element.handleElementPresent(mLocator.POPUP_LEAVE_PAGE, GlobalVariable.TWO_SEC_IN_MILLIS);
        element.click(mLocator.SUBMIT_POPUP);
        return element.handleElementPresent(mLocator.BUTTON_ADD_ELEMENT, globalVariable.FIVE_SEC_IN_MILLIS);
    }
}
