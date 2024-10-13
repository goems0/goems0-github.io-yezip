package com.dongduk.yezip.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
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

    @Id
    private int uid;
    
    @MapsId // Cart의 uid가 User의 uid를 참조함
    @OneToOne // User와 1:1 관계
    @JoinColumn(name = "uid") // uid를 외래 키로 사용
    private User user;
}
