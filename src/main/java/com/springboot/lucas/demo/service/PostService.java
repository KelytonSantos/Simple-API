package com.springboot.lucas.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.lucas.demo.entity.Post;
import com.springboot.lucas.demo.repositories.PostRepository;

@Service
public class PostService {

    @Autowired
    public PostRepository postRepository;

    public List<Post> findAll(){
        return postRepository.findAll();
    }
}