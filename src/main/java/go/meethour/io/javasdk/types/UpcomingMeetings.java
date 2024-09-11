package go.meethour.io.javasdk.types;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class UpcomingMeetings {
    private Integer limit;
    private Integer page;
    private Integer showAll;

    public UpcomingMeetings(Integer limit, Integer page, Integer showAll) {
        this.limit = limit;
        this.page = page;
        this.showAll = showAll;
    }

    public String prepare() {
        Map<String, Object> upcomingMeetings = new HashMap<String, Object>();
        if (this.limit != null) {
            upcomingMeetings.put("limit", this.limit);
        }
        if (this.page != null) {
            upcomingMeetings.put("page", this.page);
        }
        if (this.showAll != null) {
            upcomingMeetings.put("show_all", this.showAll);
        }
        Gson gson = new Gson();
        return gson.toJson(upcomingMeetings);

    }

}
