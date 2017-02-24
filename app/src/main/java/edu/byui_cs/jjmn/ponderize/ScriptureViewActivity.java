package edu.byui_cs.jjmn.ponderize;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.byui_cs.jjmn.ponderize.R;

import java.io.File;

public class ScriptureViewActivity extends AppActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scripture_view);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    return super.onOptionsItemSelected(item);
  }

  public void testStorage(View view) {
      File aFile = new File(this.getFilesDir(),"json.txt");
      ScriptureContainer scripture = new ScriptureContainer("Ether", 5, 5);

      new scriptureSaver().saveScripture(scripture, aFile);
      System.out.println("Saved file");

      ScriptureContainer loadScripture;
      loadScripture = new scriptureLoader().loadScripture(aFile);

      System.out.println("Loaded: ");
      System.out.println(loadScripture.getBook() + " " + loadScripture.getChapter() + " " + loadScripture.getVerse());
  }


}
