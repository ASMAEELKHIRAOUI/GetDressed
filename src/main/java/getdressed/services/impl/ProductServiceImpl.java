package getdressed.services.impl;

import getdressed.domain.Product;
import getdressed.repositories.ProductRepository;
import getdressed.services.CategoryService;
import getdressed.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Override
    public Product save(Product product) {
        product.setCategory(categoryService.getByName(product.getCategory().getName()).orElse(null));
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product, Long id) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<List<Product>> getByName(String name) {
        return productRepository.findAllByName(name);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
