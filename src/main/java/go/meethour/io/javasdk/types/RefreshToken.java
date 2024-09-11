package go.meethour.io.javasdk.types;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;


public class RefreshToken {
    private String clientId;
    private String clientSecret;
    private String refreshToken;
    private final String grantType = "refresh_token";

    public RefreshToken(String clientId, String clientSecret, String refreshToken, String access_token) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.refreshToken = refreshToken;
    }

    public   String prepare() {
        Map<String, String> data = new HashMap<String, String>();
        data.put("client_id", clientId);
        data.put("client_secret", clientSecret);
        data.put("grant_type", grantType);
        data.put("refresh_token", refreshToken);
        Gson gson = new Gson();
        return gson.toJson(data);
    }
}

