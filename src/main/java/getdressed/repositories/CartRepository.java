package getdressed.repositories;

import getdressed.domain.Cart;
import getdressed.domain.Product;
import getdressed.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<List<Cart>> findAllByUser(User user);

    Cart getCartById(Long id);

    Optional<Cart> getCartByUserAndProduct(User user, Product product);
}
