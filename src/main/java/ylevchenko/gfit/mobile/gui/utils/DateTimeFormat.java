package ylevchenko.gfit.mobile.gui.utils;

import ylevchenko.gfit.mobile.gui.service.IConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Properties;

public class DateTimeFormat implements IConstants {

    private static final Properties props = new Properties();

    public static Properties readProperty() {
        try (FileInputStream in = new FileInputStream("src/main/resources/_config.properties")) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    public static String dateFormat(LocalDateTime dateTime) {
        String locale = props.isEmpty() ? readProperty().getProperty("locale") : props.getProperty("locale");
        if (locale.equalsIgnoreCase("en_US")) return dateTime.toLocalDate().format(EN_US);
        else throw new DateTimeException("Wrong date format");
    }

    public static String getHour(LocalDateTime dateTime) {
        String locale = props.isEmpty() ? readProperty().getProperty("locale") : props.getProperty("locale");
        if (locale.equalsIgnoreCase("en_US")) return String.valueOf(Math.abs(dateTime.toLocalTime().getHour() - 12));
        else throw new DateTimeException("Wrong date format");
    }

    public static String timeParser(LocalDateTime dateTime) {
        String hours;
        if (dateTime.getHour() >= 12) {
            hours = String.valueOf(dateTime.getHour() - 12);
        } else hours = String.valueOf(dateTime.getHour());
        String minutes = String.valueOf(dateTime.getMinute());
        if (minutes.length() == 1) {
            minutes = "0" + minutes;
        }
        if (hours.equalsIgnoreCase("0") || hours.equalsIgnoreCase("00")) {
            return minutes + "m 00s";
        } else return hours + "h " + minutes + "m 00s";
    }

}
