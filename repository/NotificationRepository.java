package com.budhathoki.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budhathoki.edu.entities.NotificationEntity;

public interface NotificationRepository extends JpaRepository
<NotificationEntity, Long> {

}
