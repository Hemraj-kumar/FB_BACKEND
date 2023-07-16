package com.hems.springbackend.Repositry;

import com.hems.springbackend.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, Integer> {
    User findByUsername(String username);
}
