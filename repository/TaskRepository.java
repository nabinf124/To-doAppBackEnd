package com.budhathoki.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budhathoki.edu.entities.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long>{

}
