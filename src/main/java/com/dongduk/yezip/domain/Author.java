package com.dongduk.yezip.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private String insta;
    private String career;
    private String intro;
    private String nickname;
    private String school;
    
    @Id
    private int uid; 

    public Author() {}
	public Author(String insta, String career, String intro, String nickname, String school, int uid) {
		super();
		this.insta = insta;
		this.career = career;
		this.intro = intro;
		this.nickname = nickname;
		this.school = school;
		this.uid = uid;
	}
    
    
}
