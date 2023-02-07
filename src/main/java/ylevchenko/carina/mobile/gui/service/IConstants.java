package ylevchenko.carina.mobile.gui.service;

import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.Point;

import java.util.List;

public interface IConstants {

    int LOGIN_SYMBOL_COUNT = 7;

    int TIMEOUT_SHORT = 3;

    int SWIPE_DURATION_SHORTEST = 50;

    int SWIPE_DURATION_LONG = 200;

    int ATTEMPTS_FIVE = 5;

    String NAME_FIELD_TEXT = "Name";

    String PASSWORD_FIELD_TEXT = "Password";

    String PRIVACY_POLICY_TEXT = "I agree to the Privacy Policy";

    String ONE_SPACE_TEXT = " ";

    String EMPTY_TEXT = "";

    String EMAIL_NAME = "support";

    String EMAIL_DOMAIN = "zebrunner.com";


    public default boolean indexExists(List list, int index) {
        return index >= 0 && index < list.size();
    }

    public default boolean doesPointInsideRect (Point topLeft, Point bottomRight, Point checkedPoint) {
        return topLeft.x<=checkedPoint.x&&bottomRight.x>=checkedPoint.x&&topLeft.y<=checkedPoint.y&&bottomRight.y>=checkedPoint.y;
    }

    public default Point randomPointInsideRect (Point topLeft, Point bottomRight) {
        return new Point(RandomUtils.nextInt(topLeft.x,++bottomRight.x),
                RandomUtils.nextInt(topLeft.y,++bottomRight.y));
    }

}
