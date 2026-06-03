package automation.platforms.core.academic.bankcluster;

import automation.config.GlobalVariable;
import automation.platforms.core.BaseCore;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class BankClusterPage extends BaseCore<BankClusterLocator> implements BankClusterSteps {

  public BankClusterPage(Page page) {
    super(page);
  }

  @Override
  public void setupLocator() {
    mLocator = new BankClusterLocator();
  }

  @Override
  public boolean navigateToPageBankCluster() {
    element.click(mLocator.BUTTON_ADD_BANK_CLUSTER);
    driver.waitForLoadState(LoadState.NETWORKIDLE);
    return element.verifyTextPresent("Tambah Cluster");
  }

  @Override
  public boolean fillNameBankCluster(BankClusterModel name) {
    return fillAndValidate(mLocator.INPUT_NAME_CLUSTER, name.nameCluster);
  }

  @Override
  public boolean fillCodeBankCluster(BankClusterModel code) {
    return fillAndValidate(mLocator.INPUT_CODE_CLUSTER, code.codeCluster);
  }

  @Override
  public boolean fillDescriptionBankCluster(BankClusterModel description) {
    return fillAndValidate(mLocator.INPUT_DESCRIPTION_CLUSTER, description.descriptionCluster);
  }

  @Override
  public boolean selectFramework() {
    element.click(mLocator.DROPDOWN_FRAMEWORK);
    element.click(mLocator.SELECT_ALL_FRAMEWORK);
    return element.verifyElementPresent(mLocator.DROPDOWN_FRAMEWORK);
  }

  @Override
  public boolean clickButtonAddFramework() {
    element.clickHandlerJs(mLocator.BUTTON_ADD_FRAMEWORK);
    driver.waitForLoadState(LoadState.DOMCONTENTLOADED);
    return element.verifyElementPresent(mLocator.BUTTON_ADD_FRAMEWORK);
  }

  @Override
  public boolean clickButtonSaveCluster() {
    element.click(mLocator.BUTTON_SAVE_CLUSTER);
    driver.waitForLoadState(LoadState.NETWORKIDLE);
    return element.handleElementPresent(mLocator.TOAST_SUCCESS, GlobalVariable.THREE_SEC_IN_MILLIS);
  }

  @Override
  public boolean searchBankCluster(BankClusterModel data) {
    driver.waitForLoadState(LoadState.NETWORKIDLE);
    element.click(mLocator.SEARCH_INPUT_BANK_CLUSTER);
    element.setText(mLocator.SEARCH_INPUT_BANK_CLUSTER, data.searchKeyword);
    element.handleElementPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
    element.handleElementNotPresent(mLocator.LOADING_SPINNER, globalVariable.FIVE_SEC_IN_MILLIS);
    return element.verifyElementPresent(mLocator.RESULT_SEARCH);
  }

  @Override
  public boolean filterByActiveStatus() {
    element.click(mLocator.BUTTON_FILTER);
    element.click(mLocator.FILTER_ACTIVE);
    return element.verifyElementPresent(mLocator.BUTTON_RESET);
  }

  @Override
  public boolean filterByInactiveStatus() {
    element.click(mLocator.BUTTON_FILTER);
    driver.waitForLoadState();
    element.click(mLocator.FILTER_INACTIVE);
    return element.verifyElementPresent(mLocator.BUTTON_RESET);
  }

  @Override
  public boolean clickButtonResetFilter() {
    element.handleElementPresent(mLocator.BUTTON_RESET, GlobalVariable.THREE_SEC_IN_MILLIS);
    element.click(mLocator.BUTTON_RESET);
    return element.verifyElementNotPresent(mLocator.BUTTON_RESET);
  }

  @Override
  public boolean clickButtonDetail() {
    driver.waitForLoadState(LoadState.NETWORKIDLE);
    element.click(mLocator.BUTTON_DETAIL_CLUSTER);
    driver.waitForLoadState(LoadState.DOMCONTENTLOADED);
    return element.handleElementPresent(mLocator.TITLE_DETAIL_PAGE, GlobalVariable.THREE_SEC_IN_MILLIS);
  }

  public boolean clickButtonEdit() {
    element.clickHandlerJs(mLocator.BUTTON_EDIT_CLUSTER);
    driver.waitForLoadState(LoadState.NETWORKIDLE);
    return element.handleElementPresent(mLocator.TITLE_EDIT_PAGE, GlobalVariable.THREE_SEC_IN_MILLIS);
  }

  @Override
  public boolean toggleStatusCluster() {
    element.click(mLocator.TOGGLE_STATUS_CLUSTER);
    element.handleElementPresent(mLocator.POPUP_STATUS, 3000);
    element.click(mLocator.BUTTON_SUBMIT_POPUP);
    return element.handleElementPresent(mLocator.BUTTON_SAVE_CLUSTER, GlobalVariable.THREE_SEC_IN_MILLIS);
  }

  @Override
  public boolean toggleStatusRelationFramework() {
    element.scrollToElement(mLocator.TOGGLE_RELATION_FRAMEWORK);
    element.click(mLocator.TOGGLE_RELATION_FRAMEWORK);
    element.handleElementPresent(mLocator.POPUP_STATUS, 3000);
    element.click(mLocator.BUTTON_SUBMIT_POPUP_RELATION_FRAMEWORK);
    return element.handleElementPresent(mLocator.BUTTON_SAVE_CLUSTER, GlobalVariable.THREE_SEC_IN_MILLIS);
  }

  @Override
  public boolean saveEditCluster() {
    element.click(mLocator.BUTTON_SAVE_CLUSTER);
    element.handleElementPresent(mLocator.POPUP_EDIT_CONFIRMATION, GlobalVariable.THREE_SEC_IN_MILLIS);
    element.click(mLocator.BUTTON_SAVE_POPUP);
    return element.handleElementPresent(mLocator.TOAST_SUCCESS_EDIT, GlobalVariable.THREE_SEC_IN_MILLIS);
  }

  @Override
  public boolean saveClusterExpectingError() {
    element.clickHandlerJs(mLocator.BUTTON_SAVE_CLUSTER);
    return element.verifyElementPresent(mLocator.ALERT_ERROR);
  }

  @Override
  public boolean leavingPageWithoutSaving() {
    element.click(mLocator.BUTTON_CANCEL);
    element.handleElementPresent(mLocator.POPUP_LEAVE_PAGE, GlobalVariable.TWO_SEC_IN_MILLIS);
    element.click(mLocator.BUTTON_LEAVE_PAGE);
    return element.handleElementPresent(mLocator.BUTTON_ADD_BANK_CLUSTER, globalVariable.FIVE_SEC_IN_MILLIS);
  }

  @Override
  public boolean stayOnThePage() {
    element.click(mLocator.BUTTON_CANCEL);
    element.handleElementPresent(mLocator.POPUP_LEAVE_PAGE, GlobalVariable.TWO_SEC_IN_MILLIS);
    element.click(mLocator.BUTTON_STAY_ON_THE_PAGE);
    return element.handleElementPresent(mLocator.BUTTON_SAVE_CLUSTER, globalVariable.FIVE_SEC_IN_MILLIS);
  }

  private boolean fillAndValidate(String locator, String value) {
    driver.waitForLoadState(LoadState.NETWORKIDLE);
    element.setText(locator, value);
    return element.getTextFromInput(locator).equals(value);
  }
}
