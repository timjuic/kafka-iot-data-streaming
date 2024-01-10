package me.timjuice.producers;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class DoorSensorProducer extends SensorProducer {

    public DoorSensorProducer(String topic, String sensorId, String sensorDescription, int intervalSeconds) {
        super(topic, sensorId, sensorDescription, intervalSeconds);
    }

    @Override
    protected double generateSensorValue() {
        // Simulate a binary door status (1 for open, 0 for closed)
        return Math.random() < 0.5 ? 0 : 1;
    }

    @Override
    public void produceMessage(Producer<String, String> producer, String topic, double sensorValue) {
        String message = "{\"sensorId\": \"" + sensorId + "\", \"sensorDescription\": \"" + sensorDescription + "\", \"doorStatus\": " + (int) sensorValue + "}";
        producer.send(new ProducerRecord<>(topic, message));
        System.out.println("Produced message: " + message);
    }
}
