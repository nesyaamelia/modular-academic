package automation.platforms.base;

/**
 * Base class for all Locator classes.
 * Provides common locators shared across multiple pages (e.g. toast, modal, spinner).
 */
public abstract class BaseLocator {

    // ===== Common UI Elements =====
    public final String TOAST_SUCCESS_GENERIC  = "//div[contains(@class,'toast') and contains(@class,'success')]";
    public final String TOAST_ERROR_GENERIC    = "//div[contains(@class,'toast') and contains(@class,'error')]";
    public final String LOADING_SPINNER_GENERIC = "//div[@role='progressbar']";
    public final String MODAL_DIALOG           = "//div[@role='dialog']";
    public final String BUTTON_CONFIRM         = "//button[.//span[text()='Konfirmasi']]";
    public final String BUTTON_CANCEL_GENERIC  = "//button[.//span[text()='Batal']]";
}
