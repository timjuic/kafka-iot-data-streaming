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

    // Optional: You can override other methods from the Sensor base class if needed
    // For example, you might want to customize the way messages are produced or add additional behavior.

    @Override
    public void produceMessage(Producer<String, String> producer, String topic, double sensorValue) {
        String message = "{\"sensor\": \"temperature\", \"value\": " + sensorValue + "}";
        producer.send(new ProducerRecord<>(topic, message));
        System.out.println("Produced message: " + message);
    }
}
