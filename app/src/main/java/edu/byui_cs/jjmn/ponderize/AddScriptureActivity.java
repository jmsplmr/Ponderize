package edu.byui_cs.jjmn.ponderize;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AddScriptureActivity extends AppCompatActivity {
  
  private List < ScriptureContainer > scriptures;
  
  @Override
  protected void onCreate (Bundle savedInstanceState) {
    super.onCreate (savedInstanceState);
    setContentView (R.layout.activity_add_scripture);
    
    Type listType = new TypeToken < ArrayList < ScriptureContainer > > () {
    }.getType ();
    
    String list = (String) savedInstanceState.get ("List");
    scriptures = new Gson ().fromJson (list, listType);
  }
  
  public void addScriptureToList () {
  
    String scriptureReference = getStringFromView (R.id.editScriptureReference);
    String scriptureText = getStringFromView(R.id.editScriptureText);
    
    scriptures.add ( new ScriptureContainer (scriptureReference, scriptureText));
    
    File saveFile = new File(getFilesDir(), "");
    
    new ScriptureStorage ().saveAllScriptures (scriptures, saveFile);
  }
  
  @NonNull
  private String getStringFromView(int view) {
    return ((EditText) findViewById(view)).getText().toString();
  }
}
