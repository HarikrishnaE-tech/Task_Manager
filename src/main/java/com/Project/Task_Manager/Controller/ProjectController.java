package com.Project.Task_Manager.Controller;

import com.Project.Task_Manager.Model.Project;
import com.Project.Task_Manager.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("taskapi/project")
public class ProjectController {

    @Autowired
    ProjectService projs;




    @PostMapping("/createproject")
    public ResponseEntity<Project> createProject(@RequestBody  Project project){
        Project proj=   projs.createProject(project);
        return new ResponseEntity<>(proj, HttpStatus.OK);
    }
    @PostMapping("/assignuser")
    public ResponseEntity<Project>  assignUserToProject(@RequestBody Long userid,Long projectid){
      Project pro=  projs.assignUserToProject(userid,projectid);
      return new ResponseEntity<>(pro,HttpStatus.OK);
    }
    @GetMapping("/projbyid/{projid}")
    public ResponseEntity<Project> getProjectByid(Long id){
       Project pro= projs.getProjectByid(id);
       return new ResponseEntity<>(pro,HttpStatus.OK);
    }

    @GetMapping("/getprojofuser/{userid}")
    public ResponseEntity<Project> getProjectofUser(Long userid){
       Project proj= projs.getProjectofUser(userid);
       return new ResponseEntity<>(proj,HttpStatus.OK);
    }
    @GetMapping("/getallproj")
    public ResponseEntity<List<Project>> getAllProject(){
      List<Project>lproj=  projs.getAllProject();
      return new ResponseEntity<>(lproj,HttpStatus.OK);
    }
    @PostMapping("/deleteproj/{projid}")
    public ResponseEntity<String>  deleteProject(@PathVariable Long projid){
       String message=  projs.deleteProject(projid);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
    @PostMapping("/updateproj")
    public ResponseEntity<Project> updateProject(Long projid){
          Project proj=  projs.updateProject(projid);
          return new ResponseEntity<>(proj,HttpStatus.OK);
    }









}
