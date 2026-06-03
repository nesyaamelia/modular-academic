package automation.platforms.core.academic.categoryinterpretationscore.create;


import automation.config.GlobalVariable;
import automation.config.Host;
import automation.platforms.core.BaseCore;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class CreateCategoryInterpretationScorePage extends BaseCore<CreateCategoryInterpretationScoreLocator> implements CreateCategoryInterpretationScoreSteps {
    
    @Override
    public void setupLocator() {
        mLocator = new CreateCategoryInterpretationScoreLocator();
    }

    public CreateCategoryInterpretationScorePage(Page page){
        super(page);
    }

    @Override
    public boolean navigateToPageKategoriInterpretasiNilai(){
        element.click(mLocator.BUTTON_ADD_CATEGORY_INTERPRETATION_GUIDANCE);
        element.handleElementPresent(mLocator.INPUT_NAME_CATEGORY_INTERPRETATION_GUIDANCE, globalVariable.FIVE_SEC_IN_MILLIS);
        return element.verifyTextPresent("Tambah Panduan Interpretasi");
    }
  
    @Override
    public boolean fillNameInterpretationGuidance(CreateCategoryInterpretationScoreModel name) {
        return fillAndValidate(mLocator.INPUT_NAME_CATEGORY_INTERPRETATION_GUIDANCE, name.nameInterpretationGuidance);
    }

    @Override
    public boolean fillNameCategory(CreateCategoryInterpretationScoreModel name) {
        return fillAndValidate(mLocator.INPUT_CATEGORY_NAME, name.nameCategory);
    }

    @Override
    public boolean fillMaxValueCategory(CreateCategoryInterpretationScoreModel name) {
        boolean filled = fillAndValidate(mLocator.INPUT_CATEGORY_MAX_VALUE, name.maxValueCategory);
        boolean enabled = element.isEnabled(mLocator.BUTTON_ADD_CATEGORY);
        String disabledAttr = element.getAttributeFrom(mLocator.BUTTON_ADD_CATEGORY, "disabled");
        String ariaDisabled = element.getAttributeFrom(mLocator.BUTTON_ADD_CATEGORY, "aria-disabled");
        boolean isDisabled = !enabled || "true".equalsIgnoreCase(ariaDisabled) || (disabledAttr != null);
        return filled && isDisabled;
    }

    @Override
    public boolean saveCategoryInterpretationScore() {
        element.setDelay(globalVariable.FIVE_SEC_IN_MILLIS);
        element.click(mLocator.BUTTON_SAVE);
        for (int i = 0; i < 10; i++) {
            if (element.handleElementPresent(mLocator.TOAST_SUCCESS, globalVariable.FIVE_SEC_IN_MILLIS)) return true;
            if (element.handleElementPresent(mLocator.ALERT_ERROR, globalVariable.FIVE_SEC_IN_MILLIS)) return false;
        }
        return false;
    }

    @Override
    public boolean invalidCase(CreateCategoryInterpretationScoreModel name) {
        // 1) empty inputs -> attempt save, expect specific errors
        boolean emptyValidationBlocked = !saveCategoryInterpretationScore();
        boolean emptyErrorsShown =
                element.verifyTextPresent("Nama Panduan Interpretasi wajib dimasukkan.") &&
                element.verifyTextPresent("Nama kategori wajib dimasukkan.") &&
                element.verifyTextPresent("Nilai maksimal wajib dimasukkan.");

        // 2) invalid char in grade -> fill only grade and try save
        element.setText(mLocator.INPUT_GRADE, "");
        fillAndValidate(mLocator.INPUT_GRADE, name.invalidCharGradeCategory().gradeCategory);
        boolean invalidGradeBlocked = !saveCategoryInterpretationScore();
        boolean invalidGradeErrorShown = element.verifyTextPresent(
                "Format tidak sesuai. Pastikan hanya menggunakan titik (.), koma (,), tanda hubung (-), garis bawah (_), garis miring (/), dan tanda tambah (+)."
        );

        // 3) invalid max value on last category must be 100
        element.setText(mLocator.INPUT_CATEGORY_MAX_VALUE, "");
        fillAndValidate(mLocator.INPUT_CATEGORY_MAX_VALUE, name.invalidMaxValueCategory().maxValueCategory);
        boolean invalidMaxBlocked = !saveCategoryInterpretationScore();
        boolean invalidMaxErrorShown = element.verifyTextPresent("Nilai maksimal pada kategori terakhir harus bernilai 100.");

        // 4) decimal max value -> must be integer
        element.setText(mLocator.INPUT_CATEGORY_MAX_VALUE, "");
        fillAndValidate(mLocator.INPUT_CATEGORY_MAX_VALUE, name.invalidDecimalMaxValueCategory().maxValueCategory);
        boolean decimalMaxBlocked = !saveCategoryInterpretationScore();
        boolean decimalMaxErrorShown = element.verifyTextPresent("Nilai kategori harus angka bulat.");

        // 5) max less than min -> must be greater than min
        element.setText(mLocator.INPUT_CATEGORY_MAX_VALUE, "");
        fillAndValidate(mLocator.INPUT_CATEGORY_MAX_VALUE, name.invalidLessThanMinMaxValueCategory().maxValueCategory);
        boolean lessThanMinBlocked = !saveCategoryInterpretationScore();
        boolean lessThanMinErrorShown = element.verifyTextPresent("Nilai maksimal harus lebih besar dari nilai minimal.");

        // 6) long chars -> fill long values and try save
        CreateCategoryInterpretationScoreModel longCase = new CreateCategoryInterpretationScoreModel().invalidNameLongChars();
        fillAndValidate(mLocator.INPUT_NAME_CATEGORY_INTERPRETATION_GUIDANCE, longCase.nameInterpretationGuidance);
        fillAndValidate(mLocator.INPUT_CATEGORY_NAME, longCase.nameCategory);
        fillAndValidate(mLocator.INPUT_GRADE, longCase.gradeCategory);
        boolean longCharsBlocked = !saveCategoryInterpretationScore();
        boolean longCharsErrorShown = element.verifyTextPresent("Jumlah karakter melebihi batas maksimum.");

        return (emptyValidationBlocked && emptyErrorsShown) &&
               (invalidGradeBlocked && invalidGradeErrorShown) &&
               (invalidMaxBlocked && invalidMaxErrorShown) &&
               (decimalMaxBlocked && decimalMaxErrorShown) &&
               (lessThanMinBlocked && lessThanMinErrorShown) &&
               (longCharsBlocked && longCharsErrorShown);
    }

    @Override
    public boolean duplicateNameCase(CreateCategoryInterpretationScoreModel name) {
        element.setDelay(GlobalVariable.THREE_SEC_IN_MILLIS);
        String firstTableData = element.getText(mLocator.FIRST_TABLE_DATA);
        navigateToPageKategoriInterpretasiNilai();
        fillAndValidate(mLocator.INPUT_NAME_CATEGORY_INTERPRETATION_GUIDANCE, firstTableData);
        fillAndValidate(mLocator.INPUT_CATEGORY_NAME, name.nameCategory);
        fillAndValidate(mLocator.INPUT_CATEGORY_MAX_VALUE, name.maxValueCategory);
        fillAndValidate(mLocator.INPUT_GRADE, name.gradeCategory);
        element.click(mLocator.BUTTON_SAVE);
        element.setDelay(GlobalVariable.THREE_SEC_IN_MILLIS);
        return element.verifyTextPresent("Nama Panduan Interpretasi telah terdaftar di organisasi penyedia yang sama.");
    }

    @Override
    public boolean duplicateNameInDifferentOrganizationCase(CreateCategoryInterpretationScoreModel name) {
        String firstTableData = element.getText(mLocator.FIRST_TABLE_DATA);
        navigateToPageKategoriInterpretasiNilai();
        fillAndValidate(mLocator.INPUT_NAME_CATEGORY_INTERPRETATION_GUIDANCE, firstTableData);
        element.click(mLocator.DROPDOWN_ORGANIZATION);
        element.setText(mLocator.INPUT_ORGANIZATION_NAME, "Lembaga QA 1");
        element.click(mLocator.SID_ORGANIZATION);
        fillAndValidate(mLocator.INPUT_CATEGORY_NAME, name.nameCategory);
        fillAndValidate(mLocator.INPUT_CATEGORY_MAX_VALUE, name.maxValueCategory);
        fillAndValidate(mLocator.INPUT_GRADE, name.gradeCategory);

        element.click(mLocator.BUTTON_SAVE);
        for (int i = 0; i < 10; i++) {
            if (element.handleElementPresent(mLocator.TOAST_SUCCESS, globalVariable.FIVE_SEC_IN_MILLIS)) return true;
            if (element.handleElementPresent(mLocator.ALERT_ERROR, globalVariable.FIVE_SEC_IN_MILLIS)) return false;
        }
        return false;
    }

    @Override
    public boolean redirectBackFromBreadcrumb() {
        element.click(mLocator.BREADCRUMB_CATEGORY_INTERPRETATION_SCORE);
        return element.verifyTextPresent("Kategori Interpretasi Nilai");
    }

    @Override
    public boolean redirectBackFromSideMenu() {
        navigateToPageKategoriInterpretasiNilai();
        element.click(mLocator.SIDE_MENU_CATEGORY_INTERPRETATION_SCORE);
        return element.verifyTextPresent("Kategori Interpretasi Nilai");
    }

    @Override
    public boolean redirectBackFromButtonBatalkan() {
        navigateToPageKategoriInterpretasiNilai();
        element.click(mLocator.BUTTON_CANCEL);
        return element.verifyTextPresent("Kategori Interpretasi Nilai");
    }

    @Override
    public boolean addCategoryTenTimesThenVerifyDisabled() {
        for (int i = 0; i < 10; i++) {
            if (!element.isEnabled(mLocator.BUTTON_ADD_CATEGORY)) break;
            element.click(mLocator.BUTTON_ADD_CATEGORY);
            driver.waitForLoadState(LoadState.NETWORKIDLE);
        }
        boolean enabled = element.isEnabled(mLocator.BUTTON_ADD_CATEGORY);
        String disabledAttr = element.getAttributeFrom(mLocator.BUTTON_ADD_CATEGORY, "disabled");
        String ariaDisabled = element.getAttributeFrom(mLocator.BUTTON_ADD_CATEGORY, "aria-disabled");
        return !enabled || "true".equalsIgnoreCase(ariaDisabled) || (disabledAttr != null);
    }

    @Override
    public boolean fillMaxValueThenAddCategoryAndFillSame(CreateCategoryInterpretationScoreModel name) {
        boolean firstFilled = fillAndValidate(mLocator.INPUT_CATEGORY_MAX_VALUE, name.maxValueCategory);
        element.click(mLocator.BUTTON_ADD_CATEGORY);
        driver.waitForLoadState(LoadState.NETWORKIDLE);
        String secondMaxLocator = mLocator.INPUT_CATEGORY_MAX_VALUE.replace("-0", "-1");
        boolean secondFilled = fillAndValidate(secondMaxLocator, name.maxValueCategory);
        return firstFilled && secondFilled;
    }

    @Override
    public void directUrlToClient() {
        element.navigateToUrl(Host.clientHost() + "admin/proficiency");
        element.verifyElement(mLocator.BUTTON_ADD_CATEGORY_INTERPRETATION_GUIDANCE);
    }

    private boolean fillAndValidate(String locator, String value) {
        driver.waitForLoadState(LoadState.NETWORKIDLE);
        element.setText(locator, value);
        return element.getTextFromInput(locator).equals(value);
    }
}
