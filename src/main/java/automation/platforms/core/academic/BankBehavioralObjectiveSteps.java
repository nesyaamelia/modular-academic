package automation.platforms.core.academic.bankbehavioralobjective;

public interface BankBehavioralObjectiveSteps {

    boolean fillNameBehavioralObjective(String name);

    boolean fillCodeBehavioralObjective(String code);

    boolean selectTahapPerkembangan();

    boolean selectElement(boolean isSearch, BankBehavioralObjectiveModel data);

    boolean verifyValidation();

    boolean clickButtonAddBankBehavioralObjective();

    boolean clickButtonSaveBehavioralObjective(boolean isSuccess);

    boolean searchBehavioralObjective(BankBehavioralObjectiveModel data);

    boolean filterBehavioralObjective(String isFilter, BankBehavioralObjectiveModel data);

    boolean toggleStatus(String isToggle, String submitOption);

    boolean detailBehavioralObjective();

    void directToClientUrl();

    boolean addBehavioralObjective(BankBehavioralObjectiveModel behavioralObjectiveModel);

    boolean validateFieldElementAtBehavioralObjective(BankBehavioralObjectiveModel behavioralObjectiveModel);

    boolean editBehavioralObjective(BankBehavioralObjectiveModel behavioralObjectiveModel);

    boolean injectAcademicFrameworkForBO();
}
