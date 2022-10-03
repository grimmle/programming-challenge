package de.exxcellent.challenge;

import java.io.*;
import java.util.*;

import static de.exxcellent.challenge.FootballData.sortTeamsBySmallestGoalSpread;
import static de.exxcellent.challenge.WeatherData.sortDaysBySmallestTempSpread;


/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        // create custom FileReader to read file contents
        FileReader fr = new FileReader();

        // WEATHER DATASET
        List<List<String>> weatherData = fr.getFileData("de/exxcellent/challenge/weather.csv");
        // sorting days by smallest temperature spread
        weatherData.sort(sortDaysBySmallestTempSpread);
        // get id of day at index 0
        String dayWithSmallestTempSpread = weatherData.get(0).get(0).toString();
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);


        // FOOTBALL DATASET
        List<List<String>> footballData = fr.getFileData("de/exxcellent/challenge/football.csv");
        // sorting teams by absolute goal difference
        footballData.sort(sortTeamsBySmallestGoalSpread);
        // get name of team at index 0
        String teamWithSmallestGoalSpread = footballData.get(0).get(0).toString();
        System.out.printf("Team with smallest goal spread: %s%n", teamWithSmallestGoalSpread);
    }
}
