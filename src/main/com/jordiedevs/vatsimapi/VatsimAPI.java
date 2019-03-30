package com.jordiedevs.vatsimapi;

/**
 * @projectName VatsimMemberAPI
 * @description A simple API to get Vatsim member data from the CERT system.
 * @version 1.1
 *
 * @apiNote Version 1.1 removes local caching, and removes the caching utility in total. If you
 * still want the version with caching you can review the previous version on Github.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class VatsimAPI {

    public static VatsimAPI instance = new VatsimAPI();

    private VatsimAPI(){
        System.out.println("VatsimAPI instance set..");
    }

    /**
     * Checks to see if a user's CID is valid (ie exists).
     * @param cid The cid of the user you want to obtain (don't run this manually, use the Client Builder).
     * @throws IOException
     */
    public boolean isValidCID(String cid) {
        BufferedReader reader = null;
        try {
            String vatsimURL = "https://cert.vatsim.net/vatsimnet/idstatus.php?cid=" + cid;
            reader = new BufferedReader(new InputStreamReader(new URL(vatsimURL).openStream()));
            // Ideally, I'd like to use != null, or see if the contents are empty but for some reason
            // this is the only version that seems to work, and produce errors. So I'm just gonna leave it this way.
            // Maybe come back to it.
            if(!reader.readLine().equals(""))
                return true;
            else
                return false;
        }catch (Exception ex) {
             ex.printStackTrace();
             return false;
        }finally {
            try {
                reader.close();
            }catch (Exception ex) {
                 ex.printStackTrace();
            }
        }
    }

    public static VatsimAPI getInstance() {
        return instance;
    }
}
