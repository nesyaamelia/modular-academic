package automation.platforms.core.academic.sidemenu;

import automation.config.Host;
import automation.platforms.core.BaseCore;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class MenuCorePage extends BaseCore<MenuCoreLocator> implements MenuCoreSteps {

    public MenuCorePage(Page page){
        super(page);
    }

    @Override
    public void setupLocator() {
        mLocator = new MenuCoreLocator();
    }

    @Override
    public boolean navigateToMenu(MenuCoreOptions menuCoreOptions) {
        try {
            driver.navigate(Host.coreHost() + menuCoreOptions.getValue);
            driver.waitForTimeout(3000);
            driver.waitForLoadState(LoadState.DOMCONTENTLOADED);

            String getCurrentUrl = driver.url();

            return getCurrentUrl.contains(menuCoreOptions.getValue);
        } catch (Exception e) {
            System.err.println("Failed to navigate to menu: " + e.getMessage());
            return false;
        }
    }
}
