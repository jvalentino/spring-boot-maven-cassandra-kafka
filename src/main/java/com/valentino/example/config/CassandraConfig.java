package com.valentino.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

/**
 * Config for cassandra
 *
 * @author john valentino
 */
@Configuration
@EnableCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {

  @Override
  protected String getKeyspaceName() {
    return "mykeyspace";
  }
}
