package com.saeed.tasky.repositories;

import com.saeed.tasky.models.TaskStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskStatusRepository extends CrudRepository<TaskStatus, Long> {
}
