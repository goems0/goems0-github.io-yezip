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
    @Query("INSERT INTO Like (uid, itemid) VALUES (?1, ?2)")
    int createByUidAndItemid(int uid, int itemid);
    
    // 좋아요 취소 
    @Modifying
    @Transactional
    @Query("DELETE FROM Like l WHERE l.uid = ?1 AND l.itemid = ?2")
    int deleteLikeByUidAndItemid(int uid, int itemid);
    
    // 좋아요 보관함
    @Query("SELECT i FROM Item i JOIN Like l ON i.id = l.itemid WHERE l.uid = ?1")
    List<Item> getItemLikeListByUid(int uid);
}
