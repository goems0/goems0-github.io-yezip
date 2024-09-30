package com.dongduk.yezip.repository;

import org.springframework.data.repository.CrudRepository;

import com.dongduk.yezip.domain.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer> {

    // 장바구니 생성 
    int createByUidAndOid(int uid, int oid);
    
    // 전체 상품 주문
    int createTotalOrder(int uid);
    
    // 장바구니 상품 삭제
    int deleteByUidAndItemId(int uid, int ItemId);
    
    // 장바구니 비우기
    int deleteByUid(int uid);
}
