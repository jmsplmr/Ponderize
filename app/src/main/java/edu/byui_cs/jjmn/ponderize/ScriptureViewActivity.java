package edu.byui_cs.jjmn.ponderize;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TextView;

import com.byui_cs.jjmn.ponderize.R;

public class ScriptureViewActivity extends AppActivity {

  // init scripture data
  String _scriptureTitle;
  String _scriptureText;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Log.v(getClass().getSimpleName(), "Open ScriptureView activity.");
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scripture_view);

    TabHost host = (TabHost) findViewById(R.id.tabHostScript);
    host.setup();

    //Scripture Tab
    TabHost.TabSpec spec = host.newTabSpec("Scripture");
    spec.setContent(R.id.Scripture);
    spec.setIndicator("Scripture");
    host.addTab(spec);

    //Notes Tab
    spec = host.newTabSpec("Notes");
    spec.setContent(R.id.Notes);
    spec.setIndicator("Notes");
    host.addTab(spec);

    /**
     * Created by Joseph on 2/24/17.
     */

    // Receive intent from main activity
    Intent intent = getIntent();

    // Extract data from intent
    _scriptureTitle = intent.getStringExtra(MainActivity.SCRIPTURE_TITLE);
    _scriptureText = intent.getStringExtra(MainActivity.SCRIPTURE_TEXT);

    // Get reference for Text view
    TextView scriptureTextView = (TextView) this.findViewById(R.id.txtScripture);

    // Format data into Text view
    scriptureTextView.setText(_scriptureTitle + "\n" + _scriptureText);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    return super.onOptionsItemSelected(item);
  }
}
