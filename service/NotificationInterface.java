package com.budhathoki.edu.service;

import java.util.List;

import com.budhathoki.edu.entities.NotificationEntity;

import jakarta.validation.Valid;

public interface NotificationInterface {

	NotificationEntity saveNotification(NotificationEntity notificationEntity);

	List<NotificationEntity> allNotification();

	NotificationEntity getNotificationId(long id);

	NotificationEntity deleteNotificationId(long id);

	NotificationEntity updateNotificationById(long id, NotificationEntity notification);


}
