package com.softtech.case3ismaildemircann.app.prd.controller;

import com.softtech.case3ismaildemircann.app.gen.dto.RestResponse;
import com.softtech.case3ismaildemircann.app.prd.dto.PrdProductResponseDto;
import com.softtech.case3ismaildemircann.app.prd.dto.PrdProductSaveRequestDto;
import com.softtech.case3ismaildemircann.app.prd.service.PrdProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class PrdProductController {

    private final PrdProductService prdProductService;

    @PostMapping
    public ResponseEntity saveProduct(@RequestBody PrdProductSaveRequestDto prdProductSaveRequestDto) {

        PrdProductResponseDto prdProductResponseDto = prdProductService.saveProduct(prdProductSaveRequestDto);

        return ResponseEntity.ok(RestResponse.of(prdProductResponseDto));

    }

    @GetMapping
    public ResponseEntity findAllProducts() {

        List<PrdProductResponseDto> prdProductResponseDtoList = prdProductService.findAll();

        return ResponseEntity.ok(RestResponse.of(prdProductResponseDtoList));

    }

    @GetMapping("{productId}")
    public ResponseEntity findProductById(@PathVariable Long productId) {

        PrdProductResponseDto prdProductResponseDto = prdProductService.findById(productId);

        return ResponseEntity.ok(RestResponse.of(prdProductResponseDto));

    }

    @DeleteMapping("{productId}")
    public ResponseEntity deleteProduct(@PathVariable Long productId) {

        prdProductService.deleteById(productId);

        return ResponseEntity.ok(RestResponse.of(Void.TYPE));

    }

    @PatchMapping("{id}/{newProductPrice}")
    public ResponseEntity updateProductPrice(Long productId, BigDecimal newProductPrice) {

        PrdProductResponseDto prdProductResponseDto = prdProductService.updateProductName(productId, newProductPrice);

        return ResponseEntity.ok(RestResponse.of(prdProductResponseDto));

    }

}
