package ylevchenko.carina.enums;

public enum Gender {
    MALE("male"), FEMALE("female"), UNCHECKED ("unchecked");

    private String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
