package com.softtech.case3ismaildemircann.app.prd.dao;

import com.softtech.case3ismaildemircann.app.prd.entity.PrdProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrdProductDao extends JpaRepository<PrdProduct, Long> {
}
