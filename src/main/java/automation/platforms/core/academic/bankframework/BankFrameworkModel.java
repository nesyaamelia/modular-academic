package automation.platforms.core.academic.bankframework;

import automation.platforms.base.BaseModel;

import java.util.Random;

public class BankFrameworkModel extends BaseModel {

    Random random = new Random();

    private String randomNumber() {
        return String.valueOf(random.nextInt(1000));
    }

    public String generateNameFramework() {
        return "Bank Framework " + randomNumber();
    }

    public String generateCodeFramework() {
        return "BF-" + randomNumber();
    }
}
