package go.meethour.io.javasdk;

import org.json.JSONObject;

import go.meethour.io.javasdk.services.ApiServices;
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

public class Test {
        public static void main(String[] args)
                        throws Exception {
                LoginType loginDetails = new LoginType("xl7sr7ul4ksnw5y70ow7s21u58m7z59qp7m5",
                                "976953f491fc498ffeaa4bd47937852d6d9c76b89628e37dfba43f0ea5201347", "password",
                                "jyothi.bai@v-empower.com", "Jyothi@04");
                ApiServices apiServices = new ApiServices();
                String response = apiServices.login(loginDetails);
                System.out.println("Login Response:" + response);
                System.out.println("----------------------------------------------------------------");

                JSONObject responsesObject = new JSONObject(response);
                String access_token = responsesObject.getString("access_token");
                System.out.println("AccessToken:" + access_token);
                System.out.println("-------------------------------------------------------------");
                String tokens = responsesObject.getString("refresh_token");
                System.out.println("RefreshToken:" + tokens);
                System.out.println("-------------------------------------------------------------");

                AddContactType contactDetails = new AddContactType("krishnaram@gmail.com",
                                "Krishna", "Ram",
                                "123456789", " US", " ", true);
                String contactObject = apiServices.addcontact(contactDetails, access_token);
                System.out.println("AddContact Response:" + contactObject);
                System.out.println("==================================================================");

                ContactsType contactObjects = new ContactsType(null, null, null);
                String contactResponse = apiServices.contacts(contactObjects, access_token);
                System.out.println("Contact Response:" + contactResponse);
                System.out.println("==================================================================");

                EditContactType contacts = new EditContactType(8565, "+91",
                                "johndoee@email.com", "John", "Doee", " ",
                                true,
                                "1234567890");
                String editresponse = apiServices.editcontact(contacts, access_token);
                System.out.println("EditContact Response:" + editresponse);
                System.out.println("==================================================================");

                ScheduleMeetingType meeting = new ScheduleMeetingType(" API Calls ", "123456789 ", " 04:00",
                                " PM",
                                "29-08-2024", "Kolkata", 1, 1, null, null, null);
                String scheduleObject = apiServices.schedulemeeting(meeting, access_token);
                System.out.println("ScheduleMeeting Response:" + scheduleObject);
                System.out.println("==================================================================");

                EditMeeting editmeeting = new EditMeeting("MHR23111565929 ");
                String editmeetingObject = apiServices.editmeeting(editmeeting, access_token);
                System.out.println("Edit Meeting Response:" + editmeetingObject);
                System.out.println("==================================================================");

                GenerateJwt jwt = new GenerateJwt("MHR23111565929");
                String jwtObject = apiServices.generatejwt(jwt, access_token);
                System.out.println("Generate Jwt Response:" + jwtObject);
                System.out.println("==================================================================");

                CompletedMeetings completedmeeting = new CompletedMeetings();
                String completedObject = apiServices.completedmeeting(completedmeeting, access_token);
                System.out.println("Completed Meeting Reponse:" + completedObject);
                System.out.println("==================================================================");

                UpcomingMeetings upcomingmeeting = new UpcomingMeetings(null, null, null);
                String upcomingObject = apiServices.upcomingmeeting(upcomingmeeting, access_token);
                System.out.println("Upcoming Meeting Reponse:" + upcomingObject);
                System.out.println("==================================================================");

                MissedMeetings missed = new MissedMeetings(null, null, null);
                String missedObject = apiServices.missedmeeting(missed, access_token);
                System.out.println("Missed Meeting Response:" + missedObject);
                System.out.println("==================================================================");

                ArchiveMeetings archive = new ArchiveMeetings(65929);
                String archiveObject = apiServices.archivemeetings(archive, access_token);
                System.out.println("ArchiveMeeting Response: " + archiveObject);
                System.out.println("==================================================================");

                ViewMeeting view = new ViewMeeting("MHR23111565929");
                String viewObject = apiServices.viewmeeting(view, access_token);
                System.out.println("ViewMeeting Response:" + viewObject);
                System.out.println("==================================================================");

                RecordingsList record = new RecordingsList("Local", 0, 0);
                String reocrdObject = apiServices.recordingList(record, access_token);
                System.out.println("RecordingList:" + reocrdObject);
                System.out.println("==================================================================");

                TimeZone time = new TimeZone();
                String timezone = apiServices.timeZone(time, access_token);
                System.out.println("TimeZone Response:" + timezone);
                System.out.println("==================================================================");

                UserDetails user = new UserDetails();
                String userObject = apiServices.userdetails(user, access_token);
                System.out.println("UserDetails Response:" + userObject);
                System.out.println("==================================================================");

                RefreshToken refresh = new RefreshToken("xl7sr7ul4ksnw5y70ow7s21u58m7z59qp7m5",
                                "976953f491fc498ffeaa4bd47937852d6d9c76b89628e37dfba43f0ea5201347", tokens,
                                access_token);
                String refreshObject = apiServices.refreshtoken(refresh);
                System.out.println("RefreshToken Response: " + refreshObject);

        }
}
