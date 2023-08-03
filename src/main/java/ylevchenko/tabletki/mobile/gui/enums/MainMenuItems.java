package ylevchenko.tabletki.mobile.gui.enums;

import ylevchenko.tabletki.mobile.gui.TabletkiAbstractPage;
import ylevchenko.tabletki.mobile.gui.common.CatalogPageBase;
import ylevchenko.tabletki.mobile.gui.common.MainPageBase;
import ylevchenko.tabletki.mobile.gui.common.ProfilePageBase;

public enum MainMenuItems {

    MAIN("Головна", MainPageBase.class),
    CATALOG("Каталог", CatalogPageBase.class),
    PROFILE ("Профіль", ProfilePageBase.class);

    final String text;
    final Class <?extends TabletkiAbstractPage> classType;

    MainMenuItems(String text, Class<?extends TabletkiAbstractPage> classType) {
        this.text = text;
        this.classType = classType;
    }

    public String getText() {
        return text;
    }

    public Class<? extends TabletkiAbstractPage> getClassType() {
        return classType;
    }
}
