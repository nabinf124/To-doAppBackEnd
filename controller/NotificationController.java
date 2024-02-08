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

import com.budhathoki.edu.entities.NotificationEntity;
import com.budhathoki.edu.service.NotificationInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/notifications")
public class NotificationController {
private final NotificationInterface notificationInterface;
public NotificationController(NotificationInterface notificationInterface) {
	this.notificationInterface=notificationInterface;
}
@PostMapping
public ResponseEntity<NotificationEntity> saveNotification
(@Valid @RequestBody NotificationEntity notificationEntity){
	NotificationEntity notific= notificationInterface.saveNotification(notificationEntity);
	return ResponseEntity.status(HttpStatus.CREATED).body(notific);
}
@GetMapping
public ResponseEntity<List<NotificationEntity>> getAllNotification(){
	return ResponseEntity.ok(notificationInterface.allNotification());
}
@GetMapping("/{id}")
public ResponseEntity<NotificationEntity> getNotificationById(@PathVariable("id") long id){
	return ResponseEntity.ok(notificationInterface.getNotificationId(id));
}
@DeleteMapping("/{id}")
public ResponseEntity<?> deleteById(@PathVariable("id") long id) {
    notificationInterface.deleteNotificationId(id);
    return ResponseEntity.noContent().build();
}
@PutMapping("/{id}")
public ResponseEntity<NotificationEntity> updateNotificaion
(@Valid @PathVariable("id") long id, @RequestBody NotificationEntity notification){
    NotificationEntity updatednotification = notificationInterface.updateNotificationById(id, notification);
    return ResponseEntity.ok(updatednotification);
}


}
