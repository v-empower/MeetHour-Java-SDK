package go.meethour.io.javasdk.types;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class ArchiveMeetings {

    private Integer id;

    public ArchiveMeetings(Integer id) {
        this.id = id;
    }
    

    public String prepare() {
        Map<String, Integer> archiveMeetings = new HashMap<String, Integer>();
        archiveMeetings.put("id", id);

        Gson gson = new Gson();
      
        return gson.toJson(archiveMeetings);
    }


}
