package getdressed.dto.requests;

import getdressed.domain.Category;
import getdressed.domain.Product;

public record ProductRequestDTO(
         String name,
         String description,
         Double price,
         Integer stock,
         Integer promotion,
         String image,
         Category category
) {
    public Product toProduct(){
        return Product.builder()
                .name(name)
                .description(description)
                .price(price)
                .stock(stock)
                .promotion(promotion)
                .category(category)
                .build();
    }
}
