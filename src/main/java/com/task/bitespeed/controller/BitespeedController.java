package com.task.bitespeed.controller;

import com.task.bitespeed.Model.BitespeedModel;
import com.task.bitespeed.Repository.BitespeedRepository;
import com.task.bitespeed.Service.BitespeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BitespeedController {
    @Autowired
    private BitespeedRepository repo;
    @Autowired
    private BitespeedService service;
    @PostMapping("/identify")
    public BitespeedModel addData(@RequestBody BitespeedModel bitespeedmodel){
        return repo.save(service.addAllDetails(bitespeedmodel));
    }
    @GetMapping("/identify")
    public List<BitespeedModel> getAllData(){
        return (List<BitespeedModel>) repo.findAll();
    }

    @GetMapping("/emails")
    public void getEmailData(){
        service.getAllEmails();
    }
}
