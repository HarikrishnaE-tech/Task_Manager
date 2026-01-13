package com.Project.Task_Manager.Service;

import com.Project.Task_Manager.Model.Project;
import com.Project.Task_Manager.Model.User;
import com.Project.Task_Manager.Repository.projectRepo;
import com.Project.Task_Manager.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class ProjectImpl implements ProjectService{

    @Autowired
    projectRepo projrepo;
    @Autowired
    userRepo userrepo;


    @Override
    public Project createProject(Project project) {
       List<Project>lproj= projrepo.findAll();
      Boolean jj= lproj.stream().anyMatch(u->u.getName().equals(project.getName()));
      if(jj){
          throw new ResponseStatusException(HttpStatus.FOUND,"project is already exist");
      }
        return projrepo.save(project);
    }

    @Override
    public Project assignUserToProject(Long userid, Long projectid) {
       Optional<Project> project=projrepo.findById(projectid);

        if(project.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"project is not found");
        }
        Project pro=project.get();

       Optional<User>user= userrepo.findById(userid);
        if(user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user id is not present");
        }
        User us=user.get();
        us.setProject(pro);


        return projrepo.save(pro);
    }

    @Override
    public Project getProjectByid(Long id) {
        return projrepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"id exist"));
    }

    @Override
    public Project getProjectofUser(Long userid) {
      List<Project>  proj= projrepo.findAll();
     return  proj.stream().filter(pro->pro.getId().equals(userid)).findFirst().orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"id is not exist"));

    }

    @Override
    public List<Project> getAllProject() {
       List<Project>lproj= projrepo.findAll();
        return lproj;
    }

    @Override
    public String deleteProject(Long projid) {
        projrepo.deleteById(projid);
        return "project deleted succeessfully";
    }

    @Override
    public Project updateProject(Long projid) {
            Optional<Project> proj=   projrepo.findById(projid);
             Project project= proj.get();
             project.setName(project.getName());
             project.setDescription(project.getDescription());
             project.setTask(project.getTask());
             project.setUser(project.getUser());

        return  projrepo.save(project);
    }
}
