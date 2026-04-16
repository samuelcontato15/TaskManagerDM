package com.dispositivosmoveis.TaskManager.datasource.repositories;

import com.dispositivosmoveis.TaskManager.domain.entities.Task;
import com.dispositivosmoveis.TaskManager.domain.entities.TaskPriority;
import com.dispositivosmoveis.TaskManager.domain.entities.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TaskRepository extends JpaRepository <Task, Long> {

    public List<Task> findAllByPriorityOrderByDueDateAsc(TaskPriority priority);
    public List<Task> findAllByStatusOrderByDueDateAsc(TaskStatus status);

    @Query("SELECT t FROM Task t WHERE t.title = :title")
    List<Task> findByTitleJPQL(@Param("title")String title);

    @Query("""
            SELECT t FROM Task t
            WHERE t.status = :status
            AND t.priority = :priority
            AND t.creationDate >= :startDate
            AND t.dueDate <= :endDate
            """)
    List<Task> findAdvancedJPQL(
            @Param("status") TaskStatus status,
            @Param("priority") TaskPriority priority,
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate
    );

    //Simples
    @Query(value = "SELECT * FROM TASKS T WHERE T.TITLE = :title", nativeQuery = true)
    List<Task> findByTitleNative(@Param("title")String title);

}
