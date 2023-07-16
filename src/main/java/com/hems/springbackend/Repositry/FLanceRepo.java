package com.hems.springbackend.Repositry;

import com.hems.springbackend.Model.FreeLance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FLanceRepo extends MongoRepository<FreeLance, String> {
}
