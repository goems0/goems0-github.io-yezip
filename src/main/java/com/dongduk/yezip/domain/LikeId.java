package com.dongduk.yezip.domain;

import java.io.Serializable;
import java.util.Objects;

public class LikeId implements Serializable {
    private static final long serialVersionUID = 1L; // serialVersionUID 필드 추가
    
    private int itemId;
    private int uid;

    // 기본 생성자
    public LikeId() {}

    public LikeId(int itemId, int uid) {
        this.itemId = itemId;
        this.uid = uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LikeId)) return false;
        LikeId likeId = (LikeId) o;
        return itemId == likeId.itemId && uid == likeId.uid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, uid);
    }
}

