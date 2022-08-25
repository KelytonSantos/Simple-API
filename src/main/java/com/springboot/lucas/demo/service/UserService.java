package com.springboot.lucas.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.lucas.demo.entity.User;
import com.springboot.lucas.demo.repositories.UserRepository;
import com.springboot.lucas.demo.service.exception.ResourceNotFoundException;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;


    public List<User> findAll(){
        return userRepository.findAll();
    }


    public User findById(String id){
        Optional<User> obj1 = userRepository.findById(id);
        return obj1.orElseThrow(() -> new ResourceNotFoundException(id)) ;
    }

    @Transactional
    public User save(User user){
        return userRepository.save(user);
    }

    @Transactional
    public void delete(User user){
        userRepository.delete(user);
    }
}