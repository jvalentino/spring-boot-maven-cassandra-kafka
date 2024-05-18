package com.valentino.example.repo;

import com.valentino.example.entity.MyEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

/**
 * Example repo for the entity.
 *
 * @author John Valention
 */
@Repository
public interface MyEntityRepository extends CassandraRepository<MyEntity, String> {}
