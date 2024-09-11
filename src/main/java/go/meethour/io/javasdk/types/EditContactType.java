package go.meethour.io.javasdk.types;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class EditContactType {
    private Integer contact_id;
    private String country_code;
    private String email;
    private String firstname;
    private String lastname;
    private String image;
    private boolean is_show_portal;
    private String phone;

    public EditContactType(Integer contact_id, String country_code, String email, String firstname, String lastname,
            String image, boolean is_show_portal, String phone) {
        this.contact_id = contact_id;
        this.country_code = country_code;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.image = image;
        this.is_show_portal = is_show_portal;
        this.phone = phone;
    }

    public String prepare() {
        Map<String, Object> contactDetails = new HashMap<String, Object>();
        contactDetails.put("contact_id", contact_id);
        contactDetails.put("country_code", country_code);
        contactDetails.put("email", email);
        contactDetails.put("firstname", firstname);
        contactDetails.put("lastname", lastname);
        contactDetails.put("image", image);
        contactDetails.put("is_show_portal", is_show_portal);
        contactDetails.put("phone", phone);
        Gson gson = new Gson();
        return gson.toJson(contactDetails);
    }

}
