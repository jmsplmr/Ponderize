package layout;

import edu.byui_cs.jjmn.ponderize.ScriptureContainer;

/**
 * Created by James on 29-Mar-17.
 */

class ScriptureList {
  List<ScriptureContainer>
  private static final ScriptureList ourInstance = new ScriptureList ();
  
  static ScriptureList getInstance () {
    return ourInstance;
  }
  
  private ScriptureList () {
  }
}
