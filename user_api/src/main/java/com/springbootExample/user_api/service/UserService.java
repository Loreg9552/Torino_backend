package com.springbootExample.user_api.service;

import com.springbootExample.user_api.model.User;
import com.springbootExample.user_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUserById(Long userId){
        return userRepository.findById(userId).orElseThrow();
    }

    public User updateUser(User userToUpdate,Long userId){

        User user = userRepository.findById(userId).orElseThrow();
        user.setName(userToUpdate.getName());
        user.setJob(userToUpdate.getJob());

        return userRepository.save(user);
    }

    public void deleteUser(Long userId){
        if(userRepository.existsById(userId)){
            userRepository.deleteById(userId);
        }
    }
}
