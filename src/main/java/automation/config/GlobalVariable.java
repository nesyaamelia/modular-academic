package automation.config;

/**
 * Global constants and runtime variables shared across the test suite.
 * Provides timeout constants and stores session-level data like access tokens.
 */
public class GlobalVariable {

    private static GlobalVariable instance;

    // ===== Timeout Constants (milliseconds) =====
    public static final int ONE_SEC_IN_MILLIS   = 1_000;
    public static final int TWO_SEC_IN_MILLIS   = 2_000;
    public static final int THREE_SEC_IN_MILLIS = 3_000;
    public static final int FIVE_SEC_IN_MILLIS  = 5_000;
    public static final int TEN_SEC_IN_MILLIS   = 10_000;
    public static final int THIRTY_SEC_IN_MILLIS = 30_000;

    // ===== Runtime Variables =====
    private String accessToken;
    private String baseUrl;
    private String apiBaseUrl;

    private GlobalVariable() {
        this.baseUrl    = System.getenv().getOrDefault("BASE_URL", "http://localhost:3000");
        this.apiBaseUrl = System.getenv().getOrDefault("API_BASE_URL", "http://localhost:8080");
    }

    public static synchronized GlobalVariable getInstance() {
        if (instance == null) {
            instance = new GlobalVariable();
        }
        return instance;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getApiBaseUrl() {
        return apiBaseUrl;
    }
}
