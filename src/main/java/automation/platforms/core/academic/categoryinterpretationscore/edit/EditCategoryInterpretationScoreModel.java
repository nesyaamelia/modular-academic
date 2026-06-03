package automation.platforms.core.academic.categoryinterpretationscore.edit;

import automation.platforms.base.BaseModel;
import automation.helper.RandomNumber;

public class EditCategoryInterpretationScoreModel extends BaseModel {
  public String nameInterpretationGuidance;
  public String nameCategory;
  public String maxValueCategory;
  public String valueCategory;
  public String gradeCategory;

  public int randomNumber = RandomNumber.getRandomInteger(1, 1000);

  public EditCategoryInterpretationScoreModel validNameInterpretationGuidance() {
    nameInterpretationGuidance = "[Automation] Edited Interpretasi Nilai " + randomNumber;
    return this;
  }

  public EditCategoryInterpretationScoreModel validNameCategory() {
    nameCategory = "[Automation] Edited Kategori " + randomNumber;
    return this;
  }

  public EditCategoryInterpretationScoreModel validMaxValueCategory() {
    maxValueCategory = "100";
    return this;
  }

  public EditCategoryInterpretationScoreModel validValueCategory() {
    valueCategory = "50";
    return this;
  }

  public EditCategoryInterpretationScoreModel validGradeCategory() {
    gradeCategory = "L-201";
    return this;
  }

  public EditCategoryInterpretationScoreModel invalidCharGradeCategory() {
    gradeCategory = "L#201";
    return this;
  }

  public EditCategoryInterpretationScoreModel duplicateNameInterpretationGuidance() {
    nameInterpretationGuidance = "Tes Panduan 2";
    nameCategory = "[Automation] Kategori " + randomNumber;
    maxValueCategory = "100";
    gradeCategory = "L-201";
    return this;
  }

  public EditCategoryInterpretationScoreModel invalidNameLongChars() {
    nameInterpretationGuidance = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed neque tortor, commodo nec eros dictum, consectetur rhoncus erat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed neque tortor, commodo nec eros dictum.";
    nameCategory = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed neque tortor, commodo nec eros dictum, consectetur rhoncus erat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed neque tortor, commodo nec eros dictum.";
    gradeCategory = "L-121212121";
    return this;
  }

  public EditCategoryInterpretationScoreModel invalidMaxValueCategory() {
    maxValueCategory = "1000";
    return this;
  }

  public EditCategoryInterpretationScoreModel invalidDecimalMaxValueCategory() {
    maxValueCategory = "99.5";
    return this;
  }

  public EditCategoryInterpretationScoreModel invalidLessThanMinMaxValueCategory() {
    maxValueCategory = "-10";
    return this;
  }
}
