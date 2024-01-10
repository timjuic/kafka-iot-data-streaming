package me.timjuice.producers;


public class SensorFactory {

    private static final String TEMPERATURE_TOPIC = KafkaTopic.TEMPERATURE_DATA.getTopicName();

    public static Thread createTemperatureSensorThread() {
        return new Thread(
                new TemperatureSensorProducer(
                        KafkaTopic.TEMPERATURE_DATA.getTopicName(),
                        "Temp_001",
                        "Downstairs temperature sensor",
                        10
                )
        );
    }

    public static Thread createMotionSensorThread() {
        return new Thread(
                new MotionSensorProducer(
                        KafkaTopic.MOTION_DATA.getTopicName(),
                        "Motion_001",
                        "Motion sensor at front door",
                        8
                )
        );
    }

    public static Thread createMotionSensorThread2() {
        return new Thread(
                new MotionSensorProducer(
                        KafkaTopic.MOTION_DATA.getTopicName(),
                        "Motion_002",
                        "Motion sensor in the back yard",
                        8
                )
        );
    }

    public static Thread createDoorSensorThread1() {
        return new Thread(
                new MotionSensorProducer(
                        KafkaTopic.DOOR_DATA.getTopicName(),
                        "Door_001",
                        "Front door sensor",
                        20
                )
        );
    }

    public static Thread createDoorSensorThread2() {
        return new Thread(
                new MotionSensorProducer(
                        KafkaTopic.DOOR_DATA.getTopicName(),
                        "Door_002",
                        "Garage door sensor",
                        20
                )
        );
    }

    public static Thread createVibrationSensorThread1() {
        return new Thread(
                new VibrationSensorProducer(
                        KafkaTopic.VIBRATION_DATA.getTopicName(),
                        "Vibration_001",
                        "Vibration sensor",
                        20
                )
        );
    }

    // Add methods for creating other sensor threads here, e.g., createDoorSensorThread, createSmokeSensorThread, createVibrationSensorThread, etc.
}
