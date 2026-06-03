package automation.testcase.platforms.core;

import automation.config.GeneralConfiguration;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Base test class for all Core platform UI tests.
 *
 * <p>Handles Playwright browser lifecycle:
 * <ul>
 *   <li>{@code @BeforeClass} — launches browser, creates page, calls {@link #initInstance()}</li>
 *   <li>{@code @AfterClass} — closes browser and cleans up</li>
 * </ul>
 *
 * <p>Subclasses override {@link #initInstance()} to initialize their
 * Page Object and Model instances.
 */
public abstract class BaseCoreDriverTest {

    protected Page page;

    @BeforeClass
    public void setup() {
        GeneralConfiguration config = GeneralConfiguration.getInstance();
        config.initialize();
        page = config.newPage();
        initInstance();
    }

    /**
     * Called after the browser page is ready.
     * Subclasses must initialize their Steps and Model instances here.
     */
    public void initInstance() {
        // Override in subclasses
    }

    @AfterClass
    public void tearDown() {
        GeneralConfiguration.getInstance().tearDown();
    }
}
