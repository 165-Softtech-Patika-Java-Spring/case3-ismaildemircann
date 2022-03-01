package com.softtech.case3ismaildemircann.app.cmt.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CmtCommentSaveRequestDto {

    @NotNull
    private Long userId;

    @NotNull
    private Long productId;

    @NotNull
    private String comment;

}
