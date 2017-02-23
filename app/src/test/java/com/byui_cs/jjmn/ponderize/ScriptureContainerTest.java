package com.byui_cs.jjmn.ponderize;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by James Palmer on 22-Feb-17.
 */

public class ScriptureContainerTest {

    ScriptureContainer sc = new ScriptureContainer("Ether",12,4);

    @Test
    public void scriptureContainerShouldDisplayScripture()throws Exception{

        assertEquals("Ether 12:4", sc.toString());
        assertNotEquals("Ether 12-4",sc.toString());
    }

}