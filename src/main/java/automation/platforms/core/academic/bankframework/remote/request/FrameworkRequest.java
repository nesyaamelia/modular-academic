package automation.platforms.core.academic.bankframework.remote.request;

import automation.data.User;
import automation.remote.api.base.BaseRequest;

public class FrameworkRequest extends BaseRequest<FrameworkRequest> {

  public Integer id;
  public String name;
  public Integer owner_organization_id;
  public String code;
  public String description;
  public Integer status;

  @Override
  public FrameworkRequest getBody() {
    return this;
  }

  public FrameworkRequest() {
    User userModel = new User();
    this.id = 0;
    this.name = "Engineer - " + userModel.password.toUpperCase();
    this.owner_organization_id = 0;
    this.code = userModel.password.toUpperCase();
    this.description = "Engineer - " + userModel.password.toUpperCase();
    this.status = 1;
  }
}