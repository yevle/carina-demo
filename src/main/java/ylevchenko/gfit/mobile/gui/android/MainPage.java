package ylevchenko.gfit.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.android.components.MainMenu;
import ylevchenko.gfit.mobile.gui.android.components.PlusMenu;
import ylevchenko.gfit.mobile.gui.common.MainPageBase;
import ylevchenko.gfit.mobile.gui.enums.MainMenuItems;
import ylevchenko.gfit.mobile.gui.enums.MainPageCards;
import ylevchenko.gfit.mobile.gui.enums.YoutubeCarouselItems;
import ylevchenko.gfit.mobile.gui.utils.ColorUtils;
import ylevchenko.gfit.mobile.gui.utils.ScreenshotUtils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MainPageBase.class)
public class MainPage extends MainPageBase {

    @FindBy(id = "daily_goals_frame")
    private ExtendedWebElement mainGoalsFrame;

    @FindBy(id = "add_entry_fab")
    private ExtendedWebElement plusBtn;

    @FindBy(id = "og_apd_internal_image_view")
    private ExtendedWebElement accLogo;

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

    @FindBy(xpath = "//*[@content-desc='Heart Points history']/*[contains(@class,'ImageView')]")
    private ExtendedWebElement heartPtsLogo;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Steps history']/android.widget.ImageView")
    private ExtendedWebElement stepsLogo;

    @FindBy(xpath = "//*[@resource-id='com.google.android.apps.fitness:id/metric_value_text']")
    private List<ExtendedWebElement> mainValues;

    @FindBy(id = "bottom_navigation")
    private MainMenu mainMenu;

    @FindBy(id = "add_entry_speed_dial")
    private PlusMenu plusMenu;

    private BufferedImage screenshot;

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

    @Override
    public String getStepsLogoColor() {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(stepsLogo.getBy()), TIMEOUT_SHORT);
        try {
            if (screenshot == null) {
                screenshot = ScreenshotUtils.screenshot(getDriver());
            }
            return ColorUtils.getElementColorName(screenshot, stepsLogo, BACKGROUND_COLOR_WHITE, COLOR_DISTANCE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getHeartPtsLogoColor() {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(heartPtsLogo.getBy()), TIMEOUT_SHORT);
        try {
            if (screenshot == null) {
                screenshot = ScreenshotUtils.screenshot(getDriver());
            }
            return ColorUtils.getElementColorName(screenshot, heartPtsLogo, BACKGROUND_COLOR_WHITE, COLOR_DISTANCE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getAccLogoColor() {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(accLogo.getBy()), TIMEOUT_SHORT);
        try {
            if (screenshot == null) {
                screenshot = ScreenshotUtils.screenshot(getDriver());
            }
            return ColorUtils.getElementColorName(screenshot, accLogo, BACKGROUND_COLOR_WHITE, COLOR_DISTANCE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getMainValuesColor() {
        int randomValue = RandomUtils.nextInt(0, 2);
        waitUntil(ExpectedConditions.visibilityOfElementLocated(mainValues.get(0).getBy()), TIMEOUT_SHORT);
        try {
            if (screenshot == null) {
                screenshot = ScreenshotUtils.screenshot(getDriver());
            }
            return ColorUtils.getElementColorName(screenshot, mainValues.get(randomValue), BACKGROUND_COLOR_WHITE, COLOR_DISTANCE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
