package com.rodolpho.study.config;

import java.util.Arrays;
import com.rodolpho.study.entities.User;
import com.rodolpho.study.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Rodolpho Caetano", "rod12@gmail.com", "981616716", "123456");
        User u2 = new User(null, "Daniele Cabral", "dani123@gmail.com", "976205149", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
