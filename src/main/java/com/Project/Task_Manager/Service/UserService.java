package com.Project.Task_Manager.Service;

import com.Project.Task_Manager.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    public User registerUser(User user);

    public User getUserById(Long id);

    public List<User> getAllUser();

    public User updateUser(User user);

    public User findByEmail(String email);

    public String deleteUser(Long userid);






}
