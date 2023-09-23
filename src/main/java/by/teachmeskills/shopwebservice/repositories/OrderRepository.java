package by.teachmeskills.shopwebservice.repositories;

import by.teachmeskills.shopwebservice.domain.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository {
    Order findById(int id);

    Order findByDate(LocalDateTime date);

    List<Order> findByUserId(int id);

    List<Order> findAll();

    Order createOrUpdate(Order order);

    void delete(int id);
}
