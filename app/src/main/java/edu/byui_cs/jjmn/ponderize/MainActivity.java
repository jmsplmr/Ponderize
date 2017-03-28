package edu.byui_cs.jjmn.ponderize;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareButton;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static edu.byui_cs.jjmn.ponderize.R.layout.activity_main;

// FOR FACEBOOK

/**
 *
 */
public class MainActivity extends AppCompatActivity {

  public static final String SCRIPTURE_TITLE = "SCRIPTURE_TITLE";
  public static final String SCRIPTURE_TEXT = "SCRIPTURE_TEXT";
  private List < ScriptureContainer > omniList;

  @Override
  protected void onCreate (Bundle savedInstanceState) {
    
    
    Log.v (getClass ().getSimpleName (), "Create main activity.");
    super.onCreate (savedInstanceState);
    setContentView (activity_main);
    
    TabHost host = (TabHost) findViewById (R.id.tabHostMain);
    host.setup ();
    
    //Progressing Tab
    Log.v (getClass ().getSimpleName (), "Setup Progressing Tab");
    TabHost.TabSpec spec = host.newTabSpec ("Progressing");
    spec.setContent (R.id.Progressing);
    spec.setIndicator ("Progressing");
    host.addTab (spec);
    
    //Memorized Tab
    spec = host.newTabSpec ("Memorized");
    spec.setContent (R.id.Memorized);
    spec.setIndicator ("Memorized");
    host.addTab (spec);

    /* ******************************************************************************************
     * Loads the pre-loaded scriptures into an array and loads them into the scripture view
     ********************************************************************************************/
    // init array
    Log.d(getClass ().getSimpleName (), "Setting up lists");
    ArrayList < ScriptureContainer > memList = new ArrayList <> ();
    ArrayList < ScriptureContainer > proList = new ArrayList <> ();

    Log.d(getClass ().getSimpleName (), "try to get save file");
    String scriptureFilePath = getFilesDir() + "/scriptureFile.json";
    // The file path of the file in the internal directory with the pre-loaded scriptures
    Log.d(getClass ().getSimpleName (), "Point to file");

    File oldFile = new File(getFilesDir(), "/scriptureFile.json");
    oldFile.delete();

    File saveFile = new File(getFilesDir(), "/scriptureFile.json");

    Log.d(getClass ().getSimpleName (), "Did we find a file");
    if (!saveFile.exists()) {
      Context cntxt = getApplicationContext();
      new preLoader().loadPreLoaded(cntxt, scriptureFilePath);
    }

    Log.d(getClass ().getSimpleName (), "Store scriptures");
    ScriptureStorage loadScriptures = new ScriptureStorage();
    omniList = new ArrayList <> ();
    omniList = loadScriptures.loadAllScriptures(saveFile);


    // Look at scriptures, determine if completed or not
    // Adds to appropriate list view
    Log.v(getClass ().getSimpleName (), "Add scriptures to lists");
    for (ScriptureContainer sc : omniList) {
      Log.v(getClass ().getSimpleName (), "Attempt to separate lists");
      if (sc.getCompleted ()) {
        Log.v(getClass ().getSimpleName (), "Add to memorized list");
        memList.add (sc);
        Log.v(getClass ().getSimpleName (), "Added");
      }
      else {
        Log.v(getClass ().getSimpleName (), "Add to progressing list");
        proList.add (sc);
        Log.v(getClass ().getSimpleName (), "Added");
      }
    }

    Log.d(getClass ().getSimpleName (), "Set views");
    // grab list view reference
    ListView memView = (ListView) findViewById (R.id.memorizedScripts);
    ListView proView = (ListView) findViewById (R.id.progressingScripts);

    Log.d(getClass ().getSimpleName (), "Create Adapters");
    // create new scripture adapter
    ScriptureAdapter memAdapter = new ScriptureAdapter (this, memList);
    ScriptureAdapter proAdapter = new ScriptureAdapter (this, proList);

    Log.d(getClass ().getSimpleName (), "Update list views");
    // set list views adapter to new scripture adapter
    memView.setAdapter (memAdapter);
    proView.setAdapter (proAdapter);

    // LIST VIEW ON CLICK LISTENER
    // Joseph Koetting
    // Mar 4, 2017
    // When an item in the list view is clicked,
    // Opens a new Scripture View Activity
    
    proView.setOnItemClickListener (
          new AdapterView.OnItemClickListener () {
            
            @Override
            public void onItemClick (AdapterView < ? > parent, View view, int position, long id) {
              
              // Make a new Intent
              Intent myIntent = new Intent (view.getContext (), ScriptureViewActivity.class);
              
              // Grab References
              TextView scriptureTitleView = (TextView) view.findViewById (R.id.list_item_scripture_title);
              TextView scriptureTextView = (TextView) view.findViewById (R.id.list_item_scripture_text);
              
              // Convert to string
              String scriptureTitle = scriptureTitleView.getText ().toString ();
              String scriptureText = scriptureTextView.getText ().toString ();
              
              // Put into intent
              myIntent.putExtra (SCRIPTURE_TITLE, scriptureTitle);
              myIntent.putExtra (SCRIPTURE_TEXT, scriptureText);
              
              // Open the new activity
              startActivityForResult (myIntent, 0);
            }
          });

        /* ************************************************************************************
         * LIST VIEW ON CLICK LISTENER
         * Joseph Koetting
         * Mar 4, 2017
         * When an item in the list view is clicked,
         * Opens a new Scripture View Activity
         ************************************************************************************/
    
    memView.setOnItemClickListener (
          new AdapterView.OnItemClickListener () {
            
            @Override
            public void onItemClick (AdapterView < ? > parent, View view, int position, long id) {
              
              // Make a new Intent
              Intent myIntent = new Intent (view.getContext (), ScriptureViewActivity.class);
              
              // Grab References
              TextView scriptureTitleView = (TextView) view.findViewById (R.id.list_item_scripture_title);
              TextView scriptureTextView = (TextView) view.findViewById (R.id.list_item_scripture_text);
              
              // Convert to string
              String scriptureTitle = scriptureTitleView.getText ().toString ();
              String scriptureText = scriptureTextView.getText ().toString ();
              
              // Put into intent
              myIntent.putExtra (SCRIPTURE_TITLE, scriptureTitle).putExtra (SCRIPTURE_TEXT, scriptureText);
              
              // Open the new activity
              startActivityForResult (myIntent, 0);
            }
          });
  }

  /**
   * Activity changer to ScriptureViewActivity
   *
   * @param v Current view
   */
  //For navigation testing buttons
  public void onScriptureBtnClick (View v) {
    Intent i = new Intent (this, ScriptureViewActivity.class);
    startActivity (i);
  }
  
  /**
   * Activity changer to MemorizeQuizActivity
   *
   * @param v Current view
   */
  public void onQuizBtnClick (View v) {
    Intent i = new Intent (this, MemorizeQuizActivity.class);
    startActivity (i);
  }
  
  /**
   * Activity changer to SettingsActivity
   *
   * @param v Current view
   */
  public void onSettingClick (View v) {
    Intent i = new Intent (this, SettingsActivity.class);
    startActivity (i);
  }

  public void addNewScripture (View view) {
    Intent i = new Intent (this, AddScriptureActivity.class);
    String scriptureList = new Gson ().toJson (omniList);
    i.putExtra ("List", scriptureList);
    startActivity (i);
  }
}

