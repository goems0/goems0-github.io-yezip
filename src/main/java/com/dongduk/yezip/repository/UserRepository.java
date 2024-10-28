package com.dongduk.yezip.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dongduk.yezip.domain.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends CrudRepository<User, Integer> {

    // 회원가입
//    User save(User user);
    
    // 로그인
    User findByUserIdAndPw(String userId, String pw);
    
    // 아이디 찾기
    int findByNameAndPhone(String name, String phone);
    
    // 비밀번호 찾기
    int findByUserIdAndNameAndPhone(String userId, String name, String phone);
    
 // 비밀번호 재설정
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.pw = ?1 WHERE u.uid = ?2")
    int updatePw(String newpw, int uid);
    
    // 회원정보 수정
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.userId = ?1, u.pw = ?2, u.name = ?3, u.phone = ?4, u.email = ?5 WHERE u.uid = ?6")
    int updateUser(String userId, String pw, String name, String phone, String email, int uid);
    
    // 프로필 설정
//    int updateProfile(int uid, Profile profile, Author author);
    
    
}
