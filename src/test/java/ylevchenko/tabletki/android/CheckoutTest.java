package ylevchenko.tabletki.android;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import ylevchenko.tabletki.mobile.gui.common.MainPageBase;
import ylevchenko.tabletki.mobile.gui.common.ProductPageBase;

public class CheckoutTest extends BaseTest {

    @Test(description = "Testing of adding to cart and checkout")
    @MethodOwner(owner = "ylevchenko", platform = "android")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void checkoutTest(){

        String searchKeyword = "nurofen";

        MainPageBase mainPage = initPage(getDriver(), MainPageBase.class);
        ProductPageBase productPage = mainPage.searchProduct(searchKeyword);

        Assert.assertTrue(productPage.findPharmacies().addQtyToCart(2).finishCheckout().isCheckoutSucceed(),
                "[CHECKOUT PAGE] - checkout was not successful");

    }

}
