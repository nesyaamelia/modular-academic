package automation.platforms.core.academic.bankdimension.create;

import automation.platforms.base.BaseLocator;

public class CreateBankDimensionLocator extends BaseLocator {
    public final String BUTTON_ADD_NEW_DIMENSION = "#add-dimension-btn";
    public final String INPUT_NAME_DIMENSION = "#dimension-name-input";
    public final String INPUT_CODE_DIMENSION = "#dimension-code-input";
    public final String INPUT_DESCRIPTION_DIMENSION = "#dimension-description-textarea";
    public final String INPUT_ELEMENT = "#element-dropdown";
    public final String SELECT_ELEMENT = "(//div[@id='dropdown-container-element-dropdown']/ul/li[contains(@id,'dropdown-option')])[1]";
    public final String ADD_ELEMENT = "#add-element-button";
    public final String BUTTON_SAVE = "#submit-button";
    public final String TOAST_SUCCESS = "//*[contains(text(),'Dimension berhasil disimpan')]";
    public final String ALERT_ERROR = "//img[contains(@src,'error.svg')]";
    public final String FIELD_ORGANIZATION = "#organization-dropdown";
    public final String INPUT_ORGANIZATION = "#input-organization-dropdown";
    public final String SELECT_ORGANIZATION = "#dropdown-option-{ORGANIZATION_ID}";
    public final String SEARCH_ELEMENT = "#input-element-dropdown";
    public final String SELECT_MULTIPLE_ELEMENT = "#dropdown-select-all-element-dropdown";
    public final String INPUT_SEARCH = "#dimension-search-field-input";
    public final String LOADING_SPINNER = "//div[contains(text(), 'Sedang memuat data') ]";
    public final String TOTAl_ROW = "//table/tbody/tr";
    public final String POPUP_EDIT_CONFIRMATION = "//div[text()='Simpan Perubahan?']";
    public final String BUTTON_SAVE_POPUP = "//span[text()='Simpan']";
    public final String TOGGLE_STATUS_RELATION = "label#element-relation-27-1-1-toggle > div";
    public final String POPUP_NONACTIVE_RELATION = "//div[text()='Nonaktifkan Relasi Academic Framework?']";
    public final String BUTTON_SUBMIT_POPUP_STATUS_RELATION = "(//span[text()='Nonaktifkan'])[2]";
    public final String TOGGLE_STATUS = "label#dimension-status-toggle > div";
    public final String POPUP_STATUS = "//div[contains(text(), 'Nonaktifkan Dimension')]";
    public final String SUBMIT_NONACTIVE = "(//span[text()='Nonaktifkan'])[1]";
    public final String TOAST_SUCCESS_EDIT = "//*[contains(text(),'Dimension berhasil diubah')]";

    public String getIDActivity(int i){
        return "(//table/tbody/tr/td[1]/div)["+i+"]";
    }

    public String getButtonEdit(int i){
        return "(//table/tbody/tr/td[last()]/div/div[2]/span/*)["+i+"]";
    }
}