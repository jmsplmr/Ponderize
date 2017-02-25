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
import edu.byui_cs.jjmn.ponderize.ScriptureAdapter;
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

      //###########################################
      //******* JOE TEST CODE DO NOT DELETE *******
      //###########################################
    ArrayList<ScriptureContainer> sc = new ArrayList<>();

    ScriptureContainer a = new ScriptureContainer("Mark", 4, 5);
    ScriptureContainer b = new ScriptureContainer("James", 5, 3);
    ScriptureContainer c = new ScriptureContainer("Hockey", 6, 7);
    ScriptureContainer d = new ScriptureContainer("Falron", 7, 3);

    sc.add(0, a);
    sc.add(1, b);
    sc.add(2, c);
    sc.add(3, d);

    ListView listView = (ListView) findViewById(R.id.listView);

    //listView.getAdapter();
   ScriptureAdapter itemsAdapter = new ScriptureAdapter(this, sc);
    listView.setAdapter(itemsAdapter);

      //###########################################
      //******* JOE TEST CODE DO NOT DELETE *******
      //###########################################
  }

    public void goToView(View view) {
      Intent intent = new Intent(this, ScriptureViewActivity.class);
      startActivity(intent);
    }
}
