
package com.budhathoki.edu.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.budhathoki.edu.entities.TaskEntity;
import com.budhathoki.edu.entities.UserEntity;
import com.budhathoki.edu.exception.ResourceNotFound;
import com.budhathoki.edu.map.TaskMap;
import com.budhathoki.edu.model.TaskDTO;
import com.budhathoki.edu.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskInterface {

    private final TaskRepository taskRepository;
    private final UserInterface userInterface;
    private final TaskMap taskMap;

    public TaskServiceImpl(TaskRepository taskRepository, UserInterface userInterface, TaskMap taskMap) {
        this.taskRepository = taskRepository;
        this.userInterface = userInterface;
        this.taskMap=taskMap;
        
    }

    @Override
    public TaskEntity savedTasak(TaskEntity taskEntity) {
        return taskRepository.save(taskEntity);
    }

    @Override
    public List<TaskDTO> getAllTask() {
        List<TaskEntity> taskEntities = taskRepository.findAll();
        return taskEntities.stream()
                .map(taskMap::mapTaskEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskEntity getTaskId(long id) {
        return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Task not found with id: " + id));
    }

    @Override
    public TaskEntity updatedById(TaskEntity taskEntity, long id) {
        TaskEntity existingEntity = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("No task with that id: " + id));
        existingEntity.setTitle(taskEntity.getTitle());
        existingEntity.setDescription(taskEntity.getDescription());
        existingEntity.setCompleted(taskEntity.isCompleted());
        UserEntity existingUser = existingEntity.getUser();
        if (existingUser != null) {
            existingUser.setUsername(taskEntity.getUser().getUsername());
            existingUser.setPassword(taskEntity.getUser().getPassword());
            existingUser.setRole(taskEntity.getUser().getRole());
        }

        return taskRepository.save(existingEntity);
    }

	@Override
	public TaskEntity deleteById(long id) {
		TaskEntity deletedId= taskRepository.findById(id).orElseThrow
				(()-> new ResourceNotFound("No matching id found"+id));
		taskRepository.deleteById(id);
		return deletedId;
	}

}
