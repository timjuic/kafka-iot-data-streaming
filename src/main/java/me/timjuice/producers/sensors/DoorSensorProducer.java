package me.timjuice.producers.sensors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;

public class DoorSensorProducer extends SensorProducer {

    public DoorSensorProducer(String topic, String sensorId, String sensorDescription, int intervalSeconds) {
        super(topic, sensorId, sensorDescription, intervalSeconds);
    }

    @Override
    protected double generateSensorValue() {
        return Math.random() < 0.5 ? 0 : 1;
    }

    @Override
    public void produceMessage(Producer<String, String> producer, String topic, double sensorValue) {
        ObjectMapper objectMapper = new ObjectMapper();

        // Create a Map representing your JSON structure
        Map<String, Object> messageMap = new HashMap<>();
        messageMap.put("sensorId", sensorId);
        messageMap.put("sensorType", topic);
        messageMap.put("sensorDescription", sensorDescription);
        messageMap.put("value", (int) sensorValue);

        try {
            String message = objectMapper.writeValueAsString(messageMap);
            producer.send(new ProducerRecord<>(topic, message));
            System.out.println("Produced message: " + message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
