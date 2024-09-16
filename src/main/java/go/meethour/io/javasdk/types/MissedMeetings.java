package go.meethour.io.javasdk.types;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class MissedMeetings {

    private Integer limit;
    private Integer page;
    private Integer showAll;

    public MissedMeetings(Integer limit, Integer page, Integer showAll) {
        this.limit = limit;
        this.page = page;
        this.showAll = showAll;
    }

    public String prepare() {
        Map<String, Integer> missedMeetings = new HashMap<String, Integer>();
        if (limit != null) {
            missedMeetings.put("limit", limit);
        }
        if (showAll != null) {
            missedMeetings.put("show_all", showAll);
        }
        if (page != null) {
            missedMeetings.put("page", page);
        }
        Gson gson = new Gson();
        return gson.toJson(missedMeetings);
    }

}
