package com.dennis.controller;

import com.dennis.dto.response.PFeatureGetAllResponseDto;
import com.dennis.service.PFeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.dennis.constants.RestApiUrls.GET_ALL;
import static com.dennis.constants.RestApiUrls.PFEATURE;

@RestController
@RequestMapping(PFEATURE)
@RequiredArgsConstructor
public class PFeatureController {
    private final PFeatureService pFeatureService;
    @GetMapping(GET_ALL)
    public ResponseEntity<List<PFeatureGetAllResponseDto>> getAll(){
        return ResponseEntity.ok(pFeatureService.findAll());
    }
}
