package com.dongduk.yezip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dongduk.yezip.domain.Like;
import com.dongduk.yezip.domain.LikeId;

import jakarta.transaction.Transactional;

import com.dongduk.yezip.domain.Item;

public interface LikeRepository extends CrudRepository<Like, LikeId> {

	// 좋아요 누름 
    @Modifying
    @Transactional
    @Query("INSERT INTO Like (uid, itemId) VALUES (?1, ?2)")
    int createByUidAndItemId(int uid, int itemId);
    
    // 좋아요 취소 
    @Modifying
    @Transactional
    @Query("DELETE FROM Like l WHERE l.uid = ?1 AND l.itemId = ?2")
    int deleteLikeByUidAndItemId(int uid, int itemId);
    
    // 좋아요 보관함
    @Query("SELECT i FROM Item i JOIN Like l ON i.id = l.itemId WHERE l.uid = ?1")
    List<Item> getItemLikeListByUid(int uid);
}
