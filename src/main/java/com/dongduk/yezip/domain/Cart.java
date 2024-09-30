package com.dongduk.yezip.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_cart")
@Getter
@Setter
public class Cart implements Serializable{
    private String orderItems;
    @PrimaryKeyJoinColumn(name="uid")
    private int uid;
}
