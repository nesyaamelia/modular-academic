package automation.platforms.core.academic.bankelement.create;

import automation.platforms.base.BaseLocator;

public class CreateBankElementLocator extends BaseLocator {
    public final String BUTTON_ADD_ELEMENT = "#btn-to-add-element-master";
    public final String INPUT_ELEMENT_NAME = "#input-element-name";
    public final String BUTTON_SAVE = "#btn-element-submit";
    public final String INPUT_CODE_ELEMENT = "#input-element-code";
    public final String INPUT_DESCRIPTION = "#input-element-description";
    public final String INPUT_CLUSTER = "#input-element-cluster";
    public final String SELECT_CLUSTER = "(//div[@id='dropdown-container-input-element-cluster']/ul/li[contains(@id,'dropdown-option')])[1]";
    public final String BUTTON_ADD_CLUSTER = "#btn-element-add-cluster";
    public final String TOAST_SUCCESS = "//*[contains(text(),'Element berhasil disimpan')]";
    public final String ALERT_ERROR = "//img[contains(@src,'error.svg')]";
    public final String BUTTON_CANCEL = "#btn-element-cancel";
    public final String POPUP_LEAVE_PAGE = "#popup-leave-confirmation-close";
    public final String SUBMIT_POPUP = "//span[text()='Simpan dan Tinggalkan Halaman']";
    public final String INPUT_SEARCH = "#-input";
    public final String LOADING_SPINNER = "//div[contains(text(), 'Sedang memuat data') ]";
    public final String TOTAl_ROW = "//table/tbody/tr";
    public final String POPUP_EDIT_CONFIRMATION = "//div[text()='Simpan Perubahan?']";
    public final String BUTTON_SAVE_POPUP = "//span[text()='Simpan']";
    public final String TOAST_SUCCESS_EDIT = "//*[contains(text(),'Element berhasil diubah')]";
    public final String TOGGLE_STATUS = "label#input-element-status > div";
    public final String POPUP_STATUS = "//div[text()='Nonaktifkan Element?']";
    public final String BUTTON_SUBMIT_POPUP = "(//span[text()='Nonaktifkan'])[1]";

    public String getButtonEdit(int i){
        return "(//table/tbody/tr/td[last()]/div/div[2]/span/*)["+i+"]";
    }

    public String getIdElement(int i){
        return "(//table/tbody/tr/td[1]/div/span)["+i+"]";
    }
}
