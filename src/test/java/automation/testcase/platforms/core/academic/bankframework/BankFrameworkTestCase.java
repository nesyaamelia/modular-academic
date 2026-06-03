package mu.core.id.website.testcase.platforms.core.academic.bankframework;

import org.testng.annotations.Test;

public interface BankFrameworkTestCase {
    void createBankFrameworkWithValidCredentials();

    @Test(priority = 2, description = "AAAA-1235")
    void tambahFrameworkFailedToCreateFrameworkWithUnsupportedSpecialCharactersInKodeFramework();
}
