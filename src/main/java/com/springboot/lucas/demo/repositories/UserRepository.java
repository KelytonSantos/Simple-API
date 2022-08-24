package com.springboot.lucas.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.lucas.demo.entity.User;

public interface UserRepository extends JpaRepository<User ,String>{
}