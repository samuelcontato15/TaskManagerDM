package com.dispositivosmoveis.TaskManager.datasource.repositories;

import com.dispositivosmoveis.TaskManager.domain.entities.Task;
import com.dispositivosmoveis.TaskManager.domain.entities.TaskPriority;
import com.dispositivosmoveis.TaskManager.domain.entities.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository <Task, Long> {

    public List<Task> findAllByPriorityOrderByDueDateAsc(TaskPriority priority);
    public List<Task> findAllByStatusOrderByDueDateAsc(TaskStatus status);

}
