package com.dennis.controller;

import com.dennis.dto.request.RegisterRequestDto;
import com.dennis.entity.Auth;
import com.dennis.service.AuthService;
import com.dennis.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.dennis.constants.RestApiUrls.AUTH;
import static com.dennis.constants.RestApiUrls.REGISTER;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<Boolean> register(@RequestBody @Valid RegisterRequestDto dto){
        Auth auth = authService.save(dto);
        userService.save(auth.getId(),dto.getEmail(),dto.getName());
        return ResponseEntity.ok(true);
    }
}
