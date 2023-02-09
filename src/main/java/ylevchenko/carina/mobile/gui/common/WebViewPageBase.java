package ylevchenko.carina.mobile.gui.common;

import org.openqa.selenium.WebDriver;

public abstract class WebViewPageBase extends MainMenuPageBase {

    public WebViewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isFooterEmailLinkPresent();

    public abstract boolean isFooterEmailLinkCorrect(String name, String domain);

}
