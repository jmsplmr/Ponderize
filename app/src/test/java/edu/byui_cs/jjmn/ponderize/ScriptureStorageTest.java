package edu.byui_cs.jjmn.ponderize;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by James Palmer on 17-Mar-17.
 */

public class ScriptureStorageTest {
  
  private ScriptureContainer scripture;
  private final String BOOK = "Ether";
  private final int CHAPTER = 12;
  private final int VERSE = 4;
  private final String TEXT = "Wherefore, whoso believeth in God might with surety hope for a " +
                                   "better world, yea, even a place at the right hand of God, " +
                                   "which hope cometh of faith, maketh an anchor to the souls of" +
                                   " men, which would make them sure and steadfast, always " +
                                   "abounding in good works, being led to glorify God.";
  @Mock
  private Context context;
  
  @Before
  public void setUp () throws Exception {
    scripture = new ScriptureContainer (BOOK, CHAPTER, VERSE);
    scripture.setText (TEXT);
    context = mock(MainActivity.class);
  }
  
  @Test
  public void scriptureStorage_Should_SaveScripture () throws Exception {
    ScriptureStorage scriptureSave = new ScriptureStorage ();
    
    File file = new File (context.getFilesDir(), "Ether124.txt");
    scriptureSave.saveScripture (scripture, file);
    
    ScriptureContainer loadedScripture = scriptureSave.loadScripture (file);
    
    assertEquals (scripture.getReference (), loadedScripture.getReference ());
  }
}
