package go.meethour.io.javasdk.types;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class UserDetails {
    private Boolean success;
    private Integer code;
    private String message;
    private Object data;

    public UserDetails() {
    }

    public String prepare() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", success);
        map.put("code", code);
        map.put("message", message);
        map.put("data", data);

        Gson gson = new Gson();
        return gson.toJson(map);
    }

}
