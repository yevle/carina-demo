package ylevchenko.gsmarena.android;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import ylevchenko.gsmarena.mobile.gui.common.NewsPageBase;
import ylevchenko.gsmarena.mobile.gui.common.SearchPageBase;
import ylevchenko.gsmarena.mobile.gui.enums.LeftMenuItems;


public class SearchTest extends BaseTest {

    @Test(description = "Login and search test")
    @MethodOwner(owner = "ylevchenko", platform = "android")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void searchTest() {

        NewsPageBase newsPage = initPage(getDriver(), NewsPageBase.class);
        SearchPageBase searchPage = (SearchPageBase)newsPage.openLeftMenuItem(LeftMenuItems.SEARCH);

        Assert.assertTrue(searchPage.checkResultContains("nokia"), "[SEARCH PAGE] - search results does not match");

    }

}
