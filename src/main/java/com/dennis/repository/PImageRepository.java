package com.dennis.repository;

import com.dennis.entity.PImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PImageRepository extends JpaRepository<PImage,Long> {
}
