package automation.platforms.core.academic.bankdimension.remote;

import automation.platforms.core.academic.bankdimension.remote.response.DimensionResponse;
import automation.remote.api.platforms.core.assessment.ApiResult;

public interface DimensionAPISteps {

    ApiResult<DimensionResponse> createNewElement(Integer elementId, Integer clusterId, Integer frameworkId);
}
