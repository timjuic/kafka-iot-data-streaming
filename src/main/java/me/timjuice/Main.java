package me.timjuice;

import me.timjuice.producers.TemperatureSensorProducer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Thread temperatureProducerThread = new Thread(new TemperatureSensorProducer());

        temperatureProducerThread.start();
    }
}