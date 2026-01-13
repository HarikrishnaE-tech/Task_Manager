package com.Project.Task_Manager.Service;

import com.Project.Task_Manager.Model.User;
import com.Project.Task_Manager.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserIMPL implements UserService{

    @Autowired
    userRepo userrepo;

    @Override
    public User registerUser( User user) {
       List<User>allUser= userrepo.findAll();
      Boolean us= allUser.stream().anyMatch(u-> u.getUsername().equalsIgnoreCase(user.getUsername()));
      if(us){
          throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED,"data is already exist");

      }else{
          return userrepo.save(user);
      }

    }

    @Override
    public User getUserById(Long id) {

        return userrepo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"user not exist"));
    }

    @Override
    public List<User> getAllUser() {

        return userrepo.findAll().stream().collect(Collectors.toList());
    }

    @Override
    public User updateUser(User user) {
        return userrepo.findById(user.getId())
                .map(existing -> {
                    existing.setUsername(user.getUsername());
                    existing.setEmail(user.getEmail());
                    existing.setTask(user.getTask());
                    return userrepo.save(existing);
                })
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
                );
    }


    @Override
    public User findByEmail(String email) {

        return userrepo.findByEmail(email).orElseThrow(()-> new ResponseStatusException(HttpStatus.CONFLICT,"no email exist"));
    }

    @Override
    public String deleteUser(Long userid) {
        userrepo.deleteById(userid);
        return "user is deleted Successfully";
    }
}
