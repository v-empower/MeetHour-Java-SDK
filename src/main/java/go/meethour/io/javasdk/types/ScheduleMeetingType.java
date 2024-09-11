package go.meethour.io.javasdk.types;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class ScheduleMeetingType {
    private String meeting_name;
    private String passcode;
    private String meeting_time;
    private String meeting_meridiem;
    private String meeting_date;
    private String timezone;
    private String default_recording_storage = "Dropbox";
    private int send_calendar_invite = 0;
    private String agenda;
    private Integer duration_hr;
    private Integer duration_min;
    private Integer enable_pre_registration;
    private String endBy;
    private String end_date_time;
    private Integer end_times;
    private List<Object> groups; // Since Python list was of type [str, int], Java equivalent can be List<Object>
    private String is_recurring;
    private int is_show_portal = 0;
    private String meeting_topic;
    private String monthlyBy;
    private String monthlyByDay;
    private String monthlyByWeekday;
    private String monthlyByWeekdayIndex;
    private List<String> options;
    private String recurring_type;
    private Integer repeat_interval;
    private Integer weeklyWeekDays;
    private List<String> attend;
    private List<String> hostusers;

    // New constructor
    public ScheduleMeetingType(String meeting_name, String passcode, String meeting_time, String meeting_meridiem,
            String meeting_date, String timezone, int is_show_portal, int send_calendar_invite, List<String> options,
            List<String> attend, List<String> hostusers) {
        this.meeting_name = meeting_name;
        this.passcode = passcode;
        this.meeting_time = meeting_time;
        this.meeting_meridiem = meeting_meridiem;
        this.meeting_date = meeting_date;
        this.timezone = timezone;
        this.is_show_portal = is_show_portal;
        this.send_calendar_invite = send_calendar_invite;
        this.options = options;
        this.attend = attend;
        this.hostusers = hostusers;
    }

    public String prepare() {
        Map<String, Object> scheduleMeeting = new HashMap<String, Object>();
        scheduleMeeting.put("default_recording_storage", default_recording_storage);
        scheduleMeeting.put("meeting_date", meeting_date);
        scheduleMeeting.put("meeting_meridiem", meeting_meridiem);
        scheduleMeeting.put("meeting_name", meeting_name);
        scheduleMeeting.put("meeting_time", meeting_time);
        scheduleMeeting.put("passcode", passcode);
        scheduleMeeting.put("send_calendar_invite", send_calendar_invite);
        scheduleMeeting.put("is_show_portal", is_show_portal);
        scheduleMeeting.put("timezone", timezone);

        if (agenda != null)
            scheduleMeeting.put("agenda", agenda);
        if (attend != null)
            scheduleMeeting.put("attend", attend);
        if (duration_hr != null)
            scheduleMeeting.put("duration_hr", duration_hr);
        if (duration_min != null)
            scheduleMeeting.put("duration_min", duration_min);
        if (enable_pre_registration != null)
            scheduleMeeting.put("enable_pre_registration", enable_pre_registration);
        if (endBy != null)
            scheduleMeeting.put("endBy", endBy);
        if (end_date_time != null)
            scheduleMeeting.put("endDateTime", end_date_time);
        if (end_times != null)
            scheduleMeeting.put("end_times", end_times);
        if (groups != null)
            scheduleMeeting.put("groups", groups);
        if (hostusers != null)
            scheduleMeeting.put("hostusers", hostusers);
        if (is_recurring != null)
            scheduleMeeting.put("is_recurring", is_recurring);
        if (meeting_topic != null)
            scheduleMeeting.put("meeting_topic", meeting_topic);
        if (monthlyBy != null)
            scheduleMeeting.put("monthlyBy", monthlyBy);
        if (monthlyByDay != null)
            scheduleMeeting.put("monthlyByDay", monthlyByDay);
        if (monthlyByWeekday != null)
            scheduleMeeting.put("monthlyByWeekday", monthlyByWeekday);
        if (monthlyByWeekdayIndex != null)
            scheduleMeeting.put("monthlyByWeekdayIndex", monthlyByWeekdayIndex);
        if (options != null)
            scheduleMeeting.put("options", options);
        if (recurring_type != null)
            scheduleMeeting.put("recurring_type", recurring_type);
        if (repeat_interval != null)
            scheduleMeeting.put("repeat_interval", repeat_interval);
        if (weeklyWeekDays != null)
            scheduleMeeting.put("weeklyWeekDays", weeklyWeekDays);

        Gson gson = new Gson();
        return gson.toJson(scheduleMeeting);
    }
}
