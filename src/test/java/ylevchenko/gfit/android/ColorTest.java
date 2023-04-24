package ylevchenko.gfit.android;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;
import ylevchenko.gfit.mobile.gui.common.MainPageBase;
import ylevchenko.gfit.mobile.gui.utils.ScreenshotUtils;

import java.awt.*;
import java.io.IOException;


public class ColorTest extends BaseTest {

    @Test(description = "Checking changes in profile and weight/height measures")
    @MethodOwner(owner = "ylevchenko")
    public void mainPageContentTest() {

        MainPageBase mainPage = initPage(getDriver(), MainPageBase.class);

        mainPage.getHeartPtsScreenshot();


        try {
            Color color = ScreenshotUtils.getMostCommonColor("screenshots/elem_screenshot.png", Color.WHITE);
            System.out.println(ScreenshotUtils.getColorName(color,25));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
