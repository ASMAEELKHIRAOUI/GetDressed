package getdressed.services.impl;

import getdressed.domain.Order;
import getdressed.domain.OrderItem;
import getdressed.repositories.OrderItemRepository;
import getdressed.services.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Override
    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem update(OrderItem orderItem, Long id) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public Optional<OrderItem> getById(Long id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public Optional<List<OrderItem>> getByOrder(Order order) {
        return orderItemRepository.findAllByOrder(order);
    }

    @Override
    public void delete(Long id) {
        orderItemRepository.deleteById(id);
    }

    @Override
    public List<OrderItem> getAll() {
        return orderItemRepository.findAll();
    }

}
