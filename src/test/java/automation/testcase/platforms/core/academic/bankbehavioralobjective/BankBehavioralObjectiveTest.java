package mu.core.id.website.testcase.platforms.core.academic.bankbehavioralobjective;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import automation.platforms.core.academic.bankbehavioralobjective.BankBehavioralObjectiveLocator;
import automation.platforms.core.academic.bankbehavioralobjective.BankBehavioralObjectiveModel;
import automation.platforms.core.academic.bankbehavioralobjective.BankBehavioralObjectivePage;
import automation.platforms.core.academic.bankbehavioralobjective.BankBehavioralObjectiveSteps;
import automation.platforms.core.academic.sidemenu.MenuCoreOptions;
import automation.platforms.core.academic.sidemenu.MenuCorePage;
import automation.platforms.core.academic.sidemenu.MenuCoreSteps;
import automation.platforms.core.user.login.LoginCorePage;
import automation.platforms.core.user.login.LoginCoreSteps;
import mu.core.id.website.testcase.platforms.core.BaseCoreDriverTest;
import org.testng.annotations.Test;

import static automation.utils.StepLogger.verifyStep;

@Epic("Platform Core")
@Feature("Academic - Bank Behavioral Objective")
public class BankBehavioralObjectiveTest extends BaseCoreDriverTest implements BankBehavioralObjectiveTestCase {

    private BankBehavioralObjectiveSteps bankBehavioralObjectiveSteps;
    private BankBehavioralObjectiveModel bankBehavioralObjectiveModel;
    private BankBehavioralObjectiveLocator bankBehavioralObjectiveLocator;
    private LoginCoreSteps loginCoreSteps;
    private MenuCoreSteps menuCoreSteps;

    @Override
    public void initInstance() {
        super.initInstance();
        bankBehavioralObjectiveSteps = new BankBehavioralObjectivePage(page);
        bankBehavioralObjectiveModel = new BankBehavioralObjectiveModel();
        bankBehavioralObjectiveLocator = new BankBehavioralObjectiveLocator();
        loginCoreSteps = new LoginCorePage(page);
        menuCoreSteps = new MenuCorePage(page);
    }

    @Test(priority = 1, description = "depend = 1948, 1951")
    @Override
    public void bankBehavioralObjectiveSuccessfullySearchBehavioralObjectiveByValidId() {
        navigateToBankBehavioralObject();
        verifyStep(bankBehavioralObjectiveSteps.searchBehavioralObjective(bankBehavioralObjectiveModel.searchIDBehavioralObjective()), "Successfully fill search by valid id", "Failed fill search by valid id");
    }

    @Test(priority = 2, description = "1953")
    @Override
    public void bankBehavioralObjectiveSuccessfullySearchBehavioralObjectiveByNameMoreThan_3Character() {
        navigateToBankBehavioralObject();
        verifyStep(bankBehavioralObjectiveSteps.searchBehavioralObjective(bankBehavioralObjectiveModel.searchNameBehavioralObjective()), "Successfully fill search by name more than 3 character", "Failed fill search by valid name");
    }

    @Test(priority = 3, description = "1957")
    @Override
    public void bankBehavioralObjectiveSuccessfullyFilterByStatus() {
        navigateToBankBehavioralObject();
        verifyStep(bankBehavioralObjectiveSteps.filterBehavioralObjective(bankBehavioralObjectiveLocator.FILTER_STATUS, bankBehavioralObjectiveModel.filterByStatus()), "Successfully filter by status", "Failed filter by status");
    }

    @Test(priority = 4, description = "depend = 1958, 1959")
    @Override
    public void bankBehavioralObjectiveSuccessfullyFilterByTahapPerkembangan() {
        navigateToBankBehavioralObject();
        verifyStep(bankBehavioralObjectiveSteps.filterBehavioralObjective(bankBehavioralObjectiveLocator.FILTER_STAGE_DEVELOPMENT, bankBehavioralObjectiveModel.filterByTahapPerkembangan()), "Successfully filter by tahap perkembangan", "Failed filter by tahap perkembangan");
        verifyStep(bankBehavioralObjectiveSteps.searchBehavioralObjective(bankBehavioralObjectiveModel.searchNameBehavioralObjective()), "Successfully fill search by name more than 3 character", "Failed fill search by valid name");
    }

    @Test(priority = 5, description = "depend = 1973, 1976, 1994, 1999)")
    @Override
    public void tambahBehavioralObjectiveSuccessfullyCreateBehavioralObjectiveWithValidData() {
        navigateToBankBehavioralObject();
        verifyStep(bankBehavioralObjectiveSteps.addBehavioralObjective(bankBehavioralObjectiveModel.validData()), "Success create Bank BO With Valid Data", "Failed create Bank BO With Valid Data");
    }

    @Test(priority = 6, description = "depend = 1977, 1978")
    @Override
    public void tambahBehavioralObjectiveSuccessfullyCreateBehavioralObjectiveWithMaximumLengthInputs() {
        navigateToBankBehavioralObject();
        verifyStep(bankBehavioralObjectiveSteps.addBehavioralObjective(bankBehavioralObjectiveModel.maxLengthWithValidData()), "Success create Bank BO With Max Length Valid Data", "Failed create Bank BO With Valid Data");
    }

    @Test(priority = 7, description = "depend = 1981, 1982")
    @Override
    public void tambahBehavioralObjectiveFailedToAddMultipleElementsAndAtLeastOneHasDuplicateRelations() {
        navigateToBankBehavioralObject();
        verifyStep(bankBehavioralObjectiveSteps.validateFieldElementAtBehavioralObjective(bankBehavioralObjectiveModel.selectAddSameElement()), "Success validate with same element", "Failed validate with same element");
    }

    @Test(priority = 8, description = "1983, 1984, 1985")
    @Override
    public void tambahBehavioralObjectiveFailedToAddElementWithUpdatedDataWhenAllElementRelationsHaveBeenAdded() {
        navigateToBankBehavioralObject();
        verifyStep(bankBehavioralObjectiveSteps.validateFieldElementAtBehavioralObjective(bankBehavioralObjectiveModel.selectAllElement()), "Success validate select all element", "Failed validate select all element");
    }

    @Test(priority = 9, description = "2000")
    @Override
    public void tambahBehavioralObjectiveFailedToSearchElementWhenDataNotFound() {
        navigateToBankBehavioralObject();
        verifyStep(bankBehavioralObjectiveSteps.validateFieldElementAtBehavioralObjective(bankBehavioralObjectiveModel.searchInvalidElement()), "Success validate invalid search element", "Failed validate invalid search element");
    }

    @Test(priority = 10, description = "depend = 1990, 1991, 1992, 1993")
    @Override
    public void tambahBehavioralObjectiveFailedToCreateBehavioralObjectiveWhenMandatoryFieldIsEmpty() {
        navigateToBankBehavioralObject();
        verifyStep(bankBehavioralObjectiveSteps.addBehavioralObjective(bankBehavioralObjectiveModel.emptyData()), "Success create Bank BO With Valid Data", "Failed create Bank BO With Valid Data");
    }

    @Test(priority = 11, description = "1995")
    @Override
    public void tambahBehavioralObjectiveSuccessfullyAddMultipleElementAndAppearsInTable() {
        navigateToBankBehavioralObject();
        verifyStep(bankBehavioralObjectiveSteps.addBehavioralObjective(bankBehavioralObjectiveModel.validDataMultipleElement()), "Success create Bank BO With Multiple Element", "Failed create Bank BO With Multiple Element");
    }

    @Test(priority = 12, description = "depend = 2011, 2013, 2014, 2016, 2037, 2015")
    @Override
    public void ubahBehavioralObjectiveSuccessfullyEditAnExistingBehavioralObjectiveWithValidInputs() {
        navigateToBankBehavioralObject();
        verifyStep(bankBehavioralObjectiveSteps.editBehavioralObjective(bankBehavioralObjectiveModel.editBehavioralObjective()), "Success edit Bank BO With Valid Data", "Failed edit Bank BO With Valid Data");
    }

    @Test(priority = 13, description = "depend = 2017, 2018, 2019, 2023")
    @Override
    public void ubahBehavioralObjectiveFailedToEditAnExistingBehavioralObjectiveWhenMandatoryFieldIsEmpty() {
        navigateToBankBehavioralObject();
        verifyStep(bankBehavioralObjectiveSteps.editBehavioralObjective(bankBehavioralObjectiveModel.emptyData()), "Success edit Bank BO With Valid Data", "Failed edit Bank BO With Valid Data");
    }

    @Test(priority = 14, description = "2033")
    @Override
    public void detailBehavioralObjectiveSuccessfullyOpenDetailBehavioralObjective() {
        navigateToBankBehavioralObject();
        verifyStep(bankBehavioralObjectiveSteps.searchBehavioralObjective(bankBehavioralObjectiveModel.searchNameBehavioralObjective()), "Successfully fill search", "Failed fill search");
        verifyStep(bankBehavioralObjectiveSteps.detailBehavioralObjective(), "Successfully open detail behavioral objective", "Failed open detail behavioral objective");
    }

    private void navigateToBankBehavioralObject() {
        loginCoreSteps.injectLoginCoreCookies();
        verifyStep(menuCoreSteps.navigateToMenu(MenuCoreOptions.MANAGE_BANK_BEHAVIORAL_OBJECTIVE),
                "Successfully navigate to Behavioral Objective menu",
                "Failed navigate to Bank Behavioral Objective menu");
    }
}
