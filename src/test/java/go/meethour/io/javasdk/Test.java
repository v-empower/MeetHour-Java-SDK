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
                LoginType loginDetails = new LoginType("Client_Id","Client_Secret", "Grant_type","Email", "Password");
                                //Changes the values accordingly for client_id, client_secret,grant_type,email,password.
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

                AddContactType contactDetails = new AddContactType("email",
                                "first_name", "last_name",
                                "phone number", "country_code", " ", true); //Changes the values accordingly email,first_name,last_name,phone number,country_code.
                String contactObject = apiServices.addcontact(contactDetails, access_token);
                System.out.println("AddContact Response:" + contactObject);
                System.out.println("==================================================================");

                ContactsType contactObjects = new ContactsType(null, null, null);
                String contactResponse = apiServices.contacts(contactObjects, access_token);
                System.out.println("Contact Response:" + contactResponse);
                System.out.println("==================================================================");

                EditContactType contacts = new EditContactType(0000, "country_code",
                                "email", "first_name", "last_name", " ",
                                true,
                                "phone number");//Changes the values accordingly contact_id,country_code,email,first_name,last_name,phone number.
                String editresponse = apiServices.editcontact(contacts, access_token);
                System.out.println("EditContact Response:" + editresponse);
                System.out.println("==================================================================");

                ScheduleMeetingType meeting = new ScheduleMeetingType(" meeting_name ", "pass_code ", " meeting_time",
                                " meridian",
                                "meeting_date", "timezone", 1, 1, null, null, null);
                String scheduleObject = apiServices.schedulemeeting(meeting, access_token); //Changes the values accordingly meeting_name,pass_code,meeting_time,meridian,meeting_date,timezone.
                System.out.println("ScheduleMeeting Response:" + scheduleObject);
                System.out.println("==================================================================");

                EditMeeting editmeeting = new EditMeeting("meeting_id "); //Changes the values accordingly meeting_id.
                String editmeetingObject = apiServices.editmeeting(editmeeting, access_token);
                System.out.println("Edit Meeting Response:" + editmeetingObject);
                System.out.println("==================================================================");

                GenerateJwt jwt = new GenerateJwt("meeting_id"); //Changes the values accordingly meeting_id.
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

                ArchiveMeetings archive = new ArchiveMeetings(0);
                String archiveObject = apiServices.archivemeetings(archive, access_token);
                System.out.println("ArchiveMeeting Response: " + archiveObject);
                System.out.println("==================================================================");

                ViewMeeting view = new ViewMeeting("meeting_id");//Changes the values accordingly meeting_id.
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

                RefreshToken refresh = new RefreshToken("client_id",
                                "client_secret", tokens,
                                access_token); //Changes the values accordingly for client_id, client_secret
                String refreshObject = apiServices.refreshtoken(refresh);
                System.out.println("RefreshToken Response: " + refreshObject);

        }
}
