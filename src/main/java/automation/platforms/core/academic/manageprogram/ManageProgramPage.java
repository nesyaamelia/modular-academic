package automation.platforms.core.academic.manageprogram;

import automation.config.GlobalVariable;
import automation.platforms.core.BaseCore;

public class ManageProgramPage extends BaseCore<ManageProgramLocator> implements ManageProgramSteps {

    @Override
    public void setupLocator() {
        mLocator = new ManageProgramLocator();
    }

    public ManageProgramPage(com.microsoft.playwright.Page page) {
        super(page);
    }

    @Override
    public boolean searchManageProgram(ManageProgramModel data) {
        element.setText(mLocator.INPUT_SEARCH, data.searchKeyword);
        element.handleElementPresent(mLocator.LOADING_SPINNER, GlobalVariable.FIVE_SEC_IN_MILLIS);
        element.handleElementNotPresent(mLocator.LOADING_SPINNER, GlobalVariable.FIVE_SEC_IN_MILLIS);
        return element.verifyElementPresent(mLocator.TOTAL_ROW);
    }

    @Override
    public boolean filterByChips(ManageProgramModel data) {
        element.handleElementPresent(mLocator.LOADING_SPINNER, GlobalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.filterByChips(data.filterName));
        element.setText(mLocator.SEARCH_OPTION, data.searchOption);
        element.handleElementPresent(mLocator.LOADING_SPINNER, GlobalVariable.FIVE_SEC_IN_MILLIS);
        // if search returns no result, an empty state element will be shown — stop here
        boolean isEmptyState = element.verifyElementPresent(mLocator.EMPTY_STATE_SEARCH);
        if (isEmptyState) {
            return true;
        }
        element.click(mLocator.getFilterOption(data.filterOption));
        String result = element.getText(mLocator.BUTTON_RESET);
        return result.contains("Reset");
    }

}
