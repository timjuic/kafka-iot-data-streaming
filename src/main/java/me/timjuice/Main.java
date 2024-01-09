package me.timjuice;

import me.timjuice.producers.TemperatureSensorProducer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Thread temperatureProducerThread = new Thread(new TemperatureSensorProducer());
        temperatureProducerThread.setDaemon(true); // Set the thread as a daemon

        temperatureProducerThread.start();

        // Add a sleep or some other logic to keep the main thread alive
        try {
            Thread.sleep(Long.MAX_VALUE); // Sleep for a long time or use some other logic
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}