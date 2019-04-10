package com.saeed.tasky.repositories;

import com.saeed.tasky.models.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    Task findTaskByUserId(long userId);

    @Modifying
    @Query(value = "update Task t set t.userId = :userId where t.id = :taskId")
    Task updateUserId(@Param("taskId") long taskId, @Param("userId") long userId);

    @Modifying
    @Query(value = "update Task t set t.taskStatusId = :taskStatusId where t.id = :taskId")
    Task updatetaskStatusId(@Param("taskId") long taskId, @Param("taskStatusId") long taskStatusId);
}