package com.datn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datn.model.dto.RegularPassSub;

@Repository
public interface RegularPassSubRepository extends JpaRepository<RegularPassSub, Long>{
}
