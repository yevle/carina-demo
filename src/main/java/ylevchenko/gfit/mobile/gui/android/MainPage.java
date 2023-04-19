package ylevchenko.gfit.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.android.components.MainMenu;
import ylevchenko.gfit.mobile.gui.android.components.PlusMenu;
import ylevchenko.gfit.mobile.gui.common.MainPageBase;
import ylevchenko.gfit.mobile.gui.enums.MainMenuItems;
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

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/card_list']")
    private ExtendedWebElement cardsContainer;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/card_title'][@content-desc='%s']")
    private ExtendedWebElement youtubeCard;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/card_list']//*[@resource-id='com.google.android.apps.fitness:id/playlist_carousel']")
    private ExtendedWebElement youtubeCarousel;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/card_list']//*[@resource-id='com.google.android.apps.fitness:id/playlist_carousel']//*[@text='%s']")
    private ExtendedWebElement youtubeCarouselItem;

    @FindBy(id = "bottom_navigation")
    private MainMenu mainMenu;

    @FindBy(id = "add_entry_speed_dial")
    private PlusMenu plusMenu;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return mainGoalsFrame.isElementPresent(TIMEOUT_SHORTEST);
    }

    @Override
    public boolean isMainPageCardPresent(MainPageCards card) {
        ExtendedWebElement cardToCheck = card == MainPageCards.YOUTUBE ? youtubeCard.format(card.getText()) : mainPageCard.format(card.getText());
        return swipe(cardToCheck, cardsContainer, Direction.UP, ATTEMPTS_FIVE);
    }

    @Override
    public boolean isPlusBtnUnderContainer() {
        swipeUp(SWIPE_DURATION_SHORTEST);
        ExtendedWebElement lastMainPageCard = mainPageCard.format(MainPageCards.values()[MainPageCards.values().length - 1].getText());
        return plusBtn.getLocation().y > lastMainPageCard.getLocation().y + lastMainPageCard.getSize().height;
    }

    @Override
    public Point getPlusBtnPoint() {
        return plusBtn.getLocation();
    }

    @Override
    public boolean isYoutubeCarouselItemPresent(YoutubeCarouselItems item) {
        ExtendedWebElement itemToCheck = youtubeCarouselItem.format(item.getText());
        return swipe(itemToCheck, youtubeCarousel, Direction.LEFT, ATTEMPTS_FIVE);
    }

    @Override
    public GFitAbstractPage openMainMenuItem(MainMenuItems item) {
        return mainMenu.openMainMenuItem(item);
    }

    @Override
    public PlusMenu openPlusMenu() {
        plusBtn.click();
        return plusMenu;
    }

}
