package com.lucasstore.store.config;

import com.lucasstore.store.models.Category;
import com.lucasstore.store.models.enums.OrderStatus;
import com.lucasstore.store.models.Order;
import com.lucasstore.store.models.User;
import com.lucasstore.store.repositories.CategoryRepository;
import com.lucasstore.store.repositories.OrderRepository;
import com.lucasstore.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception{
        User firstUser = new User(null, "Miku", "miku@email.com", "99999999", "mikuPassword123");
        User secondUser = new User(null, "Zutomayo", "zutto@email.com", "999999999", "zuttomayonakadeinoni");

        Order firstOrder = new Order(null, Instant.parse("2025-10-01T10:55:20Z"), OrderStatus.WAITING_PAYMENT, firstUser);
        Order secondOrder = new Order(null, Instant.parse("2025-09-10T05:27:12Z"), OrderStatus.CANCELED, firstUser);
        Order thirdOrder = new Order(null, Instant.parse("2025-07-23T03:46:15Z"), OrderStatus.PAID, secondUser);

        Category categoryOne = new Category(null, "Bass");
        Category categoryTwo = new Category(null, "Electric Guitar");
        Category categoryThree = new Category(null, "Drummer");

        userRepository.saveAll(Arrays.asList(firstUser, secondUser));
        orderRepository.saveAll(Arrays.asList(firstOrder, secondOrder, thirdOrder));
        categoryRepository.saveAll(Arrays.asList(categoryOne, categoryTwo, categoryThree));
    }
}
