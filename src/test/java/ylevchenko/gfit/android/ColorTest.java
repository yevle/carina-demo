package ylevchenko.gfit.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ylevchenko.gfit.mobile.gui.common.MainPageBase;
import ylevchenko.gfit.mobile.gui.common.ProfilePageBase;
import ylevchenko.gfit.mobile.gui.common.SettingsPageBase;
import ylevchenko.gfit.mobile.gui.enums.MainMenuItems;

import java.util.List;


public class ColorTest extends BaseTest {

    @Test(description = "Checking changes in profile and weight/height measures")
    @MethodOwner(owner = "ylevchenko")
    public void mainPageContentTest() {

        SoftAssert softAssert = new SoftAssert();

        MainPageBase mainPage = initPage(getDriver(), MainPageBase.class);
        softAssert.assertEquals(mainPage.getHeartPtsLogoColor(), COLOR_CARIBBEAN_GREEN, "[MAIN PAGE] - Color of HeartPts Logo is inappropriate");
        softAssert.assertEquals(mainPage.getStepsLogoColor(), COLOR_YALE_BLUE, "[MAIN PAGE] - Color of Steps Logo is inappropriate");
        softAssert.assertEquals(mainPage.getMainValuesColor(), COLOR_BLUE_CRAYOLA, "[MAIN PAGE] - Color of Main Values is inappropriate");
        softAssert.assertAll();

        ProfilePageBase profilePage = (ProfilePageBase) mainPage.openMainMenuItem(MainMenuItems.PROFILE);
        softAssert.assertEquals(profilePage.getMainMenu().getMenuItemColor(MainMenuItems.PROFILE), COLOR_BLUE_CRAYOLA,
                "[PROFILE PAGE] - Color of Main Menus' Profile Icon is inappropriate");
        softAssert.assertEquals(profilePage.sleepSwitchChecker(true).getSleepSwitchColor(), COLOR_BLUE_CRAYOLA,
                "[PROFILE PAGE] - Color of checked Sleep Switch is inappropriate");
        softAssert.assertEquals(profilePage.sleepSwitchChecker(false).getSleepSwitchColor(), COLOR_GRAY_ISABELLINE,
                "[PROFILE PAGE] - Color of unchecked Sleep Switch is inappropriate");
        softAssert.assertAll();

        SettingsPageBase settingsPage = profilePage.openSettings();
        List<ExtendedWebElement> settingsElemList = settingsPage.fillElemList();
        settingsPage.swipeToSetting(settingsElemList.get(0));
        for (ExtendedWebElement element : settingsElemList) {
            String elemColor = settingsPage.getSettingsElemColor(element);
            softAssert.assertEquals(elemColor, COLOR_BLUE_CRAYOLA,
                    String.format("[SETTINGS PAGE] - '%s' color of '%s' element is inappropriate", elemColor, element.getText()));
        }
        softAssert.assertAll();

        mainPage = (MainPageBase) settingsPage.backToProfilePage().getMainMenu().openMainMenuItem(MainMenuItems.HOME);
        String accLogoColor = mainPage.getAccLogoColor();
        profilePage = (ProfilePageBase) mainPage.openMainMenuItem(MainMenuItems.PROFILE);
        Assert.assertEquals(profilePage.getAccLogoColor(), accLogoColor, "[PROFILE PAGE] - Color of Account Logo is inappropriate");
        mainPage = (MainPageBase) profilePage.getMainMenu().openMainMenuItem(MainMenuItems.HOME);
        Assert.assertEquals(mainPage.getAccLogoColor(), accLogoColor, "[MAIN PAGE] - Color of Account Logo is inappropriate");
    }

}
