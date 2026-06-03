package automation.platforms.core.academic.bankcontent.create;

import automation.platforms.base.BaseLocator;

public class CreateBankContentLocator extends BaseLocator {
    public final String BUTTON_ADD_CONTENT = "#create-content-btn";
    public final String INPUT_CONTENT_NAME = "#content-name-input";
    public final String BUTTON_SAVE = "#save-content-input";
    public final String INPUT_CONTENT_LEARNING = "#activity-type-input";
    public final String INPUT_LEARNING_INSTRUCTION = "//div[@role='textbox']";
    public final String BUTTON_ADD_BEHAVIOR = "#add-behavioral-objective-input";
    public final String UPLOAD_FILE = "(//input[@type='file'])[1]";
    public final String MODAL_ADD_BEHAVIOR = "//div[text()='Daftar Behavioral Objective']";
    public final String SELECT_BEHAVIOR = "(//table//tbody//label[contains(@class, 'cursor-pointer')]/span)[1] ";
    public final String BUTTON_ADD_BEHAVIOR_MODAL = "#modal-primary-button";
    public final String TOAST_SUCCESS = "//*[contains(text(),'Konten belajar berhasil disimpan')]";
    public final String ALERT_ERROR = "//img[contains(@src,'error.svg')]";
    public final String TOGGLE_STATUS = "label#content-status-input > div";
    public final String TOTAl_ROW = "//table/tbody/tr";
    public final String LOADING_SPINNER = "//div[contains(text(), 'Sedang memuat data') ]";
    public final String INPUT_SEARCH = "#search-content-input";
    public final String REMOVE_FILE = "#remove-content-btn";
    public final String POPUP_STATUS = "//div[contains(text(), 'Nonaktifkan Konten Belajar?')]";
    public final String SUBMIT_NONACTIVE = "(//span[text()='Nonaktifkan'])[1]";
    public final String POPUP_EDIT_CONFIRMATION = "//div[text()='Simpan Perubahan?']";
    public final String BUTTON_SAVE_POPUP = "//span[text()='Simpan']";
    public final String TOAST_SUCCESS_EDIT = "//*[contains(text(),'Konten belajar berhasil diubah')]";
    public final String INPUT_LINK_VIRTUAL = "#content-link-input";
    public final String FIELD_ORGANIZATION = "#content-organizer-input";
    public final String INPUT_ORGANIZATION = "#input-content-organizer-input";

    public String selectContentLearning(String content){
        return "//span[text()= '"+content+"']";
    }

    public String getIdContent(int i){
        return "(//table/tbody/tr/td[1]/div)["+i+"]";
    }

    public String getButtonEdit(int i){
        return "(//table/tbody/tr/td[last()]/div/a[2]/div/*)["+i+"]";
    }

    public String selectOrganization(String organization){
        return "//span[text()= '"+organization+"']";
    }
}
