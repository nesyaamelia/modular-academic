package automation.platforms.core.academic.bankframework.remote.response;

import automation.remote.api.base.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class FrameworkResponse extends BaseResponse {

    public Data data;

    public static class Data {
        public Integer id;
        public String name;
        public String code;
    }
}
