package ylevchenko.gfit.mobile.gui.enums;

import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.common.BrowsePageBase;
import ylevchenko.gfit.mobile.gui.common.JournalPageBase;
import ylevchenko.gfit.mobile.gui.common.MainPageBase;
import ylevchenko.gfit.mobile.gui.common.ProfilePageBase;

public enum MainMenuItems {
    HOME("Home", MainPageBase.class), JOURNAL("Journal", JournalPageBase.class),
    BROWSE("Browse", BrowsePageBase.class), PROFILE("Profile", ProfilePageBase.class);

    String text;
    Class<? extends GFitAbstractPage> classType;

    MainMenuItems(String text, Class<? extends GFitAbstractPage> classType) {
        this.classType = classType;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Class<? extends GFitAbstractPage> getClassType() {
        return classType;
    }

}
