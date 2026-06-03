package automation.platforms.core.academic.bankelement.remote.request;

import automation.data.User;
import automation.remote.api.base.BaseRequest;

import java.util.List;

public class ElementRequest extends BaseRequest<ElementRequest> {

    public Integer id;
    public String name;
    public Integer owner_organization_id;
    public String code;
    public String description;
    public Integer status;
    public List<Cluster> clusters;

    public static class Cluster {
        public Integer clusterId;
        public Integer frameworkId;

        public Cluster(Integer clusterId, Integer frameworkId) {
            this.clusterId = clusterId;
            this.frameworkId = frameworkId;
        }
    }

    @Override
    public ElementRequest getBody() {
        return this;
    }

    public ElementRequest(Integer clusterId, Integer frameworkId) {
        User userModel = new User();
        this.id = 0;
        this.name = "Engineer Element - " + userModel.password.toUpperCase();
        this.owner_organization_id = 0;
        this.code = userModel.password.toUpperCase();
        this.description = "Engineer Element - " + userModel.password.toUpperCase();
        this.status = 1;
        this.clusters = List.of(new Cluster(clusterId, frameworkId));
    }

    public ElementRequest withFrameworks(List<Cluster> clusters) {
        this.clusters = clusters;
        return this;
    }
}