package com.dennis.service;

import com.dennis.dto.request.ProductAddRequestDto;
import com.dennis.entity.Brand;
import com.dennis.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    public Brand saveBrand(ProductAddRequestDto dto) {
        Brand brand = Brand.builder()
                .name(dto.getBrandName())
                .build();
        return brandRepository.save(brand);
    }
}
