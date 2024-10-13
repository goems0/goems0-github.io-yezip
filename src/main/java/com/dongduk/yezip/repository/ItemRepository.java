package com.dongduk.yezip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dongduk.yezip.domain.Item;

import jakarta.transaction.Transactional;

public interface ItemRepository extends CrudRepository<Item, Integer> {

	// 작품 감상(메인화면 좋아요순) 
	@Query("SELECT i FROM Item i ORDER BY i.viewCount DESC")
	List<Item> findItemsOrderByViewCountDesc();
    
    // 작품 상세보기 
    Item findByItemId(int itemId);
    
    // 작품 검색 
    List<Item> findByName(String keyword);
    
    // 작품 등록 
    @Modifying
    @Transactional
    @Query("INSERT INTO Item (uid) VALUES (?1)")
    int createByUid(int uid);
    
    // 작품 수정 
    @Modifying
    @Transactional
    @Query("UPDATE Item i SET i.uid = ?1 WHERE i.id = ?2")
    int updateByUidAndItemId(int uid, int itemId);
    
    // 작품 삭제 
    @Modifying
    @Transactional
    @Query("DELETE FROM Item i WHERE i.id = ?1")
    int deleteByItemId(int itemId);
    
    // 작가 작품 목록(프로필페이지) 
    List<Item> getItemListByUid(int uid);
}
