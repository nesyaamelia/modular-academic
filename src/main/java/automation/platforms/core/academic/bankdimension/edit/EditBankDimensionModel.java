package automation.platforms.core.academic.bankdimension.edit;

import automation.platforms.base.BaseModel;

public class EditBankDimensionModel extends BaseModel {
    public String idDimension;
    public String nameDimension;
    public String codeDimension;
    public String descriptionDimension;

    public EditBankDimensionModel navigateToEditPage() {
        nameDimension = "Bank Dimension 864";
        idDimension = "99";
        return this;
    }

    public EditBankDimensionModel validEditBankDimension(){
        nameDimension = "Bank Dimension Edit 864";
        codeDimension = "BD800";
        descriptionDimension = "Description Edit Bank Dimension 864";
        return this;
    }

    public EditBankDimensionModel emptyMandatoryField(){
        nameDimension = "";
        return this;
    }

    public EditBankDimensionModel editFieldDimensionWithLongChars(){
        nameDimension = "Dimension Utama Wilayah Operasional Teknologi Digital Terintegrasi Nasional Alpha Beta Gamma Delta panjang";
        codeDimension = "QA-00001E1234567891234567891234";
        descriptionDimension = "Competences encompassing the skills related to understanding requirements, conceptualizing solutions, planning technical approaches, and evaluating system performance against objectives. These skills are crucial for defining what needs to be built or improved and how it should function edit. panjangCompetences encompassing the skills related to understanding requirements, conceptualizing solutions, planning technical approaches, and evaluating system performance against objectives. These skills are crucial for defining what needs to be built or improved and how it should function edit. panjang";
        return this;
    }

    public EditBankDimensionModel sameNameDimension(){
        nameDimension = "Automation Dimension Assessment";
        return this;
    }

    public EditBankDimensionModel sameCodeDimension(){
        codeDimension = "AUT-DIMENSION-01";
        return this;
    }

    public EditBankDimensionModel specialCharsCodeDimension(){
        codeDimension = "INT-SID/2025@10@11";
        return this;
    }
}
