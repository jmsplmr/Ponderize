package edu.byui_cs.jjmn.ponderize;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by jmspl on 17-Mar-17.
 */

public class ScriptureStorageTest {
  
  public ScriptureContainer scripture;
  public final String BOOK = "Ether";
  public final int CHAPTER = 12;
  public final int VERSE = 4;
  public final String TEXT = "Wherefore, whoso believeth in God might with surety hope for a " +
                                   "better world, yea, even a place at the right hand of God, " +
                                   "which hope cometh of faith, maketh an anchor to the souls of" +
                                   " men, which would make them sure and steadfast, always " +
                                   "abounding in good works, being led to glorify God.";
  
  @Before
  public void setUp() throws Exception {
    scripture = new ScriptureContainer (BOOK,CHAPTER,VERSE);
    scripture.setText (TEXT);
  }
  
  @Test
  public void scriptureStorage_Should_SaveScripture () throws Exception {
    ScriptureStorage scriptureSave = new ScriptureStorage ();
  
    File file = new File ("","Ether124.txt");
    scriptureSave.saveScripture (scripture,file);
    
    ScriptureContainer loadedScripture = scriptureSave.loadScripture (file);
    
    assertEquals (scripture.getReference (),loadedScripture.getReference () );
  }
}
