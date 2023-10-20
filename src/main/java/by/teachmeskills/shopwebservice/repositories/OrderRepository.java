package by.teachmeskills.shopwebservice.repositories;

import by.teachmeskills.shopwebservice.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findByCreatedAt(LocalDateTime date);

    List<Order> findByUserId(int id);
}
