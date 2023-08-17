package com.task.bitespeed.Service;

import com.task.bitespeed.Model.BitespeedContact;
import com.task.bitespeed.Model.BitespeedModel;
import com.task.bitespeed.Model.link;
import com.task.bitespeed.Repository.BitespeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BitespeedService {
    @Autowired
    private BitespeedRepository repo;
    @Autowired
    private BitespeedContact contact;
    public BitespeedModel addAllDetails(BitespeedModel bsm){
        List<BitespeedModel> matchingEmailsOrPhone = repo.findAllByEmailOrPhoneNumber(bsm.getEmail(), bsm.getPhoneNumber());
        for(BitespeedModel b : matchingEmailsOrPhone){
            System.out.print(b.getEmail() + " " + b.getPhoneNumber());
        }
        if(matchingEmailsOrPhone.isEmpty()){
            bsm.setLinkPrecedence("primary");
            bsm.setCreatedAt(LocalDateTime.now());
            bsm.setUpdatedAt(LocalDateTime.now());
            bsm.setLinkedId(-1);
        }
        else {
            bsm.setLinkPrecedence("secondary");
            bsm.setCreatedAt(LocalDateTime.now());
            bsm.setUpdatedAt(LocalDateTime.now());
            bsm.setLinkedId(matchingEmailsOrPhone.get(0).getId());
        }
        return bsm;
    }

    public List<BitespeedModel> returnSimilarContact(String email){
        List<BitespeedModel> bm = repo.findAllByEmailOrPhoneNumber(email, null);
        return bm;
    }
    public void getAllEmails(){
        List<BitespeedModel> ans = (List<BitespeedModel>) repo.findAll();
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i).getEmail());
        }
    }
}
