package com.Project.Task_Manager.Service;

import com.Project.Task_Manager.Model.Project;
import com.Project.Task_Manager.Model.User;

import java.util.List;

public interface ProjectService {
    public Project createProject(Project project);

    public  Project assignUserToProject(Long userid,Long projectid);

    public Project getProjectByid(Long id);

    public Project getProjectofUser(Long userid);

    public List<Project> getAllProject();

    public String deleteProject(Long projid);

    public Project updateProject(Long projid);

}
