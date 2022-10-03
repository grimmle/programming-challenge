package de.exxcellent.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static de.exxcellent.challenge.Utils.isNumeric;
import static java.lang.Float.parseFloat;

public class FootballData {
    static List<String> keys = new ArrayList<String>(Arrays.asList("Team","Games","Wins","Losses","Draws","Goals","Goals Allowed","Points"));

    /**
     Compare method for sorting teams by smallest goal spread
     **/
    public static Comparator<List<String>> sortTeamsBySmallestGoalSpread = (List<String> teamOne, List<String> teamTwo) -> {
        int goalsKey = keys.indexOf("Goals");
        int goalsAllowedKey = keys.indexOf("Goals Allowed");
        float teamOneSpread = isNumeric(teamOne.get(goalsKey)) && isNumeric(teamOne.get(goalsAllowedKey)) ? Math.abs(parseFloat(teamOne.get(goalsKey)) - parseFloat(teamOne.get(goalsAllowedKey))) : -1;
        float teamTwoSpread = isNumeric(teamTwo.get(goalsKey)) && isNumeric(teamTwo.get(goalsAllowedKey)) ? Math.abs(parseFloat(teamTwo.get(goalsKey)) - parseFloat(teamTwo.get(goalsAllowedKey))) : -1;
        return (int)(teamOneSpread - teamTwoSpread);
    };
}
