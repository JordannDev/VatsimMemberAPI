package com.jordiedevs.vatsimapi;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;

/**
 * Vatsim Client Model, this will allow you get every bit of information that is publicly available from the CERT
 * system.
 *
 * @apiNote Version 1.1 removes local caching, and removes the caching utility in total. If you
 * still want the version with caching you can review the previous version on Github.
 */

public class Client {
    private final String cid;
    private final String firstName;
    private final String lastName;
    private final String emailSuffix;
    private final String controllerRating;
    private final String registrationDate;
    private final String pilotRating;
    private final String clientCountry;
    private final String clientRegion;
    private final String clientDivision;
    private final String clientATCTime;
    private final String clientPilotTime;

    public static class Builder {
        private String cid;
        private String firstName;
        private String lastName;
        private String emailSuffix;
        private String controllerRating;
        private String registrationDate;
        private String pilotRating;
        private String clientCountry;
        private String clientRegion;
        private String clientDivision;
        private String clientATCTime;
        private String clientPilotTime;

        //region Setters

        /**
         * Get Client (this is the method which will actually retrieve the data, and then allow it to be returned.
         * @param cid The Vatsim CID of the user you want to have returned.
         * @return
         */
        public Builder getClient(String cid){
            this.cid = cid;
            if(VatsimAPI.getInstance().isValidCID(cid)){
                System.out.println("Reading user: " + cid);
                try {
                    long currentTimeMilis = System.currentTimeMillis();
                    URL url = new URL("https://cert.vatsim.net/vatsimnet/idstatus.php?cid=" + cid);
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(url.openStream());
                    doc.getDocumentElement().normalize();

                    NodeList nList = doc.getElementsByTagName("user");
                    for(int temp = 0; temp < nList.getLength(); temp++){
                        Node nNode = nList.item(temp);

                        if(nNode.getNodeType() == Node.ELEMENT_NODE){
                            Element eElement = (Element) nNode;


                            setFirstName(eElement.getElementsByTagName("name_first").item(0).getTextContent());
                            setLastName(eElement.getElementsByTagName("name_last").item(0).getTextContent());
                            setEmailSuffix(eElement.getElementsByTagName("email").item(0).getTextContent());
                            setControllerRating(eElement.getElementsByTagName("rating").item(0).getTextContent());
                            setRegistrationDate(eElement.getElementsByTagName("regdate").item(0).getTextContent());
                            setPilotRating(eElement.getElementsByTagName("pilotrating").item(0).getTextContent());
                            setClientCountry(eElement.getElementsByTagName("country").item(0).getTextContent());
                            setClientRegion(eElement.getElementsByTagName("region").item(0).getTextContent());
                            setClientDivision(eElement.getElementsByTagName("division").item(0).getTextContent());
                            setClientATCTime(eElement.getElementsByTagName("atctime").item(0).getTextContent());
                            setClientPilotTime(eElement.getElementsByTagName("pilottime").item(0).getTextContent());
                            System.out.println("Fully read client in: " + (System.currentTimeMillis() - currentTimeMilis));

                        }
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }else{
                System.out.println("Unable to download CID: " + cid);
            }

            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmailSuffix(String emailSuffix) {
            this.emailSuffix = emailSuffix;
            return this;
        }

        public Builder setControllerRating(String controllerRating) {
            this.controllerRating = controllerRating;
            return this;
        }

        public Builder setRegistrationDate(String registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder setPilotRating(String pilotRating) {
            this.pilotRating = pilotRating;
            return this;
        }

        public Builder setClientCountry(String clientCountry) {
            this.clientCountry = clientCountry;
            return this;
        }

        public Builder setClientRegion(String clientRegion) {
            this.clientRegion = clientRegion;
            return this;
        }

        public Builder setClientDivision(String clientDivision) {
            this.clientDivision = clientDivision;
            return this;
        }

        public Builder setClientATCTime(String clientATCTime) {
            this.clientATCTime = clientATCTime;
            return this;
        }

        public Builder setClientPilotTime(String clientPilotTime) {
            this.clientPilotTime = clientPilotTime;
            return this;
        }

        //endregion

        public Client build(){
            return new Client(this);
        }
    }


    private Client(Builder Builder){
        cid = Builder.cid;
        firstName = Builder.firstName;
        lastName = Builder.lastName;
        emailSuffix = Builder.emailSuffix;
        controllerRating = Builder.controllerRating;
        registrationDate = Builder.registrationDate;
        pilotRating = Builder.pilotRating;
        clientCountry = Builder.clientCountry;
        clientRegion = Builder.clientRegion;
        clientDivision = Builder.clientDivision;
        clientATCTime = Builder.clientATCTime;
        clientPilotTime = Builder.clientPilotTime;
    }

    public String getCid(){
        return cid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailSuffix() {
        return emailSuffix;
    }

    public String getControllerRating() {
        return controllerRating;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getPilotRating() {
        return pilotRating;
    }

    public String getClientCountry() {
        return clientCountry;
    }

    public String getClientRegion() {
        return clientRegion;
    }

    public String getClientDivision() {
        return clientDivision;
    }

    public String getClientATCTime() {
        return clientATCTime;
    }

    public String getClientPilotTime() {
        return clientPilotTime;
    }
}

