package com.budhathoki.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.budhathoki.edu.entities.NotificationEntity;
import com.budhathoki.edu.exception.ResourceNotFound;
import com.budhathoki.edu.repository.NotificationRepository;
@Service
public class NotificationServiceImpl implements NotificationInterface {
private final NotificationRepository notificationRepository;
public NotificationServiceImpl(NotificationRepository notificationRepostiory) {
	this.notificationRepository=notificationRepostiory;
}
@Override
public NotificationEntity saveNotification(NotificationEntity notificationEntity) {
	return notificationRepository.save(notificationEntity);
}
@Override
public List<NotificationEntity> allNotification() {
	return notificationRepository.findAll();
}
@Override
public NotificationEntity getNotificationId(long id) {
     return notificationRepository.findById(id).orElseThrow(()-> new ResourceNotFound("No such Id present:"+id));
}
@Override
public NotificationEntity deleteNotificationId(long id) {
    NotificationEntity noticeId = notificationRepository.findById(id).orElseThrow();
    notificationRepository.deleteById(id);
    return noticeId;
}
@Override
public NotificationEntity updateNotificationById(long id, NotificationEntity notification) {
    NotificationEntity existingNotification = notificationRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFound("Id doesn't Match:" + id));
    existingNotification.setMessage(notification.getMessage());
    return existingNotification;
}


}
