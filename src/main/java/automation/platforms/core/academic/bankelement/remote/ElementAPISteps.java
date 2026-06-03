package automation.platforms.core.academic.bankelement.remote;

import automation.platforms.core.academic.bankelement.remote.response.ElementResponse;
import automation.remote.api.platforms.core.assessment.ApiResult;

public interface ElementAPISteps {

    ApiResult<ElementResponse> createNewElement(Integer clusterId, Integer frameworkId);
}
