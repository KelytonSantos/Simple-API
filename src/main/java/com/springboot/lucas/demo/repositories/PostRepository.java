package com.springboot.lucas.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.lucas.demo.entity.Post;

public interface PostRepository extends JpaRepository<Post ,String>{
}