package com.budhathoki.edu.service;

import java.util.List;

import com.budhathoki.edu.entities.UserEntity;

import jakarta.validation.Valid;

public interface UserInterface {

	UserEntity savedUser(UserEntity userEntity);

	List<UserEntity> allUser();

	UserEntity getUserById(long id);

	UserEntity updateUserById(@Valid UserEntity userEntity, long id);

	UserEntity deleteUserId(long id);

}
