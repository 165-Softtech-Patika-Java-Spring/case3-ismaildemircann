package com.softtech.case3ismaildemircann.app.cmt.converter;

import com.softtech.case3ismaildemircann.app.cmt.dto.CmtCommentResponseDto;
import com.softtech.case3ismaildemircann.app.cmt.dto.CmtCommentSaveRequestDto;
import com.softtech.case3ismaildemircann.app.cmt.entity.CmtComment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CmtCommentMapper {

    CmtCommentMapper INSTANCE = Mappers.getMapper(CmtCommentMapper.class);

    CmtComment convertToCmtComment(CmtCommentSaveRequestDto cmtCommentSaveRequestDto);

    CmtCommentResponseDto convertToCmtCommentResponseDto(CmtComment cmtComment);

    List<CmtCommentResponseDto> convertToCmtCommentResponseDtoList(List<CmtComment> cmtCommentList);

}
