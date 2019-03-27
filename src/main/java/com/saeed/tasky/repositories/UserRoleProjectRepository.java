package com.saeed.tasky.repositories;

import com.saeed.tasky.models.UserRoleProject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleProjectRepository extends CrudRepository<UserRoleProject, Long> {

    UserRoleProject findByUserId(long userId);

    List<UserRoleProject> findAllByUserId(long id);

    List<UserRoleProject> findAllByProjectId(long id);
}
