package go.meethour.io.javasdk.types;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class RecordingsList {
    private String filterBy;
    private Integer limit;
    private Integer page;

    public RecordingsList(String filterBy, Integer limit, Integer page) {
        this.filterBy = filterBy;
        this.limit = limit;
        this.page = page;
    }

    public String prepare() {
        Map<String, Object> recordingList = new HashMap<>();
        recordingList.put("filter_by", filterBy);

        if (limit != null) {
            recordingList.put("limit", limit);
        }
        if (page != null) {
            recordingList.put("page", page);
        }
        Gson gson = new Gson();
        return gson.toJson(recordingList);
    }

}
