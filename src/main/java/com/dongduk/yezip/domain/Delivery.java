package com.dongduk.yezip.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_delivery")
@Getter
@Setter
public class Delivery implements Serializable {
    @Id
    private int did;
    private int status;
    @PrimaryKeyJoinColumn(name="oid")
    private int oid;
    @PrimaryKeyJoinColumn(name="uid")
    private int address;
}
