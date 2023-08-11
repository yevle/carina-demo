package ylevchenko.gsmarena.mobile.gui.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gsmarena.mobile.gui.GsmArenaAbstractPage;
import ylevchenko.gsmarena.mobile.gui.android.components.SpecsItem;
import ylevchenko.gsmarena.mobile.gui.common.DevicePageBase;
import ylevchenko.gsmarena.mobile.gui.common.SearchPageBase;
import ylevchenko.gsmarena.mobile.gui.enums.LeftMenuItems;
import ylevchenko.gsmarena.mobile.gui.utils.MobileShellCommands;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchPageBase.class)
public class SearchPage extends SearchPageBase {

    @FindBy(id = "search_src_text")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//*[@resource-id='latest-container']/*/*/*[@content-desc]")
    private List<SpecsItem> specsList;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkResultContains(String keyword) {
        searchField.type(keyword);
        (new MobileShellCommands()).pressEnter();
        return specsList.stream().allMatch(specsItem -> {
                    specsItem.swipeToElement();
                    return specsItem.getTitle().toLowerCase().contains(keyword.toLowerCase());
                }
        );
    }

    public DevicePageBase openDevicePage(String keyword) {
        searchField.type(keyword);
        (new MobileShellCommands()).pressEnter();
        return specsList.stream().findFirst().get().openFavorite();
    }

    public GsmArenaAbstractPage goBackTo(LeftMenuItems item) {
        navigateBack();
        return initPage(getDriver(), item.getClassType());
    }

}
