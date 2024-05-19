package com.valentino.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.valentino.example.entity.MyPayload;
import java.util.ArrayList;
import java.util.List;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Event listener.
 *
 * @author John Valentino
 */
@Service
public class SomeEventListener {

  /** The name of the topic. */
  @Value("${topic.name.consumer}")
  private String topicName;

  /** The group id. */
  @Value("${spring.kafka.consumer.group-id}")
  private String groupId;

  /** Don't do this, this is just an example */
  private final List<MyPayload> payloads = new ArrayList<>();

  /**
   * Consume a payload.
   *
   * @param payload The payload.
   * @return The payload.
   */
  @KafkaListener(topics = "${topic.name.consumer}", groupId = "${spring.kafka.consumer.group-id}")
  public MyPayload consume(final ConsumerRecord<String, String> payload) {
    final String json = payload.value();
    MyPayload doc = new MyPayload();
    try {
      doc = toObject(json, MyPayload.class);
      payloads.add(doc);
    } catch (JsonProcessingException e) {
      doc.setA("error");
    }
    return doc;
  }

  /**
   * Converts a JSON string to an object.
   *
   * @param json The JSON string.
   * @param clazz The class.
   * @param <T> The type.
   * @return The object.
   * @throws JsonProcessingException If there is an error.
   */
  public <T> T toObject(final String json, final Class<T> clazz) throws JsonProcessingException {
    return new ObjectMapper().readValue(json, clazz);
  }

  /**
   * Gets the payloads.
   *
   * @return The payloads.
   */
  public List<MyPayload> getPayloads() {
    return payloads;
  }
}
