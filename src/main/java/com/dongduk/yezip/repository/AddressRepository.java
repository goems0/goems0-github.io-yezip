package com.dongduk.yezip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dongduk.yezip.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
	Address findByUid(int uid);  // uid로 주소 찾기
}
