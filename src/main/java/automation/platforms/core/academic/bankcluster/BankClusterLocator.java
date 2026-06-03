package automation.platforms.core.academic.bankcluster;

import automation.platforms.base.BaseLocator;

public class BankClusterLocator extends BaseLocator {

    //create page
    public final String INPUT_NAME_CLUSTER = "#cluster-name-input";
    public final String INPUT_CODE_CLUSTER = "#cluster-code-input";
    public final String INPUT_DESCRIPTION_CLUSTER = "#cluster-description-textarea";
    public final String DROPDOWN_FRAMEWORK = "#framework-dropdown";
    public final String SELECT_ALL_FRAMEWORK = "#dropdown-select-all-framework-dropdown";
    public final String BUTTON_ADD_FRAMEWORK = "#add-framework-button";
    public final String BUTTON_SAVE_CLUSTER = "#submit-button";
    public final String BUTTON_ADD_BANK_CLUSTER = "#add-cluster-btn";
    public final String TOAST_SUCCESS = "//*[contains(text(),'Cluster berhasil disimpan')]";
    public final String BUTTON_CANCEL = "#cancel-button";
    public final String POPUP_LEAVE_PAGE = "#exit-confirmation-popup";
    public final String BUTTON_STAY_ON_THE_PAGE = "(//span[text() = 'Tetap di Halaman'])";
    public final String BUTTON_LEAVE_PAGE = "(//span[text() = 'Tinggalkan Halaman'])";

    //list page
    public final String SEARCH_INPUT_BANK_CLUSTER = "#cluster-search-field-input";
    public final String LOADING_SPINNER = "//div[contains(text(), 'Memuat data cluster...') ]";
    public final String RESULT_SEARCH = "(//tbody//tr[1]//td)[2]";
    public final String BUTTON_FILTER = "#btn-filter-status";
    public final String FILTER_ACTIVE = "//div[@id='btn-filter-status']//span[text()='Aktif']/parent::label";
    public final String FILTER_INACTIVE = "//div[@id='btn-filter-status']//span[text()='Tidak Aktif']/parent::label";
    public final String BUTTON_RESET = "#btn-reset-filter";
    public final String BUTTON_DETAIL_CLUSTER = "#cluster-detail-162-link";
    public final String TITLE_DETAIL_PAGE = "//div[contains(@class,'font-heading-6') and text()='Detail Cluster']";

    //edit page
    public final String BUTTON_EDIT_CLUSTER = "#cluster-edit-162-link";
    public final String TOGGLE_STATUS_CLUSTER = "label#cluster-status-toggle > div";
    public final String BUTTON_SUBMIT_POPUP = "(//span[text()= 'Nonaktifkan'])[1]";
    public final String BUTTON_SUBMIT_POPUP_RELATION_FRAMEWORK = "(//span[text()= 'Nonaktifkan'])[2]";
    public final String TOGGLE_RELATION_FRAMEWORK = "label#framework-relation-136-toggle > div";
    public final String POPUP_STATUS = "#status-confirmation-popup";
    public final String POPUP_EDIT_CONFIRMATION = "#edit-confirmation-popup";
    public final String BUTTON_SAVE_POPUP = "#edit-confirmation-popup #popup-submit-button";
    public final String TOAST_SUCCESS_EDIT = "//*[contains(text(),'Cluster berhasil diubah')]";
    public final String ALERT_ERROR = "//img[contains(@src,'error.svg')]";
    public final String TITLE_EDIT_PAGE = "//div[contains(@class,'font-heading-6') and text()='Ubah Cluster']";

}


