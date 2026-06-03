package automation.platforms.core.academic.bankdimension.list;

import automation.config.GlobalVariable;
import automation.platforms.core.BaseCore;

public class ListBankDimensionPage extends BaseCore<ListBankDimensionLocator> implements ListBankDimensionSteps {
  @Override
  public void setupLocator() {
    mLocator = new ListBankDimensionLocator();
  }

  public ListBankDimensionPage(com.microsoft.playwright.Page page) {
    super(page);
  }

  @Override
  public boolean searchBankDimension(ListBankDimensionModel data) {
    element.setText(mLocator.SEARCH_FIELD, data.searchKeyword);
    element.handleElementPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
    element.handleElementNotPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
    return element.verifyElementPresent(mLocator.TOTAL_ROW);
  }

  @Override
  public boolean filterByStatus(ListBankDimensionModel data) {
    element.click(mLocator.FILTER_BUTTON);
    element.click(mLocator.getFilterOption(data.filterStatusOption));
    String result = element.getText(mLocator.RESET_BUTTON);
    return result.contains("Reset");
  }

  @Override
  public boolean goToDetailBankDimension() {
    element.click(mLocator.BUTTON_DETAIL);
    element.handleElementPresent(mLocator.DETAIL_HEADER, globalVariable.FIVE_SEC_IN_MILLIS);
    String header = element.getText(mLocator.DETAIL_HEADER);
    return header.contains("Detail Dimension");
  }

  @Override
  public boolean goToEditDimension() {
    element.click(mLocator.EDIT_FROM_DETAIL);
    element.handleElementPresent(mLocator.EDIT_HEADER, globalVariable.FIVE_SEC_IN_MILLIS);
    String header = element.getText(mLocator.EDIT_HEADER);
    return header.contains("Ubah Dimension");
  }
}
