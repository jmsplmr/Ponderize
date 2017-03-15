package edu.byui_cs.jjmn.ponderize;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 2/25/17.
 */

public class ScriptureStorage {


    /***************************************
     * saves a single scripture to the file
     * passed.  Just make sure that the file is empty
     * because it will overwrite the contents of the file.
     * @param scripture A scripture container object
     * @param aFile File object that will be written to.
     * Saves 1 scripture to 1 file.
     **************************************/
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


    /****************************************
     * loads one scripture from a file.
     * If the file has more then one scripture
     * it wont be able to load just one and it will crash
     * @param aFile File object that will be read from.
     * @return Scripture Container
     * Returns 1 scriptures from a file with
     * only one scripture in it.
     ****************************************/
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


    /*************************************************
     * Saves all the scriptures in a scripture list to
     * a file for storage.
     * @param scriptList List of scriptures
     * @param saveFile File Object that is being saved too
     *************************************************/
    public void saveAllScriptures(List<ScriptureContainer> scriptList, File saveFile) {

        //Create Gson object and convert list to string.
        Gson gson = new Gson();
        String jsonList = gson.toJson(scriptList);

        //Save list to saveFile.
        FileWriter writer = null;
        try {
            writer = new FileWriter(saveFile);
            writer.write(jsonList);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return;
    }

    /***********************************************
     * loadAllScriptures.
     * @param loadFile
     * @return returns a list if it worked and empty
     * other wise.
     ************************************************/
    public List<ScriptureContainer> loadAllScriptures(File loadFile) {
        Gson gson = new Gson();

        try {
            //Read all the files into a byte array.
            FileInputStream input = new FileInputStream(loadFile);
            byte [] fileContent = new byte[(int)loadFile.length()];
            input.read(fileContent);

            //Convert byte array to string then back into an array list.
            String json = new String(fileContent);
            Type listType = new TypeToken<ArrayList<ScriptureContainer>>(){}.getType();
            ArrayList<ScriptureContainer> loadList = gson.fromJson(json, listType);
            return loadList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Return an empty array if file reader failed.
        return new ArrayList<ScriptureContainer>();
    }

}
