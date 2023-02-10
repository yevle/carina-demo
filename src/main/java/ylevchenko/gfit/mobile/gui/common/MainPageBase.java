package ylevchenko.gfit.mobile.gui.common;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.enums.MainPageCards;
import ylevchenko.gfit.mobile.gui.enums.YoutubeCarouselItems;

public abstract class MainPageBase extends GFitAbstractPage {

    public MainPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean scrollToCard(MainPageCards card);

    public abstract boolean doesPlusBtnUnderContainer();

    public abstract Point getPlusBtnPoint();

    public abstract boolean scrollToYTCarouselItem(YoutubeCarouselItems item);

}
