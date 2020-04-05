package com.example.mongodbexample;

import com.example.mongodbexample.model.User;
import com.example.mongodbexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.tools.jar.CommandLine;

import java.util.List;

@SpringBootApplication
public class MongodbExampleApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongodbExampleApplication.class, args);
    }



    @Override
    public void run(String... args) throws Exception {

        userRepository.save(User.builder()
        .name("Bko")
        .surname("Bxdoyan")
        .build());

        List<User> all = userRepository.findAll();
        System.out.println(all);
    }
}
