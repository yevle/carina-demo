package ylevchenko.gsmarena.mobile.gui.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ylevchenko.gsmarena.mobile.gui.common.SearchPageBase;
import ylevchenko.gsmarena.mobile.gui.common.components.SpecsItemBase;

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

}
