package com.hems.springbackend.Repositry;

import com.hems.springbackend.Model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo  extends MongoRepository<Post,String> {
}
