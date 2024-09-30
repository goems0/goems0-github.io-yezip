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
@Table(name="tb_item")
@Getter
@Setter
public class Item implements Serializable {
    @Id
    private int itemId;
    private String name;
    private int price;
    private int stock;
    private String uploadDate;
    private int viewCount;
    private String size;
    private String ingredient;
    private String tech;
    private String body;
    @PrimaryKeyJoinColumn(name="cid")
    private int cid;
    private String imageList;
    private String videoList;
}
