package ylevchenko.carina.utils;

import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.Point;

import java.util.List;

public class UtilMethods {
    public static boolean indexExists(List list, int index) {
        return index >= 0 && index < list.size();
    }

    public static boolean doesPointInsideRect (Point topLeft, Point bottomRight, Point checkedPoint) {
        return topLeft.x<=checkedPoint.x&&bottomRight.x>=checkedPoint.x&&topLeft.y<=checkedPoint.y&&bottomRight.y>=checkedPoint.y;
    }

    public static Point randomPointInsideRect (Point topLeft, Point bottomRight) {
        return new Point(RandomUtils.nextInt(topLeft.x,++bottomRight.x),
                RandomUtils.nextInt(topLeft.y,++bottomRight.y));
    }
}
