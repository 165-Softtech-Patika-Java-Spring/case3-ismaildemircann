package com.softtech.case3ismaildemircann.app.prd.converter;

import com.softtech.case3ismaildemircann.app.prd.dto.PrdProductResponseDto;
import com.softtech.case3ismaildemircann.app.prd.dto.PrdProductSaveRequestDto;
import com.softtech.case3ismaildemircann.app.prd.entity.PrdProduct;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PrdProductMapper {

    PrdProductMapper INSTANCE = Mappers.getMapper(PrdProductMapper.class);

    PrdProductResponseDto convertToPrdProductResponseDto(PrdProduct prdProduct);

    List<PrdProductResponseDto> convertToPrdProductResponseDtoList(List<PrdProduct> prdProductList);

    PrdProduct convertToPrdProduct(PrdProductSaveRequestDto prdProductSaveRequestDto);

}
