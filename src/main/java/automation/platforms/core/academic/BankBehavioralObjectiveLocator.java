package automation.platforms.core.academic.bankbehavioralobjective;

public class BankBehavioralObjectiveLocator extends automation.platforms.base.BaseLocator {

    public final String BUTTON_ADD_BANK_BEHAVIORAL_OBJECTIVE = "#add-bo-button";
    public final String INPUT_NAME_BEHAVIORAL_OBJECTIVE = "textarea[placeholder='Masukkan nama behavioral objective']";
    public final String INPUT_CODE_BEHAVIORAL_OBJECTIVE = "#atomic-input";
    public final String OPTION_STAGE_DEVELOPMENT = "#dropdown-option-1";
    public final String PLACE_HOLDER_STAGE_DEVELOPMENT = "//*[text()='Masukkan tahap perkembangan']";
    public final String INPUT_ELEMENT = "#input-element-dropdown";
    public final String SELECT_ALL_OPTION_ELEMENT = "#dropdown-select-all-element-dropdown";
    public final String BUTTON_ADD = "#add-new-element-button";
    public final String TABLE_ELEMENT = "#add-new-element-table";
    public final String BUTTON_SAVE = "#save-bo-button";
    public final String TOAST_SUCCESS_SAVE = "//*[text()='Behavioral Objective berhasil disimpan.'] | //*[text()='Behavioral Objective berhasil diubah.']";
    public final String ALERT_ERROR = "//img[contains(@src,'error.svg')]";
    public final String INPUT_SEARCH = "#bo-search-field-input";
    public final String LIST_BEHAVIORAL_OBJECT = "#bo-table-data-row-0";
    public final String FILTER_STATUS = "#btn-filter-status";
    public final String FILTER_STAGE_DEVELOPMENT = "#btn-filter-year_level";
    public final String BUTTON_SAVE_POPUP = "//button[normalize-space()='Simpan']";
    public final String POPUP_EDIT_CONFIRMATION = "//div[text()='Simpan Perubahan?']";
    public final String BUTTON_SUBMIT_STATUS_POPUP = "(//*[@id='popup-submit-button' and contains(.,'Nonaktifkan')])[1]";
    public final String TOGGLE_STATUS = "(//input[@type='checkbox'])[1]";
    public final String ELEMENT_DROPDOWN = "#element-dropdown";
    public final String TITLE_PAGE = "//div[text()='Bank Behavioral Objective']";
    public final String SELECT_ALL = "#dropdown-select-all-null";
    public final String SELECT_SECOND_VALUE = "//*[@id=\"dropdown-container-element-dropdown\"]/ul/li[2]/label";
    public final String SELECT_ALL_NULL = "dropdown-select-all-null";
    public final String TABLE_DATA_LOADING = "#bo-table-data-row-loading";
    public final String TABLE_ROW_ELEMENT = "//*[@id=\"add-new-element-table\"]/tbody/tr[2]";
    public final String TABLE_ROW = "//*[@id=\"add-new-element-table\"]/tbody/tr";
    public final String ERROR_FIELD = ".error-input-field";
    public final String ERROR_TEXT = "(//*[contains(@class, \"!text-amaranth-600\")])[1]/span";
    public final String ERROR_ELEMENT_TICKER = "#duplicate-element-ticker";
    public final String DROPDOWN_CONTAINER_ELEMENT = "#dropdown-container-element-dropdown";
    public final String ELEMENT_WARNING_PRESENT = "//*[@class=\"organism-input-field flex gap-x-8 items-start w-full gap-y-2 flex-row mb-6\"]/div/div[2]/span";
    public final String GET_STATUS_BO = "//*[@class=\"organism-input-field flex gap-x-8 items-start w-full gap-y-2 flex-row\"]/div/label/div/span";
    public final String CLICK_STATUS_BO = "//*[@class=\"organism-input-field flex gap-x-8 items-start w-full gap-y-2 flex-row\"]/div/label/div/div/input";
    public final String POPUP_SWITCH_STATUS = "//*[@id=\"popup-submit-button\"]/span[text()=\"Nonaktifkan\"]";
    public final String POPUP_BUTTON_SUBMIT = "#popup-submit-button";
    public final String NEW_ELEMENT_TABLE_BO = "#add-new-element-table-data-row-0";
    public final String GET_NEW_ELEMENT_TABLE = "//*[@id=\"add-new-element-table-data-row-0\"]/td[3]";

    public String FILTERBYSTATUS(String filterName) {
        return "//label[contains(@class, 'inline-flex') and normalize-space() = '" + filterName + "']";
    }

    public String SELECT_FIELD(int index) {
        return ("(//*[@class='cursor-pointer'])[" + index + "]");
    }

    public String CLICK_BUTTON_EDIT(int index) {
        return ("(//a[@id='edit-bo-button'])[" + index + "]");
    }

    public String CLICK_BUTTON_DETAIL(String index) {
        return ("(//a[@id='detail-bo-button'])[" + index + "]");
    }

    public String INPUT_FIELD_WITH_PLACEHOLDER(String value) {
        return ("//*[@placeholder=\"" + value + "\"]");
    }

    public String TEXT_CONTAINS(String value) {
        return ("//*[contains(text(), \"" + value + "\")]");
    }
}


