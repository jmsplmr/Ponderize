package edu.byui_cs.jjmn.ponderize;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

import com.byui_cs.jjmn.ponderize.R;

public class ScriptureViewActivity extends AppActivity {

  TabHost tabHost;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scripture_view);

    TabHost host = (TabHost)findViewById(R.id.tabHostScript);
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
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    return super.onOptionsItemSelected(item);
  }

  public void testScriptureStorage() {

  }


}
