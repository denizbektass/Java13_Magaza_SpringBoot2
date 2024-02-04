package com.dennis.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserImageSaveRequestDto {
    private String firstPicture; //Bu değişken fotosunu yükleyen kişinin giyinmemiş halindeki resmini temsil ediyor.
    private String name; //Kullanıcının gerçek adı
    private String secondPicture; //Bu değişken fotosunu yükleyen kişinin giyinmiş halindeki resmini temsil ediyor.
}
