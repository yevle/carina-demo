package ylevchenko.gfit.mobile.gui.service;

import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

import static java.util.Map.entry;

public interface IConstants {

    String SCREENSHOT_PATH = "screenshots/screenshot.png";
    String SCREENSHOT_ELEM_PATH = "screenshots/elem_screenshot.png";

    int TIMEOUT_SHORTEST = 1;
    int TIMEOUT_SHORT = 3;

    int SWIPE_DURATION_SHORTEST = 50;
    int SWIPE_DURATION_LONG = 200;
    int SWIPE_DURATION_LONGEST = 400;

    int ATTEMPTS_ONE = 1;
    int ATTEMPTS_FIVE = 5;
    int ATTEMPTS_FIFTY = 50;

    DateTimeFormatter EN_US = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    DateTimeFormatter ISO_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    DateTimeFormatter TEXT_MONTH = DateTimeFormatter.ofPattern("MMMM");
    DateTimeFormatter BIRTH_DATE = DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH);

    String FEET_MARK = "'";
    String INCH_MARK = String.valueOf('"');
    String FEET_TEXT = " ft";
    String INCH_TEXT = " in";

    String COMMA = ",";
    String POINT = ".";

    Map<String, String> UNITS = new HashMap<>(Map.ofEntries(
            entry("KG", "Kilograms"),
            entry("LB", "Pounds"),
            entry("CM", "Centimeters"),
            entry("FT", "Feet & inches")
    ));

    int HEIGHT_CM_DELTA = 1;
    double WEIGHT_KG_DELTA = 1.0;
    double WEIGHT_LB_DELTA = 0.2;

    Pattern ANY_DOUBLE_PATTERN = Pattern.compile("\\d+\\.\\d");
    Pattern ANY_INT_PATTERN = Pattern.compile("\\d+");
    Pattern FOUR_DIGIT_NUM = Pattern.compile("\\b\\d{4}\\b"); // match a 4-digit number surrounded by word boundaries

    Color BACKGROUND_COLOR_WHITE = Color.WHITE;
    String COLOR_CARIBBEAN_GREEN = "Caribbean Green";
    String COLOR_YALE_BLUE = "Yale Blue";
    String COLOR_BLUE_CRAYOLA = "Blue (Crayola)";
    String COLOR_GRAY_ISABELLINE = "Isabelline";

    int COLOR_DISTANCE = 43;

    String LAST_SETTING_ELEM = "Display";

}
