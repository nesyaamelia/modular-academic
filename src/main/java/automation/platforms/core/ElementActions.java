package automation.platforms.core;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class wrapping Playwright element interactions.
 *
 * <p>Provides stable, reusable methods for clicking, typing, verifying
 * element presence/absence, and extracting text — all with built-in
 * error handling and logging.
 */
public class ElementActions {

    private static final Logger log = LoggerFactory.getLogger(ElementActions.class);

    private final Page page;

    public ElementActions(Page page) {
        this.page = page;
    }

    /** Click an element identified by a CSS/XPath selector. */
    public void click(String selector) {
        log.debug("Clicking element: {}", selector);
        page.locator(selector).click();
    }

    /** Click using JavaScript (useful for elements blocked by overlays). */
    public void clickHandlerJs(String selector) {
        log.debug("JS-clicking element: {}", selector);
        page.locator(selector).evaluate("el => el.click()");
    }

    /** Clear existing text and type new value. */
    public void setText(String selector, String text) {
        log.debug("Setting text '{}' on: {}", text, selector);
        Locator locator = page.locator(selector);
        locator.clear();
        locator.fill(text);
    }

    /** Returns the current value of an input field. */
    public String getTextFromInput(String selector) {
        return page.locator(selector).inputValue();
    }

    /** Returns the inner text of an element. */
    public String getText(String selector) {
        return page.locator(selector).innerText();
    }

    /** Scroll an element into view. */
    public void scrollToElement(String selector) {
        page.locator(selector).scrollIntoViewIfNeeded();
    }

    /**
     * Returns {@code true} if the element is visible in the DOM.
     */
    public boolean verifyElementPresent(String selector) {
        try {
            return page.locator(selector).isVisible();
        } catch (Exception e) {
            log.warn("Element not found: {}", selector);
            return false;
        }
    }

    /**
     * Returns {@code true} if the element is NOT visible.
     */
    public boolean verifyElementNotPresent(String selector) {
        try {
            page.locator(selector).waitFor(
                    new Locator.WaitForOptions()
                            .setState(com.microsoft.playwright.options.WaitForSelectorState.HIDDEN));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns {@code true} if the given text is visible anywhere on the page.
     */
    public boolean verifyTextPresent(String text) {
        return page.locator("text=" + text).isVisible();
    }

    /**
     * Waits up to {@code timeoutMs} for an element to become visible.
     * Returns {@code true} if it appears within the timeout; {@code false} otherwise.
     */
    public boolean handleElementPresent(String selector, int timeoutMs) {
        try {
            page.locator(selector).waitFor(
                    new Locator.WaitForOptions()
                            .setState(com.microsoft.playwright.options.WaitForSelectorState.VISIBLE)
                            .setTimeout(timeoutMs));
            return true;
        } catch (Exception e) {
            log.warn("Element did not appear within {}ms: {}", timeoutMs, selector);
            return false;
        }
    }

    /**
     * Waits up to {@code timeoutMs} for an element to become hidden/detached.
     * Returns {@code true} if it disappears within the timeout; {@code false} otherwise.
     */
    public boolean handleElementNotPresent(String selector, int timeoutMs) {
        try {
            page.locator(selector).waitFor(
                    new Locator.WaitForOptions()
                            .setState(com.microsoft.playwright.options.WaitForSelectorState.HIDDEN)
                            .setTimeout(timeoutMs));
            return true;
        } catch (Exception e) {
            log.warn("Element did not disappear within {}ms: {}", timeoutMs, selector);
            return false;
        }
    }
}
