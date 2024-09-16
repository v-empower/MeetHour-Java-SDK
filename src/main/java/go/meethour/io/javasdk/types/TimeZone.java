package go.meethour.io.javasdk.types;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class TimeZone {
    private Boolean success;
    private String message;
    private Object timeZoneName;

    public TimeZone() {

    }

    public String prepare() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", success);
        map.put("message", message);
        map.put("timeZoneName", timeZoneName);
        Gson gson = new Gson();
        return gson.toJson(map);
    }

}
