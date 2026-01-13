package com.Project.Task_Manager.Repository;

import com.Project.Task_Manager.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface projectRepo extends JpaRepository<Project,Long> {
}
