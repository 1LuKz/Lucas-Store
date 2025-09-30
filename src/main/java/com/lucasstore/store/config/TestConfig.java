package com.lucasstore.store.config;

import com.lucasstore.store.models.User;
import com.lucasstore.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception{
        User firstUser = new User(null, "Miku", "miku@email.com", "99999999", "mikuPassword123");
        User secondUser = new User(null, "Zutomayo", "zutto@email.com", "999999999", "zuttomayonakadeinoni");

        userRepository.saveAll(Arrays.asList(firstUser, secondUser));
    }
}
