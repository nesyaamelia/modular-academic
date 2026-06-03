package automation.platforms.core.academic.bankdimension.remote;

import automation.config.GeneralConfiguration;
import automation.config.GlobalVariable;
import automation.platforms.core.academic.bankdimension.remote.request.DimensionRequest;
import automation.platforms.core.academic.bankdimension.remote.response.DimensionResponse;
import automation.remote.api.base.BaseApiClient;
import automation.remote.api.path.LearningPaths;
import automation.remote.api.platforms.core.assessment.ApiActions;
import automation.remote.api.platforms.core.assessment.ApiResult;
import automation.remote.api.platforms.core.user.LoginAPI;
import com.microsoft.playwright.Playwright;

public class DimensionAPI implements DimensionAPISteps {

    private final ApiActions api;

    public DimensionAPI() {
        Playwright playwright = GeneralConfiguration.getInstance().getPlaywright();
        GlobalVariable globalVariable = GlobalVariable.getInstance();
        BaseApiClient apiClient = new BaseApiClient(playwright, globalVariable.getAccessToken(), true);
        this.api = new ApiActions(apiClient);
    }

    @Override
    public ApiResult<DimensionResponse> createNewElement(Integer elementId, Integer clusterId, Integer frameworkId) {
        DimensionRequest dimensionRequest = new DimensionRequest(elementId, clusterId, frameworkId);
        return api.post(LearningPaths.DIMENSION_MANAGE.getUrl(), dimensionRequest.toJsonString(), DimensionResponse.class);
    }
}