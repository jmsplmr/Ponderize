package com.byui_cs.jjmn.ponderize;

/**
 * Created by James Palmer on 11-Feb-17.
 * TODO ALOT
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.File;

import edu.byui_cs.jjmn.ponderize.ScriptureContainer;
import edu.byui_cs.jjmn.ponderize.ScriptureViewActivity;
import edu.byui_cs.jjmn.ponderize.scriptureLoader;
import edu.byui_cs.jjmn.ponderize.scriptureSaver;

import static com.byui_cs.jjmn.ponderize.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Log.v(getClass().getSimpleName(), "Create main activity.");
    super.onCreate(savedInstanceState);
    setContentView(activity_main);
  }

  public void testStorage(View view) {
    File aFile = new File(this.getFilesDir(),"json.txt");
    ScriptureContainer scripture = new ScriptureContainer("Ether", 5, 5);

    new scriptureSaver().saveScripture(scripture, aFile);
    System.out.println("Saved file");

    ScriptureContainer loadScripture;
    loadScripture = new scriptureLoader().loadScripture(aFile);

    System.out.println("Loaded: ");
    System.out.println(loadScripture.getBook() + " " + loadScripture.getChapter() + " " + loadScripture.getVerse());
  }
}
