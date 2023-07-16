package com.hems.springbackend.Controller;

import com.hems.springbackend.Model.Post;
import com.hems.springbackend.Repositry.PostRepo;
import com.hems.springbackend.Repositry.SearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
public class PostController {
        @Autowired
        PostRepo repo;

        @Autowired
        SearchRepo srepo;

        @GetMapping("/allPosts")
        @CrossOrigin
        public List<Post> getAllPosts()
        {
            return repo.findAll();
        }
        // posts/java
        @GetMapping("/posts/{text}")
        @CrossOrigin
        public List<Post> search(@PathVariable String text)
        {
            return srepo.findByText(text);
        }

        @PostMapping("/post")
        @CrossOrigin
        public Post addPost(@RequestBody Post post)
        {
            return repo.save(post);
        }
}
