package com.softtech.case3ismaildemircann.app.cmt.dao;

import com.softtech.case3ismaildemircann.app.cmt.entity.CmtComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CmtCommentDao extends JpaRepository<CmtComment, Long> {

    List<CmtComment> findAllByUserId(Long userId);

    List<CmtComment> findAllByProductId(Long productId);

    void deleteAllByUserId(Long userId);

    void deleteAllByProductId(Long productId);

}
