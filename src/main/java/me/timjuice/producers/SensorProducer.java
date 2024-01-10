package me.timjuice.producers;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class SensorProducer implements Runnable {
    protected final String topic;
    protected final String sensorId;
    protected final String sensorDescription;
    protected final int intervalSeconds;

    public SensorProducer(String topic, String sensorId, String sensorDescription, int intervalSeconds) {
        this.topic = topic;
        this.sensorId = sensorId;
        this.sensorDescription = sensorDescription;
        this.intervalSeconds = intervalSeconds;
    }

    @Override
    public void run() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        try (Producer<String, String> producer = new KafkaProducer<>(properties)) {
            while (true) {
                double sensorValue = generateSensorValue();
                String message = "{\"sensorId\": \"" + sensorId + "\", \"sensorDescription\": \"" + sensorDescription + "\", \"value\": " + sensorValue + "}";

                producer.send(new ProducerRecord<>(topic, message));

                System.out.println("Produced message: " + message);

                TimeUnit.SECONDS.sleep(intervalSeconds);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // This method is abstract and must be implemented by subclasses
    protected abstract double generateSensorValue();

    // Method to produce a message, can be overridden by subclasses for customization
    public void produceMessage(Producer<String, String> producer, String topic, double sensorValue) {
        // Default implementation
        // You can override this method in subclasses if you need to customize message production
    }
}

