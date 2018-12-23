package com.jordiedevs.vatsimapi;

/*

PLEASE READ THE GITHUB WIKI FOR THIS PROJECT, BEFORE ASKING QUESTIONS.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class VatsimAPI {

    public static VatsimAPI instance;

    public VatsimAPI(){
        instance = this;
        System.out.println("VatsimAPI instance set..");
    }

    /**
     * Runs a series of methods to download and obtain the users cid.
     *
     * @param CID The cid of the user you want to obtain.
     */
    public void createClient(String CID){
        try {
            if (downloadXML(CID))
                System.out.println("Successfully downloaded CID: " + CID);
            else
                System.out.println("Unable to download CID: " + CID);
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Unable to download CID: " + CID + "\nBecause of: " + ex.getMessage());
        }
    }

    /**
     * Downloads the users xml, can be ran manually, but @createClient does all of the checking for you.
     * @param cid The cid of the user you want to obtain (don't run this manually, just use the createClient method).
     * @throws IOException
     */
    private boolean downloadXML(String cid) throws IOException {
        String vatsimURL = "https://cert.vatsim.net/vatsimnet/idstatus.php?cid=" + cid;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(vatsimURL).openStream()));
        if(!reader.readLine().equals("")){
            CacheUtility.createUserFile(cid, reader.readLine());
            return true;
        }else
            return false;
    }

    public static VatsimAPI getInstance() {
        return instance;
    }
}
