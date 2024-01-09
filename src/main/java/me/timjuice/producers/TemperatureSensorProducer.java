package me.timjuice.producers;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TemperatureSensorProducer implements Runnable {
    @Override
    public void run() {
        // Kafka broker address
        String bootstrapServers = "localhost:9092";

        // Kafka producer configuration
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        // Create Kafka producer

        // Kafka topic

        // Produce temperature sensor data every second
        try (Producer<String, String> producer = new KafkaProducer<>(properties)) {
            String topic = "temperature-data";
            while (true) {
                double temperature = Math.random() * 10 + 20; // Example: random temperature between 20 and 30
                String message = "{\"sensor\": \"temperature\", \"value\": " + temperature + "}";

                producer.send(new ProducerRecord<>(topic, message));

                System.out.println("Produced message: " + message);

                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Close the producer when done
    }
}

