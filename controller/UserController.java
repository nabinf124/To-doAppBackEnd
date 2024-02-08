package com.budhathoki.edu.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budhathoki.edu.entities.UserEntity;
import com.budhathoki.edu.exception.ResourceNotFound;
import com.budhathoki.edu.service.UserInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
private final UserInterface userInterface;
public UserController(UserInterface userInterface) {
	this.userInterface=userInterface;
}
@PostMapping
public ResponseEntity<UserEntity> saveUser(@Valid @RequestBody UserEntity userEntity){
	UserEntity user1= userInterface.savedUser(userEntity);
	return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	
}
@GetMapping
public ResponseEntity<List<UserEntity>> getAllUser(){
	return ResponseEntity.ok(userInterface.allUser());
}
@GetMapping("/{id}")
public ResponseEntity<UserEntity> getUserById(@PathVariable("id")long id)
{
	UserEntity user1= userInterface.getUserById(id);
	return ResponseEntity.ok(user1);
}
@PutMapping("/{id}")
public ResponseEntity<UserEntity> updateUserById(
        @RequestBody @Valid UserEntity userEntity,
        @PathVariable("id") long id) {
    try {
        UserEntity updatedEntity = userInterface.updateUserById(userEntity, id);
        return ResponseEntity.ok(updatedEntity);
    } catch (ResourceNotFound e) {
        return ResponseEntity.notFound().build();
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
@DeleteMapping("/{id}")
public ResponseEntity<UserEntity> deleteUserById(@PathVariable("id") long id){
	UserEntity deltedUser= userInterface.deleteUserId(id);
	return ResponseEntity.ok(deltedUser);
}
}
