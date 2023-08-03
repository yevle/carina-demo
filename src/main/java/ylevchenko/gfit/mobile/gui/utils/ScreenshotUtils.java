package ylevchenko.gfit.mobile.gui.utils;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import ylevchenko.gfit.mobile.gui.service.IConstants;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.io.File;

import java.io.IOException;


public class ScreenshotUtils implements IConstants {

    public static void elementScreenshot(WebDriver driver, ExtendedWebElement element) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);

        Point point = element.getLocation();
        int eleWidth = element.getSize().getWidth();
        int eleHeight = element.getSize().getHeight();
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);
        FileUtils.copyFile(screenshot, new File(SCREENSHOT_ELEM_PATH));
    }

    public static BufferedImage screenshot(WebDriver driver) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshot, new File(SCREENSHOT_PATH));
        return ImageIO.read(screenshot);
    }

}