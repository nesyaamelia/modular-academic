package automation.platforms.core.academic.manageprogram;

import automation.platforms.base.BaseLocator;

public class ManageProgramLocator extends BaseLocator {

    public final String TOTAL_ROW = "//tbody/tr";
    public final String LOADING_SPINNER = "//div[contains(text(), 'Sedang memuat data') ]";
    public final String INPUT_SEARCH = "#search-program-input";
    public final String BUTTON_RESET = "#btn-reset-filter";
    public final String SEARCH_OPTION = "#-input";
    public final String EMPTY_STATE_SEARCH = "//span[contains(text(), 'Data tidak ditemukan') ]";

    public String filterByChips(String filterName) {
        return "//div[contains(@class,'relative')]/button[.//span[contains(text(),'" + filterName + "')]]";
    }

    public String getFilterOption(String option){
        return "//div[contains(@class, 'dropdown')]//span[text()='"+option+"']";
    }

    public String advancedFilter(String filterLabel, String filterName){
        return "//div[text()='"+filterLabel+"']/following-sibling::div//span[text()='"+filterName+"']";
    }

}
