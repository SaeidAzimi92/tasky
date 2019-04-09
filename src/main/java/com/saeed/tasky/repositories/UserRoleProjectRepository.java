package com.saeed.tasky.repositories;

import com.saeed.tasky.models.ProjectRoots;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleProjectRepository extends CrudRepository<ProjectRoots, Long> {

    ProjectRoots findByUserId(long userId);

    List<ProjectRoots> findAllByUserId(long id);

    List<ProjectRoots> findAllByProjectId(long id);
}
