package automation.platforms.core.academic.bankcluster.remote.response;

import automation.remote.api.base.BaseResponse;

public class ClusterResponse extends BaseResponse {

    public Data data;

    public static class Data {
        public Integer id;
        public String name;
        public String code;
    }
}
