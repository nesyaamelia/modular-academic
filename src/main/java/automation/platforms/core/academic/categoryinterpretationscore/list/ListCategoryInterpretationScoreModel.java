package automation.platforms.core.academic.categoryinterpretationscore.list;

import automation.platforms.base.BaseModel;

public class ListCategoryInterpretationScoreModel extends BaseModel {
  public String searchName;
  public String searchId;
  public String slugLink;

  public ListCategoryInterpretationScoreModel validSearch(){
    searchName = "[Automation] Interpretasi Nilai 65";
    searchId = "15";
    return this;
  }

  public ListCategoryInterpretationScoreModel validSlugLink(){
    slugLink = "/proficiency/detail/92";
    return this;
  }
  
}
