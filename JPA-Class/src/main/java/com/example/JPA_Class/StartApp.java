package com.example.JPA_Class;

import com.example.JPA_Class.models.User;
import com.example.JPA_Class.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApp implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("Napoli");
        user.setUsername("caramelo_de_bad");
        user.setPassword("12345");

        repository.save(user);

        for (User u: repository.findAll()){
            System.out.println(u);
        }
    }

}
