package me.timjuice.producers;

public enum KafkaTopic {
    TEMPERATURE_DATA("temperature-data"),
    MOTION_DATA("motion-sensor-data"),
    DOOR_DATA("door-sensor-data"),
    VIBRATION_DATA("vibration-sensor-data");

    private final String topicName;

    KafkaTopic(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }
}