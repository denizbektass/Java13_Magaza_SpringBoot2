package com.dennis.repository;

import com.dennis.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth,Long> {
    Boolean existsByUserName(String userName);
}
