package ylevchenko.gsmarena.android;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ylevchenko.gsmarena.mobile.gui.common.NewsPageBase;
import ylevchenko.gsmarena.mobile.gui.common.ProfilePageBase;
import ylevchenko.gsmarena.mobile.gui.common.SearchPageBase;
import ylevchenko.gsmarena.mobile.gui.enums.LeftMenuItems;

public class FavoritesTest extends BaseTest {

    @Test(description = "Login and adding favorites test")
    @MethodOwner(owner = "ylevchenko", platform = "android")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void favoritesTest() {

        String favoritesKeyword = "Nokia G42";

        NewsPageBase newsPage = initPage(getDriver(), NewsPageBase.class);
        SearchPageBase searchPage = (SearchPageBase) newsPage.openLeftMenuItem(LeftMenuItems.SEARCH);
        newsPage = (NewsPageBase) searchPage.openDevicePage(favoritesKeyword).addToFavourites().goBackToSearch().goBackTo(LeftMenuItems.NEWS);
        ProfilePageBase profilePage = (ProfilePageBase) newsPage.openLeftMenuItem(LeftMenuItems.PROFILE);

        Assert.assertTrue(profilePage.checkFavoritesContains(favoritesKeyword), "[PROFILE PAGE] - Favorites does not contains added item(s)");
    }

    @AfterMethod
    public void clearFavourites() {
        ProfilePageBase profilePage = initPage(getDriver(), ProfilePageBase.class);
        profilePage.cleanFavorites();
    }

}
