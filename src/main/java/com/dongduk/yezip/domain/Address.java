package com.dongduk.yezip.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_address")
@Getter
@Setter
public class Address implements Serializable {
    private String city;
    private String street;
    private String zipcode;
    private String extra;
    @Id
    private int uid;
    
    public Address() {}
	public Address(String city, String street, String zipcode, String extra, int uid) {
		super();
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
		this.extra = extra;
		this.uid = uid;
	}
    
    
}
