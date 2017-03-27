package edu.byui_cs.jjmn.ponderize;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Creates a file in internal memory that holds all of the pre-loaded scriptures
 * Created by Nick on 3/24/2017.
 */

public class preLoader {

    public void loadPreLoaded(Context context, String scriptureFile) {
        StringBuilder returnString = new StringBuilder();
        InputStream fIn = null;
        InputStreamReader isr = null;
        BufferedReader input = null;
        String line = "";
        try {
            fIn = context.getResources().getAssets()
                    .open("preloadedScriptures", context.MODE_WORLD_READABLE);
            isr = new InputStreamReader(fIn);
            input = new BufferedReader(isr);

            while ((line = input.readLine()) != null) {
                returnString.append(line);
            }
        } catch (Exception e) {
            e.getMessage();
        }

        // The file path of the file in the internal directory with the pre-loaded scriptures
        File saveFile = new File(scriptureFile);

        //Save list to saveFile.
        FileWriter writer;
        try {
            writer = new FileWriter (saveFile);
            writer.write (returnString.toString());
            writer.close ();
        } catch (Exception e ) {
            e.printStackTrace ();
        }
    }
}
