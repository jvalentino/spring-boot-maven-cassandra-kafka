package com.valentino.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The return response for hello.
 *
 * @author John Valentino
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Data
@Builder
public class HelloResponseDto {

  /** The greeting */
  public String greeting;
}
