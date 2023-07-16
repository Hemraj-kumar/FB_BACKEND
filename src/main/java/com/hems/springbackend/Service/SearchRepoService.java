package com.hems.springbackend.Service;

import com.hems.springbackend.Model.FreeLance;
import com.hems.springbackend.Model.Post;
import com.hems.springbackend.Repositry.SearchRepo;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SearchRepoService implements SearchRepo {

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Post> findByText(String text) {

        final List<Post> posts = new ArrayList<>();

        MongoDatabase database = client.getDatabase("jobCluster");
        MongoCollection<Document> collection = database.getCollection("JobPost");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("techs", "desc", "profile")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 5L)));

        result.forEach(doc -> posts.add(converter.read(Post.class,doc)));

        return posts;
    }

    @Override
    public List<FreeLance> findBySkills(String text) {
        final List<FreeLance> posts = new ArrayList<>();

        MongoDatabase database = client.getDatabase("jobCluster");
        MongoCollection<Document> collection = database.getCollection("freelance");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("Skills", "Role")))),
                new Document("$sort", new Document("$limit", 5L))));

        result.forEach(doc -> posts.add(converter.read(FreeLance.class,doc)));

        return posts;
    }
}
