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
  private ScriptureContainer sc;

  @Before
  public void setUp() throws Exception {
    sc = new ScriptureContainer("Ether", 12, 4);
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void scriptureContainer_Should_DisplayScripture() throws Exception {

    assertEquals("Ether 12:4", sc.toString());
    assertNotEquals("Ether 12-4", sc.toString());
  }

}
