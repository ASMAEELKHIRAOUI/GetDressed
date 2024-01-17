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
         String category
) {
    public Product toProduct(){
        Product.ProductBuilder productBuilder = new Product().builder()
                .name(name)
                .description(description)
                .price(price)
                .stock(stock)
                .promotion(promotion);
        if(category != null) {
            productBuilder.category(Category.builder().name(category).build());
        }
        return productBuilder.build();
    }
}
