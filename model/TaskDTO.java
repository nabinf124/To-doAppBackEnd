package com.budhathoki.edu.model;

import lombok.Data;

@Data
public class TaskDTO {
	private Long id;
    private String title;
    private String description;
    private boolean completed;
    private String name;
}
