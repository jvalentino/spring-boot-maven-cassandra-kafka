package com.valentino.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.valentino.util.BaseIntegrationTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
public class HelloControllerIntgTest extends BaseIntegrationTest {

  /** Spring MVC Test framework * */
  @Autowired private MockMvc mockMvc;

  /** Test: Testing all tiers * */
  @SneakyThrows
  @Test
  public void helloAllTiersSuccess() {

    // when
    MvcResult mvcResult =
        mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk()).andReturn();

    // assert that there are no records (because this is H2)
    assertEquals("{\"greeting\":\"Hello\"}", mvcResult.getResponse().getContentAsString());
  }
}
