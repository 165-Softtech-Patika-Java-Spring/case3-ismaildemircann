package com.softtech.case3ismaildemircann.app.cmt.service.entityservice;

import com.softtech.case3ismaildemircann.app.cmt.dao.CmtCommentDao;
import com.softtech.case3ismaildemircann.app.cmt.entity.CmtComment;
import com.softtech.case3ismaildemircann.app.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmtCommentEntityService extends BaseEntityService<CmtComment, CmtCommentDao> {

    public CmtCommentEntityService(CmtCommentDao dao) {
        super(dao);
    }

    public List<CmtComment> findAllByUserId(Long userId) {

        return getDao().findAllByUserId(userId);
    }

    public List<CmtComment> findAllByProductId(Long productId) {

        return getDao().findAllByProductId(productId);
    }

    public void deleteById(Long commentId) {

        getDao().deleteById(commentId);
    }

    public void deleteAllByUserId(Long userId) {

        getDao().deleteAllByUserId(userId);
    }

    public void deleteAllByProductId(Long productId) {

        getDao().deleteAllByProductId(productId);
    }

}
