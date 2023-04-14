package ylevchenko.gfit.mobile.gui.utils;

import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.Point;

public class CoordinatesUtils {
    public static boolean doesPointInsideRect(Point topLeft, Point bottomRight, Point checkedPoint) {
        return topLeft.x <= checkedPoint.x && bottomRight.x >= checkedPoint.x && topLeft.y <= checkedPoint.y && bottomRight.y >= checkedPoint.y;
    }

    public static Point randomPointInsideRect(Point topLeft, Point bottomRight) {
        return new Point(RandomUtils.nextInt(topLeft.x, ++bottomRight.x),
                RandomUtils.nextInt(topLeft.y, ++bottomRight.y));
    }

}
