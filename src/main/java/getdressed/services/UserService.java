package getdressed.services;

import getdressed.domain.Role;
import getdressed.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {

    List<User> getAll();

    Optional<User> getById(Long id);

    User assignRole(Long id, Role role);

    User update(User user, Long id);

    void delete(Long id);

}
