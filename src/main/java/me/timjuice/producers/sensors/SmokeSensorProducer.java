package me.timjuice.producers.sensors;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class SmokeSensorProducer extends SensorProducer {

    public SmokeSensorProducer(String topic, String sensorId, String sensorDescription, int intervalSeconds) {
        super(topic, sensorId, sensorDescription, intervalSeconds);
    }

    @Override
    protected double generateSensorValue() {
        // Simulate a binary smoke status (1 for detected, 0 for not detected)
        return Math.random() < 0.5 ? 0 : 1;
    }

    @Override
    public void produceMessage(Producer<String, String> producer, String topic, double sensorValue) {
        String message = "{\"sensorId\": \"" + sensorId + "\", \"sensorDescription\": \"" + sensorDescription + "\", \"smokeDetected\": " + (int) sensorValue + "}";
        producer.send(new ProducerRecord<>(topic, message));
        System.out.println("Produced message: " + message);
    }
}
