package com.springboot.lucas.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.springboot.lucas.demo.entity.Post;
import com.springboot.lucas.demo.entity.User;
import com.springboot.lucas.demo.repositories.PostRepository;
import com.springboot.lucas.demo.repositories.UserRepository;

@Configuration
public class configs implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User maria = new User(null, "Maria Vasc", "maria@gmail.com");
        User douglas = new User(null, "Douglas Rato", "ratao@gmail.com");

        Post post1 = new Post(null, "Texto do post 1", maria);
        userRepository.saveAll(Arrays.asList(maria, douglas));
        postRepository.saveAll(Arrays.asList(post1));
    }
}