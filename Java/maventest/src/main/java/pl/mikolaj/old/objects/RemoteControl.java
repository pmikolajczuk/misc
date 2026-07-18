package pl.mikolaj.old.objects;

import java.util.List;

public class RemoteControl {
    private static final int LENGTH_IN_CM = 15;
    private static final int WIDTH_IN_CM = 4;
    private static final int THICKNESS_IN_CM = 1;

    private static final List<String> BUTTONS = List.of("1", "2", "3", "4", "5",
            "6", "7", "8", "9", "0", "Power", "VolumeUp", "VolumeDown",
            "NextChannel", "PreviousChannel");

    private int currentVolume;
    private int currentChannel;
    private final String color;

    public RemoteControl(String color) {
        this.color = color;
    }

    public void volumeUp() {
        currentVolume++;
    }

    public void volumeDown() {
        currentVolume--;
    }

    public void nextChannel() {
        currentChannel++;
    }

    public void previousChannel() {
        currentChannel--;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int volume) {
        this.currentVolume = volume;
    }
    public int getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(int channel) {
        this.currentChannel = channel;
    }
    public String getColor() {
        return color;
    }
}
