package go.meethour.io.javasdk.types;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class GenerateJwt {
    private String meetingId;
    private Integer contactId;
    private Object uiConfig;
    private Object config;

    public GenerateJwt(String meetingId, Integer contactId, Object uiConfig, Object config) {
        this.meetingId = meetingId;
        this.contactId = contactId;
        this.uiConfig = uiConfig;
        this.config = config;
    }

    public GenerateJwt(String meetingId) {
        this(meetingId, null, null, null);
    }

    public String prepare() {
        Map<String, Object> generateJwt = new HashMap<String, Object>();
        generateJwt.put("meeting_id", meetingId);
        generateJwt.put("contact_id", contactId);

        if (config != null) {
            generateJwt.put("config", config);
        }
        if (uiConfig != null) {
            generateJwt.put("ui_config", uiConfig);
        }
        Gson gson = new Gson();
        return gson.toJson(generateJwt);
    }
}
