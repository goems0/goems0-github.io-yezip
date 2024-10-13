package com.dongduk.yezip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

public User createByUidAndOid(int uid, int oid) {
    return userRepository.createByUidAndOid(uid, oid);
}

/**
 * 전체 상품 주문
 */

public User createTotalOrder(int uid) {
    return userRepository.createTotalOrder(uid);
}

/**
 * 장바구니 상품 삭제
 */

public User deleteCartByUidAndItemId(int uid, int itemId) {
    return userRepository.deleteCartByUidAndItemId(uid, itemId);
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

public List<Item> findOrderByLikeDesc() {
    return itemRepository.findOrderByLikeDesc();
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

public List<Item> findByKeyword(String keyword) {
    return itemRepository.findByKeyword(keyword);
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

public int createByUidAndItemId(int uid, int itemId) {
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

/**
 * 회원가입
 */
public int createUser(User user) {
    return userRepository.createUser(user);
}

/**
 * 로그인
 */
public int ConfirmUserIdAndPw(String userId, String pw) {
    return userRepository.confirmUserIdAndPw(userId, pw);
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
public int findByUserIdAndPhoneAndEmail(String name, String phone, String email) {
    return userRepository.findByUserIdAndPhoneAndEmail(name, phone, email);
}

/**
 * 비밀번호 재설정
 */
public int updatePw(String newpw, String checkPw) {
    return userRepository.updatePw(newpw, checkPw);
}

/**
 * 회원정보 수정
 */

public int updateUser(User user) {
    return userRepository.updateUser(user);
}

/**
 * 회원탈퇴
 */
public int deleteUser(User user) {
    return userRepository.deleteUser(user);
}

/**
 * 프로필 설정
 */

public int updateProfile(int uid, Profile profile, Author author) {
    return userRepository.updateProfile(uid, profile, author);
}

}

