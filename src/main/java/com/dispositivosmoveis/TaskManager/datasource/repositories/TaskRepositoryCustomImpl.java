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
        CriteriaQuery<Task> query = Builder.createQuery(Task.class);
        Root<Task> root = query.from(Task.class);

        query.select(root).where(Builder.equal(root.get("title"), title));

        return this.entityManager.createQuery(query).getResultList();

    }

    public List<Task> findAdvancedCriteria(TaskStatus status, TaskPriority priority, Date startDate, Date endDate){

        CriteriaBuilder Builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Task> query = Builder.createQuery(Task.class);
        Root<Task> root = query.from(Task.class);

        Predicate p1 = Builder.equal(root.get("status"), status);
        Predicate p2 = Builder.equal(root.get("priority"), priority);
        Predicate p3 = Builder.equal(root.get("startDate"), startDate);
        Predicate p4 = Builder.equal(root.get("endDate"), endDate);

        query.select(root).where(Builder.and(p1, p2, p3, p4));

        return this.entityManager.createQuery(query).getResultList();

    }
}
