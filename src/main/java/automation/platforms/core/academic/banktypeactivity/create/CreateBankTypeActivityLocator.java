package automation.platforms.core.academic.banktypeactivity.create;

import automation.platforms.base.BaseLocator;

public class CreateBankTypeActivityLocator extends BaseLocator {
    public final String BUTTON_ADD_ACTIVITY = "#create-activity-type-btn";
    public final String INPUT_NAME_ACTIVITY = "#activity-type-name-input";
    public final String INPUT_CATEGORY_ACTIVITY = "#activity-type-dropdown-activity-category";
    public final String INPUT_CONTENT_LEARNING = "#activity-type-dropdown-content-type";
    public final String SELECT_CONTENT_LEARNING = "#dropdown-select-all-activity-type-dropdown-content-type";
    public final String BUTTON_SAVE = "#save-activity-type";
    public final String TOGGLE_STATUS = "//input[@id='activity-type-toggle-status']";
    public final String POPUP_STATUS = "#popup-change-status";
    public final String BUTTON_SUBMIT_POPUP = "(//span[text()='Tinggalkan Halaman'])[1]";
    public final String POPUP_LEAVE_PAGE = "#popup-change-page";
    public final String BUTTON_CANCEL_POPUP = "//span[text()='Tetap di Halaman']";
    public final String ALERT_ERROR = "//img[contains(@src,'error.svg')]";
    public final String SUBMIT_NONACTIVE = "//span[text()= 'Nonaktifkan']";
    public final String TOAST_SUCCESS = "//*[contains(text(),'Jenis aktivitas berhasil disimpan')]";
    public final String BUTTON_CANCEL = "#cancel-change-activity-type";
    public final String INPUT_SEARCH = "#search-activity-type-input";
    public final String POPUP_EDIT_CONFIRMATION = "#popup-edit-activity-type";
    public final String BUTTON_SAVE_POPUP = "//span[text()='Simpan']";
    public final String TOAST_SUCCESS_EDIT = "//*[contains(text(),'Jenis aktivitas berhasil diubah')]";
    public final String LOADING_SPINNER = "//div[contains(text(), 'Sedang memuat data') ]";
    public final String TOTAl_ROW = "//table/tbody/tr";
    public final String TOTAL_OPTION = "//div[@id='dropdown-container-activity-type-dropdown-activity-category']/ul/li";
    public final String SELECTED_OPTION = "//div[@id='dropdown-container-activity-type-dropdown-activity-category']/ul/li[contains(@class,'text-primary')]//span[@class='line-clamp-1']";
    public final String TOTAL_TAG_CONTENT = "//div[@id='activity-type-dropdown-content-type']//div[contains(@class,'inline-block')]/span/following-sibling::button";
    public final String TITLE_PAGE = "//div[text()='Bank Jenis Aktivitas']";

    public String selectCategoryActivity(String category){
        return "//span[text()= '"+category+"']";
    }

    public String getIDActivity(int i){
        return "(//table/tbody/tr/td[1]//p)["+i+"]";
    }

    public String getButtonEdit(int i){
        return "(//table/tbody/tr/td[last()]/div/div[2]/span/*)["+i+"]";
    }

    public String getIndexOptionCategory(int i){
        return "(//div[@id='dropdown-container-activity-type-dropdown-activity-category']/ul/li)["+i+"]";
    }

    public String getTagRemoveContent(int i) {
        return "(//div[@id='activity-type-dropdown-content-type']//div[contains(@class,'inline-block')]/span/following-sibling::button)[" + i + "]";
    }
}
