package com.dennis.service;

import com.dennis.dto.request.RegisterRequestDto;
import com.dennis.entity.Auth;
import com.dennis.exception.ErrorType;
import com.dennis.exception.MagazaAppException;
import com.dennis.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;
    public Auth save(RegisterRequestDto dto) {
        if(authRepository.existsByUserName(dto.getUserName()))
            throw new MagazaAppException(ErrorType.ERROR_DUPLICATE_USERNAME);
        Auth auth = Auth.builder()
                .userName(dto.getUserName())
                .password(dto.getPassword())
                .build();
        return authRepository.save(auth);
    }
}
