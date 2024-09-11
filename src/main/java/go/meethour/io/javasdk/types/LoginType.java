package go.meethour.io.javasdk.types;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class LoginType {
    private String client_id;
    private String client_secret;
    private String grant_type;
    private String username;
    private String password;

    public LoginType(String client_id, String client_secret, String grant_type, String username, String password) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.grant_type = grant_type;
        this.username = username;
        this.password = password;
    }

    public String prepare() {
        Map<String, String> data = new HashMap<String, String>();
        data.put("client_id", client_id);
        data.put("client_secret", client_secret);
        data.put("grant_type", grant_type);
        data.put("password", password);
        data.put("username", username);

        Gson gson = new Gson();
        return gson.toJson(data);
    }

}
