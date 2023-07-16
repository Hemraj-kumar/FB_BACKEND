package com.hems.springbackend.Repositry;
import com.hems.springbackend.Model.FreeLance;
import com.hems.springbackend.Model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SearchRepo {
    List<Post> findByText(String text);
    List<FreeLance> findBySkills(String text);
}
