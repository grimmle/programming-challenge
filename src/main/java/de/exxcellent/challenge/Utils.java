package de.exxcellent.challenge;

public class Utils {
    /**
     Checks if a given String value is numeric
     @param string String value to be checked
     **/
    public static boolean isNumeric(String string) {
        if (string == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(string);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
