package ylevchenko.gsmarena.mobile.gui.enums;

import ylevchenko.gsmarena.mobile.gui.GsmArenaAbstractPage;
import ylevchenko.gsmarena.mobile.gui.common.ProfilePageBase;
import ylevchenko.gsmarena.mobile.gui.common.SearchPageBase;

public enum LeftMenuItems {

//    NEWS("NEWS"),
//    REVIEWS("REVIEWS"),
//    PHONES("PHONES"),
    SEARCH("SEARCH", SearchPageBase.class),
//    PHONE_FINDER("PHONE_FINDER"),
//    ARENAEV("ARENAEV"),
    PROFILE("Profile", ProfilePageBase.class);
//    NOTIFICATIONS("Notifications"),
//    NEWS_TOPICS("News Topics"),
//    SETTINGS("Settings"),
//    SHARE("Share");

    final String text;

    final Class<? extends GsmArenaAbstractPage> classType;

    LeftMenuItems(String text, Class<? extends GsmArenaAbstractPage> classType) {
        this.text = text;
        this.classType = classType;
    }

    public String getText() {
        return text;
    }

    public Class<? extends GsmArenaAbstractPage> getClassType() {
        return classType;
    }

}
