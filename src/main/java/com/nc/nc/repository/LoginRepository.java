package com.nc.nc.repository;

import com.nc.nc.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<UserEntity, Long> {
    public UserEntity findByUsernameAndPassword(String username, String password);
}
