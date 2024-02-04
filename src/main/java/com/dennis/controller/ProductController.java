package com.dennis.controller;

import com.dennis.dto.request.ProductAddRequestDto;
import com.dennis.dto.response.ProductGetAllBySizeResponseDto;
import com.dennis.dto.response.ProductGetAllResponseDto;
import com.dennis.entity.Brand;
import com.dennis.entity.Model;
import com.dennis.entity.Product;
import com.dennis.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.dennis.constants.RestApiUrls.*;

@RestController
@RequestMapping(PRODUCT)
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final BrandService brandService;
    private final ModelService modelService;
    private final PFeatureService pFeatureService;
    private final PImageService pImageService;

    @PostMapping(SAVEPRODUCT)
    public ResponseEntity<Boolean> saveProduct(@RequestBody ProductAddRequestDto dto){

        Brand brand = brandService.saveBrand(dto);
        Model model = modelService.saveModel(dto);

        Product product = productService.saveProduct(dto,brand.getId(),model.getId());

        pFeatureService.saveFeatures(dto.getPFeatures(),product.getId());
        pImageService.saveImages(dto.getPImages(),product.getId());
        return ResponseEntity.ok(true);
    }
    @GetMapping(GET_ALL)
    public ResponseEntity<List<ProductGetAllResponseDto>> getAll(){
        return ResponseEntity.ok(productService.findAll());
    }
    @GetMapping(GET_ALL_BY_SIZE)
    public ResponseEntity<List<ProductGetAllBySizeResponseDto>> getAllBySize(String size){
        return ResponseEntity.ok(productService.findAllBySize(size));
    }
}
