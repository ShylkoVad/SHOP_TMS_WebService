package by.teachmeskills.shopwebservice.repositories.impl;

import by.teachmeskills.shopwebservice.domain.Order;
import by.teachmeskills.shopwebservice.repositories.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Order findById(int id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public Order findByDate(LocalDateTime date) {
        return entityManager.createQuery("select o from Order o where o.created_at=:created_at", Order.class)
                .setParameter("created_at", Timestamp.valueOf(date)).getSingleResult();
    }

    @Override
    public List<Order> findByUserId(int id) {
        return entityManager.createQuery("select o from Order o where o.user.id=:user_id", Order.class)
                .setParameter("user_id", id).getResultList();
    }

    @Override
    public List<Order> findAll() {
        return entityManager.createQuery("select o from Order o ", Order.class).getResultList();
    }

    @Override
    public Order createOrUpdate(Order order) {
        return entityManager.merge(order);
    }

    @Override
    public void delete(int id) {
        Order order = Optional.ofNullable(entityManager.find(Order.class, id))
                .orElseThrow(() -> new EntityNotFoundException(String.format("Заказа с id %d не найдено.", id)));
        entityManager.remove(order);
    }
}
