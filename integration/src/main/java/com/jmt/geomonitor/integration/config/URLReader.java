package com.jmt.geomonitor.integration.config;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Reads url and returns html document
 */
public class URLReader {

    /**
     * Reads file line by line from url and saves in output file.
     *
     * @param url
     *         Source URL.
     */
    public static void readFile(final String url) {

        //Open FileReader and read source url input stream
        try {
            URL source = new URL(url);
            BufferedReader br = new BufferedReader(new InputStreamReader(source.openStream()));

            File tempFilePath = new File(System.getProperty("user.dir") + "/src/test/resources/temp.html");

            FileWriter fileWriter = new FileWriter(tempFilePath);
            BufferedWriter bw = new BufferedWriter(fileWriter);

            String line;
            while ((line = br.readLine()) != null) {

                //Write to output file
                bw.write(line + "\n");
            }

            //Close reader and writer
            br.close();
            bw.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();

            throw new IllegalArgumentException("The url:" + url + "was not a valid source");
        } catch (IOException e) {
            e.printStackTrace();

            throw new IllegalStateException("Unable to read source at url: " + url);
        }
    }
}
