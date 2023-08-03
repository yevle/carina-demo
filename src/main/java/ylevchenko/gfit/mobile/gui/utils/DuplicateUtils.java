package ylevchenko.gfit.mobile.gui.utils;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import java.util.HashSet;

public class DuplicateUtils {

    private static final HashSet<String> seen = new HashSet<>();

    public static boolean isNotDuplicate(ExtendedWebElement element) {
        return seen.add(element.getText());
    }

}
