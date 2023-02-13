package ylevchenko.gfit.mobile.gui.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.MainPageBase;
import ylevchenko.gfit.mobile.gui.enums.MainPageCards;
import ylevchenko.gfit.mobile.gui.enums.YoutubeCarouselItems;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MainPageBase.class)
public class MainPage extends MainPageBase {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        throw new NotImplementedException();
    }

    public boolean isMainPageCardPresent(MainPageCards card) {
        throw new NotImplementedException();
    }

    public boolean isPlusBtnUnderContainer() {
        throw new NotImplementedException();
    }

    public Point getPlusBtnPoint() {
        throw new NotImplementedException();
    }

    public boolean isYoutubeCarouselItemPresent(YoutubeCarouselItems item) {
        throw new NotImplementedException();
    }

}
