package ylevchenko.tabletki.android;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import ylevchenko.tabletki.mobile.gui.common.CatalogPageBase;
import ylevchenko.tabletki.mobile.gui.common.MainPageBase;
import ylevchenko.tabletki.mobile.gui.enums.SortingOrder;

public class SortingTest extends BaseTest {

    @Test(description = "Testing of products sorting feature")
    @MethodOwner(owner = "ylevchenko", platform = "android")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void sortingTest(){

        String searchKeyword = "nurofen";
        SortingOrder order = SortingOrder.PRICE_ASC;

        MainPageBase mainPage = initPage(getDriver(), MainPageBase.class);
        CatalogPageBase catalogPage = mainPage.search(searchKeyword).sortBy(order);
        Assert.assertTrue(catalogPage.isSortedBy(order));
    }

}
