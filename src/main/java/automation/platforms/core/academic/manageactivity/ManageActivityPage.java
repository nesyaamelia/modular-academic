package automation.platforms.core.academic.manageactivity;

import automation.config.GlobalVariable;
import automation.platforms.core.BaseCore;

public class ManageActivityPage extends BaseCore<ManageActivityLocator> implements ManageActivitySteps {

  @Override
  public void setupLocator() {
    mLocator = new ManageActivityLocator();
  }

  public ManageActivityPage(com.microsoft.playwright.Page page) {
    super(page);
  }

  @Override
  public boolean searchManageActivity(ManageActivityModel data) {
    element.setText(mLocator.INPUT_SEARCH, data.searchKeyword);
    element.handleElementPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
    element.handleElementNotPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
    return element.verifyElementPresent(mLocator.TOTAL_ROW);
  }

  @Override
  public boolean filterByChips(ManageActivityModel data) {
    element.handleElementPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
    element.click(mLocator.filterByChips(data.filterName));
    element.click(mLocator.getFilterOption(data.filterOption));
    String result = element.getText(mLocator.BUTTON_RESET);
    return result.contains("Reset");
  }

  @Override
  public boolean advancedFilter(ManageActivityModel data) {
    element.click(mLocator.BUTTON_GLOBAL_FILTER);
    element.handleElementPresent(mLocator.MODAL_GLOBAL_FILTER, globalVariable.FIVE_SEC_IN_MILLIS);
    element.click(mLocator.advancedFilter(data.filterLabel, data.filterName));
    element.handleElementPresent(mLocator.BUTTON_APPLY_FILTER, globalVariable.FIVE_SEC_IN_MILLIS);
    element.click(mLocator.BUTTON_APPLY_FILTER);
    String result = element.getText(mLocator.BUTTON_RESET);
    return result.contains("Reset");
  }
}
