package com.saeed.tasky.repositories;

import com.saeed.tasky.models.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    Project findProjectById(long id);

    @Transactional
    List<Project> removeByName(String name);

}
