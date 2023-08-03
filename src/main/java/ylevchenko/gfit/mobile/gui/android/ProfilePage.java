package ylevchenko.gfit.mobile.gui.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.android.components.MainMenu;
import ylevchenko.gfit.mobile.gui.common.ProfilePageBase;
import ylevchenko.gfit.mobile.gui.common.SettingsPageBase;
import ylevchenko.gfit.mobile.gui.enums.AboutYouItems;
import ylevchenko.gfit.mobile.gui.utils.ColorUtils;
import ylevchenko.gfit.mobile.gui.utils.ScreenshotUtils;

import java.awt.image.BufferedImage;
import java.io.IOException;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/toolbar']/parent::*[contains(@content-desc,'Profile')]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.widget.Button[@content-desc='{L10N:settings}']")
    private ExtendedWebElement settingsBtn;

    @FindBy(id = "og_apd_internal_image_view")
    private ExtendedWebElement accLogo;

    @FindBy(id = "profile_sleep_switch")
    private ExtendedWebElement sleepSwitch;

    @FindBy(id = "bottom_navigation")
    private MainMenu mainMenu;

    @FindBy(id = "%s_field")
    private ExtendedWebElement aboutYouField;

    private BufferedImage screenshot;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    @Override
    public SettingsPageBase openSettings() {
        settingsBtn.click();
        return initPage(getDriver(), SettingsPageBase.class);
    }

    @Override
    public GFitAbstractPage editAboutYouField(AboutYouItems field) {
        aboutYouField.format(field.getText()).click();
        return initPage(getDriver(), field.getClassType());
    }

    @Override
    public String getAboutYouFieldText(AboutYouItems field) {
        return aboutYouField.format(field.getText()).getText();
    }

    @Override
    public ProfilePageBase sleepSwitchChecker(Boolean toCheck) {
        if (!sleepSwitch.isChecked() && toCheck) {
            sleepSwitch.check();
        }
        if (sleepSwitch.isChecked() && !toCheck) {
            sleepSwitch.uncheck();
        }
        return initPage(getDriver(), ProfilePageBase.class);
    }

    @Override
    public String getSleepSwitchColor() {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(sleepSwitch.getBy()), TIMEOUT_SHORT);
        try {
            if (screenshot == null) {
                screenshot = ScreenshotUtils.screenshot(getDriver());
            }
            return ColorUtils.getElementColorName(screenshot, sleepSwitch, BACKGROUND_COLOR_WHITE, COLOR_DISTANCE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getAccLogoColor() {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(accLogo.getBy()), TIMEOUT_SHORT);
        try {
            if (screenshot == null) {
                screenshot = ScreenshotUtils.screenshot(getDriver());
            }
            return ColorUtils.getElementColorName(screenshot, accLogo, BACKGROUND_COLOR_WHITE, COLOR_DISTANCE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public MainMenu getMainMenu() {
        return mainMenu;
    }

}
