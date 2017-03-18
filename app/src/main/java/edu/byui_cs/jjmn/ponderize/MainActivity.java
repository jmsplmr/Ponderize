package edu.byui_cs.jjmn.ponderize;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareButton;

import java.util.ArrayList;
import java.util.Calendar;

import static edu.byui_cs.jjmn.ponderize.R.layout.activity_main;

// FOR FACEBOOK

/**
 *
 */
public class MainActivity extends AppCompatActivity {

  /**
   *
   */
  // Init scripture items
  public static final String SCRIPTURE_TITLE = "SCRIPTURE_TITLE";

  /**
   *
   */
  public static final String SCRIPTURE_TEXT = "SCRIPTURE_TEXT";

  /**
   * FACEBOOK THING CallbackManager - Like the facebook container to do everything.
   */
  CallbackManager callbackManager;

  /**
   * {@inheritDoc}
   *
   * @param savedInstanceState
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {

    // Sets up notifications to be working
    Notifications();

    Log.v(getClass().getSimpleName(), "Create main activity.");
    super.onCreate(savedInstanceState);
    setContentView(activity_main);

    TabHost host = (TabHost) findViewById(R.id.tabHostMain);
    host.setup();

    //Progressing Tab
    TabHost.TabSpec spec = host.newTabSpec("Progressing");
    spec.setContent(R.id.Progressing);
    spec.setIndicator("Progressing");
    host.addTab(spec);

    //Memorized Tab
    spec = host.newTabSpec("Memorized");
    spec.setContent(R.id.Memorized);
    spec.setIndicator("Memorized");
    host.addTab(spec);

        /* ************************************************************************************
         * JOE TEST CODE DO NOT DELETE
         * Joseph Koetting
         * Feb 24, 2017
         * Init an array, then displays contents to the list view
         ************************************************************************************/

    // init array
    ArrayList<ScriptureContainer> omniList = new ArrayList<>();
    ArrayList<ScriptureContainer> memList = new ArrayList<>();
    ArrayList<ScriptureContainer> proList = new ArrayList<>();

    // init scriptures
    ScriptureContainer a = new ScriptureContainer("Mark", 4, 5);
    ScriptureContainer b = new ScriptureContainer("James", 5, 3);
    ScriptureContainer c = new ScriptureContainer("Hockey", 6, 7);
    ScriptureContainer d = new ScriptureContainer("Falron", 7, 3);

    // these items will show in the completed tab
    a.setCompleted();
    b.setCompleted();

    // add scriptures to array
    omniList.add(0, a);
    omniList.add(1, b);
    omniList.add(2, c);
    omniList.add(3, d);

    // Look at scriptures, determine if completed or not
    // Adds to appropriate list view
    for (ScriptureContainer sc : omniList) {
      if (sc.getCompleted()) {
        memList.add(sc);
      } else {
        proList.add(sc);
      }
    }

    // grab list view reference
    ListView memView = (ListView) findViewById(R.id.memorizedScripts);
    ListView proView = (ListView) findViewById(R.id.progressingScripts);

    // create new scripture adapter
    ScriptureAdapter memAdapter = new ScriptureAdapter(this, memList);
    ScriptureAdapter proAdapter = new ScriptureAdapter(this, proList);

    // set list views adapter to new scripture adapter
    memView.setAdapter(memAdapter);
    proView.setAdapter(proAdapter);

        /* ************************************************************************************
         * FACEBOOK SHARE BUTTON CODE
         * Joseph Koetting
         * Mar 8, 2017
         * Allows the user to post things to facebook
         ************************************************************************************/

    // Configures share window
    ShareLinkContent content = new ShareLinkContent.Builder()
            .setContentTitle("MASTERED")
            .setContentUrl(Uri.parse("http://developers.facebook.com/android"))
            .setContentDescription("I MASTERED A SCRIPTURE WITHOUT COMMENTING ON JOE'S LEGS")
            .build();

    // Not sure what this code snippet does
    // DOES NOT WORK WITHOUT
    callbackManager = CallbackManager.Factory.create();

    // get reference to share button
    final ShareButton shareButton = (ShareButton) findViewById(R.id.fb_share_button);

    // share window is displayed
    shareButton.setShareContent(content);

        /* ************************************************************************************
         * FACEBOOK LOGIN BUTTON CODE
         * Joseph Koetting
         * Mar 8, 2017
         * Allows the user to log into to the application
         ************************************************************************************/

    LoginManager.getInstance().registerCallback(callbackManager,
            new FacebookCallback<LoginResult>() {

              /**
               * {@inheritDoc}
               * @param loginResult
               */
              // Successfully logged into facebook
              @Override
              public void onSuccess(LoginResult loginResult) {
                Log.d("MAIN ACTIVITY FACE", "LOGIN SUCCESSFUL");
              }

              /**
               * {@inheritDoc}
               */
              // Cancelled logging into facebook
              @Override
              public void onCancel() {
                Log.d("MAIN ACTIVITY FACE", "LOGIN CANCELLED");
              }

              /**
               * {@inheritDoc}
               * @param exception
               */
              // Error logging in
              @Override
              public void onError(FacebookException exception) {
                Log.e("MAIN ACTIVITY FACE", "LOGIN ERROR", exception);
              }
            });

    // LIST VIEW ON CLICK LISTENER
    // Joseph Koetting
    // Mar 4, 2017
    // When an item in the list view is clicked,
    // Opens a new Scripture View Activity

    proView.setOnItemClickListener(
            new AdapterView.OnItemClickListener() {
              /**
               * {@inheritDoc}
               * @param parent
               * @param view
               * @param position
               * @param id
               */
              @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Make a new Intent
                Intent myIntent = new Intent(view.getContext(), ScriptureViewActivity.class);

                // Grab References
                TextView scriptureTitleView = (TextView) view.findViewById(R.id.list_item_scripture_title);
                TextView scriptureTextView = (TextView) view.findViewById(R.id.list_item_scripture_text);

                // Convert to string
                String scriptureTitle = scriptureTitleView.getText().toString();
                String scriptureText = scriptureTextView.getText().toString();

                // Put into intent
                myIntent.putExtra(SCRIPTURE_TITLE, scriptureTitle);
                myIntent.putExtra(SCRIPTURE_TEXT, scriptureText);

                // Open the new activity
                startActivityForResult(myIntent, 0);
              }
            });

        /* ************************************************************************************
         * LIST VIEW ON CLICK LISTENER
         * Joseph Koetting
         * Mar 4, 2017
         * When an item in the list view is clicked,
         * Opens a new Scripture View Activity
         ************************************************************************************/

    memView.setOnItemClickListener(
            new AdapterView.OnItemClickListener() {
              /**
               *
               * {@inheritDoc}
               * @param parent
               * @param view
               * @param position
               * @param id
               */
              @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Make a new Intent
                Intent myIntent = new Intent(view.getContext(), ScriptureViewActivity.class);

                // Grab References
                TextView scriptureTitleView = (TextView) view.findViewById(R.id.list_item_scripture_title);
                TextView scriptureTextView = (TextView) view.findViewById(R.id.list_item_scripture_text);

                // Convert to string
                String scriptureTitle = scriptureTitleView.getText().toString();
                String scriptureText = scriptureTextView.getText().toString();

                // Put into intent
                myIntent.putExtra(SCRIPTURE_TITLE, scriptureTitle);
                myIntent.putExtra(SCRIPTURE_TEXT, scriptureText);

                // Open the new activity
                startActivityForResult(myIntent, 0);
              }
            });
  }

  /**
   * Activity changer to PracticeActivity
   *
   * @param v Current view
   */
  public void onPracticeBtnClick(View v) {
    Intent intent = new Intent(this, PracticeActivity.class);
    startActivity(intent);
  }

  /**
   * Activity changer to ScriptureViewActivity
   *
   * @param v Current view
   */
  //For navigation testing buttons
  public void onScriptureBtnClick(View v) {
    Intent i = new Intent(this, ScriptureViewActivity.class);
    startActivity(i);
  }

  /**
   * Activity changer to MemorizeQuizActivity
   *
   * @param v Current view
   */
  public void onQuizBtnClick(View v) {
    Intent i = new Intent(this, MemorizeQuizActivity.class);
    startActivity(i);
  }

  /**
   * Activity changer to SettingsActivity
   *
   * @param v Current view
   */
  public void onSettingClick(View v) {
    Intent i = new Intent(this, SettingsActivity.class);
    startActivity(i);
  }

  public void Notifications() {

    // get shared preferences
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

    // get booleans for each day of the week
    Boolean sun = preferences.getBoolean("check_box_preference_1", false);
    Boolean mon = preferences.getBoolean("check_box_preference_2", false);
    Boolean tue = preferences.getBoolean("check_box_preference_3", false);
    Boolean wed = preferences.getBoolean("check_box_preference_4", false);
    Boolean thu = preferences.getBoolean("check_box_preference_5", false);
    Boolean fri = preferences.getBoolean("check_box_preference_6", false);
    Boolean sat = preferences.getBoolean("check_box_preference_7", false);

    // get time and ampm
    String ampm = preferences.getString("listPref", "");
    String time = preferences.getString("time", "");

    // Testing to make sure preferences load correctly.
    Log.e("CALENDER CHECKING SUN", sun.toString());
    Log.e("CALENDER CHECKING MON", mon.toString());
    Log.e("CALENDER CHECKING TUE", tue.toString());
    Log.e("CALENDER CHECKING WED", wed.toString());
    Log.e("CALENDER CHECKING THU", thu.toString());
    Log.e("CALENDER CHECKING FRI", fri.toString());
    Log.e("CALENDER CHECKING SAT", sat.toString());
    Log.e("CALENDER CHECKING TIME", time);
    Log.e("CALENDER CHECKING AMPM", ampm);

    // init calendar object
    Calendar calendar = Calendar.getInstance();

    // makes it happen on different days
    if (sun) {
      calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
    }
    if (mon) {
      calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    }
    if (tue) {
      calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
    }
    if (wed) {
      calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
    }
    if (thu) {
      calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
    }
    if (fri) {
      calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
    }
    if (sat) {
      calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
    }

    int addTwelveHours = Integer.parseInt(ampm) * 12;

    if (time.charAt(1) == ':') {
      // Set Hour
      calendar.set(Calendar.HOUR_OF_DAY, time.charAt(0) + addTwelveHours);

      // Set Minute
      Integer minute = (time.charAt(2) - '0') * 10 + time.charAt(3) - '0';
      calendar.set(Calendar.MINUTE, minute);
    } else {
      // Set Hour
      Integer hour = (time.charAt(0) - '0') * 10 + time.charAt(0) - '0';
      calendar.set(Calendar.HOUR_OF_DAY, hour + addTwelveHours);

      // Set Minute
      Integer minute = (time.charAt(3) - '0') * 10 + time.charAt(4) - '0';
      calendar.set(Calendar.MINUTE, minute);
    }

    // No idea what this does. Requires to work
    Intent intent = new Intent(getApplicationContext(), Notification_receiver.class);
    PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);

    // Sets the alarm
    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
  }
}

