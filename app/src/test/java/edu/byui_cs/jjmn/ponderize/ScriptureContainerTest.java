package edu.byui_cs.jjmn.ponderize;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by James Palmer on 22-Feb-17.
 */

public class ScriptureContainerTest {
  private ScriptureContainer sc0, sc1;
  
  private final String BOOK = "Ether";
  private final int CHAPTER = 12;
  private final int VERSE = 4;
  private final String text = "Wherefore, whoso believeth in God might with surety hope for a " +
                                    "better world, yea, even a place at the right hand of God, " +
                                    "which hope cometh of faith, maketh an anchor to the souls of" +
                                    " men, which would make them sure and steadfast, always " +
                                    "abounding in good works, being led to glorify God.";
  
  @Before
  public void setUp () throws Exception {
    sc0 = new ScriptureContainer (BOOK, CHAPTER, VERSE);
    sc1 = new ScriptureContainer ();
    sc0.setText (text);
    
    sc1.setBook (BOOK);
    sc1.setChapter (CHAPTER);
    sc1.setVerse (VERSE);
    sc1.setText (text);
    sc1.setCompleted ();
  }
  
  @After
  public void tearDown () throws Exception {
    
  }
  
  @Test
  public void scriptureContainer_Should_DisplayScriptureReference () throws Exception {
    assertEquals ("Ether 12:4", sc0.getReference ());
    assertEquals ("Ether 12:4", sc0.getBook () + ' ' + sc0.getChapter () + ':' + sc0.getVerse ());
    assertNotEquals ("Ether 12-4", sc0.getReference ());
  }
  
  @Test
  public void scriptureContain_Should_DisplayScriptureText () throws Exception {
    assertEquals ("Wherefore, whoso believeth in God might with surety hope for a better world, " +
                        "yea, even a place at the right hand of God, which hope cometh of faith," +
                        " maketh an anchor to the souls of men, which would make them sure and " +
                        "steadfast, always abounding in good works, being led to glorify God.",
          sc0.getText ());
    assertEquals ("Wherefore, whoso believeth in God might with surety hope for a better world, " +
                        "yea, even a place at the right hand of God, which hope cometh of faith," +
                        " maketh an anchor to the souls of men, which would make them sure and " +
                        "steadfast, always abounding in good works, being led to glorify God.",
          sc1.getText ());
    
    assertNotEquals ("", sc0);
    assertNotEquals ("", sc1);
  }
  
  @Test
  public void scriptureContainer_Should_Return_Complete () throws Exception {
    assertEquals (false, sc0.getCompleted ());
    assertEquals (true, sc1.getCompleted ());
    assertNotEquals (true, sc0.getCompleted ());
    assertNotEquals (false, sc1.getCompleted ());
  }
}
