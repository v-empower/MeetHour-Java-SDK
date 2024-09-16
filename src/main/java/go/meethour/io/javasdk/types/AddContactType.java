package go.meethour.io.javasdk.types;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class AddContactType {
    private String email;
    private String firstname;
    private String lastname;
    private String phone;
    private String countryCode;
    private String image;
    private Boolean isShowPortal;

    public AddContactType(String email, String firstname, String lastname, String phone, String countryCode,
            String image, Boolean isShowPortal) {
        this.email = email;
        this.firstname = firstname;
    }

    public String prepare() {
        Map<String, Object> addContact = new HashMap<String, Object>();
        addContact.put("email", email);
        addContact.put("firstname", firstname);

        if (lastname != null) {
            addContact.put("lastname", lastname);
        }
        if (phone != null) {
            addContact.put("phone", phone);
        }
        if (countryCode != null) {
            addContact.put("country_code", countryCode);
        }
        if (image != null) {
            addContact.put("image", image);
        }
        if (isShowPortal != null) {
            addContact.put("is_show_portal", isShowPortal);
        }
        Gson gson = new Gson();
        return gson.toJson(addContact);

    }
}
