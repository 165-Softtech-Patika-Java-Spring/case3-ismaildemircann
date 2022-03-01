package com.softtech.case3ismaildemircann.app.cmt.entity;

import com.softtech.case3ismaildemircann.app.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CMT_COMMENT")
@Getter
@Setter
public class CmtComment extends BaseEntity {

    @Id
    @SequenceGenerator(name = "CmtComment", sequenceName = "CMT_COMMENT_ID_SEQ")
    @GeneratedValue(generator = "CmtComment")
    private Long id;

    @Column(name = "ID_USR_USER", nullable = false)
    private Long userId;

    @Column(name = "ID_PRD_PRODUCT", nullable = false)
    private Long productId;

    @Column(name = "COMMENT", nullable = false)
    private String comment;

}
