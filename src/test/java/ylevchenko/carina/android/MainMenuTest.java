package ylevchenko.carina.android;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ylevchenko.carina.enums.MainMenuItems;
import ylevchenko.carina.mobile.gui.common.MainMenuPageBase;
import ylevchenko.carina.mobile.gui.common.WebViewPageBase;
import ylevchenko.carina.mobile.gui.common.WelcomePageBase;
import ylevchenko.carina.mobile.gui.common.components.MainMenuBase;
import ylevchenko.carina.mobile.gui.service.IConstants;

import java.util.Arrays;
import java.util.Iterator;


public class MainMenuTest implements IAbstractTest, IMobileUtils, IConstants {

    @BeforeTest
    public void openAppAndLogin() {
        initPage(getDriver(), WelcomePageBase.class).clickNextBtn().login();
    }

    @Test(description = "Main menu items presence testing")
    @MethodOwner(owner = "ylevchenko")
    public void mainMenuItemsPresenceTest() {

        SoftAssert softAssert = new SoftAssert();

        MainMenuBase mainMenu = initPage(getDriver(), WebViewPageBase.class).tapMainMenuButton();

        for (MainMenuItems item : MainMenuItems.values()) {
            softAssert.assertTrue(mainMenu.isMenuElementPresent(item), String.format("[MAIN MENU] - '%s' item is not present", item));
        }

        softAssert.assertAll();
    }

    @Test(description = "Main menu items testing against enum")
    @MethodOwner(owner = "ylevchenko")
    public void mainMenuEnumTest() {

        SoftAssert softAssert = new SoftAssert();

        MainMenuBase mainMenu = initPage(getDriver(), WebViewPageBase.class).tapMainMenuButton();

        Iterator<MainMenuItems> itemsIterator = Arrays.stream(MainMenuItems.values()).iterator();

        for (MainMenuItems item : MainMenuItems.values()) {
            softAssert.assertTrue(mainMenu.getMenuItemsText().contains(item.getText()),
                    String.format("[MAIN MENU] - '%s' item is not present", item));
        }
        for (String element : mainMenu.getMenuItemsText()) {
            softAssert.assertEquals(element, itemsIterator.next().getText(),
                    String.format("[MAIN MENU] - '%s' item is not equal to enum value", element));
        }

        softAssert.assertAll();
    }

    @Test(description = "Main menu items testing by index and text")
    @MethodOwner(owner = "ylevchenko")
    public void mainMenuPagesTest() {

        SoftAssert softAssert = new SoftAssert();

        MainMenuPageBase mainMenuPage = initPage(getDriver(), WebViewPageBase.class);

        for (int i = 0; i < MainMenuItems.values().length; i++) {
            mainMenuPage.tapMainMenuButton().openMenuItemByIndex(i);
            mainMenuPage = initPage(getDriver(), MainMenuItems.valueByIndex(i).getPageClass());
            softAssert.assertTrue(mainMenuPage.isPageOpened(), String.format("Page with index '%s' is not opened", i));
        }

        softAssert.assertAll();

    }

    @Test(description = "Main menu items testing by index and text")
    @MethodOwner(owner = "ylevchenko")
    public void mainMenuTapAndSwipeTest() {

        SoftAssert softAssert = new SoftAssert();

        MainMenuPageBase mainMenuPage = initPage(getDriver(), WebViewPageBase.class);

        MainMenuBase mainMenu = mainMenuPage.tapMainMenuButton();

        mainMenu.tapOutsideItems(ATTEMPTS_FIVE);

        softAssert.assertTrue(mainMenu.isMainMenuOpened(), "[MAIN MENU] - Main menu closed while shouldn't be");

        mainMenu.closeBySwipe();

        softAssert.assertTrue(mainMenuPage.isPageOpened(), "[MAIN PAGE] - Main page isn't still opened");
        softAssert.assertTrue(!mainMenu.isMenuElementPresent(MainMenuItems.WEB_VIEW), "[MAIN PAGE] - Main menu still opened");

        mainMenu = mainMenuPage.tapMainMenuButton();
        mainMenu.tapOutsideMenu();

        softAssert.assertTrue(!mainMenu.isMenuElementPresent(MainMenuItems.WEB_VIEW), "[MAIN PAGE] - Main menu still opened");

        softAssert.assertAll();
    }

}
