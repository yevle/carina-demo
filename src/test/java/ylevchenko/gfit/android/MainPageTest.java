package ylevchenko.gfit.android;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ylevchenko.gfit.mobile.gui.common.MainPageBase;
import ylevchenko.gfit.mobile.gui.enums.MainPageCards;
import ylevchenko.gfit.mobile.gui.enums.YoutubeCarouselItems;

public class MainPageTest extends BaseTest {

    @Test(description = "Checking all cards and items on main page")
    @MethodOwner(owner = "ylevchenko")
    public void mainPageContentTest() {

        SoftAssert softAssert = new SoftAssert();
        MainPageBase mainPageBase = initPage(getDriver(), MainPageBase.class);
        Point initialPoint = mainPageBase.getPlusBtnPoint();

        for (MainPageCards card : MainPageCards.values()) {

            softAssert.assertTrue(mainPageBase.isMainPageCardPresent(card), String.format("Card %s wasn't found on its place", card.name()));

            if (card.equals(MainPageCards.YOUTUBE)) {
                for (YoutubeCarouselItems item : YoutubeCarouselItems.values()) {
                    softAssert.assertTrue(mainPageBase.isYoutubeCarouselItemPresent(item),
                            String.format("%s YouTube carousel item wasn't found on its place", item.name()));
                }
            }

            softAssert.assertEquals(initialPoint, mainPageBase.getPlusBtnPoint(),
                    String.format("Initial point %s does not equal to current point %s", initialPoint.toString(), mainPageBase.getPlusBtnPoint().toString()));
        }

        softAssert.assertTrue(mainPageBase.isPlusBtnUnderContainer(), "Plus button isn't under last card container");

        softAssert.assertAll();
    }

}
