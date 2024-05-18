package com.valentino.example.entity;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * Example cassandra table.
 *
 * @author John Valentino
 */
@Table
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class MyEntity {

  /** The ID */
  @PrimaryKey private UUID id;

  /** Any vale */
  private String value;
}
