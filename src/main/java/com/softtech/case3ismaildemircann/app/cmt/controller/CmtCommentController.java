package com.softtech.case3ismaildemircann.app.cmt.controller;

import com.softtech.case3ismaildemircann.app.cmt.dto.CmtCommentResponseDto;
import com.softtech.case3ismaildemircann.app.cmt.dto.CmtCommentSaveRequestDto;
import com.softtech.case3ismaildemircann.app.cmt.service.CmtCommentService;
import com.softtech.case3ismaildemircann.app.gen.dto.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CmtCommentController {

    private final CmtCommentService cmtCommentService;

    @PostMapping
    public ResponseEntity saveComment(@RequestBody CmtCommentSaveRequestDto cmtCommentSaveRequestDto) {

        CmtCommentResponseDto cmtCommentResponseDto = cmtCommentService.saveComment(cmtCommentSaveRequestDto);

        return ResponseEntity.ok(RestResponse.of(cmtCommentResponseDto));

    }

    @GetMapping("user/{username}")
    public ResponseEntity findAllCommentsByUserName(@PathVariable String username) {

        List<CmtCommentResponseDto> cmtCommentResponseDtoList = cmtCommentService.findAllCommentsByUserName(username);

        return ResponseEntity.ok(RestResponse.of(cmtCommentResponseDtoList));

    }

    @GetMapping("product/{productId}")
    public ResponseEntity findAllCommentsByUserId(@PathVariable Long productId) {

        List<CmtCommentResponseDto> cmtCommentResponseDtoList = cmtCommentService.findAllCommentsByProductId(productId);

        return ResponseEntity.ok(RestResponse.of(cmtCommentResponseDtoList));

    }

    @DeleteMapping("{commentId}")
    public ResponseEntity deleteById(@PathVariable Long commentId) {

        cmtCommentService.deleteById(commentId);

        return ResponseEntity.ok(RestResponse.of(Void.TYPE));

    }
}
