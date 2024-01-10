package me.timjuice;

import me.timjuice.producers.SensorFactory;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Create and start temperature sensor threads
        Thread temperatureThread = SensorFactory.createTemperatureSensorThread();
        startThreads(temperatureThread);

        // Create and start motion sensor threads
        Thread motionSensorProducerThread1 = SensorFactory.createMotionSensorThread();
        Thread motionSensorProducerThread2 = SensorFactory.createMotionSensorThread2();
        startThreads(motionSensorProducerThread1, motionSensorProducerThread2);

        // Create and start door sensor threads
        Thread doorSensorProducerThread1 = SensorFactory.createDoorSensorThread1();
        Thread doorSensorProducerThread2 = SensorFactory.createDoorSensorThread2();
        startThreads(doorSensorProducerThread1, doorSensorProducerThread2);

        // Create and start vibration sensor thread
        Thread vibrationSensorProducerThread1 = SensorFactory.createVibrationSensorThread1();
        startThreads(vibrationSensorProducerThread1);
    }

    private static void startThreads(Thread... threads) {
        for (Thread thread : threads) {
            thread.setDaemon(true);
            thread.start();
        }
    }
}