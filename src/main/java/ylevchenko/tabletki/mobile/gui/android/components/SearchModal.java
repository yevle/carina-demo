package ylevchenko.tabletki.mobile.gui.android.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.tabletki.mobile.gui.common.CatalogPageBase;
import ylevchenko.tabletki.mobile.gui.common.components.SearchModalBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchModalBase.class)
public class SearchModal extends SearchModalBase {

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/et_search']")
    ExtendedWebElement searchTextField;

    @FindBy(xpath = "//*[@resource-id='com.tabletkiua.tabletki:id/rv_search']/*[@resource-id='com.tabletkiua.tabletki:id/main_layout'][1]")
    ExtendedWebElement firstMatch;

    public SearchModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CatalogPageBase searchMeds(String keyword){
        searchTextField.type(keyword);
        firstMatch.click();
        return initPage(getDriver(), CatalogPageBase.class);
    }


}
