package edu.byui_cs.jjmn.ponderize;

/**
 * Created by James Palmer on 11-Feb-17.
 * TODO ALOT
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.TabHost;

import edu.byui_cs.jjmn.ponderize.MemorizeQuizActivity;
import edu.byui_cs.jjmn.ponderize.ScriptureAdapter;
import edu.byui_cs.jjmn.ponderize.ScriptureContainer;
import edu.byui_cs.jjmn.ponderize.ScriptureViewActivity;
import edu.byui_cs.jjmn.ponderize.SettingsActivity;

import static com.byui_cs.jjmn.ponderize.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

  TabHost tabHost;
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(getClass().getSimpleName(), "Create main activity.");
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        TabHost host = (TabHost)findViewById(R.id.tabHostMain);
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
      
        //###########################################
        //******* JOE TEST CODE DO NOT DELETE *******
        //###########################################

        // init array
        ArrayList<ScriptureContainer> omniList = new ArrayList<>();
        ArrayList<ScriptureContainer> memList = new ArrayList<>();
        ArrayList<ScriptureContainer> proList = new ArrayList<>();

        // init scriptures
        ScriptureContainer a = new ScriptureContainer("Mark", 4, 5);
        ScriptureContainer b = new ScriptureContainer("James", 5, 3);
        ScriptureContainer c = new ScriptureContainer("Hockey", 6, 7);
        ScriptureContainer d = new ScriptureContainer("Falron", 7, 3);


        a.setCompleted();
        b.setCompleted();

        // add scriptures to array
        omniList.add(0, a);
        omniList.add(1, b);
        omniList.add(2, c);
        omniList.add(3, d);

        //look at scriptures, determine if completed or not
        for(ScriptureContainer sc: omniList) {
            if (sc.getCompleted()) {
                memList.add(sc);
            }
            else {
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
        //###########################################
        //******* JOE TEST CODE DO NOT DELETE *******
        //###########################################
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
