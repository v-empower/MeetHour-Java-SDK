package go.meethour.io.javasdk.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import go.meethour.io.javasdk.types.AddContactType;
import go.meethour.io.javasdk.types.ArchiveMeetings;
import go.meethour.io.javasdk.types.CompletedMeetings;
import go.meethour.io.javasdk.types.ContactsType;
import go.meethour.io.javasdk.types.EditContactType;
import go.meethour.io.javasdk.types.EditMeeting;
import go.meethour.io.javasdk.types.GenerateJwt;
import go.meethour.io.javasdk.types.LoginType;
import go.meethour.io.javasdk.types.MissedMeetings;
import go.meethour.io.javasdk.types.RecordingsList;
import go.meethour.io.javasdk.types.RefreshToken;
import go.meethour.io.javasdk.types.ScheduleMeetingType;
import go.meethour.io.javasdk.types.TimeZone;
import go.meethour.io.javasdk.types.UpcomingMeetings;
import go.meethour.io.javasdk.types.UserDetails;
import go.meethour.io.javasdk.types.ViewMeeting;

public class ApiServices {

    private static final String BASE_URL = "https://api.meethour.io";
    private static final String API_VERSION = "v1.2";

    public static String getApi_version() {
        return API_VERSION;
    }

    public ApiServices() {
        HttpClient.newHttpClient();
    }

    public static String apiEndpointUrl(String endpoint) {
        String base_url = BASE_URL;
        switch (endpoint) {
            case "login":
                return base_url + "/oauth/token";
            case "add_contact":
                return base_url + "/api/" + API_VERSION + "/customer/addcontact";
            case "contacts":
                return base_url + "/api/" + API_VERSION + "/customer/contacts";
            case "edit_contact":
                return base_url + "/api/" + API_VERSION + "/customer/editcontact";
            case "edit_meeting":
                return base_url + "/api/" + API_VERSION + "/meeting/editmeeting";
            case "generate_jwt":
                return base_url + "/api/" + API_VERSION + "/getjwt";
            case "schedule_meeting":
                return base_url + "/api/" + API_VERSION + "/meeting/schedulemeeting";
            case "completed_meetings":
                return base_url + "/api/" + API_VERSION + "/meeting/completedmeetings";
            case "missed_meetings":
                return base_url + "/api/" + API_VERSION + "/meeting/missedmeetings";
            case "archive_meetings":
                return base_url + "/api/" + API_VERSION + "/meeting/archivemeeting";
            case "upcoming_meetings":
                return base_url + "/api/" + API_VERSION + "/meeting/upcomingmeetings";
            case "view_meetings":
                return base_url + "/api/" + API_VERSION + "/meeting/viewmeeting";
            case "recordings_list":
                return base_url + "/api/" + API_VERSION + "/customer/videorecordinglist";
            case "time_zone":
                return base_url + "/api/" + API_VERSION + "/getTimezone";
            case "refresh_token":
                return base_url + "/oauth/token";
            case "user_details":
                return base_url + "/api/" + API_VERSION + "/customer/user_details";

            default:
                return " ";
        }
    }

    private static String substitutePathParameter(String endpoint, String pathParam) {
        if (pathParam == null || pathParam.isEmpty()) {
            return endpoint;
        } else {
            return endpoint + "/" + pathParam;
        }
    }

    public static String getHeaders(String token) {
        if (!token.isEmpty()) {
            return "content-type: application/json\nAuthorization: Bearer " + token;
        } else {
            return "content-type: application/json";
        }
    }

    public static String postFetch(String token, String endpoint, String body, String pathParam) {
        // System.out.println("URL: " + endpoint + "\n Payload: " + body);
        String constructedUrl = substitutePathParameter(apiEndpointUrl(endpoint), pathParam);
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create(constructedUrl))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(body));

        if (token != null && !token.isEmpty()) {
            builder.header("Authorization", "Bearer " + token);
        }

        HttpRequest request = builder.build();

        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            // System.out.println("Response Code: " + response.statusCode());
            // System.out.println("Response: " + response.body());
            return response.body();
        } catch (IOException | InterruptedException e) {
        }
        return null;
    }

    public String login(LoginType loginDetails) {
        String body = loginDetails.prepare();
        return postFetch(" ", "login", body, null);
    }

    public String addcontact(AddContactType contactDetails, String access_token) {
        String body = contactDetails.prepare();
        return postFetch(access_token, "add_contact", body, null);
    }

    public String contacts(ContactsType contactObjects, String access_token) {

        String body = contactObjects.prepare();
        return postFetch(access_token, "contacts", body, null);
    }

    public String editcontact(EditContactType contacts, String access_token) {
        String body = contacts.prepare();
        return postFetch(access_token, "edit_contact", body, null);
    }

    public String schedulemeeting(ScheduleMeetingType meeting, String access_token) {
        String body = meeting.prepare();
        return postFetch(access_token, "schedule_meeting", body, null);
    }

    public String editmeeting(EditMeeting editmeeting, String access_token) {

        String body = editmeeting.prepare();
        return postFetch(access_token, "edit_meeting", body, null);
    }

    public String generatejwt(GenerateJwt jwt, String access_token) {
        String body = jwt.prepare();
        return postFetch(access_token, "generate_jwt", body, null);

    }

    public String completedmeeting(CompletedMeetings completedmeeting, String access_token) {
        String body = completedmeeting.prepare();
        return postFetch(access_token, "completed_meetings", body, null);

    }

    public String upcomingmeeting(UpcomingMeetings upcomingmeeting, String access_token) {

        String body = upcomingmeeting.prepare();
        return postFetch(access_token, "upcoming_meetings", body, null);
    }

    public String missedmeeting(MissedMeetings missed, String access_token) {

        String body = missed.prepare();
        return postFetch(access_token, "missed_meetings", body, null);
    }

    public String archivemeetings(ArchiveMeetings archive, String access_token) {

        String body = archive.prepare();
        return postFetch(access_token, "archive_meetings", body, null);
    }

    public String viewmeeting(ViewMeeting view, String access_token) {

        String body = view.prepare();
        return postFetch(access_token, "view_meetings", body, null);
    }

    public String recordingList(RecordingsList record, String access_token) {
        String body = record.prepare();
        return postFetch(access_token, "recordings_list", body, null);
    }

    public String refreshtoken(RefreshToken refresh) {

        String body = refresh.prepare();
        return postFetch(" ", "refresh_token", body, null);
    }

    public String timeZone(TimeZone time, String access_token) {
        String body = time.prepare();
        return postFetch(access_token, "time_zone", body, null);

    }

    public String userdetails(UserDetails user, String access_token) {
        String body = user.prepare();
        return postFetch(access_token, "user_details", body, null);
    }
}
