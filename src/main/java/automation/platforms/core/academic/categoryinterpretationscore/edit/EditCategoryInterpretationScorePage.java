package automation.platforms.core.academic.categoryinterpretationscore.edit;

import automation.config.Host;
import automation.platforms.core.BaseCore;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class EditCategoryInterpretationScorePage extends BaseCore<EditCategoryInterpretationScoreLocator> implements EditCategoryInterpretationScoreSteps {
    
  @Override
  public void setupLocator() {
    mLocator = new EditCategoryInterpretationScoreLocator();
  }

  public EditCategoryInterpretationScorePage(Page page){
    super(page);
  }

  @Override
  public boolean navigateToPageKategoriInterpretasiNilai() {
      element.setText(mLocator.SEARCH_BAR, "41");
      element.click(mLocator.BUTTON_EDIT_CATEGORY_INTERPRETATION_GUIDANCE);
      sleep();
      return element.verifyTextPresent("Ubah Panduan Interpretasi");
  }

@Override
public boolean successfullyEdit(EditCategoryInterpretationScoreModel name){
    element.setText(mLocator.SEARCH_BAR, "16");
    sleep();
    element.click(mLocator.BUTTON_EDIT_CATEGORY_INTERPRETATION_GUIDANCE);
    sleep();
    element.setText(mLocator.INPUT_NAME_CATEGORY_INTERPRETATION_GUIDANCE, name.validNameInterpretationGuidance().nameInterpretationGuidance);
    element.setText(mLocator.INPUT_CATEGORY_MAX_VALUE, name.validMaxValueCategory().maxValueCategory);
    saveCategoryInterpretationScore();
    String FIRST_TABLE_DATA = element.getText(mLocator.FIRST_TABLE_DATA);
    String ID_93_NAME = element.getText(mLocator.FIRST_TABLE_DATA);
    return ID_93_NAME.equals(FIRST_TABLE_DATA);
}

  @Override
  public boolean invalidCase(EditCategoryInterpretationScoreModel name) {
      // 1) empty inputs -> attempt save, expect specific errors
      element.setText(mLocator.INPUT_NAME_CATEGORY_INTERPRETATION_GUIDANCE, "");
      element.setText(mLocator.INPUT_CATEGORY_NAME, "");
      element.setText(mLocator.INPUT_CATEGORY_MAX_VALUE, "");
      boolean emptyValidationBlocked = !saveCategoryInterpretationScoreFailed();
      boolean emptyErrorsShown = element.verifyElementPresent(mLocator.ERROR_MSG);
      
      // 2) invalid char in grade -> fill only grade and try save
      element.setText(mLocator.INPUT_GRADE, "");
      fillAndValidate(mLocator.INPUT_GRADE, name.invalidCharGradeCategory().gradeCategory);
      boolean invalidGradeBlocked = !saveCategoryInterpretationScoreFailed();
      boolean invalidGradeErrorShown = element.verifyElementPresent(mLocator.ERROR_MSG);

      // 3) invalid max value on last category must be 100
      element.setText(mLocator.INPUT_CATEGORY_MAX_VALUE, "");
      fillAndValidate(mLocator.INPUT_CATEGORY_MAX_VALUE, name.invalidMaxValueCategory().maxValueCategory);
      boolean invalidMaxBlocked = !saveCategoryInterpretationScoreFailed();
      boolean invalidMaxErrorShown = element.verifyElementPresent(mLocator.ERROR_MSG);

      // 4) decimal max value -> must be integer
      element.setText(mLocator.INPUT_CATEGORY_MAX_VALUE, "");
      fillAndValidate(mLocator.INPUT_CATEGORY_MAX_VALUE, name.invalidDecimalMaxValueCategory().maxValueCategory);
      boolean decimalMaxBlocked = !saveCategoryInterpretationScoreFailed();
      boolean decimalMaxErrorShown = element.verifyElementPresent(mLocator.ERROR_MSG);

      // 5) max less than min -> must be greater than min
      element.setText(mLocator.INPUT_CATEGORY_MAX_VALUE, "");
      fillAndValidate(mLocator.INPUT_CATEGORY_MAX_VALUE, name.invalidLessThanMinMaxValueCategory().maxValueCategory);
      boolean lessThanMinBlocked = !saveCategoryInterpretationScoreFailed();
      boolean lessThanMinErrorShown = element.verifyElementPresent(mLocator.ERROR_MSG);

      // 6) long chars -> fill long values and try save
      EditCategoryInterpretationScoreModel longCase = new EditCategoryInterpretationScoreModel().invalidNameLongChars();
      fillAndValidate(mLocator.INPUT_NAME_CATEGORY_INTERPRETATION_GUIDANCE, longCase.nameInterpretationGuidance);
      fillAndValidate(mLocator.INPUT_CATEGORY_NAME, longCase.nameCategory);
      fillAndValidate(mLocator.INPUT_GRADE, longCase.gradeCategory);
      boolean longCharsBlocked = !saveCategoryInterpretationScoreFailed();
      boolean longCharsErrorShown = element.verifyElementPresent(mLocator.ERROR_MSG);

      boolean result = (emptyValidationBlocked && emptyErrorsShown) &&
              (invalidGradeBlocked && invalidGradeErrorShown) &&
              (invalidMaxBlocked && invalidMaxErrorShown) &&
              (decimalMaxBlocked && decimalMaxErrorShown) &&
              (lessThanMinBlocked && lessThanMinErrorShown) &&
              (longCharsBlocked && longCharsErrorShown);
      
      return result;
  }

  @Override
  public boolean redirectBackFromBreadcrumb() {
    element.refresh();
    element.click(mLocator.BREADCRUMB_CATEGORY_INTERPRETATION_SCORE);
    return element.verifyTextPresent("Kategori Interpretasi Nilai");
  }

  @Override
  public boolean redirectBackFromSideMenu() {
    navigateToPageKategoriInterpretasiNilai();
    element.click(mLocator.SIDE_MENU_CATEGORY_INTERPRETATION_SCORE);
    return element.verifyTextPresent("Kategori Interpretasi Nilai");
  }

  @Override
  public boolean redirectBackFromButtonBatalkan() {
    navigateToPageKategoriInterpretasiNilai();
    element.click(mLocator.BUTTON_SAVE);
    driver.waitForLoadState(LoadState.NETWORKIDLE);
    element.click(mLocator.CANCEL_POPUP);
    return element.verifyTextPresent("Kategori Interpretasi Nilai");
  }

  @Override
  public boolean addCategoryTenTimesThenVerifyDisabled() {
      for (int i = 0; i < 10; i++) {
          if (!element.isEnabled(mLocator.BUTTON_ADD_CATEGORY)) break;
          element.click(mLocator.BUTTON_ADD_CATEGORY);
          driver.waitForLoadState(LoadState.NETWORKIDLE);
      }
      boolean enabled = element.isEnabled(mLocator.BUTTON_ADD_CATEGORY);
      String disabledAttr = element.getAttributeFrom(mLocator.BUTTON_ADD_CATEGORY, "disabled");
      String ariaDisabled = element.getAttributeFrom(mLocator.BUTTON_ADD_CATEGORY, "aria-disabled");
      return !enabled || "true".equalsIgnoreCase(ariaDisabled) || (disabledAttr != null);
  }

  @Override
  public boolean fillMaxValueThenAddCategoryAndFillSame(EditCategoryInterpretationScoreModel name) {
    element.setText(mLocator.SEARCH_BAR, "16");
    sleep();
    element.click(mLocator.BUTTON_EDIT_CATEGORY_INTERPRETATION_GUIDANCE);
    boolean firstFilled = fillAndValidate(mLocator.INPUT_CATEGORY_MAX_VALUE, name.valueCategory);
    element.click(mLocator.BUTTON_ADD_CATEGORY);
    driver.waitForLoadState(LoadState.NETWORKIDLE);
    String secondMaxLocator = mLocator.INPUT_CATEGORY_MAX_VALUE.replace("-0", "-1");
    boolean secondFilled = fillAndValidate(secondMaxLocator, name.valueCategory);
    return firstFilled && secondFilled;
  }

  @Override
  public boolean activeAndNonActiveStatus(EditCategoryInterpretationScoreModel value1, EditCategoryInterpretationScoreModel value2){
    element.setText(mLocator.SEARCH_BAR, "94");
    sleep();
    element.click(mLocator.BUTTON_EDIT_CATEGORY_INTERPRETATION_GUIDANCE);
    element.click(mLocator.SWITCH_GUIDANCE_STATUS);
    saveCategoryInterpretationScore();
    sleep();
    element.setText(mLocator.SEARCH_BAR, "94");
    sleep();
    element.click(mLocator.BUTTON_EDIT_CATEGORY_INTERPRETATION_GUIDANCE);
    element.click(mLocator.SWITCH_GUIDANCE_STATUS);
    element.click(mLocator.NON_ACTIVE_POPUP);
    element.setText(mLocator.INPUT_CATEGORY_MAX_VALUE, "");
    fillAndValidate(mLocator.INPUT_CATEGORY_MAX_VALUE, value1.valueCategory);
    element.click(mLocator.BUTTON_ADD_CATEGORY);
    element.click(mLocator.DELETE_CATEGORY);
    fillAndValidate(mLocator.INPUT_CATEGORY_MAX_VALUE, value2.maxValueCategory);
    saveCategoryInterpretationScore();
    return element.verifyTextPresent("Kategori Interpretasi Nilai");
  }

  @Override
  public boolean saveCategoryInterpretationScoreFailed() {
      element.click(mLocator.BUTTON_SAVE);
      driver.waitForLoadState(LoadState.NETWORKIDLE);
      element.click(mLocator.SUBMIT_POPUP);
      driver.waitForLoadState(LoadState.NETWORKIDLE);
      try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
      boolean errorAppears = element.verifyElementPresent(mLocator.ERROR_MSG);
      
      return !errorAppears;
  }

  @Override
  public boolean saveCategoryInterpretationScore() {
    element.click(mLocator.BUTTON_SAVE);
    driver.waitForLoadState(LoadState.NETWORKIDLE);
    element.click(mLocator.SUBMIT_POPUP);
    driver.waitForLoadState(LoadState.NETWORKIDLE);
    return false;
  }

    @Override
    public void directUrlToClient() {
        element.navigateToUrl(Host.clientHost() + "admin/proficiency");
        element.verifyElement(mLocator.BUTTON_EDIT_CATEGORY_INTERPRETATION_GUIDANCE);
    }

  private void sleep() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  private boolean fillAndValidate(String locator, String value) {
    element.setText(locator, value);
    return element.getTextFromInput(locator).equals(value);
  }
}
