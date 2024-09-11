package go.meethour.io.javasdk.types;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class CompletedMeetings {
    private Integer limit;
    private Integer page;
    private Boolean showAll;

    public CompletedMeetings() {
        this.limit = null;
        this.page = null;
        this.showAll = null;
    }

    public String prepare() {
        Map<String, Object> completeMeeting = new HashMap<String, Object>();
        if (this.showAll != null) {
            completeMeeting.put("show_all", this.showAll);
        }
        if (this.limit != null) {
            completeMeeting.put("limit", this.limit);
        }
        if (this.page != null) {
            completeMeeting.put("page", this.page);
        }
        Gson gson = new Gson();
        return gson.toJson(completeMeeting);

    }

}
