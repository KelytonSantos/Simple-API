package com.springboot.lucas.demo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.lucas.demo.dto.UserDTO;
import com.springboot.lucas.demo.entity.User;
import com.springboot.lucas.demo.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    
    @Autowired
    public UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable (value = "id") String id){
        User user = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody UserDTO userDTO){
        var user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable (value = "id") String id){
        User user = userService.findById(id);   //encontrando id
        userService.delete(user); //deletando user
        return ResponseEntity.status(HttpStatus.OK).body(user); //retornando ok

    }
}