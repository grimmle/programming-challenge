package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class FileReader {
    /**
     Collects file data from given path and returns it as ArrayList
     @param filePath path relative from resources folder
     **/
    public List<List<String>> getFileData(String filePath) {
        InputStream is = getFileFromResourceAsStream(filePath);
        List<List<String>> data = getDataFromCSVInputStream(is);
        return data;
    }

    /**
     Opens file and returns a InputStream
     @param filePath path relative from resources folder
     @return A InputStream
     **/
    private InputStream getFileFromResourceAsStream(String filePath) throws IllegalArgumentException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(filePath);

        if (inputStream == null) throw new IllegalArgumentException("File not found! " + filePath);
        else return inputStream;
    }

    /**
     Reads CSV data from an InputStream and returns it as ArrayList
     @param is the InputStream containing data
     @return A ArrayList containing ArrayLists with String data
     **/
    private List<List<String>> getDataFromCSVInputStream(InputStream is) {
        List<List<String>> records = new ArrayList<>();
        try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)
        ) {
            records = reader.lines().skip(1).map(line -> {
                String[] values = line.split(",");
                return Arrays.asList(values);
            }).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
