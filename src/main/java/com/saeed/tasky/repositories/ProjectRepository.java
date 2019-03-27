package com.saeed.tasky.repositories;

import com.saeed.tasky.models.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    Project findProjectById(long id);
}
