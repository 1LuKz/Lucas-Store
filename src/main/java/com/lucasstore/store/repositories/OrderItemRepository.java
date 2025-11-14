package com.lucasstore.store.repositories;

import com.lucasstore.store.models.OrderItem;
import com.lucasstore.store.models.pk.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {
}
