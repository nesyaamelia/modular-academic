package mu.core.id.website.testcase.platforms.core.academic.bankcontent.edit;

import org.testng.annotations.Test;

public interface EditBankContentTestCase {
    void editContentSuccessfullyEditContent();
    void editContentFailedEditContentWhenUserDoesnTFillAllField();
    void editContentFailedEditContentWhenUserInputNamaKontenBelajarMoreThan_200Characters();
}
