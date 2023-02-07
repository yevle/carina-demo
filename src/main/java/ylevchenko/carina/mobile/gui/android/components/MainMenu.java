package ylevchenko.carina.mobile.gui.android.components;

import com.graphbuilder.struc.LinkedList;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.Point;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import ylevchenko.carina.enums.MainMenuItems;
import ylevchenko.carina.mobile.gui.CarinaAbstractPage;
import ylevchenko.carina.mobile.gui.common.components.MainMenuBase;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MainMenuBase.class)
public class MainMenu extends MainMenuBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "nav_view")
    private ExtendedWebElement container;

    @FindBy(xpath = "*//android.widget.CheckedTextView[contains(@text,'%s')]")
    private ExtendedWebElement menuItem;

    @FindBy(id = "com.solvd.carinademoapplication:id/design_menu_item_text")
    private List<ExtendedWebElement> listMenuItems;

    @FindBy(xpath = "//*[(@resource-id='com.solvd.carinademoapplication:id/navigation_header_container')]/following-sibling::*")
    private List<ExtendedWebElement> listClickableMenuItems;

    public MainMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public boolean isMenuElementPresent(MainMenuItems menuItem) {
        return this.menuItem.format(menuItem.getText()).isElementPresent(TIMEOUT_SHORT);
    }

    public CarinaAbstractPage openMenuItem(MainMenuItems item) {
        menuItem.format(item.getText()).click();
        return initPage(getDriver(), item.getPageClass());
    }

    public List<String> getMenuItemsText() {
        return listMenuItems.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

    public ExtendedWebElement getMenuItemByIndex(int index) {
        checkListByIndex(index);
        return listMenuItems.get(index);
    }

    public CarinaAbstractPage openMenuItemByIndex(int index) {
        checkListByIndex(index);
        menuItem.format(this.getMenuItemsText().get(index)).click();
        return initPage(getDriver(), MainMenuItems.valueByIndex(index).getPageClass());
    }

    private void checkListByIndex(int index) {
        if (listMenuItems.isEmpty()) {
            Assert.fail("List of menu items is empty!");
        }
        if (!indexExists(listMenuItems, index)) {
            Assert.fail(String.format("List of menu items does not contain %s index!", index));
        }
    }

    @Override
    public List<ExtendedWebElement> getMenuItems() {
        return this.listMenuItems;
    }


    @Override
    public void tapOutsideItems(int count) {
        ExtendedWebElement menuLastItem = listClickableMenuItems.get(listClickableMenuItems.size() - 1);

        Point menuItemsTopLeft = listClickableMenuItems.get(0).getLocation();
        Point menuItemsBottomRight = new Point(menuLastItem.getLocation().x + menuLastItem.getSize().width,
                menuLastItem.getLocation().y + menuLastItem.getSize().height);

        LOGGER.info("EXCLUDED rect TopLeft POINT X-" + menuItemsTopLeft.x + " Y-" + menuItemsTopLeft.y +
                " BottomRight POINT X-" + menuItemsBottomRight.x + " Y-" + menuItemsBottomRight.y);

        Point containerTopLeft = container.getLocation();
        Point containerBottomRight = new Point(container.getLocation().x + container.getSize().width,
                container.getLocation().y + container.getSize().height);

        for (int i = 0; i < count; i++) {
            Point tapPoint = randomPointInsideRect(containerTopLeft, containerBottomRight);

            while (doesPointInsideRect(menuItemsTopLeft, menuItemsBottomRight, tapPoint)) {
                LOGGER.info("POINT: X-" + tapPoint.x + " Y-" + tapPoint.y + " is inside EXCLUDED rect. Generating new...");
                tapPoint = randomPointInsideRect(containerTopLeft, containerBottomRight);
            }

            tap(tapPoint.x, tapPoint.y);
        }

    }

    @Override
    public void tapOutsideMenu() {
        tap(container.getSize().width+2,container.getSize().height/2);
    }

    @Override
    public void closeBySwipe() {
        swipeLeft(SWIPE_DURATION_LONG);
    }

    public boolean isMainMenuOpened () {
        return container.isElementPresent(TIMEOUT_SHORT);
    }

}
