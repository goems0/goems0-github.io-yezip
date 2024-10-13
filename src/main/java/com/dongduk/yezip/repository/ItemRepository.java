package com.dongduk.yezip.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dongduk.yezip.domain.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {

//    // 작품 감상(메인화면 좋아요순) 
//    List<Item> findOrderByLikeDesc();
//    
//    // 작품 상세보기 
//    Item findByItemId(int itemId);
//    
//    // 작품 검색 
//    List<Item> findByKeyword(String keyword);
//    
//    // 작품 등록 
//    int createByUid(int uid);
//    
//    // 작품 수정 
//    int updateByUidAndItemId(int uid, int itemId);
//    
//    // 작품 삭제 
//    int deleteByItemId(int itemId);
//    
//    // 작가 작품 목록(프로필페이지) 
//    List<Item> getItemListByUid(int uid);
}
