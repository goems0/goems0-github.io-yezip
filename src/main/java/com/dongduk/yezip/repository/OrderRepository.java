package com.dongduk.yezip.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dongduk.yezip.domain.Order;
import com.dongduk.yezip.domain.TotalOrder;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    
//    // 장바구니 버튼 클릭 (oid 반환), 상세페이지 주문버튼 클릭
//    int createOrder(int uid, int itemId, int count);
//    
//    // 상품 주문
//    int createTotalOrder(int uid);
//    
//    // 주문 상세 조회
//    TotalOrder getOrderByTid(int tid);
//    
//    // 주문 목록 조회
//    List<TotalOrder> getOrderListByUid(int uid);
}
