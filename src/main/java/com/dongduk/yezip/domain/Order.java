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
@Table(name="tb_order")
@Getter
@Setter
public class Order implements Serializable {
    @Id
    private int oid;
    private String itemId;
    private int count;
    @PrimaryKeyJoinColumn(name="uid")
    private int uid;
}
