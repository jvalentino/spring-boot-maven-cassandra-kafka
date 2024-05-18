package com.valentino.example.service;

import com.valentino.example.entity.MyEntity;
import com.valentino.example.repo.MyEntityRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** Used for demonstrating interacting with Cassandra. */
@Service
public class SomeStorageService {

  /** The repository */
  @Autowired private MyEntityRepository myEntityRepo;

  /**
   * Adds a new entity to the db.
   *
   * @param value
   * @return
   */
  public MyEntity add(final String value) {
    final MyEntity entity = MyEntity.builder().id(UUID.randomUUID()).value(value).build();
    myEntityRepo.save(entity);
    return entity;
  }

  /**
   * Returns all records in the db.
   *
   * @return
   */
  public List<MyEntity> list() {
    return myEntityRepo.findAll();
  }
}
