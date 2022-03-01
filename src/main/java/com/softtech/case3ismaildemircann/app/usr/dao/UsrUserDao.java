package com.softtech.case3ismaildemircann.app.usr.dao;

import com.softtech.case3ismaildemircann.app.usr.entity.UsrUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsrUserDao extends JpaRepository<UsrUser, Long> {

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Boolean existsByPhoneNumber(Long phoneNumber);

    UsrUser findByUsername(String username);

    UsrUser findByUsernameAndPhoneNumber(String username, Long phoneNumber);

}
