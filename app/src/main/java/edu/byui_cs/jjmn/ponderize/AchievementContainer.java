package edu.byui_cs.jjmn.ponderize;

/**
 * Created by Nick on 2/22/2017.
 */

public class AchievementContainer {

    //Variables
    private static String achievementName;
    private boolean isAchieved;
    /*
    TODO add some sort of act to complete,
    probably an int or another boolean
    of representing the act
    */
    
    //Constructor
    public AchievementContainer() {
        isAchieved = false;
    }

    //Getters and Setters
    public static String getAchievementName() {
        return achievementName;
    }

    public static void setAchievementName(String achievementName) {
        AchievementContainer.achievementName = achievementName;
    }

    public boolean isAchieved() {
        return isAchieved;
    }

    public void setAchieved(boolean achieved) {
        isAchieved = achieved;
    }
}
