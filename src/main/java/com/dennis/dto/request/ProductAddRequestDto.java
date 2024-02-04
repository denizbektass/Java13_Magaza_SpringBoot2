package com.dennis.dto.request;

import com.dennis.entity.PFeature;
import com.dennis.entity.PImage;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductAddRequestDto {
    private String name;
    private Boolean isActive;
    List<PImage> pImages;
    List<PFeature> pFeatures;

    private String brandName;
    private String modelName;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class PImage{
        private String mainImageUrl;
        private String firstImageUrl;
        private String secondImageUrl;
        private String thirdImageUrl;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class PFeature{
        private String featureName;
        private String categoryName;
        private String subFeatureName;
    }

}
