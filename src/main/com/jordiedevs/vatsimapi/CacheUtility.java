package com.jordiedevs.vatsimapi;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.io.StringWriter;

public class CacheUtility {

    public static void createUserFile(String cid, String xml){
        try {
            File userFolder = new File("./users");
            if(!userFolder.exists())
                userFolder.mkdir();
            File f = new File("./users/" + cid + ".xml");
            if(f.createNewFile())
                System.out.println(cid + ".xml - Created!");
            FileOutputStream fos = new FileOutputStream("./users/" + cid + ".xml");
            fos.write(prettyFormat(xml, 2).getBytes());
            fos.flush();
            fos.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /*
    NOTE: Didn't write this bit.
    Credit: https://stackoverflow.com/users/89266/dfa
     */

    public static String prettyFormat(String input, int indent) {
        try {
            Source xmlInput = new StreamSource(new StringReader(input));
            StringWriter stringWriter = new StringWriter();
            StreamResult xmlOutput = new StreamResult(stringWriter);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", indent);
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(xmlInput, xmlOutput);
            return xmlOutput.getWriter().toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
