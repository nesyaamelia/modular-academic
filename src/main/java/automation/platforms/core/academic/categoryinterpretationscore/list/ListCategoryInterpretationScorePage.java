package automation.platforms.core.academic.categoryinterpretationscore.list;

import automation.config.GlobalVariable;
import automation.config.Host;
import automation.platforms.core.BaseCore;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class ListCategoryInterpretationScorePage extends BaseCore<ListCategoryInterpretationScoreLocator> implements ListCategoryInterpretationScoreSteps {

  @Override
  public void setupLocator() {
    mLocator = new ListCategoryInterpretationScoreLocator();
  }

  public ListCategoryInterpretationScorePage(Page page){
    super(page);
  }

  public boolean fillSearchBarInput(ListCategoryInterpretationScoreModel name){
    fillAndValidate(mLocator.SEARCH_BAR, name.searchName);
    boolean nameFound = element.verifyTextPresent("[Automation] Interpretasi Nilai 65");
    fillAndValidate(mLocator.SEARCH_BAR, name.searchId);
    boolean IdFound = element.verifyTextPresent("15");
    element.click(mLocator.BUTTON_FILTER_RESET);
    return nameFound && IdFound;
  }

  public boolean useFilterOrganization(){
    element.setDelay(globalVariable.FIVE_SEC_IN_MILLIS);
    element.click(mLocator.BUTTON_FILTER_ORGANIZATION);
    fillAndValidate(mLocator.SEARCH_BAR_FILTER_ORGANIZATION, "PT. Semesta Integrasi Digital");
    element.setDelay(globalVariable.FIVE_SEC_IN_MILLIS);
    element.click(mLocator.RADIO_OWNER_ORGANIZATION_ID);
    return element.verifyTextPresent("PT. Semesta Integrasi Digital");
  }

  public boolean useFilterStatus(){
    element.click(mLocator.BUTTON_FILTER_STATUS);
    element.click(mLocator.STATUS_NOT_ACTIVE);
    return  element.verifyTextPresent("Tidak Aktif");
  }

  public boolean redirectFromSlugLink(){
    try {
            driver.navigate(Host.coreHost() + "proficiency/detail/15");
            driver.waitForTimeout(3000);
            driver.waitForLoadState(LoadState.DOMCONTENTLOADED);

            String getCurrentUrl = driver.url();

            return getCurrentUrl.contains("proficiency/detail/15");
        } catch (Exception e) {
            System.err.println("Failed to navigate to menu: " + e.getMessage());
            return false;
        }
  }

  public boolean redirectFromList(){
    String firstTableData = element.getText(mLocator.FIRST_TABLE_DATA);
    element.click(mLocator.BUTTON_DETAIL_PAGE);
    element.setDelay(globalVariable.FIVE_SEC_IN_MILLIS);
    return element.verifyTextPresent(firstTableData);
  }

  public void directUrlToClient() {
    element.navigateToUrl(Host.clientHost() + "admin/proficiency");
    element.verifyElement(mLocator.SEARCH_BAR);
  }

  private boolean fillAndValidate(String locator, String value) {
    driver.waitForLoadState(LoadState.NETWORKIDLE);
    element.setText(locator, value);
    return element.getTextFromInput(locator).equals(value);
  }
}
