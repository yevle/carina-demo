package ylevchenko.gfit.android;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.Point;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ylevchenko.gfit.mobile.gui.service.IConstants;
import ylevchenko.gfit.mobile.gui.common.LoginPageBase;
import ylevchenko.gfit.mobile.gui.common.MainPageBase;
import ylevchenko.gfit.mobile.gui.enums.MainPageCards;
import ylevchenko.gfit.mobile.gui.enums.YoutubeCarouselItems;

public class MainPageTest implements IAbstractTest, IMobileUtils, IConstants {

    @BeforeTest
    public void loginApp() {
        initPage(getDriver(), LoginPageBase.class).login().clickNextBtn().clickSkipBtn();
    }

    @Test(description = "Checking all cards and items on main page")
    @MethodOwner(owner = "ylevchenko")
    public void mainPageContentTest() {

        SoftAssert softAssert = new SoftAssert();
        MainPageBase mainPageBase = initPage(getDriver(), MainPageBase.class);
        Point initialPoint = mainPageBase.getPlusBtnPoint();

        for (MainPageCards card : MainPageCards.values()) {

            softAssert.assertTrue(mainPageBase.scrollToCard(card), String.format("Card %s wasn't found on its place", card.name()));

            if (card.equals(MainPageCards.YOUTUBE)) {
                for (YoutubeCarouselItems item : YoutubeCarouselItems.values()) {
                    softAssert.assertTrue(mainPageBase.scrollToYTCarouselItem(item),
                            String.format("%s YouTube carousel item wasn't found on its place", item.name()));
                }
            }

            softAssert.assertEquals(initialPoint, mainPageBase.getPlusBtnPoint(),
                    String.format("Initial point %s does not equal to current point %s", initialPoint.toString(), mainPageBase.getPlusBtnPoint().toString()));
        }

        mainPageBase.swipeUp(SWIPE_DURATION_LONG);
        softAssert.assertTrue(mainPageBase.doesPlusBtnUnderContainer(), "Plus button isn't under last card container");

        softAssert.assertAll();
    }

}
