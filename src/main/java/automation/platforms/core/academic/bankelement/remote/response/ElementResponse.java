package automation.platforms.core.academic.bankelement.remote.response;

import automation.remote.api.base.BaseResponse;

public class ElementResponse extends BaseResponse {

    public Data data;

    public static class Data {
        public Integer id;
        public String name;
        public String code;
    }
}
