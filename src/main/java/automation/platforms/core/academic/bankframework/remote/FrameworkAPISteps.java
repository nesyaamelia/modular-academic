package automation.platforms.core.academic.bankframework.remote;

import automation.platforms.core.academic.bankframework.remote.response.FrameworkResponse;
import automation.remote.api.platforms.core.assessment.ApiResult;

public interface FrameworkAPISteps {

    ApiResult<FrameworkResponse> createNewFramework();
}
