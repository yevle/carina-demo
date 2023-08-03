package ylevchenko.tabletki.mobile.gui.common;

import org.openqa.selenium.WebDriver;
import ylevchenko.tabletki.mobile.gui.TabletkiAbstractPage;
import ylevchenko.tabletki.mobile.gui.enums.MainMenuItems;

public abstract class MainPageBase extends TabletkiAbstractPage {

    public MainPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract TabletkiAbstractPage openMenuItem(MainMenuItems items);

    public abstract CatalogPageBase search(String keyword);

}
