package com.softtech.case3ismaildemircann.app.usr.converter;
import com.softtech.case3ismaildemircann.app.usr.dto.UsrUserResponseDto;
import com.softtech.case3ismaildemircann.app.usr.entity.UsrUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsrUserMapper {

    UsrUserMapper INSTANCE = Mappers.getMapper(UsrUserMapper.class);

    UsrUserResponseDto convertToUsrUserResponseDto(UsrUser usrUser);

    List<UsrUserResponseDto> convertToUsrUserResponseDtoList(List<UsrUser> usrUserList);

}
