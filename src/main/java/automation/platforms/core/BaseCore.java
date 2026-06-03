package automation.platforms.core;

import automation.config.GlobalVariable;
import com.microsoft.playwright.Page;

/**
 * Abstract base class for all Page Object classes.
 *
 * <p>Provides:
 * <ul>
 *   <li>Playwright {@link Page} driver instance</li>
 *   <li>A typed locator holder ({@code mLocator}) configured via {@link #setupLocator()}</li>
 *   <li>Shared {@link GlobalVariable} instance</li>
 *   <li>Common {@link ElementActions} helper for interacting with page elements</li>
 * </ul>
 *
 * @param <L> Locator class for the specific page
 */
public abstract class BaseCore<L> {

    protected Page driver;
    protected L mLocator;
    protected GlobalVariable globalVariable;
    protected ElementActions element;

    public BaseCore(Page page) {
        this.driver         = page;
        this.globalVariable = GlobalVariable.getInstance();
        this.element        = new ElementActions(page);
        setupLocator();
    }

    /**
     * Implementations must initialize {@code mLocator} with the page-specific locator class.
     * Called automatically in the constructor.
     */
    public abstract void setupLocator();
}
