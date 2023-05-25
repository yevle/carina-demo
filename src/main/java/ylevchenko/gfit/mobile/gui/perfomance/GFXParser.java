package ylevchenko.gfit.mobile.gui.perfomance;

import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;

import java.time.Instant;
import java.util.*;

public class GFXParser {

    public static Point getGFXPoint(String output) {
        Map<String, Object> parsedOutput = parseFramesData2(output);
        System.out.println(parsedOutput);

        return new Point("mem")
                .addTag("Benchmarks", "GFX")
                .addFields(parsedOutput)
                .time(Instant.now(), WritePrecision.NS);
    }

    public static Map<String, Object> parseFramesData2(String output) {
        Map<String, Object> framesData = new LinkedHashMap<>();
        String[] lines = output.split("\n");

        boolean startParsing = false;
        for (String line : lines) {
            if (line.startsWith("Total frames rendered:")) {
                startParsing = true;
            } else if (line.startsWith("Number Missed Vsync")) {
                break;
            }
            if (startParsing) {
                if (!line.contains("(legacy)")) {
                    String[] parts = line.split(": ");
                    if (parts.length == 2) {
                        String key = parts[0];
                        String value = parts[1].trim();
                        Integer numericValue = extractNumericValue(value);
                        framesData.put(key, numericValue);
                    }
                }
            }
        }
        return framesData;
    }

    public static Integer extractNumericValue(String value) {
        if (value.contains("(")) {
            value = value.substring(0, value.indexOf('('));
        }
        String numericString = value.replaceAll("\\D+", ""); // Remove non-digit characters
        try {
            return Integer.valueOf(numericString);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}

