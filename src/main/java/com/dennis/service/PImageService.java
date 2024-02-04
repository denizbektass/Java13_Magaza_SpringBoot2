package com.dennis.service;

import com.dennis.dto.request.ProductAddRequestDto;
import com.dennis.entity.PImage;
import com.dennis.repository.PImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PImageService {
    private final PImageRepository pImageRepository;
    public void saveImages(List<ProductAddRequestDto.PImage> pImages, Long id) {
        pImages.forEach(pImage -> {
            PImage image = PImage.builder()
                    .mainImageUrl(pImage.getMainImageUrl())
                    .firstImageUrl(pImage.getFirstImageUrl())
                    .secondImageUrl(pImage.getSecondImageUrl())
                    .thirdImageUrl(pImage.getThirdImageUrl())
                    .productId(id)
                    .build();
            pImageRepository.save(image);
        });
    }
}
