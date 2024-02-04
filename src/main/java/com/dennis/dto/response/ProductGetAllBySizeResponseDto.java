package com.dennis.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductGetAllBySizeResponseDto {
    private Long id;
    private String name;
    private String description;
    private Boolean isActive;
    private Long brandId;
    private Long modelId;

}
