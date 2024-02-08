package com.budhathoki.edu.service;

import java.util.List;

import com.budhathoki.edu.entities.TaskEntity;
import com.budhathoki.edu.model.TaskDTO;

import jakarta.validation.Valid;

public interface TaskInterface {

	TaskEntity savedTasak(TaskEntity taskEntity);

    //List<TaskEntity> getAllTask();
    List<TaskDTO> getAllTask();

	TaskEntity getTaskId(long id);

	TaskEntity updatedById(TaskEntity taskEntity, long id);

	TaskEntity deleteById(long id);

}
