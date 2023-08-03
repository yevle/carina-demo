package com.zebrunner.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.demo.mobile.gui.pages.common.MapsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MapsPageBase.class)
public class MapsPage extends MapsPageBase {

    public MapsPage(WebDriver driver) {
        super(driver);
    }

}
