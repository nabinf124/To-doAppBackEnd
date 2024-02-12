package com.budhathoki.edu.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budhathoki.edu.entities.TaskEntity;
import com.budhathoki.edu.exception.ResourceNotFound;
import com.budhathoki.edu.model.TaskDTO;
import com.budhathoki.edu.service.TaskInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/tasks")
//@CrossOrigin(origins="http://localhost:4200/")
public class TaskController {
	private final TaskInterface taskInterface;
	public TaskController(TaskInterface taskInterface) {
		this.taskInterface=taskInterface;
	}
@PostMapping
public ResponseEntity<TaskEntity> saveTask(@Valid @RequestBody TaskEntity taskEntity){
	TaskEntity task1= taskInterface.savedTasak(taskEntity);
	return ResponseEntity.status(HttpStatus.CREATED).body(task1);
}
@PreAuthorize("hasRole('admin')")
@GetMapping
public ResponseEntity<List<TaskDTO>> getAllTask(){
	return ResponseEntity.ok(taskInterface.getAllTask());
}
@GetMapping("/{id}")
public ResponseEntity<TaskEntity> getTaskById(@PathVariable ("id") long id){
	TaskEntity task2= taskInterface.getTaskId(id);
	return ResponseEntity.ok(task2);
	
}
@PutMapping("/{id}")
public ResponseEntity<TaskEntity> updateTaskById(
        @RequestBody @Valid TaskEntity taskEntity,
        @PathVariable("id") long id) {
    try {
        TaskEntity updatedEntity = taskInterface.updatedById(taskEntity, id);
        return ResponseEntity.ok(updatedEntity);
    } catch (ResourceNotFound e) {
        return ResponseEntity.notFound().build();
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
@PreAuthorize("hasRole('admin')")
@DeleteMapping("/{id}")
public ResponseEntity<TaskEntity> deleteByUserId(@PathVariable("id")long id){
	System.out.println("Delete Mapping");
	TaskEntity deletedTask= taskInterface.deleteById(id);
	return ResponseEntity.ok(deletedTask);
}
}
