package getdressed.services.impl;

import getdressed.domain.Order;
import getdressed.repositories.OrderRepository;
import getdressed.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order, Long id) {
        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> getById(Long id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public Optional<List<Order>> getByEmail(String email) {
        return orderRepository.getOrderByEmail(email);
    }

    @Override
    public Optional<List<Order>> getByPhone(String phone) {
        return orderRepository.getOrderByPhone(phone);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
