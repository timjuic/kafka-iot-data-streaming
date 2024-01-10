package me.timjuice.producers;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class TemperatureSensorProducer extends SensorProducer {
    public TemperatureSensorProducer(String topic, String sensorId, String sensorDescription, int intervalSeconds) {
        super(topic, sensorId, sensorDescription, intervalSeconds);
    }

    @Override
    protected double generateSensorValue() {
        // Generate temperature value logic
        return Math.random() * 10 + 20;
    }

    @Override
    public void produceMessage(Producer<String, String> producer, String topic, double sensorValue) {
        String message = "{\"sensorId\": \"" + sensorId + "\", \"sensorDescription\": \"" + sensorDescription + "\", \"temperature\": " + sensorValue + "}";
        producer.send(new ProducerRecord<>(topic, message));
        System.out.println("Produced message: " + message);
    }
}