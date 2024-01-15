package me.timjuice.producers.sensors;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;

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
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "158.220.113.254:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        try (Producer<String, String> producer = new KafkaProducer<>(properties)) {
            while (true) {
                double sensorValue = generateSensorValue();
                produceMessage(producer, topic, sensorValue);

                TimeUnit.SECONDS.sleep(intervalSeconds);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected abstract double generateSensorValue();

    // Method to produce a message, must be implemented by subclasses
    public abstract void produceMessage(Producer<String, String> producer, String topic, double sensorValue);
}
