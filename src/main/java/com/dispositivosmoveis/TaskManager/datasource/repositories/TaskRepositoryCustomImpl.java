package com.dispositivosmoveis.TaskManager.datasource.repositories;

import com.dispositivosmoveis.TaskManager.domain.entities.Task;
import com.dispositivosmoveis.TaskManager.domain.entities.TaskPriority;
import com.dispositivosmoveis.TaskManager.domain.entities.TaskStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class TaskRepositoryCustomImpl implements TaskRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Task> findByTitleCriteria(String title){

        CriteriaBuilder Builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Task> query = builder.createQuery(Task.class);
        Root<Task> root = query.from(Task.class);

        query.select(root).where(builder.equal(root.get("title"), title));

        return this.entityManager.createQuery(query).getResultList();

    }

    public List<Task> findAdvancedCriteria(TaskStatus status, TaskPriority priority, Date startDate, Date endDate){

        CriteriaBuilder Builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Task> query = builder.createQuery(Task.class);
        Root<Task> root = query.from(Task.class);

        Predicate p1 = builder.equal(root.get("title"), title);
        Predicate p2 = builder.equal(root.get("title"), title);
        Predicate p3 = builder.equal(root.get("title"), title);
        Predicate p4 = builder.equal(root.get("title"), title);

        query.select(root).where(titulo);

        return this.entityManager.createQuery(query).getResultList();

    }
}
