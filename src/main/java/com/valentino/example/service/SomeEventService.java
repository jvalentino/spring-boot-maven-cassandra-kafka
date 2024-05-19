package com.valentino.example.service;

import com.valentino.example.entity.MyPayload;
import com.valentino.example.repo.MyPayloadProducer;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for handling some event.
 *
 * @author John Valentino
 */
@Service
public class SomeEventService {

  /** The producer. */
  @Autowired private MyPayloadProducer producer;

  /**
   * Publishes an event.
   *
   * @param a
   * @param b
   * @param c
   * @return
   */
  public MyPayload publishEvent(final String a, final String b, final String c) {
    final MyPayload payload =
        MyPayload.builder().id(UUID.randomUUID().toString()).a(a).b(b).c(c).build();
    producer.produce(payload);
    return payload;
  }
}
