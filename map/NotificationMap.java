package com.budhathoki.edu.map;

import org.modelmapper.ModelMapper;

import com.budhathoki.edu.entities.NotificationEntity;
import com.budhathoki.edu.model.NotificationDto;

public class NotificationMap {
    private final ModelMapper modelMapper;

    public NotificationMap() {
        this.modelMapper = new ModelMapper();
    }

    public NotificationDto mapNotificationEntityToDto(NotificationEntity notificationEntity) {
        return modelMapper.map(notificationEntity, NotificationDto.class);
    }

    public NotificationEntity mapNotificationDtoToEntity(NotificationDto notificationDto) {
        return modelMapper.map(notificationDto, NotificationEntity.class);
    }
}
