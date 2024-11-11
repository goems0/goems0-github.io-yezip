package com.dongduk.yezip.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "CUSTOMER_SEQ", allocationSize = 1)
    private int uid;
    private String userid;
    private String pw;
    private String name;
    private String phone;
    private String email;
    

 // 기본 생성자 (매개변수 없음)
    public User() {
    }
    
	public User(String userid, String pw, String name, String phone, String email) {
		super();
		this.userid = userid;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

public User(String userid, String pw) {
	super();
	this.userid = userid;
	this.pw = pw;
}
    
    
    
}
