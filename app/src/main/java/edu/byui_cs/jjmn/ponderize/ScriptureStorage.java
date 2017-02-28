package edu.byui_cs.jjmn.ponderize;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Michael on 2/25/17.
 */

public class ScriptureStorage {

    //TODO: add scripture storage and saver.
    //TODO: add a load all scriptures function.
    //TODO: add a funtion that get file directory and turns scriptures names into files to read the files in.

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


    //Loads the scripture from a file.
    public ScriptureContainer loadScripture(File aFile) {

        ScriptureContainer scripture = new ScriptureContainer("",0,0);
        try {
            //Reading all the bytes into an array.
            FileInputStream fileInput = new FileInputStream(aFile);
            byte [] fileContents = new byte[(int) aFile.length()];
            fileInput.read(fileContents);
            fileInput.close();

            //Turning bytes into a string object.
            String scriptureJson = new String(fileContents, "UTF-8");

            //Turning back into a scripture.
            Gson gsonConverter = new Gson();
            scripture = gsonConverter.fromJson(scriptureJson, ScriptureContainer.class);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return scripture;

    }
}
