package com.dongduk.yezip.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
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
    
    private int uid;
    
    @ManyToOne
    @MapsId  // TotalOrder의 uid가 User의 uid를 참조함
    @JoinColumn(name = "uid", insertable = false, updatable = false) // uid를 외래 키로 사용
    private User user;
}
