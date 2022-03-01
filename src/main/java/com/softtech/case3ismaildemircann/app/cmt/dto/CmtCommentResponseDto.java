package com.softtech.case3ismaildemircann.app.cmt.dto;

import lombok.Data;

@Data
public class CmtCommentResponseDto {

    private Long id;
    private Long userId;
    private Long productId;
    private String comment;

}
