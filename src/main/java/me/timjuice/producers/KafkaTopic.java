package me.timjuice.producers;

public enum KafkaTopic {
    TEMPERATURE_DATA("temperature"),
    MOTION_DATA("motion"),
    DOOR_DATA("door"),
    VIBRATION_DATA("vibration"),
    SOUND_DATA("sound"),
    HUMIDITY_DATA("humidity");

    private final String topicName;

    KafkaTopic(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }
}