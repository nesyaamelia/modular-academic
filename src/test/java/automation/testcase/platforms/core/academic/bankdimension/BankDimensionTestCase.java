package mu.core.id.website.testcase.platforms.core.academic.bankdimension;

public interface BankDimensionTestCase {
    void bankDimensionSuccessfullySearchDimensionByValidId();
    void bankDimensionSuccessfullySearchDimensionByNameMoreThan_3Character();
    void bankDimensionSuccessfullyFiltersAndSearchesDimensionWithValidInputCombinations();
    void bankDimensionSuccessfullyFilterByStatusTidakAktif();
    void detailDimensionSuccessfullyOpenDetailDimension();
    void detailDimensionUbahDimensionButtonRedirectToUbahDimensionPage();
}
