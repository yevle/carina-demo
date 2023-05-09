package ylevchenko.gfit.mobile.gui.ios;

import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.android.components.PlusMenu;
import ylevchenko.gfit.mobile.gui.common.MainPageBase;
import ylevchenko.gfit.mobile.gui.enums.MainMenuItems;
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

    @Override
    public GFitAbstractPage openMainMenuItem(MainMenuItems item) {
        throw new NotImplementedException();
    }

    @Override
    public PlusMenu openPlusMenu() {
        throw new NotImplementedException();
    }

    @Override
    public String getStepsLogoColor() {
        throw new NotImplementedException();
    }

    @Override
    public String getHeartPtsLogoColor() {
        throw new NotImplementedException();
    }

    @Override
    public String getMainValuesColor() {
        throw new NotImplementedException();
    }

    @Override
    public String getAccLogoColor() {
        throw new NotImplementedException();
    }

}
