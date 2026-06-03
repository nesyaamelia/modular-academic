package automation.platforms.core.academic.bankframework.remote;

import automation.config.GeneralConfiguration;
import automation.config.GlobalVariable;
import automation.platforms.core.academic.bankframework.remote.request.FrameworkRequest;
import automation.platforms.core.academic.bankframework.remote.response.FrameworkResponse;
import automation.remote.api.base.BaseApiClient;
import automation.remote.api.path.LearningPaths;
import automation.remote.api.platforms.core.assessment.ApiActions;
import automation.remote.api.platforms.core.assessment.ApiResult;
import automation.remote.api.platforms.core.user.LoginAPI;
import com.microsoft.playwright.Playwright;

public class FrameworkAPI implements FrameworkAPISteps {

    private final ApiActions api;

    public FrameworkAPI() {
        Playwright playwright = GeneralConfiguration.getInstance().getPlaywright();
        GlobalVariable globalVariable = GlobalVariable.getInstance();
        BaseApiClient apiClient = new BaseApiClient(playwright, globalVariable.getAccessToken(), true);
        this.api = new ApiActions(apiClient);
    }

    @Override
    public ApiResult<FrameworkResponse> createNewFramework() {
        FrameworkRequest frameworkRequest = new FrameworkRequest();
        return api.post(LearningPaths.FRAMEWORK_MANAGE.getUrl(), frameworkRequest.toJsonString(), FrameworkResponse.class);
    }
}