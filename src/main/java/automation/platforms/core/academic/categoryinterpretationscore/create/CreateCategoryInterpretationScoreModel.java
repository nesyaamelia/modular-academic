package automation.platforms.core.academic.categoryinterpretationscore.create;

import automation.platforms.base.BaseModel;
import automation.helper.RandomNumber;

public class CreateCategoryInterpretationScoreModel extends BaseModel {
  public String nameInterpretationGuidance;
  public String nameCategory;
  public String maxValueCategory;
  public String gradeCategory;

  public int randomNumber = RandomNumber.getRandomInteger(1, 1000);

  public CreateCategoryInterpretationScoreModel validNameInterpretationGuidance() {
    nameInterpretationGuidance = "[Automation] Interpretasi Nilai " + randomNumber;
    return this;
  }

  public CreateCategoryInterpretationScoreModel validNameCategory() {
    nameCategory = "[Automation] Kategori " + randomNumber;
    return this;
  }

  public CreateCategoryInterpretationScoreModel validMaxValueCategory() {
    maxValueCategory = "100";
    return this;
  }

  public CreateCategoryInterpretationScoreModel validValueCategory() {
    maxValueCategory = "50";
    return this;
  }

  public CreateCategoryInterpretationScoreModel validGradeCategory() {
    gradeCategory = "L-201";
    return this;
  }

  public CreateCategoryInterpretationScoreModel invalidCharGradeCategory() {
    gradeCategory = "L#201";
    return this;
  }

  public CreateCategoryInterpretationScoreModel duplicateNameInterpretationGuidance() {
    nameInterpretationGuidance = "Tes Panduan 2";
    nameCategory = "[Automation] Kategori " + randomNumber;
    maxValueCategory = "100";
    gradeCategory = "L-201";
    return this;
  }

  public CreateCategoryInterpretationScoreModel invalidNameLongChars() {
    nameInterpretationGuidance = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed neque tortor, commodo nec eros dictum, consectetur rhoncus erat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed neque tortor, commodo nec eros dictum.";
    nameCategory = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed neque tortor, commodo nec eros dictum, consectetur rhoncus erat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed neque tortor, commodo nec eros dictum.";
    gradeCategory = "L-121212121";
    return this;
  }

  public CreateCategoryInterpretationScoreModel invalidMaxValueCategory() {
    maxValueCategory = "1000";
    return this;
  }

  public CreateCategoryInterpretationScoreModel invalidDecimalMaxValueCategory() {
    maxValueCategory = "99.5";
    return this;
  }

  public CreateCategoryInterpretationScoreModel invalidLessThanMinMaxValueCategory() {
    maxValueCategory = "-10";
    return this;
  }

}
