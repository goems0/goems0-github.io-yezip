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
@Table(name="tb_totalOrder")
@Getter
@Setter
public class TotalOrder implements Serializable {
    @Id
    private int tid;
    private int oidList;
    private int status;
    @PrimaryKeyJoinColumn(name="uid")
    private int uid;
}
