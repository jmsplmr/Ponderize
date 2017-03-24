package edu.byui_cs.jjmn.ponderize;

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
  
  protected List< ScriptureContainer > omniList;
  
  /**
   *
   */
  public static final String SCRIPTURE_TITLE = "SCRIPTURE_TITLE";
  
  /**
   *
   */
  public static final String SCRIPTURE_TEXT = "SCRIPTURE_TEXT";
  
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

        /* ************************************************************************************
         * JOE TEST CODE DO NOT DELETE
         * Joseph Koetting
         * Feb 24, 2017
         * Init an array, then displays contents to the list view
         ************************************************************************************/

    /*******************************************************************************************
    * Loads the preloaded scriptures into an array and loads them into the scripture view
    ********************************************************************************************/
    // init array
    ArrayList < ScriptureContainer > memList = new ArrayList <> ();
    ArrayList < ScriptureContainer > proList = new ArrayList <> ();

    // The file path of the file in the internal directory with the pre-loaded scriptures
    File saveFile = new File(getFilesDir(), "scriptureFile.json");

    ScriptureStorage loadScriptures = new ScriptureStorage();
    omniList = loadScriptures.loadAllScriptures(saveFile);

    // init scriptures
    ScriptureContainer a = new ScriptureContainer ("Mark", 4, 5);
    ScriptureContainer b = new ScriptureContainer ("James", 5, 3);
    
    // these items will show in the completed tab
    a.setCompleted ();
    b.setCompleted ();
    
    // add scriptures to array
    omniList.add (/*0,*/ a);
    omniList.add (/*1,*/ b);
    
    // Look at scriptures, determine if completed or not
    // Adds to appropriate list view
    for (ScriptureContainer sc : omniList) {
      if (sc.getCompleted ())
        memList.add (sc);
      else
        proList.add (sc);
    }
    
    // grab list view reference
    ListView memView = (ListView) findViewById (R.id.memorizedScripts);
    ListView proView = (ListView) findViewById (R.id.progressingScripts);
    
    // create new scripture adapter
    ScriptureAdapter memAdapter = new ScriptureAdapter (this, memList);
    ScriptureAdapter proAdapter = new ScriptureAdapter (this, proList);
    
    // set list views adapter to new scripture adapter
    memView.setAdapter (memAdapter);
    proView.setAdapter (proAdapter);

        /* ************************************************************************************
         * FACEBOOK SHARE BUTTON CODE
         * Joseph Koetting
         * Mar 8, 2017
         * Allows the user to post things to facebook
         ************************************************************************************/
    
    // Configures share window
    ShareLinkContent content = new ShareLinkContent.Builder ()
                                     .setContentTitle ("MASTERED")
                                     .setContentUrl (Uri.parse ("http://developers.facebook.com/android"))
                                     .setContentDescription ("I MASTERED A SCRIPTURE WITHOUT COMMENTING ON JOE'S LEGS")
                                     .build ();
    
    // Not sure what this code snippet does
    // DOES NOT WORK WITHOUT
    /*
    FACEBOOK THING CallbackManager - Like the facebook container to do everything.
   */
    CallbackManager callbackManager = CallbackManager.Factory.create ();
    
    // get reference to share button
    final ShareButton shareButton = (ShareButton) findViewById (R.id.fb_share_button);
    
    // share window is displayed
    shareButton.setShareContent (content);
    
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
   * Activity changer to PracticeActivity
   *
   * @param v Current view
   */
  public void onPracticeBtnClick (View v) {
    Intent intent = new Intent (this, PracticeActivity.class);
    startActivity (intent);
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
  
  public void addNewScripture (View view){
    Intent i = new Intent (this, AddScriptureActivity.class);
    String scriptureList = new Gson ().toJson (omniList);
    i.putExtra ("List", scriptureList);
    startActivity (i);
  }
}

