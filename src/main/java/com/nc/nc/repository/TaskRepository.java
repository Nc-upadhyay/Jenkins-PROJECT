package com.nc.nc.repository;

import com.nc.nc.entities.TaskEntity;
import com.nc.nc.entities.UserEntity;
import com.nc.nc.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findAllByUserAndStatus(Long user, String status);

    List<TaskEntity> findAllByUser(Long user);


}
