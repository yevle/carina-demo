package ylevchenko.gfit.mobile.gui.service;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static java.util.Map.entry;

public interface IConstants {

    int TIMEOUT_SHORT = 1;

    int SWIPE_DURATION_SHORTEST = 50;

    int SWIPE_DURATION_LONG = 200;

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

}
