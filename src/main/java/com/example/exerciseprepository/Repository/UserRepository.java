package com.example.exerciseprepository.Repository;

import com.example.exerciseprepository.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findUsersById(Integer id);


    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findUserByUsername(String username);

    User findUserByEmail(String email);

    List<User> findUsersByRole(String role);

    @Query("select e from User e where e.age>=?1")
    List<User> findByAge(Integer age);
}
