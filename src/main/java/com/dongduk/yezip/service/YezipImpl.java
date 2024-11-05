package com.dongduk.yezip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dongduk.yezip.domain.*;
import com.dongduk.yezip.repository.*;

@Service
@Transactional
public class YezipImpl implements YezipFacade {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CartRepository cartRepository;
    
    


/**
 * 장바구니 생성
 */

    public int createCartByUidAndItemId(int uid, int itemId) {
        return cartRepository.createByUidAndItemId(uid, itemId);
    }

/**
 * 전체 상품 주문
 */

public int createTotalOrder(int uid) {
    return cartRepository.createTotalOrder(uid);
}

/**
 * 장바구니 상품 삭제
 */

public int deleteCartByUidAndItemId(int uid, int itemId) {
    return cartRepository.deleteCartByUidAndItemId(uid, itemId);
}

/**
 * 장바구니 비우기
 */

public int deleteByUid(int uid) {
    return cartRepository.deleteByUid(uid);
}

/**
 * 작품 감상(메인화면 좋아요순)
 */

public List<Item> findItemsOrderByViewCountDesc() {
    return itemRepository.findItemsOrderByViewCountDesc();
}

/**
 * 작품 상세보기
 */

public Item findByItemId(int itemId) {
    return itemRepository.findByItemId(itemId);
}

/**
 * 작품 검색
 */

public List<Item> findByName(String keyword) {
    return itemRepository.findByName(keyword);
}

/**
 * 작품 등록
 */

public int createByUid(int uid) {
    return itemRepository.createByUid(uid);
}

/**
 * 작품 수정
 */

public int updateByUidAndItemId(int uid, int itemId) {
    return itemRepository.updateByUidAndItemId(uid, itemId);
}

/**
 * 작품 삭제
 */

public int deleteByItemId(int itemId) {
    return itemRepository.deleteByItemId(itemId);
}

/**
 * 작가 작품 목록(프로필페이지)
 */

public List<Item> getItemListByUid(int uid) {
    return itemRepository.getItemListByUid(uid);
}

/**
 * 좋아요 누름
 */

public int createLikeByUidAndItemId(int uid, int itemId) {
    return likeRepository.createByUidAndItemId(uid, itemId);
}

/**
 * 좋아요 취소
 */

public int deleteLikeByUidAndItemId(int uid, int itemId) {
    return likeRepository.deleteLikeByUidAndItemId(uid, itemId);
}

/**
 * 좋아요 보관함
 */

public List<Item> getItemLikeListByUid(int uid) {
    return likeRepository.getItemLikeListByUid(uid);
}

/**
 * 장바구니 버튼 클릭 (oid 반환), 상세페이지 주문버튼 클릭
 */

public int createOrder(int uid, int itemId, int count) {
    return orderRepository.createOrder(uid, itemId, count);
}

/**
 * 주문 상세 조회
 */
public TotalOrder getOrderByTid(int tid) {
    return orderRepository.getOrderByTid(tid);
}

/**
 * 주문 목록 조회
 */
public List<TotalOrder> getOrderListByUid(int uid) {
    return orderRepository.getOrderListByUid(uid);
}

//회원가입
public boolean registerUser(User user) {
    try {
           userRepository.save(user);
           return true; // 저장 성공
       } catch (Exception e) {
           // 예외 발생 시 false 반환
           return false;
       }
}

/**
 * 로그인
 */
public User findByUserIdAndPw(String userId, String pw) {
    return userRepository.findByUserIdAndPw(userId, pw);
}

/**
 * 아이디 찾기
 */
public int findByNameAndPhone(String name, String phone) {
    return userRepository.findByNameAndPhone(name, phone);
}

/**
 * 비밀번호 찾기
 */
public int findByUserIdAndNameAndPhone(String userId, String name, String phone) {
    return userRepository.findByUserIdAndNameAndPhone(userId, name, phone);
}

/**
 * 비밀번호 재설정
 */
public int updatePw(String newpw, int uid) {
    return userRepository.updatePw(newpw, uid);
}

/**
 * 회원정보 수정
 */

public int updateUser(String userId, String pw, String name, String phone, String email, int uid) {
    return userRepository.updateUser(userId, pw, name, phone, email, uid);
}


/**
 * 프로필 설정
 */

//public int updateProfile(int uid, Profile profile, Author author) {
//    return userRepository.updateProfile(uid, profile, author);
//}

}
