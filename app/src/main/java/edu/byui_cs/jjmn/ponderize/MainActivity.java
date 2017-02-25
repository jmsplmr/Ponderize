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
import android.widget.TabHost;

import edu.byui_cs.jjmn.ponderize.MemorizeQuizActivity;
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
