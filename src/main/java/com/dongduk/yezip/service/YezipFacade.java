package com.dongduk.yezip.service;

import java.util.List;

import com.dongduk.yezip.domain.Author;
import com.dongduk.yezip.domain.Item;
import com.dongduk.yezip.domain.Profile;
import com.dongduk.yezip.domain.TotalOrder;
import com.dongduk.yezip.domain.User;


public interface YezipFacade {
	// 장바구니 생성 
	int createCartByUidAndItemId(int uid, int oid);
	
	// 전체 상품 주문
	int createTotalOrder(int uid);
	
	// 장바구니 상품 삭제
	int deleteCartByUidAndItemId(int uid, int ItemId);
	
	// 장바구니 비우기
    int deleteByUid(int uid);
    
 // 작품 감상(메인화면 좋아요순) 
    List<Item> findItemsOrderByViewCountDesc();
    
    // 작품 상세보기 
    Item findByItemId(int itemId);
    
    // 작품 검색 
    List<Item> findByName(String keyword);
    
    // 작품 등록 
    int createByUid(int uid);
    
    // 작품 수정 
    int updateByUidAndItemId(int uid, int itemId);
    
    // 작품 삭제 
    int deleteByItemId(int itemId);
    
    // 작가 작품 목록(프로필페이지) 
    List<Item> getItemListByUid(int uid);
    
    // 좋아요 누름 
    int createLikeByUidAndItemId(int uid, int itemId);
    
    // 좋아요 취소 
    int deleteLikeByUidAndItemId(int uid, int itemId);
    
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
	//회원가입
    boolean registerUser(User user);
 // 로그인
    User findByUserIdAndPw(String userId, String pw);
    
    // 아이디 찾기
    int findByNameAndPhone(String name, String phone);
    
    // 비밀번호 찾기
    int findByUserIdAndNameAndPhone(String userId, String name, String phone);
    
    // 비밀번호 재설정
    int updatePw(String newpw, int uid);
    // 로그아웃
    
    // 회원정보 수정
    int updateUser(String userId, String pw, String name, String phone, String email, int uid);

    
    // 프로필 설정
//    int updateProfile(int uid, Profile profile, Author author);
	
	
}
