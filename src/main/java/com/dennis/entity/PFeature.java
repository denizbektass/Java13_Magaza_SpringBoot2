package com.dennis.entity;

import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.jdbc.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl_product_feature")
public class PFeature { //ProductFeature Class == Ürün özellikleri Class'ı - tablosu
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String featureName;
    private String categoryName;
    private String subFeatureName;
    private String description;
    //private Size size;
    //private String color;
    //private Double price;
    //private Gender gender;
    private Long productId;
    //private Long brandId;
    //private Long modelId;


}
