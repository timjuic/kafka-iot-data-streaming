package me.timjuice.producers;


import me.timjuice.producers.sensors.*;

import java.util.ArrayList;
import java.util.List;

public class SensorFactory {

    private static final List<Thread> createdThreads = new ArrayList<>();

    public static Thread createTemperatureSensorThread() {
        Thread thread = new Thread(
                new TemperatureSensorProducer(
                        KafkaTopic.TEMPERATURE_DATA.getTopicName(),
                        "Temp_001",
                        "Downstairs temperature sensor",
                        10
                )
        );
        createdThreads.add(thread);
        return thread;
    }

    public static Thread createTemperatureSensorThread2() {
        Thread thread = new Thread(
                new TemperatureSensorProducer(
                        KafkaTopic.TEMPERATURE_DATA.getTopicName(),
                        "Temp_002",
                        "Upstairs temperature sensor",
                        10
                )
        );
        createdThreads.add(thread);
        return thread;
    }

    public static Thread createMotionSensorThread() {
        Thread thread = new Thread(
                new MotionSensorProducer(
                        KafkaTopic.MOTION_DATA.getTopicName(),
                        "Motion_001",
                        "Motion sensor at front door",
                        8
                )
        );
        createdThreads.add(thread);
        return thread;
    }

    public static Thread createMotionSensorThread2() {
        Thread thread = new Thread(
                new MotionSensorProducer(
                        KafkaTopic.MOTION_DATA.getTopicName(),
                        "Motion_002",
                        "Motion sensor in the back yard",
                        8
                )
        );
        createdThreads.add(thread);
        return thread;
    }

    public static Thread createDoorSensorThread1() {
        Thread thread = new Thread(
                new MotionSensorProducer(
                        KafkaTopic.DOOR_DATA.getTopicName(),
                        "Door_001",
                        "Front door sensor",
                        20
                )
        );
        createdThreads.add(thread);
        return thread;
    }

    public static Thread createDoorSensorThread2() {
        Thread thread = new Thread(
                new MotionSensorProducer(
                        KafkaTopic.DOOR_DATA.getTopicName(),
                        "Door_002",
                        "Garage door sensor",
                        20
                )
        );
        createdThreads.add(thread);
        return thread;
    }

    public static Thread createVibrationSensorThread1() {
        Thread thread = new Thread(
                new VibrationSensorProducer(
                        KafkaTopic.VIBRATION_DATA.getTopicName(),
                        "Vibration_001",
                        "Vibration sensor",
                        20
                )
        );
        createdThreads.add(thread);
        return thread;
    }

    public static Thread createHumiditySensorThread1() {
        Thread thread = new Thread(
                new HumiditySensorProducer(
                        KafkaTopic.HUMIDITY_DATA.getTopicName(),
                        "Humidity_001",
                        "House humidity sensor",
                        20
                )
        );
        createdThreads.add(thread);
        return thread;
    }

    public static Thread createSoundSensorThread1() {
        Thread thread = new Thread(
                new SoundSensorProducer(
                        KafkaTopic.SOUND_DATA.getTopicName(),
                        "Sound_001",
                        "House sound sensor",
                        10
                )
        );
        createdThreads.add(thread);
        return thread;
    }

    public static List<Thread> getAllThreads() {
        return new ArrayList<>(createdThreads);
    }
}
