package automation.platforms.core.academic.bankdimension.create;

import automation.helper.RandomNumber;
import automation.platforms.base.BaseModel;

public class CreateBankDimensionModel extends BaseModel {
    public String descriptionDimension;
    public String nameOrganization;
    public String searchElement;

    public int randomNumber = RandomNumber.getRandomInteger(1, 1000);

    public String validNameDimension() {
        return "Bank Dimension " + randomNumber;
    }

    public String validCodeDimension() {
        return "DIM-" + randomNumber;
    }

    public CreateBankDimensionModel validDescriptionDimension() {
        descriptionDimension = "Dimension for Automation Testing";
        return this;
    }

    public CreateBankDimensionModel validOrganization() {
        nameOrganization = "NSY Tech";
        return this;
    }

    public String validNameDimensionLongChars(){
        return "Dimension Utama Wilayah Operasional Teknologi Digital Terintegrasi Nasional Alpha Beta Gamma" + randomNumber;
    }

    public String validCodeDimensionLongChars(){
        return "DI-1234567890abcdefghi" + randomNumber;
    }

    public CreateBankDimensionModel validDescriptionLongChars() {
        descriptionDimension = "Deskripsi Dimension: Competences encompassing the skills related to understanding requirements, conceptualizing solutions, planning technical approaches, and evaluating system performance against objectives. These skills are crucial for defining what needs to be built or improved and how it should function. Deskripsi Dimension: Competences encompassing the skills related to understanding requirements, conceptualizing solutions, planning technical approaches";
        return this;
    }

    public CreateBankDimensionModel searchAndSelectMultipleElement() {
        searchElement = "element naga";
        return this;
    }

    public String invalidNameDimensionLongChars(){
        return "Dimension Utama Wilayah Operasional Teknologi Digital Terintegrasi Nasional Alpha Beta Gamma Delta Panjang" + randomNumber;
    }

    public String invalidCodeDimensionLongChars(){
        return "INT-1234567890abcdefghijklmnopqpanjang" + randomNumber;
    }

    public CreateBankDimensionModel invalidDescriptionLongChars() {
        descriptionDimension = "Competences encompassing the skills related to understanding requirements, conceptualizing solutions, planning technical approaches, and evaluating system performance against objectives. These skills are crucial for defining what needs to be built or improved and how it should function.panjang Competences encompassing the skills related to understanding requirements, conceptualizing solutions, planning technical approaches, and evaluating system performance against objectives. These skills are crucial for defining what needs to be built or improved and how it should function.panjang";
        return this;
    }

    public String sameNameDimension(){
        return "Automation Dimension Assessment";
    }

    public String sameCodeDimension() {
        return "AUT-DIMENSION-01";
    }

    public String specialCharsCodeDimension(){
        return "INT-SID/2025@10@11";
    }
}
