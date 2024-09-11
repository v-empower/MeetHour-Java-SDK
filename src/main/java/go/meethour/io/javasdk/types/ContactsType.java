package go.meethour.io.javasdk.types;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class ContactsType {
    private Integer excludeHosts;
    private Integer limit;
    private Integer page;

    // Constructor
    public ContactsType(Integer excludeHosts, Integer limit, Integer page) {
        
    }

    public String prepare() {
        Map<String, Object> contacts = new HashMap<String, Object>();
        contacts.put("exclude_hosts", excludeHosts);
        contacts.put("limit", limit);
        contacts.put("page", page);
        Gson gson = new Gson();
        return gson.toJson(contacts);

    }

}
