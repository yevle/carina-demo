package ylevchenko.gfit.mobile.gui.utils;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class ScreenshotUtils {


    public static void takeScreenshot(WebDriver driver, ExtendedWebElement element) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);
        Point point = element.getLocation();
        int eleWidth = element.getSize().getWidth();
        int eleHeight = element.getSize().getHeight();
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);
        FileUtils.copyFile(screenshot, new File("screenshots/elem_screenshot.png"));
    }

    public static Color getMostCommonColor(String imagePath, Color backgroundColor) throws IOException {

        BufferedImage image = ImageIO.read(new File(imagePath));

        int distanceThreshold = 20;

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
            String name = parts[1];
            int r = Integer.parseInt(parts[3]);
            int g = Integer.parseInt(parts[4]);
            int b = Integer.parseInt(parts[5]);
            int distance = Math.abs(red - r) + Math.abs(green - g) + Math.abs(blue - b);
            if (distance < distanceThreshold && distance < minDistance) {
                minDistance = distance;
                colorName = name;
            }
        }
        reader.close();
        return colorName;
    }

}