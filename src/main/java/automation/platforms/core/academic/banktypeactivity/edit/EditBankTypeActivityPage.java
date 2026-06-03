package automation.platforms.core.academic.banktypeactivity.edit;

import automation.config.GlobalVariable;
import automation.config.Host;
import automation.platforms.core.BaseCore;
import automation.platforms.core.academic.banktypeactivity.create.CreateBankTypeActivityLocator;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.List;

public class EditBankTypeActivityPage extends BaseCore<CreateBankTypeActivityLocator> implements EditBankTypeActivitySteps {
    @Override
    public void setupLocator() {
        mLocator = new CreateBankTypeActivityLocator();
    }

    public EditBankTypeActivityPage(Page page){
        super(page);
    }

    @Override
    public boolean navigateToPageEditBankTypeActivity(EditBankTypeActivityModel data){
        element.setText(mLocator.INPUT_SEARCH, data.idActivity);
        element.handleElementPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
        element.handleElementNotPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
        int getTotalRow = element.getSize(mLocator.TOTAl_ROW);
        int foundIndex = -1;
        for (int i = 1; i <= getTotalRow ; i++) {
            String getIdActivity = element.getText(mLocator.getIDActivity(i));
            boolean isMatch = getIdActivity.equals(data.idActivity);
            if (isMatch){
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1) return false;
        element.click(mLocator.getButtonEdit(foundIndex));
        return element.handleElementPresent(mLocator.INPUT_NAME_ACTIVITY, globalVariable.FIVE_SEC_IN_MILLIS);
    }

    @Override
    public boolean fillNameBankTypeActivity(EditBankTypeActivityModel name) {
        element.click(mLocator.INPUT_NAME_ACTIVITY);
        element.clearText(mLocator.INPUT_NAME_ACTIVITY);
        element.setText(mLocator.INPUT_NAME_ACTIVITY, name.nameActivity);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean fillCategoryBankTypeActivity(EditBankTypeActivityModel category) {
        String categoryName;
        if (category.categoryActivity.equals("Random")){
            categoryName = getRandomCategoryActivity();
        } else {
            categoryName = category.categoryActivity;
        }
        element.click(mLocator.INPUT_CATEGORY_ACTIVITY);
        element.click(mLocator.selectCategoryActivity(categoryName));
        String result = element.getText(mLocator.INPUT_CATEGORY_ACTIVITY);
        return result.contains(categoryName);
    }

    @Override
    public boolean fillContentLearningBankTypeActivity(EditBankTypeActivityModel contentLearning) {
        if (!contentLearning.isAddAction){
            if(contentLearning.isSingleAction){
                int totalTag = element.getSize(mLocator.TOTAL_TAG_CONTENT);
                if (totalTag > 0) {
                    element.clickHandlerJs(mLocator.getTagRemoveContent(1));
                }
            } else {
                int totalTag = element.getSize(mLocator.TOTAL_TAG_CONTENT);
                for (int i = 1; i <= totalTag ; i++) {
                    element.click(mLocator.getTagRemoveContent(i));
                }
            }
            addContentLearningBankTypeActivity();
        } else {
            element.click(mLocator.INPUT_CONTENT_LEARNING);
            element.click(mLocator.SELECT_CONTENT_LEARNING);
        }
        return element.handleElementPresent(mLocator.TOGGLE_STATUS, GlobalVariable.THREE_SEC_IN_MILLIS);
    }

    private void addContentLearningBankTypeActivity(){
        int totalTag = element.getSize(mLocator.TOTAL_TAG_CONTENT);
        if (totalTag > 0) return;
        element.click(mLocator.INPUT_CONTENT_LEARNING);
        element.click(mLocator.SELECT_CONTENT_LEARNING);
    }

    @Override
    public boolean toggleStatusBankTypeActivity() {
        element.clickBlankSpace();
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
    public boolean saveEditBankTypeActivity() {
        element.clickHandlerJs(mLocator.BUTTON_SAVE);
        element.handleElementPresent(mLocator.POPUP_EDIT_CONFIRMATION, GlobalVariable.THREE_SEC_IN_MILLIS);
        element.click(mLocator.BUTTON_SAVE_POPUP);

        for (int i = 0; i < 10; i++) {
            if (element.verifyElementPresent(mLocator.TOAST_SUCCESS_EDIT)) return true;
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
    public boolean clearAllField(){
        element.click(mLocator.INPUT_NAME_ACTIVITY);
        element.clearText(mLocator.INPUT_NAME_ACTIVITY);
        element.click(mLocator.INPUT_CATEGORY_ACTIVITY);
        element.clearText(mLocator.INPUT_CATEGORY_ACTIVITY);
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public void directUrlToClient() {
        element.navigateToUrl(Host.clientHost() + "admin/activity-type");
        element.verifyElement(mLocator.TITLE_PAGE);
    }

    private String getRandomCategoryActivity(){
        element.click(mLocator.INPUT_CATEGORY_ACTIVITY);
        String getSelectedOption = element.getText(mLocator.SELECTED_OPTION);
        int totalOption = element.getSize(mLocator.TOTAL_OPTION);
        List<String> options = new ArrayList<>();
        for (int i = 1; i <= totalOption ; i++) {
            String getOption = element.getText(mLocator.getIndexOptionCategory(i));
            options.add(getOption);
        }
        String result = "";
        for (String option : options) {
            if (!option.equals(getSelectedOption)) {
                result = option;
                break;
            }
        }
        return result;
    }
}
