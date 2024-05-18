package com.valentino.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.valentino.example.dto.HelloResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HelloServiceTest {

  @InjectMocks private HelloService subject;

  @Test
  public void testGreeting() {
    // given
    final String name = "John";

    // when
    final HelloResponseDto result = subject.greet(name);

    // then
    assertEquals("Hello John!", result.getGreeting());
  }

  @Test
  public void testGreetingWithNoName() {
    // given
    final String name = null;

    // when
    final HelloResponseDto result = subject.greet(name);

    // then
    assertEquals("Hello", result.getGreeting());
  }
}
