package automation.platforms.core.academic.bankdimension.remote.request;

import automation.data.User;
import automation.remote.api.base.BaseRequest;

import java.util.List;

public class DimensionRequest extends BaseRequest<DimensionRequest> {

    public Integer id;
    public String name;
    public Integer owner_organization_id;
    public String code;
    public String description;
    public Integer status;
    public List<Element> elements;

    public static class Element {
        public Integer elementId;
        public Integer clusterId;
        public Integer frameworkId;

        public Element(Integer elementId, Integer clusterId, Integer frameworkId) {
            this.elementId = elementId;
            this.clusterId = clusterId;
            this.frameworkId = frameworkId;
        }
    }

    @Override
    public DimensionRequest getBody() {
        return this;
    }

    public DimensionRequest(Integer elementId, Integer clusterId, Integer frameworkId) {
        User userModel = new User();
        this.id = 0;
        this.name = "Engineer Dimenstion - " + userModel.password.toUpperCase();
        this.owner_organization_id = 0;
        this.code = userModel.password.toUpperCase();
        this.description = "Engineer Dimenstion - " + userModel.password.toUpperCase();
        this.status = 1;
        this.elements = List.of(new Element(elementId, clusterId, frameworkId));
    }

    public DimensionRequest withFrameworks(List<Element> elements) {
        this.elements = elements;
        return this;
    }
}