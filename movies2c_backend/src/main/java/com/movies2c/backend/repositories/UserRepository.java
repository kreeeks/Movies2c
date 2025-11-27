package com.movies2c.backend.repositories;

import com.movies2c.backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findById(String id);
}
