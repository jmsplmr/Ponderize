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

import edu.byui_cs.jjmn.ponderize.ScriptureViewActivity;

import static com.byui_cs.jjmn.ponderize.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Log.v(getClass().getSimpleName(), "Create main activity.");
    super.onCreate(savedInstanceState);
    setContentView(activity_main);
  }

    public void goToView(View view) {
      Intent intent = new Intent(this, ScriptureViewActivity.class);
      startActivity(intent);
    }
}
