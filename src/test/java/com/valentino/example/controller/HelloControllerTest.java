package com.valentino.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.valentino.example.dto.HelloResponseDto;
import com.valentino.example.service.HelloService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HelloControllerTest {

  @Mock private HelloService helloService;

  @InjectMocks private HelloController subject;

  @Test
  public void testGreeting() {
    // given
    final HelloResponseDto mockedResponse =
        HelloResponseDto.builder().greeting("Whatever I want").build();
    Mockito.when(helloService.greet("Bravo")).thenReturn(mockedResponse);

    // when
    final HelloResponseDto result = subject.hello("Bravo");

    // then
    assertEquals("Whatever I want", result.getGreeting());
  }
}
