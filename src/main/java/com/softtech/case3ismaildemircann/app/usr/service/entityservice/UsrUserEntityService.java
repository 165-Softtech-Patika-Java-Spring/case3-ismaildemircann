package com.softtech.case3ismaildemircann.app.usr.service.entityservice;

import com.softtech.case3ismaildemircann.app.gen.service.BaseEntityService;
import com.softtech.case3ismaildemircann.app.usr.dao.UsrUserDao;
import com.softtech.case3ismaildemircann.app.usr.entity.UsrUser;
import org.springframework.stereotype.Service;

@Service
public class UsrUserEntityService extends BaseEntityService<UsrUser, UsrUserDao> {

    public UsrUserEntityService(UsrUserDao dao) {
        super(dao);
    }

    public Boolean existsByUsername(String username) {
        return getDao().existsByUsername(username);
    }

    public Boolean existsByEmail(String email){
        return getDao().existsByEmail(email);
    }

    public Boolean existsByPhoneNumber(Long phoneNumber){
        return getDao().existsByPhoneNumber(phoneNumber);
    }

    public UsrUser findByUsername(String username) {
        return getDao().findByUsername(username);
    }

    public UsrUser findByUsernameAndPhoneNumber(String username, Long phoneNumber) {
        return getDao().findByUsernameAndPhoneNumber(username, phoneNumber);
    }
}
