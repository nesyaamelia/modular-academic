package automation.platforms.core.academic.banktypeactivity.list;

import automation.platforms.base.BaseLocator;

public class ListBankTypeActivityLocator extends BaseLocator {

    public final String INPUT_SEARCH = "#search-activity-type-input";
    public final String BUTTON_RESET = "//button[text()=' Reset ']";
    public final String BUTTON_FILTER_GENERAL = "//img[@src='https://cdn.sekolah.mu/assets/v3/action/filter-icon-black.svg']";
    public final String BUTTON_APPLY = "//span[text()=' Terapkan Filter ']";
    public final String MODAL_FILTER = "//div[text()='Filter']";
    public final String LOADING_SPINNER = "//div[contains(text(), 'Sedang memuat data') ]";
    public final String TOTAL_ROW = "//tbody/tr";
    public final String EMPTY_STATE = "//tbody/tr//p[contains(text(),'Pencarian tidak ditemukan')]";
    public final String BUTTON_DETAIL = "(//tbody/tr[1]/td[last()]/div/div/span/*)[1]";
    public final String BUTTON_CLOSE_MODAL = "#modal-close-button";
    public final String TITLE_PAGE = "//div[text()='Bank Jenis Aktivitas']";

    public String filterByChips(String filterName) {
        return "//div[@id='filter-activity-type']//span[contains(text(), '"+filterName+"')]";
    }

    public String advancedFilter(String filterLabel, String filterName){
        return "//div[text()='"+filterLabel+"']/following-sibling::div//span[text()='"+filterName+"']";
    }

    public String searchAdvancedFilter(String filterLabel){
        return "//div[text()='"+filterLabel+"']/following-sibling::div//input[@type='text']";
    }

    public String getRowResult(String by, int index){
        String searchBy = by.equals("id") ? "1" : "2";
        return "(//tbody/tr["+index+"]/td)["+searchBy+"]//p";
    }

    public String getFilterOption(String option){
        return "//span[text()='"+option+"']";
    }
}