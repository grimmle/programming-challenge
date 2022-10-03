package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static de.exxcellent.challenge.FootballData.sortTeamsBySmallestGoalSpread;
import static de.exxcellent.challenge.WeatherData.sortDaysBySmallestTempSpread;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    private String successLabel = "not successful";

    @BeforeEach
    void setUp() {
        successLabel = "successful";
    }

    @Test
    void aPointlessTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

    @Test
    void runFootball() {
        App.main("--football", "football.csv");
    }

    @Test
    void testWeatherSort() {
        List<String> a = new ArrayList<String>(Arrays.asList("1","88","59","74","53.8","0","280","9.6","270","17","1.6","93","23","1004.5"));
        List<String> b = new ArrayList<String>(Arrays.asList("21","86","59","73","57.7","0","240","6.1","250","12","1","87","35","1030.7"));
        List<List<String>> list = new ArrayList<List<String>>(Arrays.asList(a, b));
        list.sort(sortDaysBySmallestTempSpread);
        // b has smaller temp spread and should be first in list
        assertEquals(list.get(0).get(0), "21");
    }

    @Test
    void testFootballSort() {
        List<String> a = new ArrayList<String>(Arrays.asList("Arsenal","38","26","9","3","79","36","87"));
        List<String> b = new ArrayList<String>(Arrays.asList("Leicester","38","5","13","20","30","64","28"));
        List<List<String>> list = new ArrayList<List<String>>(Arrays.asList(a, b));
        list.sort(sortTeamsBySmallestGoalSpread);
        // b has smaller goal spread and should be first in list
        assertEquals(list.get(0).get(0), "Leicester");
    }

}