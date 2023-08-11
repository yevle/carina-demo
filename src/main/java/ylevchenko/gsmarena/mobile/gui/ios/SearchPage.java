package ylevchenko.gsmarena.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import ylevchenko.gsmarena.mobile.gui.GsmArenaAbstractPage;
import ylevchenko.gsmarena.mobile.gui.common.DevicePageBase;
import ylevchenko.gsmarena.mobile.gui.common.SearchPageBase;
import ylevchenko.gsmarena.mobile.gui.common.components.SpecsItemBase;
import ylevchenko.gsmarena.mobile.gui.enums.LeftMenuItems;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SearchPageBase.class)
public class SearchPage extends SearchPageBase {

    private ExtendedWebElement searchField;

    private List<SpecsItemBase> specsList;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkResultContains(String keyword) {
        throw new NotImplementedException();
    }

    @Override
    public DevicePageBase openDevicePage(String keyword) {
        throw new NotImplementedException();
    }

    @Override
    public GsmArenaAbstractPage goBackTo(LeftMenuItems item) {
        throw new NotImplementedException();
    }

}
