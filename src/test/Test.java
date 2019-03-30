import com.jordiedevs.vatsimapi.Client;

public class Test {


    public static void main(String[] args) {
        Client client = new Client.Builder().getClient("1437879").build();
        System.out.println("Client info:\n" +
                client.getFirstName() + "\n" +
                client.getLastName() + "\n" +
                client.getPilotRating() + "\n" +
                client.getClientPilotTime() + "\n" +
                client.getEmailSuffix() + "\n" +
                client.getRegistrationDate() + "\n" +
                client.getClientDivision() + "\n" +
                client.getClientCountry());
    }

}
