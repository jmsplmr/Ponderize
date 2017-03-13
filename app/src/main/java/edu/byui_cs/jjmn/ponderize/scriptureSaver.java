package edu.byui_cs.jjmn.ponderize;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Michael on 2/23/17.
 */

public class scriptureSaver {

    //Turns a scripture to JSON and then uses sharedPreferences to save it for later.
    public void saveScripture(ScriptureContainer scripture, File aFile) {

        try {
            //Create a print writer to write Json to file.
            FileWriter fileWriter = new FileWriter(aFile);

            //Create the Gson converter to change it to a object
            Gson gson = new Gson();

            //Convert to json and write it to file.
            String jsonScripture = gson.toJson(scripture);
            fileWriter.write(jsonScripture);

            //End file writing.
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return;
    }
}
