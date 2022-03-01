package com.softtech.case3ismaildemircann.app.prd.service;

import com.softtech.case3ismaildemircann.app.cmt.service.entityservice.CmtCommentEntityService;
import com.softtech.case3ismaildemircann.app.gen.exceptions.GenBusinessException;
import com.softtech.case3ismaildemircann.app.prd.converter.PrdProductMapper;
import com.softtech.case3ismaildemircann.app.prd.dto.PrdProductResponseDto;
import com.softtech.case3ismaildemircann.app.prd.dto.PrdProductSaveRequestDto;
import com.softtech.case3ismaildemircann.app.prd.entity.PrdProduct;
import com.softtech.case3ismaildemircann.app.prd.enums.PrdErrorMessage;
import com.softtech.case3ismaildemircann.app.prd.service.entityservice.PrdProductEntityService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PrdProductService {

    private final PrdProductEntityService prdProductEntityService;
    private final CmtCommentEntityService cmtCommentEntityService;

    public PrdProductResponseDto saveProduct(PrdProductSaveRequestDto prdProductSaveRequestDto) {

        PrdProduct prdProduct = PrdProductMapper.INSTANCE.convertToPrdProduct(prdProductSaveRequestDto);

        prdProduct = prdProductEntityService.save(prdProduct);

        PrdProductResponseDto prdProductResponseDto = PrdProductMapper.INSTANCE.convertToPrdProductResponseDto(prdProduct);;

        return prdProductResponseDto;

    }

    public List<PrdProductResponseDto> findAll() {

        List<PrdProduct> prdProductList = prdProductEntityService.findAll();

        if(prdProductList == null) {
            throw new GenBusinessException(PrdErrorMessage.PRODUCT_NOT_FOUND_MESSAGE);
        }

        List<PrdProductResponseDto> prdProductResponseDtoList = PrdProductMapper.INSTANCE.convertToPrdProductResponseDtoList(prdProductList);

        return  prdProductResponseDtoList;

    }

    public PrdProductResponseDto findById(Long productId) {

        PrdProduct prdProduct = prdProductEntityService.getByIdWithControl(productId);

        if(prdProduct == null) {
            throw new GenBusinessException(PrdErrorMessage.PRODUCT_NOT_FOUND_MESSAGE);
        }

        PrdProductResponseDto prdProductResponseDto = PrdProductMapper.INSTANCE.convertToPrdProductResponseDto(prdProduct);

        return prdProductResponseDto;

    }

    public PrdProductResponseDto updateProductName(Long productId, BigDecimal newProductPrice) {

        PrdProduct prdProduct = prdProductEntityService.getByIdWithControl(productId);

        if(prdProduct == null) {
            throw new GenBusinessException(PrdErrorMessage.PRODUCT_NOT_FOUND_MESSAGE);
        }

        prdProduct.setPrice(newProductPrice);

        prdProduct = prdProductEntityService.save(prdProduct);

        PrdProductResponseDto prdProductResponseDto = PrdProductMapper.INSTANCE.convertToPrdProductResponseDto(prdProduct);

        return prdProductResponseDto;

    }

    @Transactional
    public void deleteById(Long productId) {

        Boolean isExist = prdProductEntityService.existsById(productId);

        if(!isExist) {
            throw new GenBusinessException(PrdErrorMessage.PRODUCT_NOT_FOUND_MESSAGE);
        }

        cmtCommentEntityService.deleteAllByProductId(productId);

        prdProductEntityService.deleteById(productId);

    }

    public Boolean isExistByProductId(Long productId) {

        return prdProductEntityService.existsById(productId);
    }
}
