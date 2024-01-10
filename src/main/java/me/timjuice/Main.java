package me.timjuice;

import me.timjuice.producers.KafkaTopic;
import me.timjuice.producers.TemperatureSensorProducer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Thread temperatureProducerThread = new Thread(
                new TemperatureSensorProducer(
                        KafkaTopic.TEMPERATURE_DATA.getTopicName(),
                        "001",
                        "Downstairs temperature sensor",
                        3
                )
        );
        temperatureProducerThread.setDaemon(true); // Set the thread as a daemon
        temperatureProducerThread.start();

        try {
            Thread.sleep(Long.MAX_VALUE); // Sleep for a long time or use some other logic
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}