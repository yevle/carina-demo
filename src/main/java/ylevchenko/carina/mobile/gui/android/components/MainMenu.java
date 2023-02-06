package ylevchenko.carina.mobile.gui.android.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ylevchenko.carina.enums.MainMenuItems;
import ylevchenko.carina.mobile.gui.CarinaAbstractPage;
import ylevchenko.carina.mobile.gui.common.components.MainMenuBase;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MainMenuBase.class)
public class MainMenu extends MainMenuBase {

    @FindBy(xpath = "*//android.widget.CheckedTextView[contains(@text,'%s')]")
    private ExtendedWebElement menuItem;

    @FindBy(id = "com.solvd.carinademoapplication:id/design_menu_item_text")
    private List<ExtendedWebElement> listMenuItems;

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

    public List<String> getMenuItems() {
        return listMenuItems.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

    public ExtendedWebElement getMenuItemByIndex(int index) {
        checkListByIndex(index);
        return listMenuItems.get(index);
    }

    public CarinaAbstractPage openMenuItemByIndex(int index) {
        checkListByIndex(index);
        menuItem.format(getMenuItems().get(index)).click();
        return initPage(getDriver(), MainMenuItems.valueByIndex(index).getPageClass());
    }

    private void checkListByIndex (int index) {
        if (listMenuItems.isEmpty()) {
            Assert.fail("List of menu items is empty!");
        }
        if (!indexExists(listMenuItems, index)) {
            Assert.fail(String.format("List of menu items does not contain %s index!", index));
        }
    }

}
