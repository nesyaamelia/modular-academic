package automation.platforms.core.academic.bankcluster.remote;

import automation.platforms.core.academic.bankcluster.remote.response.ClusterResponse;
import automation.remote.api.platforms.core.assessment.ApiResult;

public interface ClusterAPISteps {

    ApiResult<ClusterResponse> createNewCluster(int id, String name);
}
