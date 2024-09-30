package com.dongduk.yezip.repository;

import org.springframework.data.repository.CrudRepository;

import com.dongduk.yezip.domain.Like;

public interface LikeRepository extends CrudRepository<Like, Integer> {
    
    // 좋아요 누름 
    int createByUidAndItemId(int uid, int itemId);
    
    // 좋아요 취소 
    int deleteByUidAndItemId(int uid, int itemId);
}
