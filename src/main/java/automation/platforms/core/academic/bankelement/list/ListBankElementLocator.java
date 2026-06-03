package automation.platforms.core.academic.bankelement.list;

import automation.platforms.base.BaseLocator;

public class ListBankElementLocator extends BaseLocator {
    public final String INPUT_SEARCH = "#-input";
    public final String BUTTON_FILTER = "#btn-filter-status";
    public final String SELECT_STATUS = "//span[text()='Aktif']";
    public final String BUTTON_RESET = "#btn-reset-filter";
    public final String BUTTON_DETAIL = "(//tbody/tr[1]/td[last()]/div/div/span/*)[1]";
    public final String DETAIL_HEADER = "//div[text()='Detail Element']";
    public final String EDIT_FROM_DETAIL = "//span[text()='Ubah Element']";
    public final String EDIT_HEADER = "//div[text()='Ubah Element Master']";
    public final String INPUT_ELEMENT_NAME = "#input-element-name";
    public final String LOADING_SPINNER = "//div[contains(text(), 'Sedang memuat data') ]";
    public final String LIST_DETAIL_ORGANIZATION_ELEMENT = "//div[text()=' Konfigurasi Element Organisasi ']";
}
