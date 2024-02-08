package com.budhathoki.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budhathoki.edu.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
