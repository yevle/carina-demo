package ylevchenko.gfit.mobile.gui.utils;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.Point;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ColorUtils {

    public static Color getMostCommonColor(BufferedImage image, Color backgroundColor, int distanceThreshold) throws IOException {

        int width = image.getWidth();
        int height = image.getHeight();
        int maxCount = 0;
        Color mostCommonColor = null;
        int[] rgbArray = new int[width * height];
        image.getRGB(0, 0, width, height, rgbArray, 0, width);
        for (int i = 0; i < rgbArray.length; i++) {
            Color color = new Color(rgbArray[i]);
            if (!isSimilarColor(color, backgroundColor, distanceThreshold)) {
                int count = 1;
                for (int j = i + 1; j < rgbArray.length; j++) {
                    Color nextColor = new Color(rgbArray[j]);
                    if (!isSimilarColor(nextColor, backgroundColor, distanceThreshold) && color.equals(nextColor)) {
                        count++;
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                    mostCommonColor = color;
                }
            }
        }
        return mostCommonColor;
    }

    private static boolean isSimilarColor(Color color, Color backgroundColor, int distanceThreshold) {
        int distance = Math.abs(color.getRed() - backgroundColor.getRed()) +
                Math.abs(color.getGreen() - backgroundColor.getGreen()) +
                Math.abs(color.getBlue() - backgroundColor.getBlue());
        return distance < distanceThreshold;
    }

    public static String getColorName(Color color, int distanceThreshold) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/colors/colors.csv"));
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        String line;
        String colorName = null;
        double minDistance = Double.MAX_VALUE;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String name = parts[0];
            int r = Integer.parseInt(parts[2]);
            int g = Integer.parseInt(parts[3]);
            int b = Integer.parseInt(parts[4]);
            int distance = Math.abs(red - r) + Math.abs(green - g) + Math.abs(blue - b);
            if (distance < distanceThreshold && distance < minDistance) {
                minDistance = distance;
                colorName = name;
            }
        }
        reader.close();
        return colorName;
    }

    public static String getElementColorName(BufferedImage screenshot, ExtendedWebElement element, Color background, int distance) throws IOException {
        Point point = element.getLocation();
        int eleWidth = element.getSize().getWidth();
        int eleHeight = element.getSize().getHeight();
        Color color = getMostCommonColor(screenshot.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight), background, distance);
        return getColorName(color, distance);
    }

}
