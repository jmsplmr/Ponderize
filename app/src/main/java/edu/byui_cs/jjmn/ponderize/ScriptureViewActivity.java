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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

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
    
    EditText noteView = (EditText) findViewById (R.id.etxtNotes);
    String scriptRef = _scriptureTitle.replaceAll ("\\s", "") + "Note.txt";
    //noteView.setText(scriptRef);
    String placeHolder = "no notes on file";
    String noteString = "";
    //Read the text from the file
    try {
      FileInputStream fin = openFileInput (scriptRef);
      InputStreamReader isr = new InputStreamReader (fin);
      BufferedReader buff = new BufferedReader (isr);
      StringBuilder sb = new StringBuilder ();
      
      while ((placeHolder = buff.readLine ()) != null) {
        
        sb.append (placeHolder);
        noteString += placeHolder;
      }
    } catch ( Exception e ) {
      e.printStackTrace ();
    }
    
    noteView.setText (noteString);
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
    
    //Create the file name from the scripture reference
    String scriptRef = _scriptureTitle.replaceAll ("\\s", "") + "Note.txt";
    
    //Create the file if it does not exist
    File note = new File (getFilesDir (), scriptRef);
    
    //Get the editText reference
    EditText saveText = (EditText) this.findViewById (R.id.etxtNotes);
    
    //Logging
    Log.v (getClass ().getName (), scriptRef);
    
    //grab the string from the text box
    String noteString = saveText.getText ().toString ();
    Log.v (getClass ().getName (), noteString);
    
    try {
      //Create an output stream for the note file.
      FileOutputStream fout = openFileOutput (scriptRef, Context.MODE_PRIVATE);
      
      //Write to the file
      fout.write (noteString.getBytes ());
      
      //End file writing.
      fout.close ();
    } catch ( Exception e ) {
      e.printStackTrace ();
    }
  }
  
  public void testScriptureStorage () {
    
  }
  
  
}
