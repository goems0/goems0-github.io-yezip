package com.dongduk.yezip.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_profile")
@Getter
@Setter
public class Profile implements Serializable {
    private String intro;
    private String image;
    @PrimaryKeyJoinColumn(name="uid")
    private int uid;
}
