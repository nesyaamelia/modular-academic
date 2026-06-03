package automation.platforms.core.academic.bankcontent.list;

import automation.platforms.base.BaseLocator;

public class ListBankContentLocator extends BaseLocator {
    public final String INPUT_SEARCH = "#search-content-input";
    public final String TOTAL_ROW = "//tbody/tr";
    public final String LOADING_SPINNER = "//div[contains(text(), 'Sedang memuat data') ]";
    public final String BUTTON_RESET = "//button[text()=' Reset ']";
    public final String BUTTON_FILTER_GENERAL = "#btn-global-filter";
    public final String MODAL_FILTER = "//div[text()='Filter']";
    public final String BUTTON_APPLY = "#btn-filter-box-apply";
    public final String BUTTON_DETAIL = "(//tbody/tr[1]/td[last()]/div/a/div/span/*)[1]";
    public final String DETAIL_HEADER = "//div[text()='Detail Konten Belajar']";
    public final String VIEW_FILE = "#download-content-input";
    public final String URL_FILE = "//button[@id='download-content-input']/parent::a";

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
