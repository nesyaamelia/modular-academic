package automation.platforms.core.academic.bankdimension.remote.response;

import automation.remote.api.base.BaseResponse;

public class DimensionResponse extends BaseResponse {

    public Data data;

    public static class Data {
        public Integer id;
        public String name;
        public String code;
    }
}
