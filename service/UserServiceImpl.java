package com.budhathoki.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.budhathoki.edu.entities.UserEntity;
import com.budhathoki.edu.exception.ResourceNotFound;
import com.budhathoki.edu.repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements UserInterface {
	private final UserRepository userRepository;
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository= userRepository;
		
	}
	@Override
	public UserEntity savedUser(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}
	@Override
	public List<UserEntity> allUser() {
		return userRepository.findAll();
	}
	@Override
	public UserEntity getUserById(long id) {
		return userRepository.findById(id).orElseThrow
		(()-> new ResourceNotFound("User with Id doesn't match"+id));
	}
	@Override
	public UserEntity updateUserById(@Valid UserEntity userEntity, long id) {
	    UserEntity existingUser = userRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFound("User Id doesn't match " + id));
	    existingUser.setUsername(userEntity.getUsername());
	    existingUser.setPassword(userEntity.getPassword());
	    existingUser.setRole(userEntity.getRole());
	    return userRepository.save(existingUser);
	}
	@Override
	public UserEntity deleteUserId(long id) {
	UserEntity deletedUser= userRepository.findById(id)
			.orElseThrow(()-> new ResourceNotFound("Id not Found"+id));
	       userRepository.deleteById(id);
		return deletedUser;
	}

}
