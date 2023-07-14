package ylevchenko.gsmarena.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gsmarena.mobile.gui.android.components.SpecsItem;
import ylevchenko.gsmarena.mobile.gui.common.SearchPageBase;
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
                    specsItem.SwipeToElement();
                    return specsItem.getTitle().toLowerCase().contains(keyword.toLowerCase());
                }
        );
    }

}
