package com.lucasstore.store.config;

import com.lucasstore.store.models.*;
import com.lucasstore.store.models.enums.OrderStatus;
import com.lucasstore.store.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception{
        User firstUser = new User(null, "Miku", "miku@email.com", "99999999", "mikuPassword123");
        User secondUser = new User(null, "Zutomayo", "zutto@email.com", "999999999", "zuttomayonakadeinoni");

        Order firstOrder = new Order(null, Instant.parse("2025-10-01T10:55:20Z"), OrderStatus.WAITING_PAYMENT, firstUser);
        Order secondOrder = new Order(null, Instant.parse("2025-09-10T05:27:12Z"), OrderStatus.CANCELED, firstUser);
        Order thirdOrder = new Order(null, Instant.parse("2025-07-23T03:46:15Z"), OrderStatus.PAID, secondUser);

        Category categoryOne = new Category(null, "Electronics");
        Category categoryTwo = new Category(null, "Books");
        Category categoryThree = new Category(null, "Computers");

        Product productOne = new Product(null, "Clean code", "Lorem ipsum dolor sit amet, consectetur.", 90.0, "");
        Product productTwo = new Product(null, "Clean architecture", "Nulla eu imperdiet purus. Maecenas ante.", 80.0, "");
        Product productThree = new Product(null, "MacBook Pro", "Nam eleifend maximus tortor, at mollis.", 3500.0, "");
        Product productFour = new Product(null, "Smart watch", "Donec aliquet odio ac rhoncus cursus.", 590.0, "");
        Product productFive = new Product(null, "iPhone 17 Pro Max", "Lorem ipsum dolor sit amet, consectetur.", 5000.0, "");

        userRepository.saveAll(Arrays.asList(firstUser, secondUser));
        orderRepository.saveAll(Arrays.asList(firstOrder, secondOrder, thirdOrder));
        categoryRepository.saveAll(Arrays.asList(categoryOne, categoryTwo, categoryThree));
        productRepository.saveAll(Arrays.asList(productOne, productTwo, productThree, productFour, productFive));

        productOne.getCategories().add(categoryTwo);
        productTwo.getCategories().add(categoryTwo);
        productThree.getCategories().add(categoryThree);
        productFour.getCategories().add(categoryOne);
        productFive.getCategories().add(categoryOne);

        productRepository.saveAll(Arrays.asList(productOne, productTwo, productThree, productFour, productFive));

        OrderItem orderItemOne = new OrderItem(firstOrder, productOne, 2, productOne.getPrice());
        OrderItem orderItemTwo = new OrderItem(firstOrder, productThree, 1, productThree.getPrice());
        OrderItem orderItemThree = new OrderItem(secondOrder, productThree, 2, productThree.getPrice());
        OrderItem orderItemFour = new OrderItem(thirdOrder, productFive, 2, productFive.getPrice());

        orderItemRepository.saveAll(Arrays.asList(orderItemOne, orderItemTwo, orderItemThree, orderItemFour));
    }
}
