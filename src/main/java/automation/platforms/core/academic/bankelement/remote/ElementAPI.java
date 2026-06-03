package automation.platforms.core.academic.bankelement.remote;

import automation.config.GeneralConfiguration;
import automation.config.GlobalVariable;
import automation.platforms.core.academic.bankelement.remote.request.ElementRequest;
import automation.platforms.core.academic.bankelement.remote.response.ElementResponse;
import automation.remote.api.base.BaseApiClient;
import automation.remote.api.path.LearningPaths;
import automation.remote.api.platforms.core.assessment.ApiActions;
import automation.remote.api.platforms.core.assessment.ApiResult;
import automation.remote.api.platforms.core.user.LoginAPI;
import com.microsoft.playwright.Playwright;

public class ElementAPI implements ElementAPISteps {

    private final ApiActions api;

    public ElementAPI() {
        Playwright playwright = GeneralConfiguration.getInstance().getPlaywright();
        GlobalVariable globalVariable = GlobalVariable.getInstance();
        BaseApiClient apiClient = new BaseApiClient(playwright, globalVariable.getAccessToken(), true);
        this.api = new ApiActions(apiClient);
    }

    @Override
    public ApiResult<ElementResponse> createNewElement(Integer clusterId, Integer frameworkId) {
        ElementRequest elementRequest = new ElementRequest(clusterId, frameworkId);
        return api.post(LearningPaths.ELEMENT_MASTER_MANAGE.getUrl(), elementRequest.toJsonString(), ElementResponse.class);
    }
}