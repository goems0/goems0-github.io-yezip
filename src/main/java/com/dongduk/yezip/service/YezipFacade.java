package com.dongduk.yezip.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.dongduk.yezip.domain.*;


public interface YezipFacade {
	// 장바구니 생성 
	int createCartByUidAndItemid(int uid, int oid);
	
	// 전체 상품 주문
	int createTotalOrder(int uid);
	
	// 장바구니 상품 삭제
	int deleteCartByUidAndItemid(int uid, int ItemId);
	
	// 장바구니 비우기
    int deleteByUid(int uid);
    
 // 작품 감상(메인화면 좋아요순) 
    List<Item> findItemsOrderByViewCountDesc();
    
    // 작품 상세보기 
    Item findByItemid(int itemid);
    
    // 작품 검색(제목, 본문)
    List<Item> findByTitleContainingOrBodyContaining(String keyword1, String keyword2);
    
    // 작품 등록 
    int createByUid(int uid);
    
    // 작품 수정 
    int updateByUidAndItemid(int uid, int itemid);
    
    // 작품 삭제 
    int deleteByItemid(int itemid);
    
    // 작가 작품 목록(프로필페이지) 
    List<Item> getItemListByUid(int uid);
    
    // 좋아요 누름 
    int createLikeByUidAndItemid(int uid, int itemid);
    
    // 좋아요 취소 
    int deleteLikeByUidAndItemid(int uid, int itemid);
    
    // 좋아요 보관함
    List<Item> getItemLikeListByUid(int uid);
	
    // 장바구니 버튼 클릭 (oid 반환), 상세페이지 주문버튼 클릭
    int createOrder(int uid, int itemId, int count);
    
    // 상품 주문
//    int createTotalOrder(int uid);
    
    // 주문 상세 조회
    TotalOrder getOrderByTid(int tid);
    
    // 주문 목록 조회
    List<TotalOrder> getOrderListByUid(int uid);
    
 // userid로 uid 찾기
    User findByUserid(@Param("userid") String userid);
    
 // uid로 user 찾기
    User findByUid(int uid);
 	
	//회원가입
    boolean registerUser(User user);
    
    // id 중복확인
    boolean isIdDuplicate(String userid);
    
 // 로그인
    User findByUseridAndPw(String userid, String pw);
    
    // 아이디 찾기
    int findByNameAndPhone(String name, String phone);
    
    // 비밀번호 찾기
    int findByUseridAndNameAndPhone(String userid, String name, String phone);
    
    // 비밀번호 재설정
    int updatePw(String newpw, int uid);
    // 로그아웃
    
    // 회원정보 수정
    int updateUser(String userid, String pw, String name, String phone, String email, int uid);

    // 작가 신청
    boolean registerAuthor(Author author);
    
 // uid로 author 찾기
 	Author findAuthorByUid(int uid);
 	
    // 프로필 설정
//    int updateProfile(int uid, Profile profile, Author author);
	
 	// uid로 주소 찾기
 	Address findAddressByUid(int uid);
 	
 	// 주소 정보 업데이트
 	boolean updateAddress(Address address);
 	
}
