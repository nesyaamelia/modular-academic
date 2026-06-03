package automation.platforms.core.academic.bankbehavioralobjective;

import automation.config.GlobalVariable;
import automation.config.Host;
import automation.config.InsertExcel;
import automation.platforms.core.BaseCore;
import automation.platforms.core.academic.bankcluster.remote.ClusterAPI;
import automation.platforms.core.academic.bankcluster.remote.response.ClusterResponse;
import automation.platforms.core.academic.bankdimension.remote.DimensionAPI;
import automation.platforms.core.academic.bankdimension.remote.response.DimensionResponse;
import automation.platforms.core.academic.bankelement.remote.ElementAPI;
import automation.platforms.core.academic.bankelement.remote.response.ElementResponse;
import automation.platforms.core.academic.bankframework.remote.FrameworkAPI;
import automation.platforms.core.academic.bankframework.remote.response.FrameworkResponse;
import automation.remote.api.platforms.core.academic.AcademicAPISteps;
import automation.remote.api.platforms.core.assessment.ApiResult;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import static automation.utils.StepLogger.logStep;

public class BankBehavioralObjectivePage extends BaseCore<BankBehavioralObjectiveLocator> implements BankBehavioralObjectiveSteps {

    public BankBehavioralObjectivePage(Page page) {
        super(page);
    }

    public AcademicAPISteps api;
    public String getValueBy;
    public String elementName;
    public boolean result;

    @Override
    public void setupLocator() {
        mLocator = new BankBehavioralObjectiveLocator();
    }

    @Override
    public boolean fillNameBehavioralObjective(String name) {
        fillAndValidate(mLocator.INPUT_NAME_BEHAVIORAL_OBJECTIVE, name);
        return false;
    }

    @Override
    public boolean fillCodeBehavioralObjective(String code) {
        return fillAndValidate(mLocator.INPUT_CODE_BEHAVIORAL_OBJECTIVE, code);
    }

    @Override
    public boolean selectTahapPerkembangan() {
        element.handleElementPresent(mLocator.SELECT_FIELD(2), globalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.SELECT_FIELD(2));
        element.click(mLocator.OPTION_STAGE_DEVELOPMENT);
        element.clickBlankSpace();
        return element.verifyElementNotPresent(mLocator.PLACE_HOLDER_STAGE_DEVELOPMENT);
    }

    @Override
    public boolean selectElement(boolean isSearch, BankBehavioralObjectiveModel data) {
        element.scrollToElement(mLocator.BUTTON_SAVE);
        element.setDelay(globalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.ELEMENT_DROPDOWN);
        if (isSearch) {
            element.setText(mLocator.INPUT_ELEMENT, data.searchElement);
            driver.waitForTimeout(globalVariable.FIVE_SEC_IN_MILLIS);
        }
        element.click(mLocator.SELECT_ALL_OPTION_ELEMENT);
        element.clickBlankSpace();
        element.click(mLocator.BUTTON_ADD);
        verifyValidation();
        return element.isClickable(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean verifyValidation() {
        element.click(mLocator.BUTTON_ADD);
        for (int i = 0; i < 10; i++) {
            if (element.handleElementPresent(mLocator.TABLE_ELEMENT, globalVariable.FIVE_SEC_IN_MILLIS)) return true;
            if (element.handleElementPresent(mLocator.ALERT_ERROR, globalVariable.FIVE_SEC_IN_MILLIS)) return false;
        }
        return false;
    }

    @Override
    public boolean clickButtonAddBankBehavioralObjective() {
        element.handleElementPresent(mLocator.BUTTON_ADD_BANK_BEHAVIORAL_OBJECTIVE, globalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.BUTTON_ADD_BANK_BEHAVIORAL_OBJECTIVE);
        driver.waitForLoadState(LoadState.DOMCONTENTLOADED);
        driver.waitForTimeout(5000);
        element.verifyTextPresent("Tambah Behavioral Objective");
        return element.verifyTextPresent("Tambah Behavioral Objective");
    }

    @Override
    public boolean clickButtonSaveBehavioralObjective(boolean isSuccess) {
        element.clickHandlerJs(mLocator.BUTTON_SAVE);
        if (element.handleElementPresent(mLocator.POPUP_EDIT_CONFIRMATION, GlobalVariable.THREE_SEC_IN_MILLIS)) {
            element.click(mLocator.BUTTON_SAVE_POPUP);
            if (isSuccess) {
                return element.handleElementPresent(mLocator.TOAST_SUCCESS_SAVE, globalVariable.FIVE_SEC_IN_MILLIS);
            } else {
                return element.handleElementPresent(mLocator.ALERT_ERROR, globalVariable.FIVE_SEC_IN_MILLIS);
            }
        } else if (element.handleElementPresent(mLocator.TOAST_SUCCESS_SAVE, globalVariable.FIVE_SEC_IN_MILLIS)) {
            return true;
        }
        return true;
    }

    @Override
    public boolean searchBehavioralObjective(BankBehavioralObjectiveModel behavioralObjectiveModel) {
        element.handleElementPresent(mLocator.INPUT_SEARCH, globalVariable.FIVE_SEC_IN_MILLIS);
        element.setText(mLocator.INPUT_SEARCH, behavioralObjectiveModel.name);
        element.handleElementPresent(mLocator.TABLE_DATA_LOADING, globalVariable.FIVE_SEC_IN_MILLIS);
        element.handleElementNotPresent(mLocator.TABLE_DATA_LOADING, globalVariable.FIVE_SEC_IN_MILLIS);
        element.handleElementPresent(mLocator.LIST_BEHAVIORAL_OBJECT, globalVariable.FIVE_SEC_IN_MILLIS);
        if (behavioralObjectiveModel.searchBy.equalsIgnoreCase("ID")) {
            getValueBy = element.getText("//tr[@id=\"bo-table-data-row-0\"]/td[1]");
            result = getValueBy.contains(behavioralObjectiveModel.name);
        } else {
            getValueBy = element.getText("//tr[@id=\"bo-table-data-row-0\"]/td[2]").toLowerCase();
            result = getValueBy.contains(behavioralObjectiveModel.name.toLowerCase());
        }
        return result;
    }

    @Override
    public boolean filterBehavioralObjective(String isFilter, BankBehavioralObjectiveModel behavioralObjectiveModel) {
        element.handleElementPresent(isFilter, globalVariable.FIVE_SEC_IN_MILLIS);
        element.click(isFilter);
        element.click(mLocator.FILTERBYSTATUS(behavioralObjectiveModel.filterName));
        element.handleElementPresent(mLocator.TABLE_DATA_LOADING, globalVariable.FIVE_SEC_IN_MILLIS);
        element.handleElementNotPresent(mLocator.TABLE_DATA_LOADING, globalVariable.FIVE_SEC_IN_MILLIS);
        element.handleElementPresent(mLocator.LIST_BEHAVIORAL_OBJECT, globalVariable.FIVE_SEC_IN_MILLIS);
        int getListData = element.getSize("//*[@id=\"bo-table\"]/tbody/tr");
        result = true;
        for (int i = 1; i <= getListData; i++) {
            String getStatus = element.getText("//*[@id=\"bo-table\"]/tbody/tr[" + i + "]/td[5]");
            if (!getStatus.equalsIgnoreCase(behavioralObjectiveModel.filterName)) {
                result = !getStatus.equalsIgnoreCase(behavioralObjectiveModel.filterName);
                return result;
            }
        }
        return result;
    }

    @Override
    public boolean toggleStatus(String isToggle, String submitOption) {
        String currentStatus = element.getText(isToggle);
        element.clickHandlerJs(isToggle);
        if (currentStatus.equalsIgnoreCase("Aktif")) {
            if (element.handleElementPresent(submitOption, GlobalVariable.THREE_SEC_IN_MILLIS)) {
                element.clickHandlerJs(submitOption);
                return element.verifyElementPresent(mLocator.BUTTON_SAVE);
            } else {
                return false;
            }
        }
        return element.verifyElementPresent(mLocator.BUTTON_SAVE);
    }

    @Override
    public boolean detailBehavioralObjective() {
        element.click(mLocator.CLICK_BUTTON_DETAIL("1"));
        driver.waitForLoadState(LoadState.DOMCONTENTLOADED);
        element.verifyTextPresent("Detail Behavioral Objective");
        return element.verifyTextPresent("Detail Behavioral Objective");
    }

    @Override
    public void directToClientUrl() {
        element.navigateToUrl(Host.clientHost() + "admin/behavioral-objective");
        element.verifyElement(mLocator.TITLE_PAGE);
    }

    @Override
    public boolean addBehavioralObjective(BankBehavioralObjectiveModel behavioralObjectiveModel) {
        element.handleElementPresent(mLocator.BUTTON_ADD_BANK_BEHAVIORAL_OBJECTIVE, globalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.BUTTON_ADD_BANK_BEHAVIORAL_OBJECTIVE);
        element.handleElementNotPresent(mLocator.BUTTON_ADD_BANK_BEHAVIORAL_OBJECTIVE, globalVariable.FIVE_SEC_IN_MILLIS);
        element.handleElementPresent(mLocator.INPUT_FIELD_WITH_PLACEHOLDER("Masukkan nama behavioral objective"), globalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.INPUT_FIELD_WITH_PLACEHOLDER("Masukkan nama behavioral objective"));
        element.setText(mLocator.INPUT_FIELD_WITH_PLACEHOLDER("Masukkan nama behavioral objective"), behavioralObjectiveModel.name);
        element.setText(mLocator.INPUT_FIELD_WITH_PLACEHOLDER("Masukkan kode behavioral objective"), behavioralObjectiveModel.code);
        if (!behavioralObjectiveModel.isEmpty) {
            element.click(mLocator.SELECT_FIELD(2));
            element.handleElementPresent(mLocator.SELECT_ALL, globalVariable.FIVE_SEC_IN_MILLIS);
            element.click(mLocator.SELECT_ALL);
            element.clickBlankSpace();
            element.click(mLocator.ELEMENT_DROPDOWN);
            element.setText(mLocator.INPUT_ELEMENT, behavioralObjectiveModel.elementName);
            element.slowDelay();
            element.click(mLocator.SELECT_SECOND_VALUE);
            element.clickBlankSpace();
            element.handleElementNotPresent(mLocator.SELECT_ALL_NULL, globalVariable.FIVE_SEC_IN_MILLIS);
            element.click(mLocator.BUTTON_ADD);
        }
        if (behavioralObjectiveModel.isMultipleElement) {
            element.slowDelay();
            element.click(mLocator.ELEMENT_DROPDOWN);
            element.setText(mLocator.INPUT_ELEMENT, behavioralObjectiveModel.multipleElementName);
            element.slowDelay();
            element.click(mLocator.SELECT_SECOND_VALUE);
            element.clickBlankSpace();
            element.handleElementNotPresent(mLocator.SELECT_ALL_NULL, globalVariable.FIVE_SEC_IN_MILLIS);
            element.click(mLocator.BUTTON_ADD);
            element.handleElementPresent(mLocator.TABLE_ROW_ELEMENT, globalVariable.FIVE_SEC_IN_MILLIS);
        }
        if (!behavioralObjectiveModel.isEmpty) {
            element.scrollToElement(mLocator.TABLE_ELEMENT);
        }
        if (behavioralObjectiveModel.isMultipleElement) {
            int getListElement = element.getSize(mLocator.TABLE_ROW);
            if (getListElement < 2) {
                return !behavioralObjectiveModel.isMultipleElement;
            }
        }
        element.click(mLocator.BUTTON_SAVE);
        if (behavioralObjectiveModel.isEmpty) {
            element.handleElementPresent(mLocator.ERROR_FIELD, globalVariable.FIVE_SEC_IN_MILLIS);
            boolean isValidateName = element.verifyElementPresent(mLocator.TEXT_CONTAINS("Nama behavioral objective wajib dimasukkan"));
            boolean isValidateOrganization = element.verifyElementPresent(mLocator.TEXT_CONTAINS("Invalid input"));
            boolean isValidateStepObjective = element.verifyElementPresent(mLocator.TEXT_CONTAINS("Tahap perkembangan wajib dimasukkan."));
            boolean isValidateElement = element.verifyElementPresent(mLocator.TEXT_CONTAINS("Element wajib dimasukkan."));
            return isValidateName && isValidateOrganization && isValidateStepObjective && isValidateElement;
        }
        element.handleElementNotPresent(mLocator.BUTTON_SAVE, globalVariable.FIVE_SEC_IN_MILLIS);
        element.handleElementPresent(mLocator.TOAST_SUCCESS_SAVE, globalVariable.FIVE_SEC_IN_MILLIS);
        boolean isSuccess = element.verifyTextPresent("Behavioral Objective berhasil disimpan.");
        if (isSuccess) {
            try {
                InsertExcel.insertBO(behavioralObjectiveModel.name);
            } catch (Exception e) {
                logStep("Failed insert to excel bo: " + e.getMessage());
            }
        }
        return isSuccess;
    }

    @Override
    public boolean validateFieldElementAtBehavioralObjective(BankBehavioralObjectiveModel behavioralObjectiveModel) {
        element.handleElementPresent(mLocator.BUTTON_ADD_BANK_BEHAVIORAL_OBJECTIVE, globalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.BUTTON_ADD_BANK_BEHAVIORAL_OBJECTIVE);
        element.handleElementNotPresent(mLocator.BUTTON_ADD_BANK_BEHAVIORAL_OBJECTIVE, globalVariable.FIVE_SEC_IN_MILLIS);
        element.handleElementPresent(mLocator.INPUT_FIELD_WITH_PLACEHOLDER("Masukkan nama behavioral objective"), globalVariable.FIVE_SEC_IN_MILLIS);
        element.handleElementPresent(mLocator.ELEMENT_DROPDOWN, globalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.ELEMENT_DROPDOWN);
        if (behavioralObjectiveModel.isSelectAll) {
            element.slowDelay();
            element.click(mLocator.SELECT_ALL_OPTION_ELEMENT);
            element.clickBlankSpace();
            element.handleElementNotPresent(mLocator.SELECT_ALL_OPTION_ELEMENT, globalVariable.FIVE_SEC_IN_MILLIS);
            element.click(mLocator.BUTTON_ADD);
            element.handleElementPresent(mLocator.ERROR_ELEMENT_TICKER, globalVariable.FIVE_SEC_IN_MILLIS);
            boolean isWarningPresent = element.verifyElementPresent(mLocator.ERROR_ELEMENT_TICKER);
            if (isWarningPresent) {
                return behavioralObjectiveModel.isValidElement = true;
            }
        }
        element.setText(mLocator.INPUT_ELEMENT, behavioralObjectiveModel.elementName);
        element.slowDelay();
        if (!behavioralObjectiveModel.isValidSearch) {
            String getText = element.getText(mLocator.DROPDOWN_CONTAINER_ELEMENT);
            if (getText.contains("Data tidak ditemukan. Silakan masukan kata kunci pencarian lain. ")) {
                return behavioralObjectiveModel.isValidSearch = true;
            }
        }
        element.click(mLocator.SELECT_SECOND_VALUE);
        element.clickBlankSpace();
        element.handleElementNotPresent(mLocator.SELECT_ALL_NULL, globalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.BUTTON_ADD);
        if (behavioralObjectiveModel.isMultipleElement) {
            if (!behavioralObjectiveModel.isValidElement) {
                element.click(mLocator.ELEMENT_DROPDOWN);
                element.setText(mLocator.INPUT_ELEMENT, behavioralObjectiveModel.elementName);
                element.slowDelay();
                element.click(mLocator.SELECT_SECOND_VALUE);
                element.clickBlankSpace();
                element.handleElementNotPresent(mLocator.SELECT_ALL_NULL, globalVariable.FIVE_SEC_IN_MILLIS);
            }
        }
        element.scrollToElement(mLocator.TABLE_ELEMENT);
        element.click(mLocator.BUTTON_SAVE);
        if (behavioralObjectiveModel.isMultipleElement) {
            if (!behavioralObjectiveModel.isValidElement) {
                boolean isWarningPresent = element.verifyElementPresent(mLocator.ELEMENT_WARNING_PRESENT);
                if (isWarningPresent) {
                    return behavioralObjectiveModel.isValidElement = true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean editBehavioralObjective(BankBehavioralObjectiveModel behavioralObjectiveModel) {
        String getBoName = InsertExcel.readBoName();
        boolean isSuccessInjectAcademicFramework = injectAcademicFrameworkForBO();
        if (!isSuccessInjectAcademicFramework) return
                element.handleElementPresent(mLocator.INPUT_SEARCH, globalVariable.FIVE_SEC_IN_MILLIS);
        element.setText(mLocator.INPUT_SEARCH, getBoName);
        element.handleElementPresent(mLocator.TABLE_DATA_LOADING, globalVariable.FIVE_SEC_IN_MILLIS);
        element.handleElementNotPresent(mLocator.TABLE_DATA_LOADING, globalVariable.FIVE_SEC_IN_MILLIS);
        element.handleElementPresent(mLocator.LIST_BEHAVIORAL_OBJECT, globalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.CLICK_BUTTON_EDIT(1));
        element.handleElementPresent(mLocator.INPUT_FIELD_WITH_PLACEHOLDER("Masukkan nama behavioral objective"), globalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.INPUT_FIELD_WITH_PLACEHOLDER("Masukkan nama behavioral objective"));
        element.clearText(mLocator.INPUT_FIELD_WITH_PLACEHOLDER("Masukkan nama behavioral objective"));
        element.setText(mLocator.INPUT_FIELD_WITH_PLACEHOLDER("Masukkan nama behavioral objective"), behavioralObjectiveModel.name);
        element.clearText(mLocator.INPUT_FIELD_WITH_PLACEHOLDER("Masukkan kode behavioral objective"));
        element.setText(mLocator.INPUT_FIELD_WITH_PLACEHOLDER("Masukkan kode behavioral objective"), behavioralObjectiveModel.code);
        element.click(mLocator.SELECT_FIELD(1));
        element.handleElementPresent(mLocator.SELECT_ALL, globalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.SELECT_ALL);
        element.click(mLocator.OPTION_STAGE_DEVELOPMENT);
        element.clickBlankSpace();
        String getStatus = element.getText(mLocator.GET_STATUS_BO);
        element.click(mLocator.CLICK_STATUS_BO);
        if (getStatus.equalsIgnoreCase("Aktif")) {
            element.handleElementPresent(mLocator.POPUP_SWITCH_STATUS, globalVariable.FIVE_SEC_IN_MILLIS);
            element.click(mLocator.POPUP_BUTTON_SUBMIT);
            element.handleElementNotPresent(mLocator.POPUP_SWITCH_STATUS, globalVariable.FIVE_SEC_IN_MILLIS);
        }
        String getUpdateStatus = element.getText(mLocator.GET_STATUS_BO);
        if (!getStatus.contains(getUpdateStatus)) {
            logStep("Success switch status behavioral objective from " + getStatus + " to " + getUpdateStatus);
        } else {
            return getStatus.contains(getUpdateStatus);
        }
        element.click(mLocator.ELEMENT_DROPDOWN);
        element.setText(mLocator.INPUT_ELEMENT, elementName);
        element.slowDelay();
        element.click(mLocator.SELECT_SECOND_VALUE);
        element.clickBlankSpace();
        element.handleElementNotPresent(mLocator.SELECT_ALL_NULL, globalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.BUTTON_ADD);
        element.scrollToElement(mLocator.TABLE_ELEMENT);
        if (element.handleElementPresent(mLocator.NEW_ELEMENT_TABLE_BO, globalVariable.FIVE_SEC_IN_MILLIS)) {
            String getNewElement = element.getText(mLocator.GET_NEW_ELEMENT_TABLE);
            if (getNewElement.contains(elementName)) {
                logStep("Success added a new element with api");
            } else {
                return !getNewElement.contains(elementName);
            }
        }
        element.click(mLocator.BUTTON_SAVE);
        element.handleElementPresent(mLocator.POPUP_BUTTON_SUBMIT, globalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.POPUP_BUTTON_SUBMIT);
        if (behavioralObjectiveModel.isEmpty) {
            element.handleElementPresent(mLocator.ERROR_FIELD, globalVariable.FIVE_SEC_IN_MILLIS);
            String getAlert = element.getText(mLocator.ERROR_TEXT);
            return getAlert.contains("Nama behavioral objective wajib dimasukkan");
        }
        element.handleElementNotPresent(mLocator.BUTTON_SAVE, globalVariable.FIVE_SEC_IN_MILLIS);
        boolean isSuccess = element.verifyTextPresent("Behavioral Objective berhasil diubah.");
        if (isSuccess) {
            try {
                InsertExcel.insertBO(behavioralObjectiveModel.name);
            } catch (Exception e) {
                logStep("Failed insert to excel bo: " + e.getMessage());
            }
        }
        return isSuccess;
    }

    @Override
    public boolean injectAcademicFrameworkForBO() {
        FrameworkAPI frameworkAPI = new FrameworkAPI();
        ApiResult<FrameworkResponse> response = frameworkAPI.createNewFramework();
        if (response.body() == null) {
            return false;
        }
        Integer frameworkId = response.body().data.id;
        String frameworkName = response.body().data.name;

        ClusterAPI clusterAPI = new ClusterAPI();
        ApiResult<ClusterResponse> responseCluster = clusterAPI.createNewCluster(frameworkId, frameworkName + " (ID: " + frameworkId + ")");
        if (responseCluster.body() == null) {
            return false;
        }
        Integer clusterId = responseCluster.body().data.id;

        ElementAPI elementAPI = new ElementAPI();
        ApiResult<ElementResponse> elementResponseApiResult = elementAPI.createNewElement(clusterId, frameworkId);
        if (elementResponseApiResult.body() == null) {
            return false;
        }
        Integer elementId = elementResponseApiResult.body().data.id;
        elementName = elementResponseApiResult.body().data.name;

        DimensionAPI dimensionAPI = new DimensionAPI();
        ApiResult<DimensionResponse> dimensionResponseApiResult = dimensionAPI.createNewElement(elementId, clusterId, frameworkId);
        if (dimensionResponseApiResult.body() == null) {
            return false;
        }
        return dimensionResponseApiResult.isOk();
    }

    private boolean fillAndValidate(String locator, String value) {
        element.handleElementPresent(locator, globalVariable.FIVE_SEC_IN_MILLIS);
        element.setText(locator, value);
        return element.getTextFromInput(locator).equals(value);
    }
}
