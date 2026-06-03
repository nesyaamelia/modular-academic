package automation.platforms.core.academic.bankcluster.remote;

import automation.config.GeneralConfiguration;
import automation.config.GlobalVariable;
import automation.platforms.core.academic.bankcluster.remote.request.ClusterRequest;
import automation.platforms.core.academic.bankcluster.remote.response.ClusterResponse;
import automation.remote.api.base.BaseApiClient;
import automation.remote.api.path.LearningPaths;
import automation.remote.api.platforms.core.assessment.ApiActions;
import automation.remote.api.platforms.core.assessment.ApiResult;
import automation.remote.api.platforms.core.user.LoginAPI;
import com.microsoft.playwright.Playwright;

public class ClusterAPI implements ClusterAPISteps {

    private final ApiActions api;

    public ClusterAPI() {
        Playwright playwright = GeneralConfiguration.getInstance().getPlaywright();
        GlobalVariable globalVariable = GlobalVariable.getInstance();
        BaseApiClient apiClient = new BaseApiClient(playwright, globalVariable.getAccessToken(), true);
        this.api = new ApiActions(apiClient);
    }

    @Override
    public ApiResult<ClusterResponse> createNewCluster(int id, String name) {
        ClusterRequest clusterRequest = new ClusterRequest(id, name);
        return api.post(LearningPaths.CLUSTER_MANAGE.getUrl(), clusterRequest.toJsonString(), ClusterResponse.class);
    }
}