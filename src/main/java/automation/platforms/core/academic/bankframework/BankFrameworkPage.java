package automation.platforms.core.academic.bankframework;

import automation.platforms.core.BaseCore;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import java.util.ArrayList;
import java.util.List;

public class BankFrameworkPage extends BaseCore<BankFrameworkLocator> implements BankFrameworkSteps {

    public BankFrameworkPage(Page page){
        super(page);
    }

    @Override
    public void setupLocator() {
        mLocator = new BankFrameworkLocator();
    }

    @Override
    public boolean navigateToPageBankFramework(){
        element.click(mLocator.buttonAddBankFramework);
        driver.waitForLoadState(LoadState.NETWORKIDLE);
        return element.verifyTextPresent("Tambah Framework");
    }

    @Override
    public boolean fillNameBankFramework(String name) {
        return fillAndValidate(mLocator.inputNameFramework, name);
    }

    @Override
    public boolean fillCodeBankFramework(String code) {
        return fillAndValidate(mLocator.inputCodeFramework, code);
    }

    @Override
    public boolean fillDescriptionBankFramework(String description) {
        return fillAndValidate(mLocator.inputDescriptionFramework, description);
    }

    @Override
    public boolean selectOrganizerProvider(String organizer) {
        driver.waitForTimeout(5000);
        String selectedValue = element.selectDropdownWithSearchValue(mLocator.dropdownOrganizerProvider, organizer);
        return selectedValue != null;
    }

    @Override
    public boolean clickButtonSaveFramework() {
        driver.waitForTimeout(5000);
        element.clickHandlerJs(mLocator.buttonSaveFramework);
        driver.waitForLoadState(LoadState.DOMCONTENTLOADED);
        driver.waitForTimeout(5000);
        validationPopUp(false);
        return element.verifyElementNotPresent(mLocator.buttonSaveFramework);
    }

    @Override
    public boolean clickButtonCancelFramework() {
        element.clickHandlerJs(mLocator.buttonCancelFramework);
        driver.waitForTimeout(5000);
        return element.verifyElementNotPresent(mLocator.buttonCancelFramework);
    }

    @Override
    public boolean getValidationMessages() {
        driver.waitForLoadState(LoadState.NETWORKIDLE);

        List<String> messages = new ArrayList<>();
        int count = element.getSize(mLocator.validationMessage);

        for (int i = 1; i <= count; i++) {
            String actualMessage = element.getTextFromContentPage(mLocator.getValidationMessage(i));
            if (!actualMessage.isEmpty()) {
                messages.add(actualMessage);
            }
        }

        return !messages.isEmpty();
    }

    @Override
    public boolean validationPopUp(boolean isCancel) {
        driver.waitForLoadState(LoadState.NETWORKIDLE);
        element.verifyElementPresent(mLocator.buttonCancelPopUp);
        boolean isValid;
        if (isCancel) {
            element.clickHandlerJs(mLocator.buttonCancelPopUp);
        } else {
            element.clickHandlerJs(mLocator.buttonSubmitPopUp);
        }

        driver.waitForLoadState(LoadState.NETWORKIDLE);
        isValid = element.verifyElementNotPresent(mLocator.buttonCancelFramework) ||
                element.verifyElementNotPresent(mLocator.buttonSubmitPopUp);
        return isValid;
    }

    @Override
    public boolean clickButtonDetail(int index){
        driver.waitForLoadState(LoadState.NETWORKIDLE);
        element.click(mLocator.getButtonDetailBankFramework(index));
        driver.waitForLoadState(LoadState.DOMCONTENTLOADED);
        return element.verifyTextPresent("Detail Framework");
    }

    @Override
    public boolean clickButtonEdit(int index){
        driver.waitForLoadState(LoadState.NETWORKIDLE);
        element.click(mLocator.getButtonEditBankFramework(index));
        driver.waitForLoadState(LoadState.DOMCONTENTLOADED);
        return element.verifyTextPresent("Ubah Framework");
    }

    @Override
    public boolean searchBankFramework(String name){
        driver.waitForLoadState(LoadState.NETWORKIDLE);
        element.click(mLocator.searchInputBankFramework);
        element.setText(mLocator.searchInputBankFramework, name);
        String actualName = resultBankFramework(name);
        return actualName != null && actualName.equals(name);
    }

    @Override
    public boolean selectRowDisplay(String row){
        element.selectSingleDropdown(mLocator.rowDisplayBankFramework, String.valueOf(row));
        driver.waitForTimeout(3000);
        driver.waitForLoadState(LoadState.DOMCONTENTLOADED);
        int count = element.getSize(mLocator.resultListBankFramework);
        int parameterCount = Integer.parseInt(row);
        return count <= parameterCount;
    }

    private String resultBankFramework(String name){
        driver.waitForTimeout(5000);
        driver.waitForLoadState(LoadState.DOMCONTENTLOADED);
        int count = element.getSize(mLocator.resultListBankFramework);

        for (int i = 1; i <= count; i++) {
            String actualName = element.getTextFromContentPage(mLocator.getColumnNameBankFramework(i));
            if (actualName.equals(name) || actualName.contains(name)) {
                return actualName;
            }
        }
        return null;
    }

    private boolean fillAndValidate(String locator, String value) {
        driver.waitForLoadState(LoadState.NETWORKIDLE);
        element.setText(locator, value);
        return element.getTextFromInput(locator).equals(value);
    }
}
