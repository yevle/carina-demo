package ylevchenko.gfit.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.common.MainPageBase;
import ylevchenko.gfit.mobile.gui.enums.MainPageCards;
import ylevchenko.gfit.mobile.gui.enums.YoutubeCarouselItems;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MainPageBase.class)
public class MainPage extends MainPageBase {

    @FindBy(id = "daily_goals_frame")
    private ExtendedWebElement mainGoalsFrame;

    @FindBy(id = "add_entry_fab")
    private ExtendedWebElement plusBtn;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/card_title'][@text='%s']")
    private ExtendedWebElement mainPageCard;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/card_title'][@content-desc='%s']")
    private ExtendedWebElement youtubeCard;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/card_list']//*[@resource-id='com.google.android.apps.fitness:id/playlist_carousel']")
    private ExtendedWebElement youtubeCarousel;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/card_list']//*[@resource-id='com.google.android.apps.fitness:id/playlist_carousel']//*[@text='%s']")
    private ExtendedWebElement youtubeCarouselItem;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return mainGoalsFrame.isElementPresent(TIMEOUT_SHORT);
    }

    public boolean isMainPageCardPresent(MainPageCards card) {
        return mainPageCard.format(card.getText()).isElementPresent(TIMEOUT_SHORT) ||
                youtubeCard.format(card.getText()).isElementPresent(TIMEOUT_SHORT);
    }

    public boolean scrollToCard(MainPageCards card) {
        if (card == MainPageCards.YOUTUBE) {
            return swipe(youtubeCard.format(card.getText()), Direction.UP);
        }
        return swipe(mainPageCard.format(card.getText()), Direction.UP);
    }

    public boolean doesPlusBtnUnderContainer() {
        return plusBtn.getLocation().y>mainPageCard.format(MainPageCards.values()[MainPageCards.values().length-1].getText()).getLocation().y;
    }

    public Point getPlusBtnPoint () {
        return plusBtn.getLocation();
    }

    public boolean scrollToYTCarouselItem(YoutubeCarouselItems item) {
        return swipe(youtubeCarouselItem.format(item.getText()),youtubeCarousel,Direction.LEFT);
    }

}
