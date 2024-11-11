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
    @Autowired
    private AuthorRepository authorRepository;
    
    


/**
 * 장바구니 생성
 */

    public int createCartByUidAndItemid(int uid, int itemid) {
        return cartRepository.createByUidAndItemid(uid, itemid);
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

public int deleteCartByUidAndItemid(int uid, int itemid) {
    return cartRepository.deleteCartByUidAndItemid(uid, itemid);
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

public Item findByItemid(int itemid) {
    return itemRepository.findByItemid(itemid);
}

/**
 * 작품 검색
 */

public List<Item> findByTitle(String keyword) {
    return itemRepository.findByTitle(keyword);
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

public int updateByUidAndItemid(int uid, int itemid) {
    return itemRepository.updateByUidAndItemid(uid, itemid);
}

/**
 * 작품 삭제
 */

public int deleteByItemid(int itemid) {
    return itemRepository.deleteByItemid(itemid);
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

public int createLikeByUidAndItemid(int uid, int itemid) {
    return likeRepository.createByUidAndItemid(uid, itemid);
}

/**
 * 좋아요 취소
 */

public int deleteLikeByUidAndItemid(int uid, int itemid) {
    return likeRepository.deleteLikeByUidAndItemid(uid, itemid);
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

public int createOrder(int uid, int itemid, int count) {
    return orderRepository.createOrder(uid, itemid, count);
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

	//userid로 uid 찾기
	public User findByUserid(String userid) {
		return userRepository.findByUserid(userid);
	}
	
	// uid로 user 찾기
    public User findByUid(int uid) {
    	return userRepository.findByUid(uid);
    }
	
//회원가입
	@Transactional(rollbackFor = Exception.class)
public boolean registerUser(User user) {
	 try {
	        userRepository.save(user);
	        return true; // 저장 성공
	    } catch (Exception e) {
	        // 예외 발생 시 false 반환
	        return false;
	    }
}

// id 중복확인
public boolean isIdDuplicate(String userid) {
    return userRepository.existsByUserid(userid);
}

/**
 * 로그인
 */
public User findByUseridAndPw(String userid, String pw) {
    return userRepository.findByUseridAndPw(userid, pw);
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
public int findByUseridAndNameAndPhone(String userid, String name, String phone) {
    return userRepository.findByUseridAndNameAndPhone(userid, name, phone);
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

public int updateUser(String userid, String pw, String name, String phone, String email, int uid) {
    return userRepository.updateUser(userid, pw, name, phone, email, uid);
}

// 작가 신청
@Transactional(rollbackFor = Exception.class)
public boolean registerAuthor(Author author) {
    try {
        authorRepository.save(author);
        return true;
    } catch (Exception e) {
        // 예외 발생 시 롤백 처리
        // 로깅 추가 (필요시)
        System.out.println("Error occurred while registering author: "+ e);
        
        // 예외를 던져서 트랜잭션이 롤백되도록 함
        throw new RuntimeException("Failed to register author", e);
    }
}

//uid로 author 찾기
	public Author findAuthorByUid(int uid) {
		return authorRepository.findAuthorByUid(uid);
	}

/**
 * 프로필 설정
 */

//public int updateProfile(int uid, Profile profile, Author author) {
//    return userRepository.updateProfile(uid, profile, author);
//}

}
