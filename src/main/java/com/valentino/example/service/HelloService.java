package com.valentino.example.service;

import com.valentino.example.dto.HelloResponseDto;
import org.springframework.stereotype.Service;

/**
 * Example service.
 *
 * @author John Valentino
 */
@Service
public class HelloService {

  /**
   * If no name is given, just says hello. Otherwise it returns Hello name.
   *
   * @param name The given name.
   * @return The greeting.
   */
  public HelloResponseDto greet(final String name) {
    String greeting = "Hello";
    if (name != null) {
      greeting = "Hello " + name + "!";
    }
    return HelloResponseDto.builder().greeting(greeting).build();
  }
}
