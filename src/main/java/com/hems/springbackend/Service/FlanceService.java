package com.hems.springbackend.Service;

import com.hems.springbackend.Model.FreeLance;
import com.hems.springbackend.Model.Post;
import com.hems.springbackend.Repositry.FLanceRepo;
import com.hems.springbackend.Repositry.SearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlanceService {
    @Autowired
    FLanceRepo repo;
    public void saveFreeLancer(FreeLance freeLance){
        repo.save(freeLance);
    }
    public ArrayList<FreeLance> showFLP(){
        return (ArrayList<FreeLance>)repo.findAll();
    }
}
