package ylevchenko.gfit.mobile.gui.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ylevchenko.gfit.mobile.gui.common.ProfilePageBase;
import ylevchenko.gfit.mobile.gui.common.SettingsPageBase;
import ylevchenko.gfit.mobile.gui.utils.ColorUtils;
import ylevchenko.gfit.mobile.gui.utils.DuplicateUtils;
import ylevchenko.gfit.mobile.gui.utils.ScreenshotUtils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SettingsPageBase.class)
public class SettingsPage extends SettingsPageBase {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='{L10N:backBtn}']")
    private ExtendedWebElement backBtn;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/settings_unit_container']//*[contains(@text,'%s')]//parent::*")
    private ExtendedWebElement unitsField;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/recycler_view']/child::*[1]//*[@resource-id='android:id/title'][contains(@text,'%s')]")
    private ExtendedWebElement settingsElem;

    @FindBy(xpath = "(//*[@resource-id='com.google.android.apps.fitness:id/recycler_view']/child::*[1]//*[@resource-id='android:id/title'])[1]")
    private ExtendedWebElement firstElemInList;

    private List<ExtendedWebElement> fullList;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/recycler_view']/child::*[1]//*[@resource-id='android:id/title']")
    private List<ExtendedWebElement> settingsElemList;

    @FindBy(xpath = "//*[@resource-id='android:id/text1'][contains(@text,'%s')]")
    private ExtendedWebElement choiceRadioBtn;

    private BufferedImage screenshot;


    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<ExtendedWebElement> fillElemList() {
        List<ExtendedWebElement> elemList = new ArrayList<>(settingsElemList);
        int counter = 0;
        while (counter < ATTEMPTS_FIVE || !elemList.get(elemList.size() - 1).getText().equals(LAST_SETTING_ELEM)) {
            swipeUp(SWIPE_DURATION_LONGEST);
            elemList.addAll(settingsElemList.subList(1, settingsElemList.size()));
            counter++;
        }
        return fullList = elemList.stream()
                .filter(DuplicateUtils::isNotDuplicate)
                .collect(Collectors.toList());
    }

    @Override
    public SettingsPageBase swipeToSetting(ExtendedWebElement element) {
        swipe(element, Direction.DOWN, ATTEMPTS_FIVE, SWIPE_DURATION_SHORTEST);
        return initPage(getDriver(), SettingsPageBase.class);
    }

    @Override
    public String getSettingsElemColor(ExtendedWebElement element) {
        swipe(element, Direction.UP, ATTEMPTS_FIVE, SWIPE_DURATION_LONGEST);
        try {
            waitUntil(ExpectedConditions.visibilityOfElementLocated(element.getBy()), TIMEOUT_SHORT);
            screenshot = ScreenshotUtils.screenshot(getDriver());
            return ColorUtils.getElementColorName(screenshot, element, BACKGROUND_COLOR_WHITE, COLOR_DISTANCE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ProfilePageBase backToProfilePage() {
        backBtn.click();
        return initPage(getDriver(), ProfilePageBase.class);
    }

}
