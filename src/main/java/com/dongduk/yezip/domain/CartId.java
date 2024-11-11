package com.dongduk.yezip.domain;

import java.io.Serializable;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class CartId implements Serializable {
	private static final long serialVersionUID = 1L; // serialVersionUID 추가
	
    private int uid;
    private int itemid;
}
