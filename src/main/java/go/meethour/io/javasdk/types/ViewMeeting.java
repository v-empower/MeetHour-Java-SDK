package go.meethour.io.javasdk.types;

import java.util.Map;

import com.google.gson.Gson;

import java.util.HashMap;

public class ViewMeeting {
    private String meeting_id;
    private Object occurrences;
    private Object meetingAttendees;
    private String organizer;

    public ViewMeeting(String meeting_id) {
        this.meeting_id = meeting_id;
    }

    public String prepare() {
        Map<String, Object> viewMeeting = new HashMap<String, Object>();
        viewMeeting.put("meeting_id", meeting_id);

        if (occurrences != null) {
            viewMeeting.put("occurrences", occurrences);
        }
        if (meetingAttendees != null) {
            viewMeeting.put("meeting_attendees", meetingAttendees);
        }
        if (organizer != null) {
            viewMeeting.put("organizer", organizer);
        }
        Gson gson = new Gson();
        return gson.toJson(viewMeeting);

    }

}
