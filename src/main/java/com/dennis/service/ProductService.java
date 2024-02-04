package com.dennis.service;

import com.dennis.dto.request.ProductAddRequestDto;
import com.dennis.dto.response.ProductGetAllBySizeResponseDto;
import com.dennis.dto.response.ProductGetAllResponseDto;
import com.dennis.entity.PFeature;
import com.dennis.entity.Product;
import com.dennis.exception.ErrorType;
import com.dennis.exception.MagazaAppException;
import com.dennis.repository.PFeatureRepository;
import com.dennis.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final PFeatureRepository pFeatureRepository;
    public Product saveProduct(ProductAddRequestDto dto, Long id, Long id1) {
        Product product = Product.builder()
                .name(dto.getName())
                .isActive(dto.getIsActive())
                .brandId(id)
                .modelId(id1)
                .build();
        return productRepository.save(product);
    }

    public List<ProductGetAllResponseDto> findAll() {
        List<ProductGetAllResponseDto> productResponseDtos = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        products.forEach(product -> {
            ProductGetAllResponseDto productGetAllResponseDto = ProductGetAllResponseDto.builder()
                    .name(product.getName())
                    .brandId(product.getBrandId())
                    .modelId(product.getModelId())
                    .isActive(product.getIsActive())
                    .id(product.getId())
                    .description(product.getDescription())
                    .build();
            productResponseDtos.add(productGetAllResponseDto);
        });

        return productResponseDtos;
    }

    public List<ProductGetAllBySizeResponseDto> findAllBySize(String size) {
        List<ProductGetAllBySizeResponseDto> productGetAllBySizeResponseDto = new ArrayList<>();
        List<PFeature> productFeatures = pFeatureRepository.findAllBySubFeatureName(size);

        productFeatures.forEach(productFeature -> {
            Product product = getProduct(productFeature.getProductId());
            ProductGetAllBySizeResponseDto productGetAllBySizeResponseDto1 = ProductGetAllBySizeResponseDto.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .brandId(product.getBrandId())
                    .modelId(product.getModelId())
                    .isActive(product.getIsActive())
                    .description(product.getDescription())
                    .build();
            productGetAllBySizeResponseDto.add(productGetAllBySizeResponseDto1);
        });
        return productGetAllBySizeResponseDto;
    }
    private Product  getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new MagazaAppException(ErrorType.ERROR_PRODUCT_NOT_FOUND));
    }
}
