package com.task.bitespeed.Repository;

import com.task.bitespeed.Model.BitespeedModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BitespeedRepository extends CrudRepository<BitespeedModel, String> {
    List<BitespeedModel> findAllByEmailOrPhoneNumber(String email, String phoneNumber);
}
