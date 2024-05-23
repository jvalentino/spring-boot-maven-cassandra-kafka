package com.valentino.util;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

import com.valentino.example.repo.MyEntityRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@EnableAutoConfiguration(
    exclude = {
      SecurityAutoConfiguration.class,
      CassandraDataAutoConfiguration.class,
      CassandraAutoConfiguration.class
    })
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
@AutoConfigureMockMvc(addFilters = false)
public abstract class BaseIntegrationTest {

  @MockBean public MyEntityRepository myEntityRepository;
}
