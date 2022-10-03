package de.exxcellent.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static de.exxcellent.challenge.Utils.isNumeric;
import static java.lang.Float.parseFloat;

public class WeatherData {
    static List<String> keys = new ArrayList<String>(Arrays.asList("Day","MxT","MnT","AvT","AvDP","1HrP TPcpn","PDir","AvSp","Dir","MxS","SkyC","MxR","Mn","R AvSLP"));

    /**
     Compare method for sorting days by smallest temperature spread
     **/
    public static Comparator<List<String>> sortDaysBySmallestTempSpread = (List<String> dayOne, List<String> dayTwo) -> {
        int maxKey = keys.indexOf("MxT");
        int minKey = keys.indexOf("MnT");
        float dayOneSpread = isNumeric(dayOne.get(maxKey)) && isNumeric(dayOne.get(minKey)) ? parseFloat(dayOne.get(maxKey)) - parseFloat(dayOne.get(minKey)) : -1;
        float dayTwoSpread = isNumeric(dayTwo.get(maxKey)) && isNumeric(dayTwo.get(minKey)) ? parseFloat(dayTwo.get(maxKey)) - parseFloat(dayTwo.get(minKey)) : -1;
        return (int)(dayOneSpread - dayTwoSpread);
    };
}
