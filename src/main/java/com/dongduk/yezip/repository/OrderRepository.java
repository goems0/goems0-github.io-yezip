package com.dongduk.yezip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dongduk.yezip.domain.Order;
import com.dongduk.yezip.domain.TotalOrder;

import jakarta.transaction.Transactional;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    
	// 장바구니 버튼 클릭 (oid 반환), 상세페이지 주문버튼 클릭
    @Modifying
    @Transactional
    @Query("INSERT INTO Order (uid, itemId, count) VALUES (?1, ?2, ?3)")
    int createOrder(int uid, int itemId, int count);
    
    // 상품 주문
    @Modifying
    @Transactional
    @Query("INSERT INTO TotalOrder (uid) SELECT ?1")
    int createTotalOrder(int uid);
    
    // 주문 상세 조회
    @Query("SELECT o FROM TotalOrder o WHERE o.tid = ?1")
    TotalOrder getOrderByTid(int tid);
    
    // 주문 목록 조회
    @Query("SELECT o FROM TotalOrder o WHERE o.uid = ?1")
    List<TotalOrder> getOrderListByUid(int uid);
}
