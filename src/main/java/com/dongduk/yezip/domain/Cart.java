package com.dongduk.yezip.domain;

import java.io.Serializable;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_cart")
@Getter
@Setter
@IdClass(CartId.class)
public class Cart implements Serializable{
	@Id
    private int uid;
	@Id
    private int itemid; // itemId 필드 추가
    private String orderitems;
}
