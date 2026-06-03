package automation.platforms.core.academic.menucore;

import automation.platforms.core.BaseCore;
import com.microsoft.playwright.Page;

public class MenuCorePage extends BaseCore<MenuCoreLocator> implements MenuCoreSteps {

    public MenuCorePage(Page page) {
        super(page);
    }

    @Override
    public void setupLocator() {
        mLocator = new MenuCoreLocator();
    }

    @Override
    public boolean navigateToMenu(MenuCoreOptions menuCoreOptions) {
        try {
            element.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String isDirected = element.getUrl();
        return isDirected.contains(menuCoreOptions.getValue);
    }
}
