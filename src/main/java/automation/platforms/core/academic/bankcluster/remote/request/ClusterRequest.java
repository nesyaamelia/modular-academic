package automation.platforms.core.academic.bankcluster.remote.request;

import automation.data.User;
import automation.remote.api.base.BaseRequest;

import java.util.List;

public class ClusterRequest extends BaseRequest<ClusterRequest> {

  public Integer id;
  public String name;
  public Integer owner_organization_id;
  public String code;
  public String description;
  public Integer status;
  public List<Framework> frameworks;

  public static class Framework {
    public Integer frameworkId;
    public String frameworkName;

    public Framework(Integer frameworkId, String frameworkName) {
      this.frameworkId = frameworkId;
      this.frameworkName = frameworkName;
    }
  }

  @Override
  public ClusterRequest getBody() {
    return this;
  }

  public ClusterRequest(int id, String name) {
    User userModel = new User();
    this.id = 0;
    this.name = "Engineer Cluster - " + userModel.password.toUpperCase();
    this.owner_organization_id = 0;
    this.code = userModel.password.toUpperCase();
    this.description = "Engineer Cluster - " + userModel.password.toUpperCase();
    this.status = 1;
    this.frameworks = List.of(new Framework(id, name));
  }

  // ini dipakai kalau frameworknya lebih dari 1, nanti dipakainya di depan kaya
  // gini:
  // ClusterRequest request = new ClusterRequest(0, "")
  // .withFrameworks(List.of(
  // new ClusterRequest.Framework(101, "Framework 1"),
  // new ClusterRequest.Framework(102, "Framework 2")));

  public ClusterRequest withFrameworks(List<Framework> frameworks) {
    this.frameworks = frameworks;
    return this;
  }
}