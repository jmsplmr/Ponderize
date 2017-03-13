package edu.byui_cs.jjmn.ponderize;

/**
 * Created by James Palmer on 11-Feb-17.
 * TODO ALOT
 * Call people gypsies - Mike Graver
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.TabHost;
import android.widget.TextView;

// FOR FACEBOOK
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookDialog;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;

import com.byui_cs.jjmn.ponderize.R;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.ShareApi;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareButton;
import com.facebook.share.widget.ShareDialog;

import org.json.JSONObject;

import edu.byui_cs.jjmn.ponderize.MemorizeQuizActivity;
import edu.byui_cs.jjmn.ponderize.ScriptureAdapter;
import edu.byui_cs.jjmn.ponderize.ScriptureContainer;
import edu.byui_cs.jjmn.ponderize.ScriptureViewActivity;
import edu.byui_cs.jjmn.ponderize.SettingsActivity;

import static com.byui_cs.jjmn.ponderize.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {


    // FACEBOOK THING
    // CallbackManager - Like the facebook container to do everything.
    CallbackManager callbackManager;

    // Init scripture items
    public static final String SCRIPTURE_TITLE = "SCRIPTURE_TITLE";
    public static final String SCRIPTURE_TEXT = "SCRIPTURE_TEXT";

    // Init tabs
    private TabHost host;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.v(getClass().getSimpleName(), "Create main activity.");
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        host = (TabHost) findViewById(R.id.tabHostMain);
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
         * FACEBOOK LOGIN CODE
         * Joseph Koetting
         * Mar 8, 2017
         * Allows the user to log into to the application
         ************************************************************************************/

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {

                    // Successfully logged into facebook
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.e("MAIN ACTIVITY FACE", "LOGIN SUCCESSFUL");
                    }

                    // Cancelled logging into facebook
                    @Override
                    public void onCancel() {

                        Log.e("MAIN ACTIVITY FACE", "LOGIN CANCELLED");
                    }

                    // Error logging in
                    @Override
                    public void onError(FacebookException exception) {
                        Log.e("MAIN ACTIVITY FACE", "LOGIN ERROR");
                    }
                });

        /* ************************************************************************************
         * LIST VIEW ON CLICK LISTENER
         * Joseph Koetting
         * Mar 4, 2017
         * When an item in the list view is clicked,
         * Opens a new Scripture View Activity
         ************************************************************************************/

        proView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
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

    public void goToView(View view) {
        Intent intent = new Intent(this, ScriptureViewActivity.class);
        startActivity(intent);
    }

    //For navigation testing buttons
    public void onScriptureBtnClick(View v) {
        Intent i = new Intent(this, ScriptureViewActivity.class);
        startActivity(i);
    }

    public void onQuizBtnClick(View v) {
        Intent i = new Intent(this, MemorizeQuizActivity.class);
        startActivity(i);
    }

    public void onSettingClick(View v) {
        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i);
    }
}
