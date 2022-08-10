package com.rodolpho.study.config;

import java.time.Instant;
import java.util.Arrays;

import com.rodolpho.study.entities.Category;
import com.rodolpho.study.entities.Order;
import com.rodolpho.study.entities.Product;
import com.rodolpho.study.entities.User;
import com.rodolpho.study.entities.enums.OrderStatus;
import com.rodolpho.study.repositories.CategoryRepository;
import com.rodolpho.study.repositories.OrderRepository;
import com.rodolpho.study.repositories.ProductRepository;
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

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Book of LOTR Saga.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Great TV.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Apple macbook, just amazing.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Play all games.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Book to learn Rails.", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u1 = new User(null, "Rodolpho Caetano", "rod12@gmail.com", "981616716", "123456");
        User u2 = new User(null, "Daniele Cabral", "dani123@gmail.com", "976205149", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.DELIVERED, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.PAID, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
