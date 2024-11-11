package com.dongduk.yezip.domain;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_like")
@Getter
@Setter
@IdClass(LikeId.class) // Like 클래스를 복합 키 클래스로 설정
public class Like implements Serializable {
    @Id
    private int itemid; // Item의 기본 키

    @Id
    private int uid; // User의 기본 키

}
