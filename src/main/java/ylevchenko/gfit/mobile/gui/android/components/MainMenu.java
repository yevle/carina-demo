package ylevchenko.gfit.mobile.gui.android.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.common.components.MainMenuBase;
import ylevchenko.gfit.mobile.gui.enums.MainMenuItems;
import ylevchenko.gfit.mobile.gui.utils.ColorUtils;
import ylevchenko.gfit.mobile.gui.utils.ScreenshotUtils;

import java.awt.image.BufferedImage;
import java.io.IOException;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MainMenuBase.class)
public class MainMenu extends MainMenuBase {

    @FindBy(id = "bottom_navigation")
    private ExtendedWebElement container;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='%s']")
    private ExtendedWebElement menuItem;

    private BufferedImage screenshot;

    public MainMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public GFitAbstractPage openMainMenuItem(MainMenuItems item) {
        menuItem.format(item.getText()).click();
        return (initPage(getDriver(), item.getClassType()));
    }

    public String getMenuItemColor(MainMenuItems item) {
        ExtendedWebElement menuFieldIcon = menuItem.format(item.getText());
        waitUntil(ExpectedConditions.visibilityOfElementLocated(menuFieldIcon.getBy()), TIMEOUT_SHORT);
        try {
            if (screenshot == null) {
                screenshot = ScreenshotUtils.screenshot(getDriver());
            }
            return ColorUtils.getElementColorName(screenshot, menuFieldIcon, BACKGROUND_COLOR_WHITE, COLOR_DISTANCE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
