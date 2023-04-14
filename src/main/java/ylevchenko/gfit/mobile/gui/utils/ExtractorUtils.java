package ylevchenko.gfit.mobile.gui.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractorUtils {

    public static int extractIntValue(String str) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        throw new NumberFormatException("No integer value found in string: " + str);
    }

    public static double extractDoubleValue(String str) {
        Pattern pattern = Pattern.compile("\\d+\\.\\d");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return Double.parseDouble(matcher.group());
        }
        throw new NumberFormatException("No double value found in string: " + str);
    }

}
