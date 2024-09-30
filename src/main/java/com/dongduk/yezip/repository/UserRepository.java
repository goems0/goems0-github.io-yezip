package com.dongduk.yezip.repository;

import org.springframework.data.repository.CrudRepository;

import com.dongduk.yezip.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    // 회원가입
    int createUser(User user);
    
    // 로그인
    int ConfirmUserIdAndPw(String userId, String pw);
    
    // 아이디 찾기
    int findByNameAndPhone(String name, String phone);
    
    // 비밀번호 찾기
    int findByUserIdAndPhoneAndEmail(String name, String phone, String email);
    
    // 비밀번호 재설정
    
    // 로그아웃
    
    // 회원정보 수정
    
    // 회원탈퇴
    
    // 프로필 설정
    
    //
}
