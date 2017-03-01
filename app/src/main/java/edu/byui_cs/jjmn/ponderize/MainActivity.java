package com.byui_cs.jjmn.ponderize;

/**
 * Created by James Palmer on 11-Feb-17.
 * TODO ALOT
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import edu.byui_cs.jjmn.ponderize.ScriptureContainer;
import edu.byui_cs.jjmn.ponderize.ScriptureStorage;

import static com.byui_cs.jjmn.ponderize.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Log.v(getClass().getSimpleName(), "Create main activity.");
    super.onCreate(savedInstanceState);
    setContentView(activity_main);

      //###########################################
      //******* JOE TEST CODE DO NOT DELETE *******
      //###########################################
    /*ArrayList<ScriptureContainer> sc = new ArrayList<>();

    ScriptureContainer a = new ScriptureContainer("Mark", 4, 5);
    ScriptureContainer b = new ScriptureContainer("James", 5, 3);
    ScriptureContainer c = new ScriptureContainer("Hockey", 6, 7);
    ScriptureContainer d = new ScriptureContainer("Falron", 7, 3);

    sc.add(0, a);
    sc.add(1, b);
    sc.add(2, c);
    sc.add(3, d);

    ListView listView = (ListView) findViewById(R.id.listView);

    listView.getAdapter();
   ScriptureAdapter itemsAdapter = new ScriptureAdapter(this, sc);
    listView.setAdapter(itemsAdapter);*/

      //###########################################
      //******* JOE TEST CODE DO NOT DELETE *******
      //###########################################
  }

    //TODO: Remove test code.
    public void testCode(View view) {
        List<ScriptureContainer> scriptureList = new ArrayList<ScriptureContainer>();

        ScriptureContainer s1 = new ScriptureContainer("1 Nephi", 1, 1);
        ScriptureContainer s2 = new ScriptureContainer("Moroni", 1, 15);
        ScriptureContainer s3 = new ScriptureContainer("Alma", 37, 6);
        ScriptureContainer s4 = new ScriptureContainer("Ether", 7, 7);

        scriptureList.add(s1);
        scriptureList.add(s2);
        scriptureList.add(s3);
        scriptureList.add(s4);




        File aFile = new File(this.getFilesDir(), "test.txt");
        new ScriptureStorage().saveAllScriptures(scriptureList, aFile);

        File loadFile = new File(this.getFilesDir(), "test.txt");
        List<ScriptureContainer> loadList = new ScriptureStorage().loadAllScriptures(loadFile);

        for (int i = 0; i < loadList.size(); i++) {
            System.out.println(loadList.get(i).getBook());
        }


    }
}
