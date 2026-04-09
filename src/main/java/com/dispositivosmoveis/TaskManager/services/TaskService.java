package com.dispositivosmoveis.TaskManager.services;

import com.dispositivosmoveis.TaskManager.domain.entities.Task;
import com.dispositivosmoveis.TaskManager.domain.entities.TaskPriority;
import com.dispositivosmoveis.TaskManager.domain.entities.TaskStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findAllByOrderByDueDateAsc(TaskPriority priority);

    List<Task> findByStatusOrderByDueDate(TaskStatus taskStatus);

    Page<Task> findAll(Pageable pageable);

    List<Task> findAll(Sort sort);

    List<Task> findAllByExample(Task task);

    Optional<Task> findById(Long id);

    boolean existsById(long id);

    Long countEntities();

    void deleteById(Task task);

    Task save(Task task);

    List<Task> save(List<Task> tasks);

    Task update(Task task);
}
