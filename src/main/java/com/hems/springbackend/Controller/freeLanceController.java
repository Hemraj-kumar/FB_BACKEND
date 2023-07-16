package com.hems.springbackend.Controller;

import com.hems.springbackend.Model.FreeLance;
import com.hems.springbackend.Repositry.SearchRepo;
import com.hems.springbackend.Service.FlanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Freelancer")
public class freeLanceController {
    @Autowired
    FlanceService flp;
    @Autowired
    SearchRepo searchRepo;
    @PostMapping("/saveFreelancer")
    public void saveFLancer(@RequestBody  FreeLance freeLance){
        flp.saveFreeLancer(freeLance);
    }
    @GetMapping("/getFreelancer")
    public ArrayList<FreeLance> getFlancer(){
        return (ArrayList<FreeLance>) flp.showFLP();
    }

    @GetMapping("/search/{text}")
    @CrossOrigin
    public List<FreeLance> search(@PathVariable String text)
    {
        return searchRepo.findBySkills(text);
    }
}
