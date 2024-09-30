package com.dongduk.yezip.domain;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@SuppressWarnings("serial")
@Entity
@Table(name="tb_user")
@Getter
@Setter
public class User implements Serializable{
    @Id
    private int uid;
    private String userId;
    private String pw;
    private String name;
    private String phone;
    private String email;
    private String nickname;
    
    @Embedded
    private Address address;
    
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name="uid")
    private Profile profile;
    
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name="uid")
    private Author author;
}
