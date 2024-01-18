package me.timjuice;

import me.timjuice.producers.SensorFactory;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        // Create and start all sensor threads
        List<Thread> allThreads = List.of(
                SensorFactory.createTemperatureSensorThread(),
                SensorFactory.createMotionSensorThread(),
                SensorFactory.createMotionSensorThread2(),
                SensorFactory.createDoorSensorThread1(),
                SensorFactory.createDoorSensorThread2(),
                SensorFactory.createVibrationSensorThread1(),
                SensorFactory.createHumiditySensorThread1()
        );
        startThreads(allThreads);

        // Wait for threads to finish (optional)
        joinThreads(allThreads);
    }

    private static void startThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    private static void joinThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}