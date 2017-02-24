package edu.byui_cs.jjmn.ponderize;

import android.graphics.Path;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Michael on 2/23/17.
 */

public class scriptureLoader {

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
