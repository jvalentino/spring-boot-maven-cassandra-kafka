

Spring Boot, Maven, Cassandra, Kafka



```
# Just run tests
mvn test

# runs test and check
mvn verify

# run test, run check, build jar, build site
mvn site

# start the container with cassandra in it
docker compose up -d

# Wait a couple minutes, and run this to create the schema.
docker-compose exec cassandra cqlsh -f /docker-entrypoint-initdb.d/create-keyspace.cql


```





Validation Cassandra

```
docker-compose exec cassandra cqlsh

DESCRIBE KEYSPACES;
```

