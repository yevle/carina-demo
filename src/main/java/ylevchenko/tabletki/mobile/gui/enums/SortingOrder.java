package ylevchenko.tabletki.mobile.gui.enums;

public enum SortingOrder {

    ALPHABET_ASC("А-я"), ALPHABET_DESC("Я-а"),
    PRICE_ASC("Спочатку дешеві"), PRICE_DESC("Спочатку дорогі");

    final String text;

    SortingOrder(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
