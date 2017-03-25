package edu.byui_cs.jjmn.ponderize;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

public class ScriptureViewActivity extends AppActivity {
  
  // init scripture data
  String _scriptureTitle;
  String _scriptureText;
  
  @Override
  protected void onCreate (Bundle savedInstanceState) {
    Log.v (getClass ().getSimpleName (), "Open ScriptureView activity.");
    super.onCreate (savedInstanceState);
    setContentView (R.layout.activity_scripture_view);
    
    TabHost host = (TabHost) findViewById (R.id.tabHostScript);
    host.setup ();
    
    // Receive intent from main activity
    Intent intent = getIntent ();
    
    // Extract data from intent
    _scriptureTitle = intent.getStringExtra (MainActivity.SCRIPTURE_TITLE);
    _scriptureText = intent.getStringExtra (MainActivity.SCRIPTURE_TEXT);
    
    // Get reference for Text view
    TextView scriptureTextView = (TextView) this.findViewById (R.id.txtScriptureText);
    
    //Test Text
    //scriptureTextView.setText(_scriptureText);
    scriptureTextView.setText ("\t\t\t8 Bring forth therefore fruits meet for repentance: " +
                                     "\n\t\t\t9 And think not to say within yourselves, We have Abraham to our father: for I say unto you, that God is able of these stones to raise up children unto Abraham. " +
                                     "\n\t\t\t10 And now also the axe is laid unto the root of the trees: therefore every tree which bringeth not forth good fruit is hewn down, and cast into the fire.");
    
    //Scripture Tab
    TabHost.TabSpec spec = host.newTabSpec ("Scripture");
    spec.setContent (R.id.Scripture);
    spec.setIndicator (_scriptureTitle);
    host.addTab (spec);
    
    //Notes Tab
    spec = host.newTabSpec ("Notes");
    spec.setContent (R.id.Notes);
    spec.setIndicator ("Notes");
    host.addTab (spec);
    
    //load the notes for the scripture
    Context scriptureContext = this.getApplicationContext ();
    //get the edit text reference
    EditText noteView = (EditText) findViewById (R.id.etxtNotes);
    //load the note
    NoteStorage loadNote = new NoteStorage ();
    loadNote.loadNote (_scriptureTitle, scriptureContext, noteView);
    
  }
  
  @Override
  public boolean onCreateOptionsMenu (Menu menu) {
    return super.onCreateOptionsMenu (menu);
  }
  
  @Override
  public boolean onOptionsItemSelected (MenuItem item) {
    return super.onOptionsItemSelected (item);
  }
  
  @Override
  protected void onStop () {
    super.onStop ();
    Log.v (getClass ().getName (), "Paused");
    
    //get the context for the scripture view
    Context scriptureContext = this.getApplicationContext ();
    
    //Get the editText reference
    EditText saveText = (EditText) this.findViewById (R.id.etxtNotes);
    
    //save the note
    NoteStorage note = new NoteStorage ();
    note.saveNote (_scriptureTitle, scriptureContext, saveText);
  }
  
  public void testScriptureStorage () {
    
  }
  
  
}
