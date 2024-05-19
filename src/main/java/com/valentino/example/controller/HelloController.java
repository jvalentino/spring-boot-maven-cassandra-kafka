package com.valentino.example.controller;

import com.valentino.example.dto.HelloResponseDto;
import com.valentino.example.entity.MyEntity;
import com.valentino.example.entity.MyPayload;
import com.valentino.example.service.HelloService;
import com.valentino.example.service.SomeEventListener;
import com.valentino.example.service.SomeEventService;
import com.valentino.example.service.SomeStorageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * An example rest controller.
 *
 * @author John Valentino
 */
@RestController
public class HelloController {

  /** The hello service */
  @Autowired private HelloService helloService;

  /** The thing that talks to cassandra eventually. */
  @Autowired private SomeStorageService someStorage;

  /** The event service */
  @Autowired private SomeEventService someEventService;

  /** The event listener */
  @Autowired private SomeEventListener someEventListener;

  /**
   * Returns a greeting for the given name.
   *
   * @param name The name, but is option.
   * @return Greeting.
   */
  @GetMapping("/hello")
  public HelloResponseDto hello(@RequestParam(required = false) final String name) {
    return helloService.greet(name);
  }

  /**
   * Create a record and saves it in cassandra.
   *
   * @param value Anything.
   * @return The entity.
   */
  @PostMapping("/save")
  public MyEntity add(@RequestParam(required = true) final String value) {
    return someStorage.add(value);
  }

  /**
   * Lists all the entity records.
   *
   * @return
   */
  @GetMapping("/list")
  public List<MyEntity> list() {
    return someStorage.list();
  }

  /**
   * Publishes an event.
   *
   * @param a
   * @param b
   * @param c
   * @return
   */
  @PostMapping("/publish")
  public MyPayload publishEvent(
      @RequestParam(required = true) final String a,
      @RequestParam(required = true) final String b,
      @RequestParam(required = true) final String c) {
    return someEventService.publishEvent(a, b, c);
  }

  /**
   * Gets all the events that have come in.
   *
   * @return
   */
  @GetMapping("/events")
  public List<MyPayload> getEvents() {
    return someEventListener.getPayloads();
  }
}
