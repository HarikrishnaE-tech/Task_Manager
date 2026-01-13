package com.Project.Task_Manager.Repository;

import com.Project.Task_Manager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepo extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

}
