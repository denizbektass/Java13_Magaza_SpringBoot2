package com.dennis.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PFeatureGetAllResponseDto {
    List<PFeatureNameSubName> pFeatureNameSubNameList;
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class PFeatureNameSubName{
        private Object name;
        private String subName;
    }
}
