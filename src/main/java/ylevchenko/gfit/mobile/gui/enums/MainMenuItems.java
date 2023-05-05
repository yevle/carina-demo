package ylevchenko.gfit.mobile.gui.enums;

import com.zebrunner.carina.utils.resources.L10N;
import ylevchenko.gfit.mobile.gui.GFitAbstractPage;
import ylevchenko.gfit.mobile.gui.common.BrowsePageBase;
import ylevchenko.gfit.mobile.gui.common.JournalPageBase;
import ylevchenko.gfit.mobile.gui.common.MainPageBase;
import ylevchenko.gfit.mobile.gui.common.ProfilePageBase;

public enum MainMenuItems {
    HOME(L10N.getText("home"), MainPageBase.class),
    JOURNAL(L10N.getText("journal"), JournalPageBase.class),
    BROWSE(L10N.getText("browse"), BrowsePageBase.class),
    PROFILE(L10N.getText("profile"), ProfilePageBase.class);

    final String text;
    final Class<? extends GFitAbstractPage> classType;

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
