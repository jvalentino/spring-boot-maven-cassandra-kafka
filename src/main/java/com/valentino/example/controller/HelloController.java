package com.valentino.example.controller;

import com.valentino.example.dto.HelloResponseDto;
import com.valentino.example.entity.MyEntity;
import com.valentino.example.service.HelloService;
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
}
