package com.byui_cs.jjmn.ponderize;

/**
 * Created by James Palmer on 11-Feb-17.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_list_item_1;
import static edu.byui_cs.jmsplmr.a06team.R.id.listView;
import static edu.byui_cs.jmsplmr.a06team.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

  public static final int MAX = 10;
  public static final int MILLIS = 250;
  private static final String FILE_NAME = "_numbers.txt";

  private ProgressBar _progressBar;
  private ArrayAdapter <String> _listAdapter;
  private List <String> _numbers;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Log.v(getClass().getSimpleName(), "Create file");
    super.onCreate(savedInstanceState);
    setContentView(activity_main);

    _progressBar = (ProgressBar) findViewById(R.id.progressBar);
    _progressBar.setMax(MAX);

    _numbers = new ArrayList <>(MAX);
    _listAdapter = new ArrayAdapter <>(this, simple_list_item_1, _numbers);
    ((ListView) findViewById(listView)).setAdapter(_listAdapter);
  }

  public void createFile(View view) {
    Log.v(getClass().getSimpleName(), "Create file");
    new CreateTask(FILE_NAME, this, _progressBar).execute();
  }

  public void loadFile(View view) {
    _listAdapter.clear();
    Log.v(getClass().getSimpleName(), "Load file");
    new LoadTask(FILE_NAME, _listAdapter, this, _progressBar).execute();
  }

  public void clearList(View view) {
    Log.v(getClass().getSimpleName(), "Clear list");
    _listAdapter.clear();
  }
}
