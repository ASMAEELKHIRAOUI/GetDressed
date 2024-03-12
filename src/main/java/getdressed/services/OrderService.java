package getdressed.services;

import getdressed.domain.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface OrderService {
    Order save(Order order);

    Order update(Order order, Long id);

    Optional<Order> getById(Long id);

    Optional<List<Order>> getByEmail(String email);

    Optional<List<Order>> getByPhone(String phone);

    void delete(Long id);

    List<Order> getAll();
}
