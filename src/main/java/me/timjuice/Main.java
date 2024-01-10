package me.timjuice;

import me.timjuice.producers.KafkaTopic;
import me.timjuice.producers.MotionSensorProducer;
import me.timjuice.producers.TemperatureSensorProducer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Temperature sensor thread
        Thread temperatureProducerThread = new Thread(
                new TemperatureSensorProducer(
                        KafkaTopic.TEMPERATURE_DATA.getTopicName(),
                        "001",
                        "Downstairs temperature sensor",
                        3
                )
        );
        temperatureProducerThread.setDaemon(true);
        temperatureProducerThread.start();

        // Motion sensor thread
        Thread motionSensorProducerThread = new Thread(
                new MotionSensorProducer(
                        KafkaTopic.MOTION_DATA.getTopicName(),
                        "002",
                        "Living Room Motion Sensor",
                        5
                )
        );
        motionSensorProducerThread.setDaemon(true);
        motionSensorProducerThread.start();

        try {
            // Sleep for some time or use other logic
            Thread.sleep(60000); // Sleep for 1 minute for example
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Optionally, you can interrupt the threads or perform other cleanup logic here
        temperatureProducerThread.interrupt();
        motionSensorProducerThread.interrupt();
    }
}
