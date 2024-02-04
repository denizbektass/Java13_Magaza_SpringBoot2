package com.dennis.controller;
import com.dennis.dto.request.UserImageSaveRequestDto;
import com.dennis.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.dennis.constants.RestApiUrls.SAVEUSERIMAGE;
import static com.dennis.constants.RestApiUrls.USER;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping(SAVEUSERIMAGE)
    public ResponseEntity<String> saveUserImage(@RequestBody UserImageSaveRequestDto dto){
        return ResponseEntity.ok(userService.saveUserImage(dto));
    }
}



