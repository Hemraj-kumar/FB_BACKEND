package com.hems.springbackend.Model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "JobListing")
@Data
public class Post {
    @Id
    private Integer post_id;
    private String profile;
    private String desc;
    private int exp;
    private String[] techs;
}