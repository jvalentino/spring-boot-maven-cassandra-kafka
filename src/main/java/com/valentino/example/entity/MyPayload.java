package com.valentino.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an example payload for a Kafka event.
 *
 * @author John Valentino
 */
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class MyPayload {

  /** The ID */
  private String id;
  /** The first field */
  private String a;
  /** The second field */
  private String b;
  /** The third field */
  private String c;
}
