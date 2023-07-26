package ylevchenko.gfit.mobile.gui.utils;

import ylevchenko.gfit.mobile.gui.service.IConstants;

import java.util.regex.Matcher;

public class ExtractorUtils implements IConstants {

    public static int extractIntValue(String str) {
        Matcher matcher = ANY_INT_PATTERN.matcher(str);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        throw new NumberFormatException("No integer value found in string: " + str);
    }

    public static double extractDoubleValue(String str) {
        Matcher matcher = ANY_DOUBLE_PATTERN.matcher(str);
        if (matcher.find()) {
            return Double.parseDouble(matcher.group());
        } else {
            return extractIntValue(str);
        }
    }

}
