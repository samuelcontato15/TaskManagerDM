package com.dispositivosmoveis.TaskManager.resources;

import com.dispositivosmoveis.TaskManager.domain.entities.Task;
import com.dispositivosmoveis.TaskManager.resources.dtos.TaskDTO;
import com.dispositivosmoveis.TaskManager.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

//http://localhost:8080/api/tasks
@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor

public class TaskResource {

    private final TaskService taskService;

    //http://localhost:8080/api/tasks/1
    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> fetchById(@PathVariable id){
        Optional<Task> taskOp = this.taskService.findById(id);
        if(taskOp.isPresent())
            return ResponseEntity.ok(TaskDTO.fromEntity(taskOp.get()));
        return ResponseEntity.notFound().build();
    }
}
