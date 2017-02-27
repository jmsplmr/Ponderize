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
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.TabHost;

import edu.byui_cs.jjmn.ponderize.MemorizeQuizActivity;
import edu.byui_cs.jjmn.ponderize.ScriptureAdapter;
import edu.byui_cs.jjmn.ponderize.ScriptureContainer;
import edu.byui_cs.jjmn.ponderize.ScriptureViewActivity;
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
        ArrayList<ScriptureContainer> sc = new ArrayList<>();

        // init scriptures
        ScriptureContainer a = new ScriptureContainer("Mark", 4, 5);
        ScriptureContainer b = new ScriptureContainer("James", 5, 3);
        ScriptureContainer c = new ScriptureContainer("Hockey", 6, 7);
        ScriptureContainer d = new ScriptureContainer("Falron", 7, 3);

        // add scriptures to array
        sc.add(0, a);
        sc.add(1, b);
        sc.add(2, c);
        sc.add(3, d);

        // grab list view reference
        ListView listView = (ListView) findViewById(R.id.listView);

        // create new scripture adapter
        ScriptureAdapter itemsAdapter = new ScriptureAdapter(this, sc);

        // set list views adapter to new scripture adapter
        listView.setAdapter(itemsAdapter);

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


}
