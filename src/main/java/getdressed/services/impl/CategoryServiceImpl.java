package getdressed.services.impl;

import getdressed.domain.Category;
import getdressed.repositories.CategoryRepository;
import getdressed.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Optional<Category> getByName(String name) {
        return categoryRepository.findByName(name);
    }
}
