package com.dongduk.yezip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dongduk.yezip.domain.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {
	// userid로 user 찾기
    User findByUserid(@Param("userid") String userid);
	
    // uid로 user 찾기
    User findByUid(int uid);
    
    // id 중복확인
	boolean existsByUserid(String userid);
    
    // 로그인
    User findByUseridAndPw(String userId, String pw);
    
    // 아이디 찾기
    int findByNameAndPhone(String name, String phone);
    
    // 비밀번호 찾기
    int findByUseridAndNameAndPhone(String userid, String name, String phone);
    
 // 비밀번호 재설정
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.pw = ?1 WHERE u.uid = ?2")
    int updatePw(String newpw, int uid);
    
    // 회원정보 수정
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.userid = ?1, u.pw = ?2, u.name = ?3, u.phone = ?4, u.email = ?5 WHERE u.uid = ?6")
    int updateUser(String userid, String pw, String name, String phone, String email, int uid);
    
    // 프로필 설정
//    int updateProfile(int uid, Profile profile, Author author);
    
}
