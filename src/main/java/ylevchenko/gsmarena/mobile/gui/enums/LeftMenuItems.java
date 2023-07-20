package ylevchenko.gsmarena.mobile.gui.enums;

import ylevchenko.gsmarena.mobile.gui.GsmArenaAbstractPage;
import ylevchenko.gsmarena.mobile.gui.common.NewsPageBase;
import ylevchenko.gsmarena.mobile.gui.common.ProfilePageBase;
import ylevchenko.gsmarena.mobile.gui.common.SearchPageBase;

public enum LeftMenuItems {

    NEWS("NEWS", NewsPageBase.class),
    SEARCH("SEARCH", SearchPageBase.class),
    PROFILE("Profile", ProfilePageBase.class);

//    REVIEWS("REVIEWS"),
//    PHONES("PHONES"),
//    PHONE_FINDER("PHONE_FINDER"),
//    ARENAEV("ARENAEV");
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
