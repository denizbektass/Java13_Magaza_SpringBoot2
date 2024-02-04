package com.dennis.service;

import com.dennis.dto.request.ProductAddRequestDto;
import com.dennis.dto.response.PFeatureGetAllResponseDto;
import com.dennis.entity.PFeature;
import com.dennis.repository.PFeatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PFeatureService {

    private final PFeatureRepository pFeatureRepository;
    public void saveFeatures(List<ProductAddRequestDto.PFeature> pFeatures, Long id) {
        pFeatures.forEach(pFeature -> {
            PFeature feature = PFeature.builder()
                    .featureName(pFeature.getFeatureName())
                    .categoryName(pFeature.getCategoryName())
                    .subFeatureName(pFeature.getSubFeatureName())
                    .productId(id)
                    .build();
            pFeatureRepository.save(feature);
        });
    }

    public List<PFeatureGetAllResponseDto> findAll() {

        List<PFeatureGetAllResponseDto> pFeatureGetAllResponseDto = new ArrayList<>();
        List<PFeature> features = pFeatureRepository.findAll();

        features.forEach(pFeature -> {
            pFeatureGetAllResponseDto.add(PFeatureGetAllResponseDto.builder()
                    .pFeatureNameSubNameList(List.of(PFeatureGetAllResponseDto.PFeatureNameSubName.builder()
                            .name(pFeature.getFeatureName())
                            .subName(pFeature.getSubFeatureName())
                            .build()))
                    .build());
        });
        return pFeatureGetAllResponseDto;
    }
}
