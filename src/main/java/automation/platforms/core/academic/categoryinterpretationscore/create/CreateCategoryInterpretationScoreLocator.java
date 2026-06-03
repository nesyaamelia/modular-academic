package automation.platforms.core.academic.categoryinterpretationscore.create;

import automation.platforms.base.BaseLocator;

public class CreateCategoryInterpretationScoreLocator extends BaseLocator {
  public final String BUTTON_ADD_CATEGORY_INTERPRETATION_GUIDANCE = "#add-new-proficiency-btn";
  public final String INPUT_NAME_CATEGORY_INTERPRETATION_GUIDANCE = "#form-proficiency-name";
  public final String DROPDOWN_ORGANIZATION = "#form-proficiency-organization";
  public final String SWITCH_GUIDANCE_STATUS = "#form-proficiency-status";
  public final String INPUT_CATEGORY_NAME = "#form-category-name-0";
  public final String INPUT_CATEGORY_MAX_VALUE = "#form-category-max-0";
  public final String INPUT_ORGANIZATION_NAME = "#input-form-proficiency-organization";
  public final String BUTTON_ADD_CATEGORY = "#add-proficiency-category-btn";
  public final String BUTTON_CANCEL = "#upsert-proficiency-back-btn";
  public final String BUTTON_SAVE = "#upsert-proficiency-submit-btn";
  public final String TOAST_SUCCESS = "//*[contains(text(),'Panduan interpretasi berhasil disimpan.')]";
  public final String ALERT_ERROR = "//img[contains(@src,'error.svg')]";
  public final String INPUT_GRADE = "#form-category-grade-0";
  public final String SID_ORGANIZATION = "#dropdown-option-{ORGANIZATION_ID}";
  public final String BREADCRUMB_CATEGORY_INTERPRETATION_SCORE = "//a[@href='/proficiency' and contains(@class,'text-primary-600') and normalize-space()='Kategori Interpretasi Nilai']";
  public final String SIDE_MENU_CATEGORY_INTERPRETATION_SCORE = "//li[contains(@class,'font-label-5') and contains(@class,'text-primary-600') and contains(@class,'bg-primary-100') and normalize-space()='Kategori Interpretasi Nilai']";
  public final String FIRST_TABLE_DATA = "#proficiency-list-table-data-row-0 td:nth-child(2)";
}