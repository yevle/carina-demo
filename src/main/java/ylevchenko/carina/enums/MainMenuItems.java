package ylevchenko.carina.enums;

import ylevchenko.carina.mobile.gui.common.*;

public enum MainMenuItems {

    WEB_VIEW ("Web View", WebViewPageBase.class, 0),
    CHARTS ("Charts", ChartsPageBase.class, 1),
    MAP ("Map", MapPageBase.class, 2),
    UI_ELEMENTS ("UI elements", UiElementsPageBase.class, 3);

    private final Class <?extends MainMenuPageBase> pageClass;
    private final String text;
    private final int index;

    MainMenuItems(String text, Class <?extends MainMenuPageBase> pageClass, int index) {
        this.pageClass = pageClass;
        this.text = text;
        this.index = index;
    }

    public Class <?extends MainMenuPageBase> getPageClass() {
        return pageClass;
    }

    public String getText() {
        return text;
    }

    public int getIndex() {
        return index;
    }

    public static MainMenuItems valueByIndex (int index) {
        for (MainMenuItems item: MainMenuItems.values()) {
            if (item.getIndex()==index) return item;
        }
        throw new IllegalArgumentException();
    }

    public static MainMenuItems valueByText (String text) {
        for (MainMenuItems item: MainMenuItems.values()) {
            if (item.getText().equals(text)) return item;
        }
        throw new IllegalArgumentException();
    }

}
