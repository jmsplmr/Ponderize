package com.byui_cs.jjmn.ponderize;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * Created by Nick on 2/22/2017.
 */

public class AchievementUnitTest {

    AchievementContainer achievement = new AchievementContainer();



    @Test
    public void achievementNameIsCorrect() throws Exception {
        achievement.setAchievementName("test");

        assertEquals("test", achievement.getAchievementName());
        assertNotEquals("wrong", achievement.getAchievementName());
    }

    @Test
    public void achievementBoolIsCorrect() throws Exception {
        assertEquals(false, achievement.isAchieved());
        assertNotEquals(true, achievement.isAchieved());
    }

}
