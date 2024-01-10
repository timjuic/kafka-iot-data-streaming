package me.timjuice.producers;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class VibrationSensorProducer extends SensorProducer {

    public VibrationSensorProducer(String topic, String sensorId, String sensorDescription, int intervalSeconds) {
        super(topic, sensorId, sensorDescription, intervalSeconds);
    }

    @Override
    protected double generateSensorValue() {
        // Simulate a continuous vibration value
        return Math.random() * 10;
    }

    @Override
    public void produceMessage(Producer<String, String> producer, String topic, double sensorValue) {
        String message = "{\"sensorId\": \"" + sensorId + "\", \"sensorDescription\": \"" + sensorDescription + "\", \"vibrationLevel\": " + sensorValue + "}";
        producer.send(new ProducerRecord<>(topic, message));
        System.out.println("Produced message: " + message);
    }
}
