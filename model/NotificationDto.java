package com.budhathoki.edu.model;

import lombok.Data;

@Data
public class NotificationDto {
	private Long id;
    private Long userId;
    private String message;
}
