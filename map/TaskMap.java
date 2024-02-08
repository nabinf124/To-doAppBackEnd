package com.budhathoki.edu.map;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.budhathoki.edu.entities.TaskEntity;
import com.budhathoki.edu.model.TaskDTO;
@Component
public class TaskMap {
   private final ModelMapper modelMapper;
    public TaskMap() {
        this.modelMapper = new ModelMapper();
    }
    public TaskDTO mapTaskEntityToDto(TaskEntity taskEntity) {
        return modelMapper.map(taskEntity, TaskDTO.class);
    }

    public TaskEntity mapTaskDtoToEntity(TaskDTO taskDTO) {
        return modelMapper.map(taskDTO, TaskEntity.class);
    }
}
