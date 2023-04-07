package ylevchenko.gfit.mobile.gui.service;

import java.time.format.DateTimeFormatter;

public interface IConstants {

    int TIMEOUT_SHORT = 1;

    int SWIPE_DURATION_SHORTEST = 50;

    int SWIPE_DURATION_LONG = 200;

    int ATTEMPTS_FIVE = 5;

    DateTimeFormatter EN_US = DateTimeFormatter.ofPattern("MM/dd/yyyy");

}
