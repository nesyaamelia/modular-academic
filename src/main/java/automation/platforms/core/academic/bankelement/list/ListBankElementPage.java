package automation.platforms.core.academic.bankelement.list;

import automation.config.GlobalVariable;
import automation.platforms.core.BaseCore;

public class ListBankElementPage extends BaseCore<ListBankElementLocator> implements ListBankElementSteps {
    @Override
    public void setupLocator() {
        mLocator = new ListBankElementLocator();
    }

    public ListBankElementPage(com.microsoft.playwright.Page page) {
        super(page);
    }

    @Override
    public boolean searchAndFilterBankElement(ListBankElementModel data){
        element.setText(mLocator.INPUT_SEARCH, data.searchKeyword);
        element.handleElementPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
        element.handleElementNotPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.BUTTON_FILTER);
        element.click(mLocator.SELECT_STATUS);
        element.handleElementPresent(mLocator.BUTTON_RESET, GlobalVariable.THREE_SEC_IN_MILLIS);
        element.click(mLocator.BUTTON_RESET);
        String result = element.getText(mLocator.BUTTON_FILTER);
        return result.contains("Status");
    }

    @Override
    public boolean goToDetailBankElement() {
        element.click(mLocator.BUTTON_DETAIL);
        element.handleElementPresent(mLocator.DETAIL_HEADER, GlobalVariable.TEN_SEC_IN_MILLIS);
        String header = element.getText(mLocator.DETAIL_HEADER);
        return header.contains("Detail Element");
    }

    @Override
    public boolean goToEditElement() {
        element.handleElementPresent(mLocator.LIST_DETAIL_ORGANIZATION_ELEMENT, GlobalVariable.TEN_SEC_IN_MILLIS);
        element.click(mLocator.EDIT_FROM_DETAIL);
        element.handleElementPresent(mLocator.INPUT_ELEMENT_NAME, GlobalVariable.TEN_SEC_IN_MILLIS);
        return element.verifyElementPresent(mLocator.INPUT_ELEMENT_NAME);
    }
}
