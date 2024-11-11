package com.dongduk.yezip.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dongduk.yezip.domain.*;

import jakarta.transaction.Transactional;

public interface CartRepository extends CrudRepository<Cart, CartId> {

	// 장바구니 생성 
    @Modifying
    @Transactional
    @Query("INSERT INTO Cart (uid, itemid) VALUES (?1, ?2)")
    int createByUidAndItemid(int uid, int itemid);
    
    // 전체 상품 주문
    @Modifying
    @Transactional
    @Query("INSERT INTO TotalOrder (uid) VALUES (?1)")
    int createTotalOrder(int uid);
    
    // 장바구니 상품 삭제
    @Modifying
    @Transactional
    @Query("DELETE FROM Cart c WHERE c.uid = ?1 AND c.itemid = ?2")
    int deleteCartByUidAndItemid(int uid, int itemid);
    
    // 장바구니 비우기
    @Modifying
    @Transactional
    @Query("DELETE FROM Cart c WHERE c.uid = ?1")
    int deleteByUid(int uid);

}
