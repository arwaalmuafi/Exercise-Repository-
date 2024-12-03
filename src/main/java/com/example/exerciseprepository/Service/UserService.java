package com.example.exerciseprepository.Service;

import com.example.exerciseprepository.ApiResponse.ApiException;
import com.example.exerciseprepository.Model.User;
import com.example.exerciseprepository.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUSer(User user){
        userRepository.save(user);
    }


    public void updateUSer(Integer id, User user){
        User oldUser =userRepository.findUsersById(id);

        if(oldUser==null){
            throw new ApiException("user is not found");
        }

        oldUser.setName(user.getName());
        oldUser.setUsername(user.getUsername());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setRole(user.getRole());
        oldUser.setAge(user.getAge());
        userRepository.save(oldUser);
    }

    public void deleteUser(Integer id){
        User user=userRepository.findUsersById(id);
        if(user==null){
            throw new ApiException("user not found");
        }

        userRepository.delete(user);
    }

    public User getUserById(Integer id) {
        User user = userRepository.findUsersById(id);
        if (user == null) {
            throw new ApiException("user is not found");
        }
        return user;
    }

    public User getUserByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new ApiException("user is not found");
        }
        return user;
    }

    public User getUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            throw new ApiException("user is not found");
        }
        return user;
    }

    public List<User> getUsersByRole(String role) {
        List<User> users = userRepository.findUsersByRole(role);
        if (users == null) {
            throw new ApiException("user is not found");
        }
        return users;
    }

    public List<User> getUsersByAgeOrAbove(Integer age) {
        List<User> users = userRepository.findByAge(age);
        if (users == null) {
            throw new ApiException("user is not found");
        }
        return users;
    }

    public boolean checkCredentials(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new ApiException("user not found");
        }
        return user.getPassword().equals(password);
    }
}
