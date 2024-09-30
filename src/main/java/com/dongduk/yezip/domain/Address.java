package com.dongduk.yezip.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
    @PrimaryKeyJoinColumn(name="uid")
    private int uid;
}
