package getdressed.repositories;

import getdressed.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> getOrderById(Long id);

    Optional<List<Order>> getOrderByEmail(String email);

    Optional<List<Order>> getOrderByPhone(String phone);

}
