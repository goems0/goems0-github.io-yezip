package com.dongduk.yezip.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_author")
@Getter
@Setter
public class Author implements Serializable {
    private int type;
    private String career;
    private String insta;

    @Id
    private int uid;
    
    @MapsId // Author의 uid가 User의 uid를 참조함
    @OneToOne // User와 1:1 관계
    @JoinColumn(name = "uid") // uid를 외래 키로 사용
    private User user;
}
