package automation.platforms.core.academic.categoryinterpretationscore.edit;

import automation.platforms.base.BaseLocator;

public class EditCategoryInterpretationScoreLocator extends BaseLocator {
  public final String BUTTON_EDIT_CATEGORY_INTERPRETATION_GUIDANCE = "#go-to-edit-page-0";
  public final String INPUT_NAME_CATEGORY_INTERPRETATION_GUIDANCE = "#form-proficiency-name";
  public final String SWITCH_GUIDANCE_STATUS = "//input[contains(@class,'opacity-0') and @type='checkbox']";
  public final String INPUT_CATEGORY_NAME = "#form-category-name-0";
  public final String INPUT_CATEGORY_MAX_VALUE = "#form-category-max-0";
  public final String INPUT_ORGANIZATION_NAME = "#input-form-proficiency-organization";
  public final String BUTTON_ADD_CATEGORY = "#add-proficiency-category-btn";
  public final String BUTTON_CANCEL = "#upsert-proficiency-back-btn";
  public final String BUTTON_SAVE = "#upsert-proficiency-submit-btn";
  public final String TOAST_SUCCESS = "//*[contains(text(),'Panduan interpretasi berhasil disimpan.')]";
  public final String ALERT_ERROR = "//img[contains(@src,'error.svg')]";
  public final String INPUT_GRADE = "#form-category-grade-0";
  public final String SID_ORGANIZATION = "#dropdown-option-279";
  public final String BREADCRUMB_CATEGORY_INTERPRETATION_SCORE = "//a[@href='/proficiency' and contains(@class,'text-primary-600') and normalize-space()='Kategori Interpretasi Nilai']";
  public final String SIDE_MENU_CATEGORY_INTERPRETATION_SCORE = "//li[contains(@class,'font-label-5') and contains(@class,'text-primary-600') and contains(@class,'bg-primary-100') and normalize-space()='Kategori Interpretasi Nilai']";
  public final String FIRST_TABLE_DATA = "#proficiency-list-table-data-row-0 td:nth-child(2)";
  public final String SUBMIT_POPUP = "#update-confirmation-popup #popup-submit-button";
  public final String ERROR_MSG = "//span[contains(@class,'grow break-words')]";
  public final String SEARCH_BAR = "#proficiency-search-bar-input";
  public final String CANCEL_POPUP = "#update-confirmation-popup #popup-cancel-button";
  public final String NON_ACTIVE_POPUP = "#proficiency-status-popup #popup-submit-button";
  public final String DELETE_CATEGORY = "#delete-category-btn-1";
}
