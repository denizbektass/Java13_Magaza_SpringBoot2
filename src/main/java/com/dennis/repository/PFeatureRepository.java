package com.dennis.repository;

import com.dennis.entity.PFeature;
import com.dennis.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PFeatureRepository extends JpaRepository<PFeature,Long> {

    List<PFeature> findAllBySubFeatureName(String size);
}
