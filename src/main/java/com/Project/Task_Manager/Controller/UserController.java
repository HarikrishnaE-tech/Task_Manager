package com.Project.Task_Manager.Controller;

import com.Project.Task_Manager.Model.User;
import com.Project.Task_Manager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("taskapi/user")
public class UserController {

    @Autowired
    UserService userservice;
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
      User user1=  userservice.registerUser(user);
      return new ResponseEntity<>(user1,HttpStatus.OK);

    }

    @GetMapping("/getuserbyid/{userid}")
    public ResponseEntity<User> getUserByid(@PathVariable Long userid){
        User user=  userservice.getUserById(userid);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/getalluser")
    public ResponseEntity<List<User>> getAllUser(){
         List<User> luser=  userservice.getAllUser();
         return new ResponseEntity<>(luser,HttpStatus.OK);
    }

    @PostMapping("/updateuser")
    public ResponseEntity<User> updateUser(@RequestBody User user){
         User user1= userservice.updateUser(user);
         return new ResponseEntity<>(user1,HttpStatus.OK);
    }
    @DeleteMapping("/deleteuser/{userid}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userid){
       String vari=         userservice.deleteUser(userid);
     return new ResponseEntity<>(vari,HttpStatus.OK);
    }

    @GetMapping("/findbyemail")
    public ResponseEntity<User> findbyemail(@RequestParam String email){
         User user1= userservice.findByEmail(email);
         return new ResponseEntity<>(user1,HttpStatus.OK);
    }




}
