package edu.byui_cs.jjmn.ponderize;

import java.util.List;

/**
 * Created by James on 29-Mar-17.
 */

class ScriptureList {
  
  private static List<ScriptureContainer> list;
  private static final ScriptureList ourInstance = new ScriptureList ();
  
  private ScriptureList (){
    
  }
  
  static ScriptureList getInstance () {
    return ourInstance;
  }
  
}
