package automation.platforms.core.academic.manageactivity;

import automation.platforms.base.BaseLocator;

public class ManageActivityLocator extends BaseLocator {
    public final String BUTTON_GLOBAL_FILTER = "#btn-global-filter";
    public final String MODAL_GLOBAL_FILTER = ".box-content-filter";
    public final String TOTAL_ROW = "//tbody/tr";
    public final String LOADING_SPINNER = "//div[contains(text(), 'Sedang memuat data') ]";
    public final String BUTTON_APPLY_FILTER = "#btn-filter-box-apply";
    public final String INPUT_SEARCH = "#search-activity-type-input";
    public final String BUTTON_RESET = "//button[text()=' Reset ']";

    public String filterByChips(String filterName) {
        return "//div[contains(@class,'relative')]/button[.//span[contains(text(),'" + filterName + "')]]";
    }

    public String getFilterOption(String option){
        return "//div[contains(@class, 'dropdown')]//span[text()='"+option+"']";
    }

    public String advancedFilter(String filterLabel, String filterName){
        return "//div[text()='"+filterLabel+"']/following-sibling::div//span[text()='"+filterName+"']";
    }

    // ==================== SCHEDULE / DATE PICKER LOCATORS ====================

    // Tab navigation
    public final String TAB_PENGATURAN_UMUM = "#general";
    public final String TAB_PENGATURAN_DASAR = "#basic";
    public final String TAB_PENGATURAN_KONTEN = "#content";

    // Side menu - Kuota & Jadwal Aktivitas
    public final String MENU_KUOTA_JADWAL = "#content-list-general-schedule-content-list";

    // Toggle Jadwal Aktivitas
    public final String TOGGLE_JADWAL_AKTIVITAS = "#activity-schedule-toggle";

    // Date picker input fields
    public final String INPUT_TANGGAL_MULAI = "#activity-schedule-start-date";
    public final String INPUT_TANGGAL_SELESAI = "#activity-schedule-end-date";

    // Date picker container (Vue Datepicker)
    public final String DATE_PICKER_MENU = ".dp__menu";
    public final String DATE_PICKER_PREV_MONTH = "button[aria-label='Previous month']";
    public final String DATE_PICKER_NEXT_MONTH = "button[aria-label='Next month']";
    public final String DATE_PICKER_APPLY = ".dp__action_select";
    public final String DATE_PICKER_RESET = "//button[contains(text(), 'Reset')]";
}
