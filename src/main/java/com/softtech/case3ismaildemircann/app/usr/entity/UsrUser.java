package com.softtech.case3ismaildemircann.app.usr.entity;

import com.softtech.case3ismaildemircann.app.gen.entity.BaseEntity;
import com.softtech.case3ismaildemircann.app.usr.enums.UsrUserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USR_USER")
@Getter
@Setter
public class UsrUser extends BaseEntity {

    @Id
    @SequenceGenerator(name = "UsrUser", sequenceName = "USR_USER_ID_SEQ")
    @GeneratedValue(generator = "UsrUser")
    private Long id;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private Long phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_TYPE", length = 30)
    private UsrUserType userType;

}
