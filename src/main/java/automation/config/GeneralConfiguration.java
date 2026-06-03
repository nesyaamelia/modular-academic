package automation.config;

import com.microsoft.playwright.*;

/**
 * Singleton configuration class that manages Playwright instance lifecycle.
 * Provides centralized browser setup for both UI and API testing.
 */
public class GeneralConfiguration {

    private static GeneralConfiguration instance;
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;

    private GeneralConfiguration() {}

    public static synchronized GeneralConfiguration getInstance() {
        if (instance == null) {
            instance = new GeneralConfiguration();
        }
        return instance;
    }

    public void initialize() {
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(Boolean.parseBoolean(System.getenv().getOrDefault("HEADLESS", "true")))
                .setSlowMo(Double.parseDouble(System.getenv().getOrDefault("SLOW_MO", "0")));

        browser = playwright.chromium().launch(launchOptions);

        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions()
                .setViewportSize(1920, 1080)
                .setIgnoreHTTPSErrors(true);

        context = browser.newContext(contextOptions);
        context.setDefaultTimeout(Double.parseDouble(
                System.getenv().getOrDefault("DEFAULT_TIMEOUT", "30000")));
    }

    public Playwright getPlaywright() {
        return playwright;
    }

    public Browser getBrowser() {
        return browser;
    }

    public BrowserContext getContext() {
        return context;
    }

    public Page newPage() {
        return context.newPage();
    }

    public void tearDown() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
        instance = null;
    }
}
