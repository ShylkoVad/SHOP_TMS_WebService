package by.teachmeskills.shopwebservice.services.impl;

import by.teachmeskills.shopwebservice.domain.Order;
import by.teachmeskills.shopwebservice.dto.OrderDto;
import by.teachmeskills.shopwebservice.dto.ProductDto;
import by.teachmeskills.shopwebservice.dto.converters.OrderConverter;
import by.teachmeskills.shopwebservice.dto.converters.ProductConverter;
import by.teachmeskills.shopwebservice.repositories.OrderRepository;
import by.teachmeskills.shopwebservice.services.OrderService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;
    private final ProductConverter productConverter;

    public OrderServiceImpl(OrderRepository orderRepository, OrderConverter orderConverter, ProductConverter productConverter) {
        this.orderRepository = orderRepository;
        this.orderConverter = orderConverter;
        this.productConverter = productConverter;
    }

    @Override
    public OrderDto getOrder(int id) {
        return orderConverter.toDto(orderRepository.findById(id));
    }

    @Override
    public OrderDto getOrderByDate(LocalDateTime date) {
        Order order = Optional.ofNullable(orderRepository.findByDate(date))
                .orElseThrow(() -> new EntityNotFoundException(String.format("Заказа с id %s не найдено.", date)));
        return orderConverter.toDto(order);
    }

    @Override
    public List<OrderDto> getOrdersByUserId(int id) {
        return orderRepository.findByUserId(id).stream().map(orderConverter::toDto).toList();
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream().map(orderConverter::toDto).toList();
    }

    @Override
    public List<ProductDto> getOrderProducts(int id) {
        Order order = Optional.ofNullable(orderRepository.findById(id))
                .orElseThrow(() -> new EntityNotFoundException(String.format("Заказа с id %d не найдено.", id)));
        return order.getProducts().stream().map(productConverter::toDto).toList();
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) {
        Order order = Optional.ofNullable(orderRepository.findById(orderDto.getId()))
                .orElseThrow(() -> new EntityNotFoundException(String.format("Заказа с id %d не найдено.", orderDto.getId())));
        order.setPrice(orderDto.getPrice());
        return orderConverter.toDto(orderRepository.createOrUpdate(order));
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = orderConverter.fromDto(orderDto);
        order = orderRepository.createOrUpdate(order);
        return orderConverter.toDto(order);
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.delete(id);
    }
}
