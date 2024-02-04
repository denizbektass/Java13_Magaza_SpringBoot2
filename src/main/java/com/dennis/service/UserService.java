package com.dennis.service;

import com.dennis.dto.request.UserImageSaveRequestDto;
import com.dennis.entity.UImage;
import com.dennis.entity.User;
import com.dennis.repository.UImageRepository;
import com.dennis.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class UserService {

    private  final UserRepository userRepository;
    private final UImageRepository uImageRepository;
    public void save(Long id, String email, String name) {
        User user = User.builder()
                .email(email)
                .authId(id)
                .name(name)
                .build();
        userRepository.save(user);
}
    public String saveUserImage(UserImageSaveRequestDto dto) {
        User user = userRepository.findAllByName(dto.getName());
        UImage uImage = UImage.builder()
                .userId(user.getId())
                .url(dto.getFirstPicture())
                .build();
        user.setUImageId(uImageRepository.save(uImage).getId());
        userRepository.save(user);
        return dto.getSecondPicture();
    }


}
