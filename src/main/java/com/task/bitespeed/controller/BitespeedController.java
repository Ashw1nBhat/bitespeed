package com.task.bitespeed.controller;

import com.task.bitespeed.Model.BitespeedModel;
import com.task.bitespeed.Repository.BitespeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BitespeedController {
    @Autowired
    private BitespeedRepository repo;
    @PostMapping("/identify")
    public BitespeedModel addData(@RequestBody BitespeedModel bitespeedmodel){
        return repo.save(bitespeedmodel);
    }
    @GetMapping("/")
    public String test(){
        return "The api Endpoint is working";
    }
}
