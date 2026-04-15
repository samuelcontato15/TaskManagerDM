package com.dispositivosmoveis.TaskManager.resources;

import com.dispositivosmoveis.TaskManager.domain.entities.Task;
import com.dispositivosmoveis.TaskManager.resources.dtos.TaskDTO;
import com.dispositivosmoveis.TaskManager.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;



@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskResource {

    private final TaskService taskService;

    // http://localhost:8080/api/tasks/1
    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> fetchById(@PathVariable Long id) {
        Optional<Task> taskOp = this.taskService.findById(id);

        return taskOp.map(task ->
                ResponseEntity.ok(TaskDTO.fromEntity(task))
        ).orElseGet(() ->
                ResponseEntity.notFound().build()
        );
    }

    // http://localhost:8080/api/tasks
    @PostMapping
    public ResponseEntity<TaskDTO> save(@RequestBody TaskDTO taskDTO) {
        Task task = this.taskService.save(TaskDTO.fromDTO(taskDTO));
        return ResponseEntity.ok(TaskDTO.fromEntity(task));
    }

    // http://localhost:8080/api/tasks/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> update(
            @PathVariable Long id,
            @RequestBody TaskDTO taskDTO) {

        if (!this.taskService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Task task = TaskDTO.fromDTO(taskDTO);
        task.setId(id);

        Task updatedTask = this.taskService.update(task);
        return ResponseEntity.ok(TaskDTO.fromEntity(updatedTask));
    }

    // http://localhost:8080/api/tasks/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Task> taskOp = this.taskService.findById(id);

        if (taskOp.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        this.taskService.deleteById(taskOp.get());
        return ResponseEntity.noContent().build();
    }
}