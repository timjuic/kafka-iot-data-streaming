package me.timjuice;

import me.timjuice.producers.SensorFactory;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Thread> allThreads = List.of(
                SensorFactory.createTemperatureSensorThread(),
                SensorFactory.createTemperatureSensorThread2(),
                SensorFactory.createMotionSensorThread(),
                SensorFactory.createMotionSensorThread2(),
                SensorFactory.createDoorSensorThread1(),
                SensorFactory.createDoorSensorThread2(),
                SensorFactory.createVibrationSensorThread1(),
                SensorFactory.createSoundSensorThread1(),
                SensorFactory.createHumiditySensorThread1()
        );
        startThreads(allThreads);
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