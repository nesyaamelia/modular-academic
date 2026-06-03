package automation.utils;

import io.qameta.allure.Allure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

/**
 * Utility for logging test step results consistently across all tests.
 *
 * <p>Each {@code verifyStep} call:
 * <ol>
 *   <li>Attaches the step result to the Allure report</li>
 *   <li>Asserts the condition — failing the test with a descriptive message if {@code false}</li>
 * </ol>
 *
 * <p>Usage:
 * <pre>{@code
 *   verifyStep(page.clickSave(), "Save button clicked successfully", "Failed to click save");
 * }</pre>
 */
public class StepLogger {

    private static final Logger log = LoggerFactory.getLogger(StepLogger.class);

    /**
     * Verifies a step result, logs it, and attaches it to the Allure report.
     *
     * @param condition      Result of the step action
     * @param passMessage    Message logged/reported when condition is {@code true}
     * @param failMessage    Message logged/reported and used as assertion failure message
     */
    public static void verifyStep(boolean condition, String passMessage, String failMessage) {
        if (condition) {
            log.info("✅ PASS — {}", passMessage);
            Allure.step(passMessage, io.qameta.allure.model.Status.PASSED);
        } else {
            log.error("❌ FAIL — {}", failMessage);
            Allure.step(failMessage, io.qameta.allure.model.Status.FAILED);
            Assert.fail(failMessage);
        }
    }
}
