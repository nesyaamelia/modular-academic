package automation.platforms.core.academic.banktypeactivity.list;

import automation.config.GlobalVariable;
import automation.config.Host;
import automation.platforms.core.BaseCore;
import com.microsoft.playwright.Page;

public class ListBankTypeActivityPage extends BaseCore<ListBankTypeActivityLocator> implements ListBankTypeActivitySteps {

    @Override
    public void setupLocator() {
        mLocator = new ListBankTypeActivityLocator();
    }

    public ListBankTypeActivityPage(Page page){
        super(page);
    }

    @Override
    public boolean searchActivityType(ListBankTypeActivityModel data) {
        element.setText(mLocator.INPUT_SEARCH, data.searchKeyword);
        element.handleElementPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
        element.handleElementNotPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
        boolean isEmpty = element.handleElementPresent(mLocator.EMPTY_STATE, GlobalVariable.TWO_SEC_IN_MILLIS);
        int totalRow = isEmpty ? 0 : element.getSize(mLocator.TOTAL_ROW);
        boolean isFound = false;
        for (int i = 1; i <= totalRow; i++) {
            String actualValue = element.getText(mLocator.getRowResult(data.searchBy, i));
            if (actualValue.equals(data.searchKeyword)) {
                isFound = true;
                break;
            }
        }
        return isFound == data.isSuccessSearch;
    }

    @Override
    public boolean filterByChips(ListBankTypeActivityModel data){
        element.setDelay(globalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.filterByChips(data.filterName));
        element.click(mLocator.getFilterOption(data.filterOption));
        String result = element.getText(mLocator.BUTTON_RESET);
        return result.contains("Reset");
    }

    @Override
    public boolean advancedFilter(ListBankTypeActivityModel data){
        element.click(mLocator.BUTTON_FILTER_GENERAL);
        element.handleElementPresent(mLocator.MODAL_FILTER, globalVariable.FIVE_SEC_IN_MILLIS);
        if (data.filterWithSearch){
            element.setText(mLocator.searchAdvancedFilter(data.filterLabel), data.searchValue);
            element.handleElementPresent(mLocator.advancedFilter(data.filterLabel, data.filterName), globalVariable.FIVE_SEC_IN_MILLIS);
            return true;
        }
        element.click(mLocator.advancedFilter(data.filterLabel, data.filterName));
        element.handleElementPresent(mLocator.BUTTON_APPLY, globalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.BUTTON_APPLY);
        String result = element.getText(mLocator.BUTTON_RESET);
        return result.contains("Reset");
    }

    @Override
    public boolean detailActivityType(){
        element.click(mLocator.BUTTON_DETAIL);
        boolean isModalOpen = element.handleElementPresent(mLocator.BUTTON_CLOSE_MODAL, globalVariable.FIVE_SEC_IN_MILLIS);
        if (isModalOpen){
            element.click(mLocator.BUTTON_CLOSE_MODAL);
        }
        return isModalOpen;
    }

    @Override
    public void directUrlToClient() {
        element.navigateToUrl(Host.clientHost() + "admin/activity-type");
        element.verifyElement(mLocator.TITLE_PAGE);
    }
}
