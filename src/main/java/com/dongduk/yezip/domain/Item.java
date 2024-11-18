package com.dongduk.yezip.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_item")
@Getter
@Setter
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
    @SequenceGenerator(name = "item_seq", sequenceName = "ITEM_SEQ", allocationSize = 1)
    private int itemid;
    private String title;
    private String size;
    private String material;
    private String tech;
    private String productiondate;
    private int price;
    private int stock;
    private String uploaddate;
    private int viewcount;
    private String body;
    private String cidlist;
    private int uid;
}
