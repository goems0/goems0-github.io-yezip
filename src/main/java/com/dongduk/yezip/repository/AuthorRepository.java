package com.dongduk.yezip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dongduk.yezip.domain.*;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
	// uid로 author 찾기
	Author findAuthorByUid(int uid);
	
}
