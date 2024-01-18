package me.timjuice.producers.sensors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;

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
        ObjectMapper objectMapper = new ObjectMapper();

        // Create a Map representing your JSON structure for the vibration sensor
        Map<String, Object> messageMap = new HashMap<>();
        messageMap.put("sensorId", sensorId);
        messageMap.put("sensorType", topic);
        messageMap.put("sensorDescription", sensorDescription);
        messageMap.put("value", sensorValue);

        try {
            String message = objectMapper.writeValueAsString(messageMap);
            producer.send(new ProducerRecord<>(topic, message));
            System.out.println("Produced message: " + message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
