package com.dongduk.yezip.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
    @PrimaryKeyJoinColumn(name="uid")
    private int uid;
}
