

# Spring Boot, Maven, Cassandra, Kafka



## Setting up Local Infrastructure

```
# You need to have docker and docker compose installed

# start the container with cassandra in it
docker compose up -d

# Wait a couple minutes, and run this to create the schema.
docker-compose exec cassandra cqlsh -f /docker-entrypoint-initdb.d/create-keyspace.cql

# reuqires the applicaiton "kafka-topics" and a mac. If on windows do this manually.
# See https://www.conduktor.io/kafka/kafka-topics-cli-tutorial/
./create-topics.sh
```



## Running the App

- Import into your IDE as a Maven project.
  - It requires Java 17 or later
- Run "MainApplication" as a Spring Boot Application
- Using "Maven verify" to validate your code through whatever the maven plugin is
- spring-boot-maven-cassandra-kafka/target/site will have reports on everything, from code coverage (jacoco) to PMD.
- Use http://localhost:8080/swagger-ui/index.html in directly invoke web services
  - /publish: Puts an event on the mytopic Kafka topic
  - /events: List all events that have been put on the mytopic Kafka topic since the app started up
  - /save: Generates a MyEntity record and puts it in the mykeyspace.myentity table
  - /list: List all records in the mykeyspace.myentity table
  - /hello: An example of a standard web service
- Use http://localhost:8080/actuator/health to access the health page



## Command-Line Building

Note that instead of "mvn" you should use the wrapper:

- Mac: ./mvnw.sh
- Windows: mvnw.bat

```
# Just run tests
mvn test

# runs test and check
mvn verify

# run test, run check, build jar, build site
mvn site

# formats the code using spotless
mvn spotless:apply
```





## Troubleshooting Cassandra

```
docker-compose exec cassandra cqlsh

DESCRIBE KEYSPACES;
```

