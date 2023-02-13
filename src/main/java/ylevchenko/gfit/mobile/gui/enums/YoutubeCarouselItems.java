package ylevchenko.gfit.mobile.gui.enums;

public enum YoutubeCarouselItems {

    WORKOUT("Workout"), YOGA("Yoga"), DANCE("Dance"),
    MEDITATE("Meditate"), MENTAL_HEALTH("Mental Health"), SLEEP("Sleep");

    String text;

    YoutubeCarouselItems(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
