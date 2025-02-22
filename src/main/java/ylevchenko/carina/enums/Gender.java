package ylevchenko.carina.enums;

public enum Gender {

    MALE("male", "Male"), FEMALE("female", "Female");

    private final String idName;

    private final String text;

    Gender(String idName, String text) {
        this.idName = idName;
        this.text = text;
    }

    public String getIdName() {
        return idName;
    }

    public String getText() {
        return text;
    }

}
