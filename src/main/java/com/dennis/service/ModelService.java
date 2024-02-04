package com.dennis.service;

import com.dennis.dto.request.ProductAddRequestDto;
import com.dennis.entity.Model;
import com.dennis.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelService {
    private final ModelRepository modelRepository;
    public Model saveModel(ProductAddRequestDto dto) {
        Model model = Model.builder()
                .name(dto.getModelName())
                .build();
        return modelRepository.save(model);
    }
}
