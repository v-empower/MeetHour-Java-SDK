package go.meethour.io.javasdk.types;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class EditMeeting {
    private  String meeting_id;
    private String meeting_name;
    private String agenda;
    private String passcode;
    private String meeting_date;
    private String meeting_meridiem;
    private String meeting_time;
    private Integer durationHr;
    private Integer durationMin;
    private String timezone;
    private Integer isRecurring;
    private String recurringType;
    private Integer repeatInterval;
    private List<Object> attend;
    private Integer enablePreRegistration;
    private String endBy;
    private String endDateTime;
    private List<Integer> groups;
    private List<Object> hostusers;
    private String instructions;
    private Integer isShowPortal;
    private String meetingAgenda;
    private String meetingTopic;
    private List<Object> oldAttend;
    private List<String> options;

    public EditMeeting(String meeting_id) {
        this.meeting_id = meeting_id;
    }

    public String prepare() {
        Map<String, Object> editMeeting = new HashMap<>();
        editMeeting.put("meeting_id", meeting_id);
        editMeeting.put("meeting_date", meeting_date);
        editMeeting.put("meeting_meridiem", meeting_meridiem);
        editMeeting.put("meeting_name", meeting_name);
        editMeeting.put("meeting_time", meeting_time);
        editMeeting.put("passcode", passcode);
        editMeeting.put("isShowPortal", isShowPortal);
        editMeeting.put("timezone", timezone);
        if (attend != null)
            editMeeting.put("attend", attend);
        if (agenda != null)
            editMeeting.put("agenda", agenda);
        if (durationHr != null)
            editMeeting.put("durationHr", durationHr);
        if (durationMin != null)
            editMeeting.put("durationMin", durationMin);
        if (enablePreRegistration != null)
            editMeeting.put("enablePreRegistration", enablePreRegistration);
        if (endBy != null)
            editMeeting.put("endBy", endBy);
        if (endDateTime != null)
            editMeeting.put("endDateTime", endDateTime);
        if (instructions != null)
            editMeeting.put("instructions", instructions);
        if (groups != null)
            editMeeting.put("groups", groups);
        if (hostusers != null)
            editMeeting.put("hostusers", hostusers);
        if (meetingAgenda != null)
            editMeeting.put("meetingAgenda", meetingAgenda);
        if (meetingTopic != null)
            editMeeting.put("meetingTopic", meetingTopic);
        if (oldAttend != null)
            editMeeting.put("oldAttend", oldAttend);
        if (options != null)
            editMeeting.put("options", options);
        if (isRecurring != null)
            editMeeting.put("isRecurring", isRecurring);
        if (repeatInterval != null)
            editMeeting.put("repeatInterval", repeatInterval);
        if (recurringType != null)
            editMeeting.put("recurringType", recurringType);
        Gson gson = new Gson();
        return gson.toJson(editMeeting);
    }
}
