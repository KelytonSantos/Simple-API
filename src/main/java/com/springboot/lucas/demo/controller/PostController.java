package com.springboot.lucas.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.lucas.demo.entity.Post;
import com.springboot.lucas.demo.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
    
    @Autowired
    public PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        List<Post> list = postService.findAll();
        return ResponseEntity.ok().body(list);
    }

}