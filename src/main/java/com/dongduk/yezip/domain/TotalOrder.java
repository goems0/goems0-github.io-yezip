package com.dongduk.yezip.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_total_order")
@Getter
@Setter
public class TotalOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "totalorder_seq")
    @SequenceGenerator(name = "totalorder_seq", sequenceName = "TOTALORDER_SEQ", allocationSize = 1)
    private int tid;
    private int oidlist;
    private int status;
    private int transport;
    private int uid;
    
}
