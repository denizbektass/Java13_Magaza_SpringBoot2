package com.dennis.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl_pimage")
public class PImage { //ProductImage Class
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mainImageUrl;
    private String firstImageUrl;
    private String secondImageUrl;
    private String thirdImageUrl;
    private Long productId;


}
