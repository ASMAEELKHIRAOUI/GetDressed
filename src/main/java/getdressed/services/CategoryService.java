package getdressed.services;

import getdressed.domain.Category;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CategoryService {

    Optional<Category> getByName(String name);

}
