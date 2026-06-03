package automation.platforms.core.academic.bankframework;

public interface BankFrameworkSteps{
    boolean navigateToPageBankFramework();
    boolean fillNameBankFramework(String name);
    boolean fillCodeBankFramework(String code);
    boolean fillDescriptionBankFramework(String description);
    boolean selectOrganizerProvider(String organizer);
    boolean clickButtonSaveFramework();
    boolean clickButtonCancelFramework();
    boolean getValidationMessages();
    boolean validationPopUp(boolean isCancel);
    boolean searchBankFramework(String name);
    boolean clickButtonDetail(int index);
    boolean clickButtonEdit(int index);
    boolean selectRowDisplay(String row);
}
