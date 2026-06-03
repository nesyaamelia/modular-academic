package automation.platforms.core.academic.banktypeactivity.create;

import automation.config.GlobalVariable;
import automation.config.Host;
import automation.platforms.core.BaseCore;
import com.microsoft.playwright.Page;

public class CreateBankTypeActivityPage extends BaseCore<CreateBankTypeActivityLocator>
    implements CreateBankTypeActivitySteps {
  @Override
  public void setupLocator() {
    mLocator = new CreateBankTypeActivityLocator();
  }

  public CreateBankTypeActivityPage(Page page) {
    super(page);
  }

  @Override
  public boolean navigateToPageBankTypeActivity() {
    element.click(mLocator.BUTTON_ADD_ACTIVITY);
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    return element.verifyTextPresent("Tambah Jenis Aktivitas");
  }

  @Override
  public boolean fillNameBankTypeActivity(CreateBankTypeActivityModel name) {
    element.click(mLocator.INPUT_NAME_ACTIVITY);
    element.setText(mLocator.INPUT_NAME_ACTIVITY, name.nameActivity);
    return element.isClickable(mLocator.BUTTON_SAVE);
  }

  @Override
  public boolean fillCategoryBankTypeActivity(CreateBankTypeActivityModel category) {
    element.click(mLocator.INPUT_CATEGORY_ACTIVITY);
    element.click(mLocator.selectCategoryActivity(category.categoryActivity));
    String result = element.getText(mLocator.INPUT_CATEGORY_ACTIVITY);
    return result.contains(category.categoryActivity);
  }

  @Override
  public boolean fillContentLearningBankTypeActivity(CreateBankTypeActivityModel contentLearning) {
    element.click(mLocator.INPUT_CONTENT_LEARNING);
    element.click(mLocator.SELECT_CONTENT_LEARNING);
    return element.handleElementPresent(mLocator.TOGGLE_STATUS, GlobalVariable.THREE_SEC_IN_MILLIS);
  }

  @Override
  public boolean toggleStatusBankTypeActivity() {
    element.clickBlankSpace();
    element.click(mLocator.TOGGLE_STATUS);
    element.handleElementPresent(mLocator.POPUP_STATUS, 3000);
    element.click(mLocator.SUBMIT_NONACTIVE);
    return element.handleElementPresent(mLocator.BUTTON_SAVE, GlobalVariable.THREE_SEC_IN_MILLIS);
  }

  @Override
  public boolean saveBankTypeActivity() {
    element.clickHandlerJs(mLocator.BUTTON_SAVE);

    for (int i = 0; i < 10; i++) {
      if (element.verifyElementPresent(mLocator.TOAST_SUCCESS))
        return true;
      if (element.verifyElementPresent(mLocator.ALERT_ERROR))
        return false;
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
  public boolean leavePageBankTypeActivity() {
    element.click(mLocator.BUTTON_CANCEL);
    element.handleElementPresent(mLocator.POPUP_LEAVE_PAGE, GlobalVariable.TWO_SEC_IN_MILLIS);
    element.click(mLocator.BUTTON_SUBMIT_POPUP);
    return element.handleElementPresent(mLocator.BUTTON_ADD_ACTIVITY, globalVariable.FIVE_SEC_IN_MILLIS);
  }

  @Override
  public boolean stayOnPageBankTypeActivity() {
    element.click(mLocator.BUTTON_CANCEL);
    element.handleElementPresent(mLocator.POPUP_LEAVE_PAGE, GlobalVariable.TWO_SEC_IN_MILLIS);
    element.click(mLocator.BUTTON_CANCEL_POPUP);
    return element.verifyElementPresent(mLocator.INPUT_NAME_ACTIVITY);
  }

  @Override
  public void directUrlToClient() {
    element.navigateToUrl(Host.clientHost() + "admin/activity-type");
    element.verifyElement(mLocator.TITLE_PAGE);
  }
}
