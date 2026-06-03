package automation.platforms.core.academic.bankcontent.create;

import automation.config.GlobalVariable;
import automation.config.Host;
import automation.platforms.core.BaseCore;

public class CreateBankContentPage extends BaseCore<CreateBankContentLocator> implements CreateBankContentSteps {
    @Override
    public void setupLocator() {
        mLocator = new CreateBankContentLocator();
    }

    public CreateBankContentPage(com.microsoft.playwright.Page page) {
        super(page);
    }

    @Override
    public boolean navigateToPageBankContent(){
        element.click(mLocator.BUTTON_ADD_CONTENT);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return element.verifyTextPresent("Tambah Konten Belajar");
    }

    @Override
    public boolean fillNameBankContent(CreateBankContentModel name) {
        element.click(mLocator.INPUT_CONTENT_NAME);
        element.setText(mLocator.INPUT_CONTENT_NAME, name.nameContentLearning);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillContentLearning(CreateBankContentModel content) {
        element.click(mLocator.INPUT_CONTENT_LEARNING);
        element.click(mLocator.selectContentLearning(content.contentLearning));
        String result = element.getText(mLocator.INPUT_CONTENT_LEARNING);
        return result.contains(content.contentLearning);
    }

    @Override
    public boolean uploadFile(String file) {
        element.dropFile(mLocator.UPLOAD_FILE, file);
        element.midDelay();
        return element.verifyElementPresent(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillLinkVirtual(String link){
        element.click(mLocator.INPUT_LINK_VIRTUAL);
        element.setText(mLocator.INPUT_LINK_VIRTUAL, link);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillLearningInstruction(CreateBankContentModel description) {
        element.click(mLocator.INPUT_LEARNING_INSTRUCTION);
        element.setText(mLocator.INPUT_LEARNING_INSTRUCTION, description.instructionalLearning);
        return element.verifyElementPresent(mLocator.INPUT_LEARNING_INSTRUCTION);
    }

    @Override
    public boolean addBehavioralObjective(){
        element.click(mLocator.BUTTON_ADD_BEHAVIOR);
        element.handleElementPresent(mLocator.MODAL_ADD_BEHAVIOR, GlobalVariable.THREE_SEC_IN_MILLIS);
        element.click(mLocator.SELECT_BEHAVIOR);
        element.click(mLocator.BUTTON_ADD_BEHAVIOR_MODAL);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean toggleStatus(){
        element.scrollToElement(mLocator.TOGGLE_STATUS);
        element.click(mLocator.TOGGLE_STATUS);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean saveBankContentLearning(){
        element.clickHandlerJs(mLocator.BUTTON_SAVE);

        for (int i = 0; i < 10; i++) {
            if (element.handleElementPresent(mLocator.TOAST_SUCCESS, globalVariable.FIVE_SEC_IN_MILLIS)) return true;
            if (element.handleElementPresent(mLocator.ALERT_ERROR, globalVariable.FIVE_SEC_IN_MILLIS)) return false;
        }
        return false;
    }

    @Override
    public boolean fillOrganization(CreateBankContentModel organization) {
        element.click(mLocator.FIELD_ORGANIZATION);
        element.setText(mLocator.INPUT_ORGANIZATION, organization.organizationLearning);
        element.click(mLocator.selectOrganization(organization.organizationLearning));
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public void directUrlToClient() {
        element.navigateToUrl(Host.clientHost() + "admin/content");
        element.verifyElement(mLocator.BUTTON_ADD_CONTENT);
    }
}
