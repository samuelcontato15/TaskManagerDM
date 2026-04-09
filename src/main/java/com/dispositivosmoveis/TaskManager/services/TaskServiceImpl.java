package com.dispositivosmoveis.TaskManager.services;

import com.dispositivosmoveis.TaskManager.datasource.repositories.TaskRepository;
import com.dispositivosmoveis.TaskManager.domain.entities.Task;
import com.dispositivosmoveis.TaskManager.domain.entities.TaskPriority;
import com.dispositivosmoveis.TaskManager.domain.entities.TaskStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.SUPPORTS)
    public List<Task> findAllByOrderByDueDateAsc(TaskPriority priority){
        return this.taskRepository.findAllByPriorityOrderByDueDateAsc(priority);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.SUPPORTS)
    public List<Task> findByStatusOrderByDueDate(TaskStatus taskStatus) {
        return this.taskRepository.findAllByStatusOrderByDueDateAsc(taskStatus);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.SUPPORTS)
    public Page<Task> findAll(Pageable pageable) {
        return this.taskRepository.findAll(pageable);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.SUPPORTS)
    public List<Task> findAll(Sort sort) {
        return this.taskRepository.findAll();
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.SUPPORTS)
    public List<Task> findAllByExample(Task task) {
        return this.taskRepository.findAll(Example.of(task));
    }
    @Override
    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.SUPPORTS)
    public Optional<Task> findById(Long id){
        return this.taskRepository.findById(id);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRED)
    public boolean existsById(long id){
        return this.taskRepository.existsById(id);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRED)
    public Long countEntities(){
        return this.taskRepository.count();
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(Task task){
        this.taskRepository.delete(task);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRED)
    public Task save(Task task){
        return this.taskRepository.save(task);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRED)
    public List<Task> save(List<Task> tasks){
        return this.taskRepository.saveAll(tasks);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRED)
    public Task update(Task task){
        return this.taskRepository.save(task);
    }



}
