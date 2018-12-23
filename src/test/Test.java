import com.jordiedevs.vatsimapi.Client;
import com.jordiedevs.vatsimapi.VatsimAPI;

public class Test {

    public static void main(String[] args) {
        VatsimAPI vatsimAPI = new VatsimAPI();
        // getClient will automatically download, and cache the users information.
        Client client = new Client.Builder().getClient("1429747").build();
        System.out.println("\n" +
                "Client name: " + client.getFirstName() + " " + client.getLastName() + "\n" +
                "Client cid: " + client.getCid() + "\n" +
                "Client Email Suffix: " + client.getEmailSuffix() + "\n" +
                "Client (Controller) Rating: " + client.getControllerRating() + "\n" +
                "Client Registration Date: " + client.getRegistrationDate() + "\n" +
                "Client (Pilot) Rating: " + client.getPilotRating() + "\n" +
                "Client Country: " + client.getClientCountry() + "\n" +
                "Client Region: " + client.getClientRegion() + "\n" +
                "Client Division: " + client.getClientDivision() + "\n" +
                "Client (ATC) Hours: " + client.getClientATCTime() + "\n" +
                "Client (Pilot) Hours: "+ client.getClientPilotTime());
    }

}
