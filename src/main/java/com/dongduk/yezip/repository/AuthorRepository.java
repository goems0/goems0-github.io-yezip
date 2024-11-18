package com.dongduk.yezip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dongduk.yezip.domain.*;

import jakarta.transaction.Transactional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
	// uid로 author 찾기
	Author findAuthorByUid(int uid);
	
	// 프로필 설정
	@Modifying
    @Transactional
    @Query("UPDATE Author a SET a.insta = :insta, a.intro = :intro, a.nickname = :nickname, " +
           "a.school = :school, a.career = :career WHERE a.uid = :uid")
    int updateProfile(String insta, String intro, String nickname, String school, String career, int uid);
}
