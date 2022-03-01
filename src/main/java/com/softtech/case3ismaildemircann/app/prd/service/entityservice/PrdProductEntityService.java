package com.softtech.case3ismaildemircann.app.prd.service.entityservice;

import com.softtech.case3ismaildemircann.app.gen.service.BaseEntityService;
import com.softtech.case3ismaildemircann.app.prd.dao.PrdProductDao;
import com.softtech.case3ismaildemircann.app.prd.entity.PrdProduct;
import org.springframework.stereotype.Service;

@Service
public class PrdProductEntityService extends BaseEntityService<PrdProduct, PrdProductDao> {

    public PrdProductEntityService(PrdProductDao dao) {
        super(dao);
    }

    public void deleteById(Long productId) {
        getDao().deleteById(productId);
    }

}
