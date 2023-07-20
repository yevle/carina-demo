package ylevchenko.gsmarena.mobile.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ylevchenko.gsmarena.mobile.gui.android.components.FavoritesItem;
import ylevchenko.gsmarena.mobile.gui.android.components.MoreOptionsModal;
import ylevchenko.gsmarena.mobile.gui.android.components.SpecsItem;
import ylevchenko.gsmarena.mobile.gui.common.DevicePageBase;
import ylevchenko.gsmarena.mobile.gui.common.ForgotPassPageBase;
import ylevchenko.gsmarena.mobile.gui.common.NewsPageBase;
import ylevchenko.gsmarena.mobile.gui.common.ProfilePageBase;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    @FindBy(id = "input_email")
    ExtendedWebElement emailInputField;

    @FindBy(id = "input_password")
    ExtendedWebElement passInputField;

    @FindBy(xpath = "//*[@resource-id='com.gsmarena.android:id/btn_login'][@text, 'LOGIN']")
    ExtendedWebElement loginBtn;

    @FindBy(xpath = "//*[@content-desc='LOGOUT']")
    ExtendedWebElement logoutBtn;

    @FindBy(xpath = "//*[@content-desc='MANAGE ACCOUNT']")
    ExtendedWebElement manageAccountBtn;

    @FindBy(id = "link_forgot_password")
    ExtendedWebElement forgotPassLink;

    @FindBy(xpath = "//*[@resource-id='list-brands']/android.widget.ListView")
    List<FavoritesItem> favoritesList;

    @FindBy(xpath = "//*[@content-desc='More options']")
    ExtendedWebElement moreOptionsBtn;

    @FindBy(className = "android.widget.ListView")
    MoreOptionsModal moreOptionsMenu;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public NewsPageBase loginWithCreds(String login, String pass) {
        emailInputField.type(login);
        passInputField.type(pass);
        loginBtn.click();
        return initPage(getDriver(), NewsPageBase.class);
    }

    public boolean isLoggedIn() {
        return logoutBtn.isElementPresent(TIMEOUT_SHORTEST) && manageAccountBtn.isElementPresent(TIMEOUT_SHORTEST);
    }

    public ForgotPassPageBase clickForgotPass() {
        forgotPassLink.click(TIMEOUT_SHORT);
        return initPage(getDriver(), ForgotPassPageBase.class);
    }

    public boolean checkFavoritesContains(String keyword) {
        return favoritesList.stream().anyMatch(favoritesItem -> {
            favoritesItem.SwipeToElement();
            return favoritesItem.getTitle().toLowerCase().contains(keyword.toLowerCase());
        });
    }

    public void cleanFavorites() {
        favoritesList.forEach(favoritesItem -> {
            favoritesItem.SwipeToElement();
            favoritesItem.openFavorite().removeFromFavourites().goBackToProfile();
            moreOptionsBtn.click(TIMEOUT_SHORT);
            moreOptionsMenu.refreshPage();
        });
    }

}
