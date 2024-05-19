package com.valentino.example.repo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.valentino.example.entity.MyPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Service for interacting with Kafka.
 *
 * @author John Valentino
 */
@Component
public class MyPayloadProducer {

  /** Kafka template. */
  @Autowired private KafkaTemplate<String, String> kafkaTemplate;

  /** The name of the topic. */
  @Value("${topic.name.producer}")
  private String topicName;

  /**
   * Produces a payload to Kafka.
   *
   * @param input the payload
   */
  public void produce(final MyPayload input) {
    kafkaTemplate.send(topicName, input.getId(), toJson(input));
  }

  /**
   * Converts an object to JSON.
   *
   * @param obj the object
   * @return the JSON string
   */
  public String toJson(final Object obj) {
    String result = "error";
    try {
      result = new ObjectMapper().writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      result += e.getMessage();
    }
    return result;
  }
}
