package automation.platforms.core.academic.bankdimension.list;

import automation.platforms.base.BaseLocator;

public class ListBankDimensionLocator extends BaseLocator {
    public final String SEARCH_FIELD = "#dimension-search-field-input";
    public final String LOADING_SPINNER = "//div[contains(text(), 'Sedang memuat data') ]";
    public final String TOTAL_ROW = "//tbody/tr";
    public final String FILTER_BUTTON = "#btn-filter-status";
    public final String RESET_BUTTON = "#btn-reset-filter";
    public final String BUTTON_DETAIL = "(//tbody/tr[1]/td[last()]/div/div/span/*)[1]";
    public final String DETAIL_HEADER = "//div[text()='Detail Dimension']";
    public final String EDIT_FROM_DETAIL = "#edit-dimension-button";
    public final String EDIT_HEADER = "//div[text()='Ubah Dimension']";

    public String getFilterOption(String option){
        return "//span[text()='"+option+"']";
    }
}
