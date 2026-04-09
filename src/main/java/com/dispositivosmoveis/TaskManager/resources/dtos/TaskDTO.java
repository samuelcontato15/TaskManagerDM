package com.dispositivosmoveis.TaskManager.resources.dtos;

import com.dispositivosmoveis.TaskManager.domain.entities.Task;
import com.dispositivosmoveis.TaskManager.domain.entities.TaskPriority;
import com.dispositivosmoveis.TaskManager.domain.entities.TaskStatus;


import java.util.Date;

public record TaskDTO(Long id,
                      String title,
                      String description,
                      Date creationDate,
                      Date completionDate,
                      Date dueDate,
                      TaskPriority priority,
                      TaskStatus status
) {

    public static TaskDTO fromEntity( Task entity) {
        return new TaskDTO(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getCreationDate(),
                entity.getCompletionDate(),
                entity.getDueDate(),
                entity.getPriority(),
                entity.getStatus()
        );
    }
        public static Task fromDTO( TaskDTO dto ){
            return Task.builder()
                    .id(dto.id)
                    .title(dto.title)
                    .description(dto.description)
                    .completionDate((java.sql.Date) dto.completionDate)
                    .dueDate((java.sql.Date) dto.dueDate)
                    .creationDate((java.sql.Date) dto.creationDate)
                    .priority(dto.priority)
                    .status(dto.status)
                    .build();
        }
    }
