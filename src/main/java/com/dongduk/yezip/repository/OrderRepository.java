package com.dongduk.yezip.repository;

import org.springframework.data.repository.CrudRepository;

import com.dongduk.yezip.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    
    // 장바구니 버튼 클릭 (oid 반환), 상세페이지 주문버튼 클릭
    int createOrder(int uid, int itemId, int count);
    
    // 상품 주문
    int createTotalOrder(int uid);
    
    
}
