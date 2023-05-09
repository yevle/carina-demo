package ylevchenko.gfit.mobile.gui.enums;

import com.zebrunner.carina.utils.resources.L10N;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.common.BrowsePageBase;
import ylevchenko.gfit.mobile.gui.common.JournalPageBase;
import ylevchenko.gfit.mobile.gui.common.MainPageBase;
import ylevchenko.gfit.mobile.gui.common.ProfilePageBase;

public enum MainMenuItems {
    HOME("home", MainPageBase.class),
    JOURNAL("journal", JournalPageBase.class),
    BROWSE("browse", BrowsePageBase.class),
    PROFILE("profile", ProfilePageBase.class);

    final String text;
    final Class<? extends GFitAbstractPage> classType;

    MainMenuItems(String text, Class<? extends GFitAbstractPage> classType) {
        this.classType = classType;
        this.text = text;
    }

    public String getText() {
        return L10N.getText(text);
    }

    public Class<? extends GFitAbstractPage> getClassType() {
        return classType;
    }

}
