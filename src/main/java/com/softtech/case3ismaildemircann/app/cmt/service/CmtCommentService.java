package com.softtech.case3ismaildemircann.app.cmt.service;

import com.softtech.case3ismaildemircann.app.cmt.converter.CmtCommentMapper;
import com.softtech.case3ismaildemircann.app.cmt.dto.CmtCommentResponseDto;
import com.softtech.case3ismaildemircann.app.cmt.dto.CmtCommentSaveRequestDto;
import com.softtech.case3ismaildemircann.app.cmt.entity.CmtComment;
import com.softtech.case3ismaildemircann.app.cmt.enums.CmtErrorMessage;
import com.softtech.case3ismaildemircann.app.cmt.service.entityservice.CmtCommentEntityService;
import com.softtech.case3ismaildemircann.app.gen.exceptions.GenBusinessException;
import com.softtech.case3ismaildemircann.app.gen.exceptions.ItemNotFoundException;
import com.softtech.case3ismaildemircann.app.prd.dto.PrdProductResponseDto;
import com.softtech.case3ismaildemircann.app.prd.enums.PrdErrorMessage;
import com.softtech.case3ismaildemircann.app.prd.service.PrdProductService;
import com.softtech.case3ismaildemircann.app.usr.dto.UsrUserResponseDto;
import com.softtech.case3ismaildemircann.app.usr.enums.UsrErrorMessage;
import com.softtech.case3ismaildemircann.app.usr.service.UsrUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CmtCommentService {

    private final CmtCommentEntityService cmtCommentEntityService;
    private final UsrUserService usrUserService;
    private final PrdProductService prdProductService;

    public CmtCommentResponseDto saveComment(CmtCommentSaveRequestDto cmtCommentSaveRequestDto) {

        Boolean isExistUser = usrUserService.isExistByUserId(cmtCommentSaveRequestDto.getUserId());

        if(!isExistUser) {
            throw new ItemNotFoundException(UsrErrorMessage.USER_NOT_FOUND_MESSAGE);
        }

        Boolean isExistProduct = prdProductService.isExistByProductId(cmtCommentSaveRequestDto.getProductId());

        if(!isExistProduct) {
            throw new ItemNotFoundException(PrdErrorMessage.PRODUCT_NOT_FOUND_MESSAGE);
        }

        CmtComment cmtComment = CmtCommentMapper.INSTANCE.convertToCmtComment(cmtCommentSaveRequestDto);

        cmtComment = cmtCommentEntityService.save(cmtComment);

        CmtCommentResponseDto cmtCommentResponseDto = CmtCommentMapper.INSTANCE.convertToCmtCommentResponseDto(cmtComment);;

        return cmtCommentResponseDto;

    }

    public List<CmtCommentResponseDto> findAllCommentsByUserName(String username) {

        UsrUserResponseDto usrUserResponseDto = usrUserService.findUserByUsername(username);

        if (usrUserResponseDto == null) {
            throw new ItemNotFoundException(UsrErrorMessage.USER_NOT_FOUND_MESSAGE);
        }

        List<CmtComment> cmtCommentList = cmtCommentEntityService.findAllByUserId(usrUserResponseDto.getId());

        if (cmtCommentList.isEmpty()) {
            throw new ItemNotFoundException(username + " haven't written any comments yet.");
        }

        List<CmtCommentResponseDto> cmtCommentResponseDtoList = CmtCommentMapper.INSTANCE.convertToCmtCommentResponseDtoList(cmtCommentList);

        return cmtCommentResponseDtoList;

    }

    public List<CmtCommentResponseDto> findAllCommentsByProductId(Long productId) {

        PrdProductResponseDto prdProductResponseDto = prdProductService.findById(productId);

        if (prdProductResponseDto == null) {
            throw new ItemNotFoundException(PrdErrorMessage.PRODUCT_NOT_FOUND_MESSAGE);
        }

        List<CmtComment> cmtCommentList = cmtCommentEntityService.findAllByProductId(productId);

        if (cmtCommentList.isEmpty()) {
            throw new ItemNotFoundException("There are no comments for " + prdProductResponseDto.getName() + " product yet.");
        }

        List<CmtCommentResponseDto> cmtCommentResponseDtoList = CmtCommentMapper.INSTANCE.convertToCmtCommentResponseDtoList(cmtCommentList);

        return cmtCommentResponseDtoList;

    }

    public void deleteById(Long commentId) {

        Boolean isExist = cmtCommentEntityService.existsById(commentId);

        if(!isExist) {
            throw new GenBusinessException(CmtErrorMessage.COMMENT_NOT_FOUND_MESSAGE);
        }

        cmtCommentEntityService.deleteById(commentId);

    }

}
