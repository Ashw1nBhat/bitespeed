package com.task.bitespeed.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

enum link {
    primary,
    secondary
}
@Getter
@Setter
@ToString
@Entity
@Table(name="Contact")
public class BitespeedModel {
    @Id
    private int id;
    private String phoneNumber;
    private String email;
    private int linkedId;
    private link linkPrecedence;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
