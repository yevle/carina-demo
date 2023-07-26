package ylevchenko.gfit.mobile.gui.perfomance;

import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import ylevchenko.gfit.mobile.gui.service.IPerformanceCredits;

import java.time.Instant;
import java.util.*;

public class ShellOutputParser implements IPerformanceCredits {

    public static String[] parseCpuMemOutput(String output, String pid) {
        String[] rows = output.split("\n");
        String mainRow = "";
        for (String row : rows) {
            row=row.trim();
            if (row.startsWith(pid)) {
                mainRow = row;
            }
        }

        System.out.println(mainRow);

        String[] tokens = mainRow.split("\\s+");

        return new String[]{tokens[8], tokens[6]};
    }

    public static Point getGFXPoint(String output) {
        Map<String, Object> parsedOutput = parseFramesData(output);

        return new Point(MEASUREMENT_NAME)
                .addTag("Benchmarks", "GFX")
                .addFields(parsedOutput)
                .time(Instant.now(), WritePrecision.NS);
    }

    public static Map<String, Object> parseFramesData(String output) {
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
        System.out.println(framesData);

        return framesData;
    }

    public static Integer extractNumericValue(String value) {
        if (value.contains("(")) {
            value = value.substring(0, value.indexOf('('));
        }
        String numericString = value.replaceAll("\\D+", "");
        try {
            return Integer.valueOf(numericString);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}

